# Исходный код на начало занятия

### class Main

```
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
	public static void main(String[] args) {
		new Window();
	}
}

class Window extends JFrame {
	public Window() {
		setBounds(0, 0, 800, 600);
		setTitle("Управление приложением с помощью мыши");
		add(new Panel());
		setVisible(true);
	}
}

class Panel extends JPanel {
	public Panel() {

	}
	
	public void paintComponent(Graphics gr) {
		
	}
}
```

#### Массив с палитрой цветов
```
private Color[] colors = {
				Color.pink, 
	            Color.black, 
	            Color.green, 
	            Color.blue, 
	            Color.red, 
	            Color.yellow, 
	            Color.white, 
	            Color.orange
	};
```

## Полный код

```
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
	public static void main(String[] args) {
		new Window();
	}
}

class Window extends JFrame {
	public Window() {
		setBounds(0, 0, 800, 600);
		setTitle("Управление приложением с помощью мыши");
		add(new Panel());
		setVisible(true);
	}
}

class Panel extends JPanel {
	private Color[] colors = {
				Color.pink, 
	            Color.black, 
	            Color.green, 
	            Color.blue, 
	            Color.red, 
	            Color.yellow, 
	            Color.white, 
	            Color.orange
	};
	private int currentColor = 0;
	private int mX, mY;
	private boolean flag = false;
	
	public class Mouse implements MouseListener {
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {
			int cX = e.getX();
			int cY = e.getY();
			int btn = e.getButton();
			
			if ((cX > 0) && (cY < 50)) {
				if (btn == 1) {
					currentColor = cX / 100;
				}
			}
		}
		public void mouseReleased(MouseEvent e) {
			flag = false;
		}	
	}
	
	public class MouseMotion implements MouseMotionListener {
		public void mouseDragged(MouseEvent e) {
			int cX = e.getX();
			int cY = e.getY();
			
			if (cY > 50) {
				mX = cX;
				mY = cY;
				flag = true;
				repaint();
			}
		}
		public void mouseMoved(MouseEvent e) {
			if (e.getY() < 50) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			} else {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
	}
	
	public Panel() {
		addMouseListener(new Mouse());
		addMouseMotionListener(new MouseMotion());
		setFocusable(true);
	}
	
	public void paintComponent(Graphics gr) {
		for (int i = 0; i < 8; i++) {
			gr.setColor(colors[i]);
			gr.fillRect(i*100, 0, 100, 50);
			if (flag) {
				gr.setColor(colors[currentColor]);
				gr.fillRect(mX, mY, 5, 5);
			}
		}
	}
	
}
```