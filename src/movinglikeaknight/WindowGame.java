package movinglikeaknight;


import javax.swing.JFrame;

import img.*;

public class WindowGame {
	public static final int WIDTH = 1055, HEIGHT = 730;
	
	private JFrame window;
	private Board board;
	private Level level;
	private Image title;
	public int currLevel = 20 , finalLevel = 20;

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
		window.removeKeyListener(title);
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
		window.addKeyListener(title);
		window.revalidate();
	}
	
	public void gameOver() {
		window.remove(board);
		window.removeKeyListener(board);
		levelCreate(currLevel);
		board = new Board(level, this);
		title = new EndScreen(this);
		window.add(title);
		window.addKeyListener(title);
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
		case 0:
			level = new Level(8, 8, 5);
			
			for(int i = 8; i < 18; i++) {
				if(i == 11 || i == 14) continue;
	        	level.color[8][i] = 1;
	        }
			for(int i = 10; i < 16; i++) {
				if(i == 14) continue;
	        	level.color[9][i] = 1;
	        }
			for(int i = 13; i < 16; i++) {
	        	level.color[10][i] = 1;
	        }
			break;
		case 1:
			level = new Level(11, 11, 3);
			
			level.color[11][11] = 1;
			for(int i = 9; i < 12; i++) {
	        	level.color[12][i] = 1;
	        }
			for(int i = 9; i < 12; i++) {
	        	level.color[13][i] = 1;
	        }
			for(int i = 9; i < 12; i++) {
	        	level.color[14][i] = 1;
	        }
			break;
		case 2:
			level = new Level(9, 9, 4);
			
			for(int i = 9; i < 14; i++) {
	        	level.color[9][i] = 1;
	        }
			for(int i = 10; i < 13; i++) {
	        	level.color[10][i] = 1;
	        }
			for(int i = 10; i < 13; i++) {
				if(i == 11) continue;
	        	level.color[11][i] = 1;
	        }
			for(int i = 10; i < 13; i++) {
	        	level.color[12][i] = 1;
	        }
			break;
		case 3:
			level = new Level(9, 10, 5);
			
			level.color[9][10] = 1;
			for(int i = 10; i < 14; i++) {
	        	level.color[10][i] = 1;
	        }
			for(int i = 9; i < 14; i++) {
				if(i == 12) continue;
	        	level.color[11][i] = 1;
	        }
			for(int i = 9; i < 14; i++) {
				if(i == 10) continue;
	        	level.color[12][i] = 1;
	        }
			for(int i = 9; i < 12; i++) {
	        	level.color[13][i] = 1;
	        }
			break;
		case 4:
			level = new Level(9, 9, 6);
			
			level.color[9][9] = 1;
			for(int i = 13; i < 15; i++) {
	        	level.color[9][i] = 1;
	        }
			for(int i = 9; i < 15; i++) {
	        	level.color[10][i] = 1;
	        }
			for(int i = 9; i < 15; i++) {
				if(i == 11) continue;
	        	level.color[11][i] = 1;
	        }
			for(int i = 10; i < 15; i++) {
	        	level.color[12][i] = 1;
	        }
			break;
		case 5:
			level = new Level(9, 9, 7);
			
			for(int i = 9; i < 12; i++) {
	        	level.color[9][i] = 1;
	        }
			for(int i = 9; i < 14; i++) {
	        	level.color[10][i] = 1;
	        }
			for(int i = 9; i < 14; i++) {
	        	level.color[11][i] = 1;
	        }
			for(int i = 9; i < 14; i++) {
	        	level.color[12][i] = 1;
	        }
			for(int i = 9; i < 13; i++) {
	        	level.color[13][i] = 1;
	        }
			break;
		case 6:
			level = new Level(11, 11, 9);
			
			for(int i = 11; i < 13; i++) {
	        	level.color[9][i] = 1;
	        }
			for(int i = 7; i < 13; i++) {
	        	level.color[10][i] = 1;
	        }
			for(int i = 7; i < 13; i++) {
	        	level.color[11][i] = 1;
	        }
			for(int i = 7; i < 15; i++) {
				if(i == 9) continue;
	        	level.color[12][i] = 1;
	        }
			for(int i = 7; i < 15; i++) {
				if(i == 9) continue;
	        	level.color[13][i] = 1;
	        }
			break;
		case 7:
			level = new Level(14, 10, 11);
			
			for(int i = 12; i < 14; i++) {
	        	level.color[10][i] = 1;
	        }
			for(int i = 12; i < 14; i++) {
	        	level.color[11][i] = 1;
	        }
			for(int i = 12; i < 16; i++) {
	        	level.color[12][i] = 1;
	        }
			for(int i = 10; i < 16; i++) {
	        	level.color[13][i] = 1;
	        }
			for(int i = 10; i < 18; i++) {
				if(i == 11 || i == 12) continue;
	        	level.color[14][i] = 1;
	        }
			for(int i = 10; i < 18; i++) {
	        	level.color[15][i] = 1;
	        }
			for(int i = 10; i < 17; i++) {
				if(i > 11 && i < 15) continue;
	        	level.color[16][i] = 1;
	        }
			for(int i = 15; i < 17; i++) {
	        	level.color[17][i] = 1;
	        }
			break;
		case 8:
			level = new Level(10, 10, 12);
			
			for(int i = 10; i < 14; i++) {
	        	level.color[7][i] = 1;
	        }
			for(int i = 10; i < 18; i++) {
	        	level.color[8][i] = 1;
	        }
	        for(int i = 8; i < 18; i++) {
	        	level.color[9][i] = 1;
	        }
	        for(int i = 8; i < 16; i++) {
	        	if(i == 9) continue;
	        	level.color[10][i] = 1;
	        }
	        for(int i = 8; i < 16; i++) {
	        	level.color[11][i] = 1;
	        }
			break;
		case 9: 
			level = new Level(9, 9, 13);
			
			for(int i = 12; i < 15; i++) {
	        	level.color[8][i] = 1;
	        }
	        for(int i = 9; i < 17; i++) {
	        	level.color[9][i] = 1;
	        }
	        for(int i = 9; i < 17; i++) {
	        	if(i == 12) continue;
	        	level.color[10][i] = 1;
	        }
	        for(int i = 9; i < 17; i++) {
	        	level.color[11][i] = 1;
	        }
	        for(int i = 10; i < 17; i++) {
	        	level.color[12][i] = 1;
	        }
	        for(int i = 10; i < 15; i++) {
	        	level.color[13][i] = 1;
	        }
	        for(int i = 13; i < 15; i++) {
	        	level.color[14][i] = 1;
	        }
	        break;
		case 10:
			level = new Level(11, 14, 15);
			
			for(int i = 11; i < 16; i++) {
	        	level.color[10][i] = 1;
	        }
			for(int i = 11; i < 16; i++) {
	        	level.color[11][i] = 1;
	        }
			for(int i = 10; i < 17; i++) {
	        	level.color[12][i] = 1;
	        }
			for(int i = 10; i < 17; i++) {
	        	level.color[13][i] = 1;
	        }
			for(int i = 10; i < 18; i++) {
	        	level.color[14][i] = 1;
	        }
			for(int i = 12; i < 18; i++) {
	        	level.color[15][i] = 1;
	        }
			for(int i = 12; i < 16; i++) {
	        	level.color[16][i] = 1;
	        }
			for(int i = 12; i < 16; i++) {
	        	level.color[17][i] = 1;
	        }
			break;
		case 11:
			level = new Level(9, 9, 4);
			
			for(int i = 10; i < 12; i++) {
	        	level.color[9][i] = 1;
	        }
			for(int i = 9; i < 12; i++) {
	        	level.color[10][i] = 1;
	        }
			for(int i = 8; i < 11; i++) {
	        	level.color[11][i] = 1;
	        }
			for(int i = 8; i < 11; i++) {
	        	level.color[12][i] = 1;
	        }
			level.color[9][9] = 2;
			break;
		case 12:
			level = new Level(10, 10, 4);
			
			for(int i = 9; i < 12; i++) {
	        	level.color[9][i] = 1;
	        }
			for(int i = 9; i < 13; i++) {
				if(i == 11) level.color[10][i] = 2;
				else level.color[10][i] = 1;
	        }
			for(int i = 7; i < 13; i++) {
				if(i == 10) continue;
	        	level.color[11][i] = 1;
	        }
			break;
		case 13:
			level = new Level(9, 9, 7);
			
			for(int i = 9; i < 15; i++) {
				if(i == 12) level.color[9][i] = 2;
				else level.color[9][i] = 1;
	        }
			for(int i = 9; i < 15; i++) {
				if(i == 13) continue;
				if(i == 10) level.color[10][i] = 2;
				else level.color[10][i] = 1;
	        }
			for(int i = 9; i < 15; i++) {
	        	level.color[11][i] = 1;
	        }
			for(int i = 9; i < 12; i++) {
	        	level.color[12][i] = 1;
	        }
			break;
		case 14:
			level = new Level(12, 12, 8);
			
			for(int i = 10; i < 13; i++) {
	        	level.color[9][i] = 1;
	        }
			for(int i = 10; i < 13; i++) {
				if(i == 12) level.color[10][i] = 2;
				else level.color[10][i] = 1;
	        }
			for(int i = 9; i < 13; i++) {
				if(i == 9) level.color[11][i] = 1;
				else level.color[11][i] = 2;
	        }
			for(int i = 9; i < 13; i++) {
				if(i == 12) level.color[12][i] = 2;
				else level.color[12][i] = 1;
	        }
			for(int i = 9; i < 13; i++) {
				level.color[13][i] = 1;
	        }
			for(int i = 11; i < 13; i++) {
				level.color[14][i] = 1;
	        }
			break;
		case 15:
			level = new Level(11, 11, 10);
			
			for(int i = 11; i < 13; i++) {
	        	level.color[8][i] = 1;
	        }
			for(int i = 10; i < 15; i++) {
	        	if(i == 11) level.color[9][i] = 2;
	        	else level.color[9][i] = 1;
	        }
			for(int i = 10; i < 15; i++) {
				level.color[10][i] = 1;
	        }
			for(int i = 10; i < 16; i++) {
				level.color[11][i] = 1;
	        }
			for(int i = 10; i < 16; i++) {
				if(i == 12) level.color[12][i] = 2;
				else level.color[12][i] = 1;
	        }
			for(int i = 10; i < 16; i++) {
				if(i == 13) continue;
				level.color[13][i] = 1;
	        }
			break;
		case 16:
			level = new Level(10, 10, 13);
			
			for(int i = 11; i < 14; i++) {
	        	level.color[8][i] = 1;
	        }
			for(int i = 9; i < 15; i++) {
				if(i == 12) continue;
				else level.color[9][i] = 1;
	        }
	        for(int i = 9; i < 15; i++) {
	        	level.color[10][i] = 1;
	        }
	        for(int i = 7; i < 15; i++) {
	        	level.color[11][i] = 1;
	        }
	        for(int i = 7; i < 15; i++) {
	        	level.color[12][i] = 1;
	        }
	        for(int i = 7; i < 13; i++) {
	        	if(i == 9) level.color[13][i] = 2;
				else level.color[13][i] = 1;
	        }
	        for(int i = 7; i < 10; i++) {
	        	level.color[14][i] = 1;
	        }
			break;
		case 17:
			level = new Level(8, 8, 13);
			
			for(int i = 8; i < 14; i++) {
				if(i == 9) continue;
	        	level.color[8][i] = 1;
	        }
			for(int i = 7; i < 14; i++) {
				if(i > 7 && i < 11) level.color[9][i] = 2;
				else level.color[9][i] = 1;
	        }
	        for(int i = 7; i < 14; i++) {
	        	if(i == 7 || i == 11) level.color[10][i] = 2;
	        	else level.color[10][i] = 1;
	        }
	        for(int i = 7; i < 14; i++) {
	        	if(i == 10) continue;
	        	else level.color[11][i] = 1;
	        }
	        for(int i = 8; i < 12; i++) {
	        	level.color[12][i] = 1;
	        }
	        for(int i = 8; i < 12; i++) {
	        	level.color[13][i] = 1;
	        }
	        level.color[14][10] = 1;
	        level.color[14][11] = 1;
			break;
		case 19:
			level = new Level(10, 9, 15);
			
			for(int i = 8; i < 17; i++) {
				if(i == 11) { 
					i = 13;
					continue;
				}
	        	level.color[8][i] = 1;
	        }
			for(int i = 8; i < 18; i++) {
				if(i == 9) continue;
				if(i == 16) level.color[9][i] = 2;
				else level.color[9][i] = 1;
	        }
	        for(int i = 8; i < 18; i++) {
	        	if(i == 16 || i == 15) level.color[10][i] = 2;
				else level.color[10][i] = 1;
	        }
	        for(int i = 8; i < 18; i++) {
	        	if(i == 11 || i == 16 || i == 15) level.color[11][i] = 2;
				else level.color[11][i] = 1;
	        }
	        for(int i = 11; i < 17; i++) {
	        	if(i == 14) continue;
	        	level.color[12][i] = 1;
	        }
			break;
		case 18:
			level = new Level(9, 9, 18);
			
			for(int i = 10; i < 17; i++) {
				if(i == 13 || i == 12) continue;
	        	level.color[8][i] = 1;
	        }
			for(int i = 9; i < 17; i++) {
				if(i == 11 || i == 14) level.color[9][i] = 2;
				else level.color[9][i] = 1;
	        }
	        for(int i = 9; i < 17; i++) {
	        	level.color[10][i] = 1;
	        }
	        for(int i = 9; i < 18; i++) {
	        	if(i == 13 || i == 16) level.color[11][i] = 2;
				else level.color[11][i] = 1;
	        }
	        for(int i = 9; i < 17; i++) {
	        	if(i == 11) level.color[12][i] = 2;
				else level.color[12][i] = 1;
	        }
	        for(int i = 8; i < 15; i++) {
	        	level.color[13][i] = 1;
	        }
	        for(int i = 8; i < 13; i++) {
	        	level.color[14][i] = 1;
	        }
			break;
		case 20:
			level = new Level(10, 8, 16);
			
			for(int i = 11; i < 15; i++) {
				if(i == 13) level.color[8][i] = 2;
				else level.color[8][i] = 1;
	        }
			for(int i = 9; i < 17; i++) {
				if(i == 12) continue;
				if(i > 12 && i < 16) level.color[9][i] = 2;
				else level.color[9][i] = 1;
	        }
	        for(int i = 8; i < 17; i++) {
	        	if(i == 9 || i == 13) level.color[10][i] = 2;
	        	else level.color[10][i] = 1;
	        }
	        for(int i = 9; i < 17; i++) {
	        	if(i == 11 || i == 12 || i == 14 || i == 15) level.color[11][i] = 2;
	        	else level.color[11][i] = 1;
	        }
	        for(int i = 10; i < 16; i++) {
	        	if(i == 11 || i == 12 || i == 14) level.color[12][i] = 2;
	        	else level.color[12][i] = 1;
	        }
	        for(int i = 11; i < 13; i++) {
	        	level.color[13][i] = 1;
	        }
			break;
		default:
			break;
		}
		
	}
}
