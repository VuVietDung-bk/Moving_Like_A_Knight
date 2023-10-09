package movinglikeaknight;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

import img.ImageLoader;

public class Board extends JPanel implements KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int boardHeight = 25, boardWidth = 35;
	public static final int blockSize = 25;
	
	private final int FPS = 10;
	private final int delay = 1000 / FPS;
	private BufferedImage img;
	private WindowGame window;
	
	//the color to draw the board
	int[][] board = new int[boardHeight][boardWidth];
	
	private Color[] colors = new Color[5];
	
	//looper
	Timer looper;
	
	Horsey horsey;
	
	public Board(Level level, WindowGame window) {	
		this.window = window;
		board = level.color;
		img = ImageLoader.loadImage("instruction.png");
		horsey = new Horsey(level.horsey_x, level.horsey_y, level.horsey_step, this);
		looper = new Timer(delay, new GameLooper());
		looper.start();
		colors[0] = Color.yellow;
		colors[1] = Color.white;
		colors[2] = Color.gray;
		colors[3] = Color.DARK_GRAY;
		colors[4] = Color.orange;
	}

	private void update() {
		horsey.update();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.decode("#8A4F34"));
		//fill the window
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);
        g.fillRect(25, 25, 875, 625);
        
        //fill the board
        for(int row = 0; row < board.length; row++) {
        	for(int col = 0; col < board[0].length; col++) {
        		if(board[row][col] > -1) {
        			g.setColor(colors[board[row][col]]);
        			g.fillRect((col + 1) * blockSize, (row + 1) * blockSize, blockSize, blockSize);
        		}
        	}
        }
        
        horsey.render(g);
        //fill the border
        g.setColor(Color.black);
        for (int i = 1; i <= boardHeight + 1; i++) {
            g.drawLine(25, i * blockSize, 900, i * blockSize);
        }
        for (int j = 1; j <= boardWidth + 1; j++) {
            g.drawLine(j * blockSize, 25, j * blockSize, 650);
        }
        //the instruction image
        g.drawImage(img, 900, 0, null);
        
        //the current level
        String levelString = "Level " + Integer.toString(window.currLevel);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Georgia", Font.BOLD, 35));
        g.drawString(levelString, 400, 685);
        
        if(horsey.winLevel()) {
        	if(window.currLevel == window.finalLevel) {
            	window.victory();
            }
        	else window.levelComplete();
        }
        
        if(horsey.gameOver) {
        	window.gameOver();
        }
	}
	

	public int[][] getBoard(){
		return board;
	}
	
	class GameLooper implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			update();
            repaint();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
            horsey.showDirection();
        } else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
        	horsey.chooseDirection();
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
