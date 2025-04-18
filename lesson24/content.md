
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
