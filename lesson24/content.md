## Ссылка на презентацию
https://docs.google.com/presentation/d/16nSReapev07zfbR7me7SwqU_ioBwXONE8EBolkLa4HU/edit?usp=sharing

## SQL запрос
```
INSERT INTO table1 (id, text)
VALUES 
    (1, "Да"),
    (2, "Нет"),
    (3, "Не знаю"),
    (4, "Скорее всего"),
    (5, "Скорее нет, чем да"),
    (6, "Скорее да, чем нет"),
    (7, "Вероятно"),
    (8, "Вполне возможно"),
    (9, "Затрудняюсь ответить"),
    (10, "Даже и не думай"),
    (11, "Тебе помогут"),
    (12, "Надейся на себя"),
    (13, "Придется хорошо заплатить"),
    (14, "Остерегайся этого"),
    (15, "А оно тебе надо?"),
    (16, "Все получится"),
    (17, "С этим повезет"),
    (18, "Будущее видно не четко");
```


## Переменные
```
String driverName = "com.mysql.cj.jdbc.Driver";
String serverName = "localhost";
String db = "game";
String url = "jdbc:mysql://" + serverName + "/" + db;
String user = "root";
String passwd = "";
```

## Генерация случайного числа
```
int rez = (int) (Math.random() * 18) + 1; // Генерация случайного числа
```

## Создаем запрос с использованием случайного id
```
String query = "SELECT text FROM table1 WHERE id = " + rez;
```

## Запрос к бд
```
try {
    Class.forName(driverName);
    try (Connection connect = DriverManager.getConnection(url, user, passwd);
            Statement stmt = connect.createStatement();
            ResultSet r = stmt.executeQuery(query)) {

        if (r.next()) {
            textField.setText(r.getString("text"));
        } 
    }
} catch (Exception e1) {}
```

## Panel.java
```
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel {
  private int val = 0;
    
  public Panel() {
    this.setLayout(null);
    Timer t = new Timer(200, e -> {
      val++;
      if (val == 256) val = 0;
      repaint();
    });
    t.start();
  }
  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    for (int i=0; i<255; i++) {
      gr.setColor(new Color(0, (i*val)%255, 0));
      gr.drawRect(250-i/2, 220-i/2, i, i);
    }
  }
}
```