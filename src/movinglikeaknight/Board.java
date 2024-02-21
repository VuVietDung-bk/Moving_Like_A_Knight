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
	private BufferedImage img, dirt;
	private WindowGame window;
	private boolean hintOn = false;
	
	//the color to draw the board
	private int[][] board = new int[boardHeight][boardWidth];
	protected int levelPoint;
	
	private BufferedImage[] colors = new BufferedImage[4];
	
	private Hinter hinter;
	
	//looper
	Timer looper;
	
	Horsey horsey;
	
	public Board(Level level, WindowGame window) {	
		this.window = window;
		board = level.color;
		img = ImageLoader.loadImage("instruction.png");
		dirt = ImageLoader.loadImage("dirt.png");
		horsey = new Horsey(level.horsey_x, level.horsey_y, level.horsey_step, level.horsey_teleStep, this);
		horsey.teleporters = level.teleporters;
		looper = new Timer(delay, new GameLooper());
		looper.start();
		colors[0] = ImageLoader.loadImage("grass_0.png");
		colors[1] = ImageLoader.loadImage("grass_1.png");
		colors[2] = ImageLoader.loadImage("grass_2.png");
		colors[3] = ImageLoader.loadImage("grass_3.png");
		
		int point1 = window.currLevel % 10 > 0 ? window.currLevel % 10 : 10;
		int point2 = (window.currLevel + 9) / 10;
		levelPoint = point1 * point2 * 1000 + point2 * 200;
	}

	private void update() {
		horsey.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.decode("#8A4F34"));
		//fill the window
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(dirt, 25, 25, null);
        
        //fill the board
        for(int row = 0; row < board.length; row++) {
        	for(int col = 0; col < board[0].length; col++) {
        		if(board[row][col] > -1) {
        			g.drawImage(colors[board[row][col]] ,(col + 1) * blockSize, (row + 1) * blockSize, null);
        		}
        	}
        }
        
        horsey.render(g);
        
        if(hintOn) {
        	hinter.display(g);
        }
        //the instruction image
        g.drawImage(img, 900, 0, null);
        
        //the current level
        String levelString = "Level " + Integer.toString(window.currLevel);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Georgia", Font.BOLD, 35));
        g.drawString(levelString, 400, 685);
        
        String levelPointString = "Level point: " + Integer.toString(levelPoint);
        String totalPointString = "Total point: " + Integer.toString(window.totalPoint);
        g.setFont(new Font("Georgia", Font.BOLD, 15));
        g.drawString(levelPointString, 700, 665);
        g.drawString(totalPointString, 700, 685);
        
        if(horsey.winLevel()) {
        	if(window.currLevel == window.finalLevel) {
            	window.victory();
            }
        	else window.levelComplete();
        }
	}
	
	public void hint() {
		hinter = new Hinter(horsey, board);
		hinter.hints();
		hintOn = true;
		if(!hinter.overFlow)
			levelPoint -= 2000;
	}

	public int[][] getBoard(){
		return board;
	}
	
	class GameLooper implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			update();
            repaint();
            if(levelPoint > 0)
            	levelPoint -= 5;
            else levelPoint = 0;
		}
		
	}

	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			hintOn = false;
            horsey.showDirection();
        } else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
        	horsey.chooseDirection();
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
        	hintOn = false;
        	horsey.undo();
        } else if(e.getKeyCode() == KeyEvent.VK_H) {
        	if(hintOn) hintOn = false;
        	else hint();
        } 
	}

	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
