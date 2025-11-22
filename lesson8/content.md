# Создание компьютерной игры "Новогодний дождь" (начало)

## Game.java
```
public class Game {
    public static void main(String[] arg) {
        new Window();
    }
}
```

## Window.java
```
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
```
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