### Ссылка на презентацию
https://docs.google.com/presentation/d/18t85ahYetGRUCHzUyC6cY3KuTgUs6x95fWL5Kh_UCcE/edit?usp=sharing

### Полный код  
```
import java.sql.*;

public class Main {

  public static void main(String[] args) {
    
    Connection connect;
    
    try {
      String driverName = "com.mysql.cj.jdbc.Driver";
      Class.forName(driverName);
      String serverName = "localhost";
      String db = "mydb1";
      String url = "jdbc:mysql://"+serverName+"/"+db;
      String user = "root";
      String passwd = "";
      
      connect = DriverManager.getConnection(url, user, passwd);
      
      String q = "SELECT * FROM table1";
      
      Statement state = connect.createStatement();
      ResultSet r = state.executeQuery(q);
      
      String temp;
      while (r.next())
      {
        temp = r.getString("firstname");
        System.out.println(temp);
      }
      
      connect.close();
    } catch (Exception e) {}
  }

}
```


## ссылки

AMPPS -> https://ampps.com/
MySQL -> https://www.mysql.com/