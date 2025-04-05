### Ссылка на презентацию
https://docs.google.com/presentation/d/1uK98suNxgNnJCNIwiffg5m02hUyhe0V85NHImc8q9ks/edit?usp=sharing

### Код обработчика события для кнопки "Создать"
```
createBtn.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    String str = inputPath.getText().trim();
    if (str.isEmpty()) {
      JOptionPane.showMessageDialog(null, 
        "Введите путь к файлу!", "Ошибка", 0);
    } 
    else 
    {
      File nf = new File(str);
      try 
      {
        nf.createNewFile();
        JOptionPane.showMessageDialog(null, 
          "Файл создан!", "Сообщение", 1);
      } 
      catch(IOException ex) 
      {
        JOptionPane.showMessageDialog(null, 
          "Файл не создан!", "Ошибка", 0);
      }
    }
  }
});
```

### Код обработчика события для кнопки "Удалить"
```
deleteBtn.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    String str = inputPath.getText().trim();
    if (str.isEmpty()) {
      JOptionPane.showMessageDialog(null, 
        "Введите путь к файлу!", "Ошибка", 0);
    } else {
      File nf = new File(str);
      if (nf.exists()) {
        nf.delete();
        JOptionPane.showMessageDialog(null, 
          "Файл удален!", "Сообщение", 1);
      } else {
        JOptionPane.showMessageDialog(null, 
          "Файл не найден!", "Ошибка", 0);
      }
    }
  }
});
```

### Код обработчика события для кнопки "Переименовать"
```
renameBtn.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    String str = inputPath.getText().trim();
    if (str.isEmpty()) {
      JOptionPane.showMessageDialog(null, 
        "Введите путь к файлу!", "Ошибка", 0);
    } else {
      File nf = new File(str);
      if (nf.exists()) {
        String newName = 
          JOptionPane.showInputDialog("Введите новое имя: ");
          if (newName==null) newName="";
        if (!newName.trim().isEmpty()) {
          File newFile = 
            new File(nf.getParent()+"\\"+newName);
          nf.renameTo(newFile);
          JOptionPane.showMessageDialog(null,
            "Файл переименован!", "Сообщение", 1);
        }
      } else {
        JOptionPane.showMessageDialog(null, 
            "Файл не найден!", "Ошибка", 0);
      }
    }
  }
});
```

### Код обработчика события для кнопки "Записать"
```
writeBtn.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    String str = inputPath.getText().trim();
    if (str.isEmpty()) {
      JOptionPane.showMessageDialog(null, 
        "Введите путь к файлу!", "Ошибка", 0);
    } else {
      File nf = new File(str);
      if (nf.exists()) {
        
        try {
          OutputStream obj = new FileOutputStream(str);
          BufferedWriter out = new BufferedWriter(new OutputStreamWriter(obj));
          out.write(textArea.getText());
          out.close();
          obj.close();
          JOptionPane.showMessageDialog(null, 
              "Запись выполнена!", "Сообщение", 1);
        } catch(IOException e2) {}
        
      } else {
        JOptionPane.showMessageDialog(null, 
          "Файл не найден!", "Ошибка", 0);
      }
    }
  }
});
```

### Код обработчика события для кнопки "Прочитать"
```
readBtn.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    String str = inputPath.getText().trim();
    if (str.isEmpty()) {
      JOptionPane.showMessageDialog(null, 
        "Введите путь к файлу!", "Ошибка", 0);
    } else {
      File nf = new File(str);
      if (nf.exists()) {
        try {
          InputStream obj = new FileInputStream(str);
          BufferedReader in = new BufferedReader(new InputStreamReader(obj));
          String tmp = "";
          while(in.ready()) 
          {
            tmp += (in.readLine()+"\n");
          }
          textArea.setText(tmp);
          in.close();
          obj.close();
        } catch(IOException e2) {}
        
      } else {
        JOptionPane.showMessageDialog(null, 
          "Файл не найден!", "Ошибка", 0);
      }
    }
  }
});
```

### Полный код приложения 
```
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField inputPath;
  private JTextArea textArea;
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Main frame = new Main();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public Main() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 800, 500);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("Укажите путь к файлу: ");
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblNewLabel.setBounds(10, 35, 218, 25);
    contentPane.add(lblNewLabel);
    
    inputPath = new JTextField();
    inputPath.setFont(new Font("Tahoma", Font.PLAIN, 20));
    inputPath.setBounds(238, 35, 536, 25);
    contentPane.add(inputPath);
    inputPath.setColumns(10);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(238, 90, 536, 345);
    contentPane.add(scrollPane);
    
    textArea = new JTextArea();
    scrollPane.setViewportView(textArea);
    
    JButton createBtn = new JButton("Создать новый");
    createBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String str = inputPath.getText().trim();
        if (str.isEmpty()) {
          JOptionPane.showMessageDialog(null, 
            "Введите путь к файлу!", "Ошибка", 0);
        } 
        else 
        {
          File nf = new File(str);
          try 
          {
            nf.createNewFile();
            JOptionPane.showMessageDialog(null, 
              "Файл создан!", "Сообщение", 1);
          } 
          catch(IOException ex) 
          {
            JOptionPane.showMessageDialog(null, 
              "Файл не создан!", "Ошибка", 0);
          }
        }
      }
    });
    createBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
    createBtn.setBounds(10, 111, 187, 25);
    contentPane.add(createBtn);
    
    JButton deleteBtn = new JButton("Удалить");
    deleteBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String str = inputPath.getText().trim();
        if (str.isEmpty()) {
          JOptionPane.showMessageDialog(null, 
            "Введите путь к файлу!", "Ошибка", 0);
        } else {
          File nf = new File(str);
          if (nf.exists()) {
            nf.delete();
            JOptionPane.showMessageDialog(null, 
              "Файл удален!", "Сообщение", 1);
          } else {
            JOptionPane.showMessageDialog(null, 
              "Файл не найден!", "Ошибка", 0);
          }
        }
      }
    });
    deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
    deleteBtn.setBounds(10, 174, 187, 25);
    contentPane.add(deleteBtn);
    
    JButton renameBtn = new JButton("Переименовать");
    renameBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String str = inputPath.getText().trim();
        if (str.isEmpty()) {
          JOptionPane.showMessageDialog(null, 
            "Введите путь к файлу!", "Ошибка", 0);
        } else {
          File nf = new File(str);
          if (nf.exists()) {
            String newName = 
              JOptionPane.showInputDialog("Введите новое имя: ");
if (newName==null) newName="";
            if (!newName.trim().isEmpty()) {
              File newFile = 
                new File(nf.getParent()+"\\"+newName);
              nf.renameTo(newFile);
              JOptionPane.showMessageDialog(null,
                "Файл переименован!", "Сообщение", 1);
            }
          } else {
            JOptionPane.showMessageDialog(null, 
                "Файл не найден!", "Ошибка", 0);
          }
        }
      }
    });
    renameBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
    renameBtn.setBounds(10, 240, 187, 25);
    contentPane.add(renameBtn);
    
    JButton readBtn = new JButton("Прочитать");
    readBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String str = inputPath.getText().trim();
        if (str.isEmpty()) {
          JOptionPane.showMessageDialog(null, 
            "Введите путь к файлу!", "Ошибка", 0);
        } else {
          File nf = new File(str);
          if (nf.exists()) {
            try {
              InputStream obj = new FileInputStream(str);
              BufferedReader in = new BufferedReader(new InputStreamReader(obj));
              String tmp = "";
              while(in.ready()) 
              {
                tmp += (in.readLine()+"\n");
              }
              textArea.setText(tmp);
              in.close();
              obj.close();
            } catch(IOException e2) {}
            
          } else {
            JOptionPane.showMessageDialog(null, 
              "Файл не найден!", "Ошибка", 0);
          }
        }
      }
    });
    readBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
    readBtn.setBounds(10, 308, 187, 25);
    contentPane.add(readBtn);
    
    JButton writeBtn = new JButton("Записать");
    writeBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String str = inputPath.getText().trim();
        if (str.isEmpty()) {
          JOptionPane.showMessageDialog(null, 
            "Введите путь к файлу!", "Ошибка", 0);
        } else {
          File nf = new File(str);
          if (nf.exists()) {
            
            try {
              OutputStream obj = new FileOutputStream(str);
              BufferedWriter out = new BufferedWriter(new OutputStreamWriter(obj));
              out.write(textArea.getText());
              out.close();
              obj.close();
              JOptionPane.showMessageDialog(null, 
                  "Запись выполнена!", "Сообщение", 1);
            } catch(IOException e2) {}
            
          } else {
            JOptionPane.showMessageDialog(null, 
              "Файл не найден!", "Ошибка", 0);
          }
        }
      }
    });
    writeBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
    writeBtn.setBounds(10, 377, 187, 25);
    contentPane.add(writeBtn);
  }
}
```