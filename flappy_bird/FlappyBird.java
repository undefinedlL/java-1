import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.*;
import javax.swing.*;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
	int boardWidth = 360, boardHeight = 640;
	
	Image bgImg, birdImg, topPipeImg, bottomPipeImg;
	
	// bird
	int birdX = boardWidth/8, birdY = boardHeight/2;
	int birdWidth = 34, birdHeight = 24;
	
	class Bird {
		int x = birdX, y = birdY;
		int width = birdWidth, height = birdHeight;
		Image img;
		Bird(Image img) {
			this.img = img;
		}
	}
	
	int pipeX = boardWidth, pipeY = 0; 
	int pipeWidth = 64, pipeHeight = 512;
	
	class Pipe {
		int x = pipeX, y = pipeY;
		int width = pipeWidth, height = pipeHeight;
		Image img;
		boolean passed = false;
		
		Pipe(Image img) {
			this.img = img;
		}
	}
	
	// game
	Bird bird;
	int velocityX = -4;
	int velocityY = -9;
	int gravity = 1;
	
	ArrayList<Pipe> pipes;
	Random random = new Random();
	
	Timer gameLoop;  
	Timer placePipesTimer;
	
	boolean gameOver = false;
	double score = 0;
	
	FlappyBird() {
		this.setPreferredSize(new Dimension(boardWidth, boardHeight));
//		this.setBackground(Color.green);
		this.setFocusable(true);
		this.addKeyListener(this);
		
		try {
			bgImg = ImageIO.read(this.getClass().getResource("./bg.png"));  
			birdImg = ImageIO.read(this.getClass().getResource("./bird.png"));
			topPipeImg = ImageIO.read(this.getClass().getResource("./toppipe.png"));
			bottomPipeImg = ImageIO.read(this.getClass().getResource("./bottompipe.png"));
		} catch (Exception e) {}
		
		bird = new Bird(birdImg);
		pipes = new ArrayList<Pipe>();
		
		placePipesTimer = new Timer(1500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placePipes();
			}
		});
		placePipesTimer.start();
		
		gameLoop = new Timer(1000/60, this);
		gameLoop.start();
	}
	
	public void placePipes() {
		int randomY = (int)(pipeY - pipeHeight/4 - Math.random()*(pipeHeight/2));
		int space = boardHeight/4;
		
		Pipe topPipe = new Pipe(topPipeImg);
		topPipe.y = randomY;
		pipes.add(topPipe);
		
		Pipe bottomPipe = new Pipe(bottomPipeImg);
		bottomPipe.y = topPipe.y + pipeHeight + space;
		pipes.add(bottomPipe);
	}
	
	public void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		draw(gr);
	}
	public void draw(Graphics g) {
		g.drawImage(bgImg, 0, 0, boardWidth, boardHeight, null);
		g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);
		
		for (int i = 0; i < pipes.size(); i++) {
			Pipe pipe = pipes.get(i);
			g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
		}
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		if (gameOver) {
			g.drawString("Game Over: " + String.valueOf(score), 20, 30);
		} else {
			g.drawString(String.valueOf(score), 20, 30);
		}
		
	}
	
	public void move() {
		velocityY += gravity; 
		bird.y += velocityY;
		bird.y = Math.max(bird.y, 0);
		
		for (int i =0 ;i < pipes.size(); i++) {
			Pipe pipe = pipes.get(i);
			pipe.x += velocityX;
			
			if (!pipe.passed && bird.x > pipe.x + pipe.width) {
				pipe.passed = true;
				score += 0.5;
			}
			
			if (collision(bird, pipe)) {
				gameOver = true;
			}
		}
		
		if (bird.y > boardHeight) {
			gameOver = true;
		}
	}
	
	public boolean collision(Bird b, Pipe p) {
		return  b.x < p.x + p.width &&
				b.x + b.width > p.x &&
				b.y < p.y + p.height &&
				b.y + b.height > p.y;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		move();
		repaint();
		if (gameOver) {
			placePipesTimer.stop();
			gameLoop.stop();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			velocityY = -9;
		}
		if (gameOver) {
			bird.y = birdY;
			velocityY = 0;
			pipes.clear();
			score = 0;
			gameOver = false;
			gameLoop.start();
			placePipesTimer.start();
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
