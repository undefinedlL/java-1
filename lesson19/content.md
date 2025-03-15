### Ссылка на презентацию
https://docs.google.com/presentation/d/1YjQ-9hS3ik5eRGR_9PBrzLxkCE-THLxtefVl6PpHcww/edit?usp=sharing

### Исходный код программы
```
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {

	public static Robot rob = null;
	
	public static void main(String[] args) {
		
		try {
			rob = new Robot();
		} catch (Exception e) {}
		
		JFrame window = new JFrame();
		window.setUndecorated(true);
		window.setAlwaysOnTop(true);
		window.setLocation(0,0);
		window.setLayout(new FlowLayout());
		
		JButton[] buttons = new JButton[5];
		
		for (int i = 0; i < 5; i++) {
			buttons[i] = new JButton();
			buttons[i].setName("btn"+i);
			buttons[i].addActionListener(e -> {
				JButton b = (JButton)e.getSource();
				String name = b.getName();
				if (name.equals("btn0")) {
					try {
						ProcessBuilder proc = new ProcessBuilder(
						"C:\\Users\\User\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe",
						"github.com");
						proc.start();
					} catch (Exception ex) {}
				}
				else if (name.equals("btn1")) {
					for (int j = 500; j >= 0; j--) {
						rob.mouseMove(j, j);
						rob.delay(5);
					}
					rob.mouseMove(50, 30);
					rob.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
					rob.delay(200);
					rob.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
					
				}
				else if (name.equals("btn2")) {
					try {
						ProcessBuilder proc = new ProcessBuilder("calc");
						proc.start();
					} catch (Exception ex) {}
					rob.delay(5000);
					
					rob.keyPress(KeyEvent.VK_ALT);
					rob.delay(100);
					rob.keyPress(KeyEvent.VK_F4);
					rob.delay(100);
					rob.keyRelease(KeyEvent.VK_ALT);
					rob.delay(100);
					rob.keyRelease(KeyEvent.VK_F4);
					rob.delay(100);
				}
				else if (name.equals("btn3")) {
					for (int j = 0; j < 10; j++) {
						rob.keyPress(KeyEvent.VK_CAPS_LOCK);
						rob.delay(500);
						rob.keyRelease(KeyEvent.VK_CAPS_LOCK);
						
						rob.keyPress(KeyEvent.VK_NUM_LOCK);
						rob.delay(500);
						rob.keyRelease(KeyEvent.VK_NUM_LOCK);
						
						rob.keyPress(KeyEvent.VK_SCROLL_LOCK);
						rob.delay(500);
						rob.keyRelease(KeyEvent.VK_SCROLL_LOCK);
					}
				}
				else if (name.equals("btn4")) {
					System.exit(0);
				}
			});
			window.add(buttons[i]);
		}
		
		buttons[0].setText("Браузер");
		buttons[1].setText("Мышь");
		buttons[2].setText("Калькулятор");
		buttons[3].setText("Мигание");
		buttons[4].setText("Выход");
		
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}

}
```