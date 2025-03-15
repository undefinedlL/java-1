### Ссылка на презентацию
https://docs.google.com/presentation/d/1hli2Oe2kOKJ9YyrjJVXpG4OIu-Im2gde-nx18DMCHqE/edit?usp=sharing

### Исходный код программы
```
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		new Window();
	}

}

class Window extends JFrame 
{
	private Robot rob;
	private Timer t;
	private int screenCount = 0;
	private Frame window;

	public Window() {
		try {
			rob = new Robot();
		} catch (Exception e) {}
		
		t = new Timer(10, e -> saveScreen());
		t.start();
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setVisible(false);
	}
	
	private void saveScreen() {
		screenCount++;
		System.out.println(screenCount);
		
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
		int w = dm.width;
		int h = dm.height;
		
		try {
			BufferedImage img = rob.createScreenCapture(new Rectangle(0,0,w,h));
			ImageIO.write(img, "PNG", new File("d:\\screenshots\\img" + screenCount+".png"));
		} catch (Exception e) {}
		
		if (screenCount == 6) {
			t.stop();
			window = new Frame();
			window.setResizable(false);
			window.setBounds(0,0,w,h);
			window.setBackground(Color.RED);
			window.setAlwaysOnTop(true);
			window.setUndecorated(true);
			window.setOpacity(0.5f);
			
			window.addWindowListener(new WindowAdapter() {
			    public void windowIconified(WindowEvent e) {
			    	window.setExtendedState(Frame.MAXIMIZED_BOTH);
			    }
		    });
			
			window.setVisible(true);
			t = new Timer(10, e -> window.toFront());
		    t.start();
		}
	}
}
```