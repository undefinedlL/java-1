### Ссылка на презентацию:

https://docs.google.com/presentation/d/12Io1TWCEL0IOvoaXxnuaboG82wKMA4CCx8Xzu0Oyefk/edit?usp=sharing


### Полный код калькулятора

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
    text.setEditable(false);
    p.add(text);
    
    add(p);
    setBounds(0, 0, 350, 540);
    setResizable(false);
    setTitle("Калькулятор");
    setVisible(true);
  }
  
  
  private void clickedButton(JButton btn) {
    String str = btn.getText();
    
    if (str == "Q") 
    {
    	System.exit(0);
    }
    else if (str == "C")
    {
    	text.setText("");
    	operand1=operand2=operation=0;
    }
    else if (str == "+")
    {
    	operation = 1;
    	operand1 = Double.parseDouble(text.getText());
    	text.setText("");
    }
    else if (str == "-")
    {
    	operation = 2;
    	operand1 = Double.parseDouble(text.getText());
    	text.setText("");
    }
    else if (str == "*")
    {
    	operation = 3;
    	operand1 = Double.parseDouble(text.getText());
    	text.setText("");
    }
    else if (str == "/")
    {
    	operation = 4;
    	operand1 = Double.parseDouble(text.getText());
    	text.setText("");
    }
    else if (str == "=") {
    	operand2 = Double.parseDouble(text.getText());
    	if (operation==1) text.setText(""+(operand1+operand2));
    	if (operation==2) text.setText(""+(operand1-operand2));
    	if (operation==3) text.setText(""+(operand1*operand2));
    	if (operation==4) text.setText(""+(operand1/operand2));
    }
    else {
    	text.setText("" + text.getText() + str);
    }
   
  }
}
```

### Код с рассмотрением области видимости переменных (с комментариями)
```
public class Main {
  public static void main(String[] args) {
    // Переменные-параметры: 'args' - это массив строк, который передается в метод main.
    
    Person alice = new Person("Alice"); // 'alice' - локальная переменная, которая ссылается на объект класса Person.
    alice.greet("Hello,"); // "Hello," - это переменная-параметр метода greet, передаваемая как аргумент.
    Person.printCount(); // Вызов статического метода для вывода количества созданных объектов.

    Person bob = new Person("Bob"); // 'bob' - еще одна локальная переменная, ссылающаяся на новый объект Person.
    bob.greet("Hello, "); // "Hello, " - также переменная-параметр метода greet.
    Person.printCount(); // Вывод обновленного количества объектов.
  }
}

class Person {
  private String name; // Переменная класса (или поле) - хранит имя объекта. Доступна только внутри класса.
  private static int count = 0; // Статическая переменная класса - общая для всех объектов класса Person. Хранит количество созданных объектов.

  public Person(String name) { // 'name' - переменная-параметр конструктора, используется для инициализации поля 'name'.
    this.name = name; // Присваивание значения переменной-параметра 'name' полю 'name' текущего объекта.
    count++; // Увеличение статической переменной 'count' при создании нового объекта.
  }

  public void greet(String greeting) { // 'greeting' - переменная-параметр метода greet.
    String msg = greeting + " " + this.name + "!"; // 'msg' - локальная переменная, используемая для хранения приветственного сообщения.
    System.out.println(msg); // Вывод сообщения на экран.
  }

  public static void printCount() { // Статический метод, который не требует создания экземпляра класса для вызова.
    System.out.println(count); // Вывод значения статической переменной 'count'.
  }
}
```