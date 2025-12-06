# Создание игры "Новогодний дождь" (Урок 9-10)

## Файл Game.java
```java
import javax.swing.*;

public class Game {
	// main -> специальный метод, откуда запускается программа
	public static void main(String[] args) {
		
		// Получаем информацию от пользователя
		String answer = JOptionPane.showInputDialog(
							null,
							"Введите сложность игры от 1 до 7: ",
							"Сложность игры", 
							JOptionPane.INFORMATION_MESSAGE
						);
		// Извлекаем первый символ (цифру) пользовательского ввода 
		int level = answer.charAt(0)-'0';
		
		// Проверяем, что уровень находится в диапазоне от 1 до 7
		if ((level >= 1) && (level <= 7)) {
			new Window(level); // -> запускаем игру
		}
	}

}
```

## Файл Window.java
```java
import javax.swing.*;
import java.awt.*;

// специальный класс, который создает объект окна
// включает специальные методы из класса JFrame
public class Window extends JFrame {

	private Field gameField; // -> переменная для игрового поля
	
	public Window(int level) // -> конструктор
	{
		this.setSize(800,600); // -> устанавливаем размеры окна
		this.setLocationRelativeTo(null); // -> центрируем окно на экране
		this.setTitle("Игра: Новогодний дождь"); // -> заголовок
		
		gameField = new Field(level); // -> создание панели, где находится логика игры
		
		Container cont = getContentPane(); // получаем объект с содержимым окна
		cont.add(gameField); // добавляем панель в окно
		
		this.setVisible(true); // -> делаем окно видимым
	}

}
```

## Файл Field.java
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Field extends JPanel  {
	private Image hat, bg; // -> шляпа и фон
	public int x = 400; // -> позиция шляпы
	private int level; // -> сложность игры
	private Gift[] giftArray; // -> массив подарков
	
	public Field(int level) 
	{
		this.level = level; // -> сохраняем уровень
		
		// -> обработка нажатий клавиш
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				int key_ = e.getKeyCode();
				System.out.println(key_);
				if (key_ == 27) System.exit(0); // Esc -> выход
				if (key_ == 37) { // стрелка влево
					if (x - 30 > -48) x -=30;
					else x = 752;
				}
				if (key_ == 39) { // стрелка вправо
					if (x + 30 < 752) x +=30;
					else x = -48;
				}
			}
		});
		this.setFocusable(true); // -> панель может получать фокус
		
		// Таймер для перерисовки окна
		Timer t = new Timer(50, (e) -> {
			repaint();
		});
		t.start();
		
		// -> загружаем изображения
		try {
			hat = ImageIO.read(new File("d:\\hat.png"));
			bg = ImageIO.read(new File("d:\\bg.png"));
		} catch (IOException expt) {}
		
		// -> создаем массив подарков
		giftArray = new Gift[7];
		for (int i = 0; i < 7; i++) {
			try {
				giftArray[i] = new Gift(ImageIO.read(new File("d:\\g"+i+".png")));
			} catch (IOException e) {}
		}
	}
	
	// -> рисуем фон и шляпу
	public void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		gr.drawImage(bg, 0,0, null);
		gr.drawImage(hat, x, 465, null);
	}
}

```

## Файл Gift.java
```java
import javax.swing.*;
import java.awt.*;

public class Gift {
	private Image img; // -> изображение подарка
	public int x, y; // -> координаты
	public Boolean act; // -> активен ли подарок
	private Timer timerUpdate; // -> таймер движения
	
	public Gift(Image img) {
		// Таймер падения подарка
		timerUpdate = new Timer(500, (e) -> {
			down();
		});
		
		this.img = img; // -> сохраняем изображение
		act = false; // -> по умолчанию неактивен
	}
	
	public void start() {
		timerUpdate.start(); // -> запускаем таймер
		y = 0; // -> начинаем с верхней границы
		x = (int)(Math.random()*700); // -> случайная позиция по горизонтали
		act = true; // -> подарок активен
	}
	
	public void down() {
		if (act = true) y += 6; // <- ошибка: должно быть act == true
		if (y + img.getHeight(null) >= 470) { // -> если достиг земли
			timerUpdate.stop(); // -> останавливаем таймер
		}
	}
	
	public void draw(Graphics gr) {
		if (act == true) { // -> рисуем только активные подарки
			gr.drawImage(img, x, y, null);
		}
	}
}
```