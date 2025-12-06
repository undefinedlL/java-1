# Создание компьютерной игры "Новогодний дождь" (начало)
## Код в начале занятия:
### файл Game.java
```java
public class Game {
    public static void main(String[] arg) {
        new Window();
    }
}
```
### Window.java
```java
import javax.swing.*;
import java.awt.*;

class Window extends JFrame {
    private Field gameField;

    public Window() {
        setBounds(0,0,800,600);
        setTitle("Игра: Новогодний дождь");

        gameField = new Field();

        Container cont = getContentPane();
        cont.add(gameField);

        setVisible(true);
    }
}
```
### Field.java
```java
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;


public class Field extends JPanel {

    private class Key implements KeyListener {
        public void keyPressed(KeyEvent e) {
            int key_ = e.getKeyCode();
            System.out.println(key_);
        }
        public void keyReleased(KeyEvent e) {}
        public void keyTyped(KeyEvent e) {}
    }

    public Field() {
        addKeyListener(new Key());
        setFocusable(true);

    }

    public void paintComponent(Graphics g) {
        
    }
}
```

# Готовый код:

## Game.java
```java
public class Game {
    public static void main(String[] arg) {
        new Window();
    }
}
```

## Window.java
```java
import javax.swing.*;
import java.awt.*;

class Window extends JFrame {
    private Field gameField;

    public Window() {
        setBounds(0,0,800,600);
        setTitle("Игра: Новогодний дождь");

        gameField = new Field();

        Container cont = getContentPane();
        cont.add(gameField);

        setVisible(true);
    }
}
```

## Field.java
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Field extends JPanel  {
  private Image hat, bg;
  public int x = 400;
  int speed = 30;
  int leftBorder = -48, rightBorder = 752;

  public Field() 
  {
    this.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        
        int key_ = e.getKeyCode();
        System.out.println(key_);
        if (key_ == 27) System.exit(0);
        if (key_ == 37) {
          if (x - speed > leftBorder) x -=speed;
          else x = rightBorder;
        }
        if (key_ == 39) {
          if (x + speed < rightBorder) x +=speed;
          else x = leftBorder;
        }

      }
    });
    this.setFocusable(true);
    
    Timer t = new Timer(50, (e) -> {
      repaint();
    });
    t.start();
    
    try {
      hat = ImageIO.read(new File("d:\\hat.png"));
      bg = ImageIO.read(new File("d:\\bg.png"));
    } catch (IOException expt) {}
  }
  
  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    gr.drawImage(bg, 0,0, null);
    gr.drawImage(hat, x, 465, null);
  }
}
```