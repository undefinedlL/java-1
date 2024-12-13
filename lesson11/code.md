# Конечный код 

## файл Game.java:

```
import javax.swing.*;

public class Game {

  public static void main(String[] args) {
    
    String answer = JOptionPane.showInputDialog(null, "Введите сложность игры от 1 до 7: ", "Сложность игры", 1);
    
    int lvl = answer.charAt(0)-'0';
    
    if ((lvl >= 1)&&(lvl <= 7)) {
      Window w = new Window(lvl);
    }
    
  }

}
```

## файл Window.java:

```
import javax.swing.*;
import java.awt.*;

class Window extends JFrame {
  private Field gameField;
  
  public Window(int lvl) {
    
    setBounds(0, 0, 800, 600);
    setTitle("Игра: Новогодний дождь");
    
    gameField = new Field(lvl);
    
    Container cont = getContentPane();
    cont.add(gameField);
    
    setVisible(true);
  }
}
```

## файл Field.java:

```
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Field extends JPanel {
  private Image hat;
  private Image bg;
  private Image end_game;
  private Image complete_game;
  public int x = 400;
  private int lvl;
  private int activeGifts = 0;
  private Gift[] giftArray;
  public Timer timerUpdate, timerDraw;
  
  
  private class Key implements KeyListener {
    public void keyPressed(KeyEvent e) {
      int key_ = e.getKeyCode();
      
      if (key_ == 27) System.exit(0);
      else if (key_ == 37) {
        if (x - 30 > -48) x -= 30;
        else x = 752;
      } else if (key_ == 39) {
        if (x - 30 < 752) x += 30;
        else x = -48;
      }
      
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
  }
  
  public Field(int lvl) {
    this.lvl = lvl;
    
    try {
      hat = ImageIO.read(new File("d:\\hat.png"));
    } catch(IOException ex) {}
    try {
      bg = ImageIO.read(new File("d:\\bg.png"));
    } catch(IOException ex) {}
    
    try {
      end_game = ImageIO.read(new File("d:\\game_over.png"));
    } catch(IOException ex) {}
    
    try {
      complete_game = ImageIO.read(new File("d:\\complete.png"));
    } catch(IOException ex) {}
    
    giftArray = new Gift[7];
    for (int i = 0; i < 7; i++) {
      try {
        giftArray[i] = new Gift(ImageIO.read(new File("d:\\g" + i + ".png")));
      } catch(IOException ex) {}
    }
    
    
    addKeyListener(new Key());
    setFocusable(true);
    
    timerUpdate = new Timer(3000, e -> updateStart());
    timerUpdate.start();
    
    timerDraw = new Timer(50, e -> repaint());
    timerDraw.start();
  }
  
  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    gr.drawImage(bg, 0, 0, null);
    gr.drawImage(hat, x, 465, null);
    
    for (int i = activeGifts; i < 7; i++) {
      Gift gift = giftArray[i];
      gift.draw(gr);
      if (gift.act == true) {
        if ((gift.y + gift.img.getHeight(null))>= 470) {
          if (Math.abs(gift.x - x) > 75) {
            gr.drawImage(end_game, 270, 100, null);
            timerUpdate.stop();
            timerDraw.stop();
            break;
          }
          else {
            gift.act = false;
            activeGifts++;
          }
        }
      }
    }
    if (activeGifts >= lvl) {
      gr.drawImage(complete_game, 280, 100, null);
      timerUpdate.stop();
      timerDraw.stop();
    }
  }
  
  private void updateStart() {
    int count = 0;
    
    for (int i = 0; i < 7; i++) {
      if (giftArray[i].act == false) {
        if (count < lvl) {
          giftArray[i].start();
          break;
        }
      } else count++;
    }
  }
}
```

## файл Gift.java:

```
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gift {
  public Image img;
  public int x, y;
  public Boolean act;
  private Timer timerUpdate;
  
  public Gift(Image img) {
    timerUpdate = new Timer(500, e -> down());
    this.img = img;
    act = false;
  }
  
  public void start() {
    timerUpdate.start();
    y = 0;
    x = (int)(Math.random()*700);
    act = true;
  }
  
  public void down() {
    if (act == true) y += 6;
    if (y + img.getHeight(null) >= 470) {
      timerUpdate.stop();
    };
  }
  
  public void draw(Graphics gr) {
    if (act == true) {
      gr.drawImage(img, x, y, null);
    }
  }
  
}
```