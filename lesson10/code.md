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
	public int x = 400;
	private int lvl;
	private Gift[] giftArray;
	
  
  private class Key implements KeyListener {
    public void keyPressed(KeyEvent e) {
      int key_ = e.getKeyCode();
      
      if (key_ == 27) System.exit(0);
      else if (key_ == 37) {
    	  if (x - 30 > -48) x -= 30;
    	  else x = 752;
      } else if (key_ == 39) {
    	  if (x - 30 > 752) x -= 30;
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
	  
	  giftArray = new Gift[7];
	  for (int i = 0; i < 7; i++) {
		  try {
			  giftArray[i] = new Gift(ImageIO.read(new File("c:\\g" + i + ".png")));
		  } catch(IOException ex) {}
	  }
	  
	  
    addKeyListener(new Key());
    setFocusable(true);
    
    Timer timerUpdate = new Timer(3000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          updateStart();
        }
      });
      timerUpdate.start();
    
    Timer t = new Timer(50, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        repaint();
      }
    });
    t.start();
  }
  
  public void paintComponent(Graphics gr) {
	  super.paintComponent(gr);
	  gr.drawImage(bg, 0, 0, null);
	  gr.drawImage(hat, x, 465, null);
	  
	  for (int i = 0; i < 7; i++) {
		  giftArray[i].draw(gr);
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
	private Image img;
	public int x, y;
	public Boolean act;
	private Timer timerUpdate;
	
	public Gift(Image img) {
		timerUpdate = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				down();
			}
		});
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