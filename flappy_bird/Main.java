import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// width and height of the game board
		int boardWidth = 360, boardHeight = 640;
		
		// window settings
		JFrame frame = new JFrame("Flappy Bird");
		frame.setSize(boardWidth, boardHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FlappyBird flappyBird = new FlappyBird();
		frame.add(flappyBird);
		frame.pack();
		flappyBird.requestFocus();
		frame.setVisible(true);
	}

}
