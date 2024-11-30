# Конечный код 

## файл Game.java:

```
public class Game {

	public static void main(String[] args) {
		Window w = new Window();
	}

}

```

## файл Window.java:

```
import javax.swing.*;
import java.awt.*;

class Window extends JFrame {
	private Field gameField;
	
	public Window() {
		
		setBounds(0, 0, 800, 600);
		setTitle("Игра: Новогодний дождь");
		
		gameField = new Field();
		
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
	
  
  private class Key implements KeyListener {
    public void keyPressed(KeyEvent e) {
      int key_ = e.getKeyCode();
      
      if (key_ == 27) System.exit(0);
      else if (key_ == 37) {
    	  if (x - 30 > -48) x -= 30;
    	  else x = 752;
      } else if (key_ == 39) {
    	  
      }
      
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
  }
  
  public Field() {
	  try {
		  hat = ImageIO.read(new File("d:\\hat.png"));
	  } catch(IOException ex) {}
	  try {
		  bg = ImageIO.read(new File("d:\\bg.png"));
	  } catch(IOException ex) {}
	  
    addKeyListener(new Key());
    setFocusable(true);
    
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
  }
}

```