### Ссылка на презентацию:


https://docs.google.com/presentation/d/16e3hduwBMbOSMnM9VI5G97oxA60XR2yMGL_6Mgup2XY/edit?usp=sharing


### Импортируемые модули

```
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
```


### Переменные класса Window
```
JButton[] btnArray = new JButton[17];
private String[] charArray = {"1", "2", "3", "4", 
                              "5", "6", "7", "8",
                              "9", "0", "+", "-",
                              "*", "/", "=", "C",
                              "Q"};
private JTextArea text;
private double operand1=0, operand2=0;
private int operation = 0;
```

### Полный код

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
  JButton[] btnArray = new JButton[17];
  private String[] charArray = {"1", "2", "3", "4",
                  "5", "6", "7", "8",
                  "9", "0", "+", "-",
                  "*", "/", "=", "C",
                  "Q"};
  private JTextArea text;
  private double operand1 = 0, operand2 = 0;
  private int operation = 0;
  
  Font buttonFont = new Font("serif", 0, 20);
  Font labelFont = new Font("arial",1, 30);
  Font textFont = new Font("arial", 2, 30);
  
  public Window() {
    
    JPanel p = new JPanel();
    p.setLayout(null);
    
    int h = 100, buttonSize = 70, spacing = 80;
    for (int i = 0; i < 17; i++) {
      btnArray[i] = new JButton();
      btnArray[i].setSize(buttonSize, buttonSize);
      btnArray[i].setFont(buttonFont);
      
      if (i > 0 && i%4==0) {
        h += spacing;
      }
      
      btnArray[i].setLocation(12 + (i % 4) * spacing, h);
      btnArray[i].addActionListener(e -> clickedButton((JButton)e.getSource()));
      btnArray[i].setText(charArray[i]);
      p.add(btnArray[i]);
    }
    
    JLabel label = new JLabel("Result: ");
    label.setFont(labelFont);
    label.setBounds(10, 0, 300, 50);
    p.add(label);
    
    text = new JTextArea();
    text.setFont(textFont);
    text.setBounds(10, 50, 300, 35);
    text.setBackground(Color.white);
    p.add(text);
    
    add(p);
    setBounds(0, 0, 350, 540);
    setResizable(false);
    setTitle("Калькулятор");
    setVisible(true);
  }
  
  
  private void clickedButton(JButton btn) {
    JOptionPane.showMessageDialog(null, "Кнопка нажата");
  }
}
```