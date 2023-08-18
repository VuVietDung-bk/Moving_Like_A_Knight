package movinglikeaknight;

import java.awt.Color;

import javax.swing.JFrame;

import img.*;

public class WindowGame {
	public static final int WIDTH = 1055, HEIGHT = 730;
	
	private JFrame window;
	private Board board;
	private Level level;
	private Image title;
	public int currLevel = 1, finalLevel = 2;

	public WindowGame(){
		window = new JFrame("movinglikeaknight");
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        levelCreate(currLevel);
        title = new Title(this);
        board = new Board(level, this);        
        
        window.addKeyListener(title);
        window.setVisible(true);
        window.add(title);
	}
	
	public void startGame() {
		window.remove(title);
		window.add(board);
		window.addKeyListener(board);
		window.revalidate();
	}
	
	public void levelComplete() {
		window.remove(board);
		window.removeKeyListener(board);
		currLevel++;
		levelCreate(currLevel);
		board = new Board(level, this);
		title = new WinLevel(this);
		window.add(title);
		window.revalidate();
	}
	
	public void gameOver() {
		window.remove(board);
		window.removeKeyListener(board);
		levelCreate(currLevel);
		board = new Board(level, this);
		title = new EndScreen(this);
		window.add(title);
		window.revalidate();
	}
	
	public void victory() {
		window.remove(board);
		window.removeKeyListener(board);
		title = new Victory(this);
		window.add(title);
		window.revalidate();
	}
	
	public static void main(String[] args) {
        new WindowGame();
    }
	
	public void levelCreate(int currLevel) {
		switch(currLevel) {
		case 1: 
			level = new Level();
			level.horsey_x = 9;
			level.horsey_y = 9;
			level.horsey_step = 13;
			for(int i = 12; i < 15; i++) {
	        	level.color[8][i] = Color.white;
	        }
	        for(int i = 9; i < 17; i++) {
	        	level.color[9][i] = Color.white;
	        }
	        for(int i = 9; i < 17; i++) {
	        	if(i == 12) continue;
	        	level.color[10][i] = Color.white;
	        }
	        for(int i = 9; i < 17; i++) {
	        	level.color[11][i] = Color.white;
	        }
	        for(int i = 10; i < 17; i++) {
	        	level.color[12][i] = Color.white;
	        }
	        for(int i = 10; i < 15; i++) {
	        	level.color[13][i] = Color.white;
	        }
	        for(int i = 13; i < 15; i++) {
	        	level.color[14][i] = Color.white;
	        }
	        break;
		case 2:
			level = new Level();
			level.horsey_x = 10;
			level.horsey_y = 10;
			level.horsey_step = 12;
			for(int i = 10; i < 14; i++) {
	        	level.color[7][i] = Color.white;
	        }
			for(int i = 10; i < 18; i++) {
	        	level.color[8][i] = Color.white;
	        }
	        for(int i = 8; i < 18; i++) {
	        	level.color[9][i] = Color.white;
	        }
	        for(int i = 8; i < 16; i++) {
	        	if(i == 9) continue;
	        	level.color[10][i] = Color.white;
	        }
	        for(int i = 8; i < 16; i++) {
	        	level.color[11][i] = Color.white;
	        }
			break;
		default:
			break;
		}
		
	}
}
