# Ссылка на презентацию
https://docs.google.com/presentation/d/1EqNmERk6MqJ46nci9wVLBb68AxElfmoXGLh57nsMmkI/edit?usp=sharing

# Код начала занятия

## Main.java
```
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int boardWidth = 600, boardHeight = boardWidth;

        JFrame frame = new JFrame("Snake");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeGame game = new SnakeGame(boardWidth, boardHeight);
        frame.add(game);
        frame.pack();
        game.requestFocus();
    }
}
```

## SnakeGame.java
```
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {
  private class Tile {
    int x, y;
    Tile(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  int tileSize = 25;
  int boardWidth, boardHeight;
  // snake
  Tile snakeHead;
  ArrayList<Tile> snakeBody;
  // food
  Tile food;
  Random random;
  //  logic
  Timer gameLoop;
  int velocityX, velocityY;
  boolean gameOver = false;
  
  SnakeGame(int boardWidth, int boardHeight) {
    this.boardWidth = boardWidth;
    this.boardHeight = boardHeight;
    this.setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
    this.setBackground(Color.black);
    
    this.addKeyListener(this);
    this.setFocusable(true);
    
  }
  
  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    draw(gr);
  }
  
  void draw(Graphics g) {
    // grid
    
    // food 
    
    // snake
    
    // score 
    
  }
  
  void placeFood() {
    
  }
  
  void move() {
    // eat food
    
    
    // snake body
    
    
    // snake head
    
    
    // game over
    
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    
  }
  @Override
  public void keyPressed(KeyEvent e) {
    
  }
  
  
  @Override
  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub
    
  }
  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub
    
  }
}

```



# Полный код

## Main.java
```
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int boardWidth = 600, boardHeight = boardWidth;

        JFrame frame = new JFrame("Snake");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeGame game = new SnakeGame(boardWidth, boardHeight);
        frame.add(game);
        frame.pack();
        game.requestFocus();
    }
}
```

## SnakeGame.java
```
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {
  private class Tile {
    int x, y;
    Tile(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  int tileSize = 25;
  int boardWidth, boardHeight;
  // snake
  Tile snakeHead;
  ArrayList<Tile> snakeBody;
  // food
  Tile food;
  Random random;
  //  logic
  Timer gameLoop;
  int velocityX, velocityY;
  boolean gameOver = false;
  
  SnakeGame(int boardWidth, int boardHeight) {
    this.boardWidth = boardWidth;
    this.boardHeight = boardHeight;
    this.setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
    this.setBackground(Color.black);
    
    this.addKeyListener(this);
    this.setFocusable(true);
    
    snakeHead = new Tile(5, 5);
    snakeBody = new ArrayList<Tile>();
    
    food = new Tile(10, 10);
    random = new Random();
    placeFood();
    
    velocityX = 0;
    velocityY = 0;
    
    gameLoop = new Timer(100, this);
    gameLoop.start();
    
  }
  
  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    draw(gr);
  }
  
  void draw(Graphics g) {
    // grid
    for (int i = 0; i < boardWidth/tileSize; i++) {
      g.drawLine(i*tileSize, 0, i*tileSize, boardHeight);
      g.drawLine(0, i*tileSize, boardWidth, i*tileSize);
    }
    // food 
    g.setColor(Color.red);
    g.fill3DRect(food.x*tileSize, food.y*tileSize, tileSize, tileSize, true);
    // snake
    g.setColor(Color.green);
    g.fill3DRect(snakeHead.x*tileSize, snakeHead.y*tileSize, tileSize, tileSize, true);
    for (int i = 0; i < snakeBody.size(); i++) {
      Tile snakePart = snakeBody.get(i);
      g.fill3DRect(snakePart.x*tileSize, snakePart.y*tileSize, tileSize, tileSize, true);
    }
    // score 
    g.setFont(new Font("Tahoma", Font.PLAIN, 30));
    g.setColor(Color.white);
    if (gameOver) {
      g.drawString("Game Over: " + String.valueOf(snakeBody.size()), 10, 40);
    }
    else {
      g.drawString("Score:" + String.valueOf(snakeBody.size()), 10, 40);
    }
  }
  
  void placeFood() {
    food.x = random.nextInt(boardWidth/tileSize);
    food.y = random.nextInt(boardHeight/tileSize);
  }
  
  void move() {
    // eat food
    if (collision(snakeHead, food)) {
      snakeBody.add(new Tile(food.x, food.y));
      placeFood();
    }
    
    // snake body
    for (int i = snakeBody.size()-1; i >= 0; i--) {
      Tile snakePart = snakeBody.get(i);
      if (i == 0) {
        snakePart.x = snakeHead.x;
        snakePart.y = snakeHead.y;
      } else {
        Tile prevSnakePart = snakeBody.get(i-1);
        snakePart.x = prevSnakePart.x;
        snakePart.y = prevSnakePart.y;
      }
    }
    
    // snake head
    snakeHead.x += velocityX;
    snakeHead.y += velocityY;
    
    // game over
    for (int i = 0; i < snakeBody.size(); i++) {
      Tile snakePart = snakeBody.get(i);
      if (collision(snakeHead, snakePart)) {
        gameOver = true;
      }
    }
    if (snakeHead.x*tileSize < 0 || snakeHead.x*tileSize >= boardWidth ||
      snakeHead.y*tileSize < 0 || snakeHead.y*tileSize >= boardHeight) {
      gameOver = true;
    }
  }
  
  boolean collision(Tile tile1, Tile tile2) {
    return tile1.x == tile2.x && tile1.y == tile2.y;
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    move();
    repaint();
    if (gameOver) {
      gameLoop.stop();
    }
  }
  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    if (code == KeyEvent.VK_UP && velocityY != 1) {
      velocityX = 0;
      velocityY = -1;
    } else if (code == KeyEvent.VK_DOWN && velocityY != -1) {
      velocityX = 0;
      velocityY = 1;
    } else if (code == KeyEvent.VK_RIGHT && velocityX != -1) {
      velocityX = 1;
      velocityY = 0;
    } else if (code == KeyEvent.VK_LEFT && velocityX != 1) {
      velocityX = -1;
      velocityY = 0;
    }
  }
  
  
  @Override
  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub
    
  }
  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub
    
  }
}

```