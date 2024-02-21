package movinglikeaknight;


import javax.swing.JFrame;

import img.*;

public class WindowGame {
	public static final int WIDTH = 1055, HEIGHT = 730;
	
	private JFrame window;
	private Board board;
	private Level level;
	private Image title;
	public int currLevel = 0, finalLevel = 40;
	protected int totalPoint;

	public WindowGame(){
		window = new JFrame("movinglikeaknight");
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        levelCreate(currLevel);
        title = new Title(this);
        board = new Board(level, this);
        totalPoint = 0;
        
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
		totalPoint += board.levelPoint;
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
			level = new Level(8, 8, 5, 0);
			
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
			level = new Level(11, 11, 3, 0);
			
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
			level = new Level(9, 9, 4, 0);
			
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
			level = new Level(9, 10, 5, 0);
			
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
			level = new Level(9, 9, 6, 0);
			
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
			level = new Level(9, 9, 7, 0);
			
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
			level = new Level(11, 11, 9, 0);
			
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
			level = new Level(14, 10, 11, 0);
			
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
			level = new Level(10, 10, 12, 0);
			
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
			level = new Level(9, 9, 13, 0);
			
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
			level = new Level(11, 14, 15, 0);
			
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
			level = new Level(9, 9, 4, 0);
			
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
			level = new Level(10, 10, 4, 0);
			
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
			level = new Level(9, 9, 7, 0);
			
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
			level = new Level(12, 12, 8, 0);
			
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
			level = new Level(11, 11, 10, 0);
			
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
			level = new Level(10, 10, 13, 0);
			
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
			level = new Level(8, 8, 13, 0);
			
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
			level = new Level(10, 9, 15, 0);
			
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
			level = new Level(9, 9, 18, 0);
			
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
			level = new Level(10, 8, 16, 0);
			
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
		case 21:
			level = new Level(10, 10, 2, 1);
			
			for(int i = 10; i < 16; i++) {
				level.color[10][i] = 1;
			}
			
			for(int i = 12; i < 14; i++) {
				level.color[11][i] = 1;
			}
			level.addTele(11, 12, 11, 13);
			break;
		case 22:
			level = new Level(10, 11, 3, 2);
			
			for(int i = 13; i < 15; i++) {
				level.color[9][i] = 1;
			}
			for(int i = 10; i < 15; i++) {
				level.color[10][i] = 1;
			}
			for(int i = 10; i < 15; i++) {
				level.color[11][i] = 1;
			}
			
			level.addTele(9, 13, 9, 14);
			level.addTele(11, 13, 10, 10);
			break;
		case 23:
			level = new Level(8, 10, 6, 1);
			
			level.color[8][10] = 1;
			for(int i = 10; i < 13; i++) {
				level.color[9][i] = 1;
			}
			for(int i = 9; i < 13; i++) {
				level.color[10][i] = 1;
			}
			for(int i = 8; i < 13; i++) {
				level.color[11][i] = 1;
			}
			for(int i = 8; i < 13; i++) {
				level.color[12][i] = 1;
			}
			for(int i = 8; i < 10; i++) {
				level.color[13][i] = 1;
			}
			
			level.addTele(9, 12, 10, 12);
			break;
		case 24:
			level = new Level(11, 11, 8, 2);
			
			for(int i = 9; i < 11; i++) {
				level.color[7][i] = 1;
			}
			for(int i = 9; i < 14; i++) {
				level.color[8][i] = 1;
			}
			for(int i = 9; i < 14; i++) {
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
			
			level.addTele(9, 10, 12, 9);
			level.addTele(9, 12, 10, 13);
			break;
		case 25:
			level = new Level(11, 11, 10, 1);
			
			for(int i = 10; i < 14; i++) {
				level.color[8][i] = 1;
			}
			for(int i = 8; i < 14; i++) {
				level.color[9][i] = 1;
			}
			for(int i = 8; i < 14; i++) {
				level.color[10][i] = 1;
			}
			for(int i = 8; i < 15; i++) {
				level.color[11][i] = 1;
			}
			for(int i = 8; i < 15; i++) {
				level.color[12][i] = 1;
			}
			for(int i = 11; i < 13; i++) {
				level.color[13][i] = 1;
			}
			
			level.addTele(13, 12, 10, 13);
			break;
		case 26:
			level = new Level(8, 8, 13, 1);
			
			for(int i = 8; i < 14; i++) {
				level.color[8][i] = 1;
			}
			for(int i = 8; i < 15; i++) {
				if(i == 12) continue;
				level.color[9][i] = 1;
			}
			for(int i = 8; i < 15; i++) {
				level.color[10][i] = 1;
			}
			for(int i = 8; i < 15; i++) {
				level.color[11][i] = 1;
			}
			for(int i = 8; i < 15; i++) {
				level.color[12][i] = 1;
			}
			for(int i = 9; i < 15; i++) {
				if(i == 10) continue;
				level.color[13][i] = 1;
			}
			for(int i = 9; i < 12; i++) {
				level.color[14][i] = 1;
			}
			
			level.addTele(12, 10, 12, 13);
			break;
		case 27:
			level = new Level(11, 11, 13, 3);
			
			for(int i = 9; i < 15; i++) {
				level.color[7][i] = 1;
			}
			for(int i = 9; i < 15; i++) {
				level.color[8][i] = 1;
			}
			for(int i = 9; i < 16; i++) {
				level.color[9][i] = 1;
			}
			for(int i = 8; i < 16; i++) {
				if(i == 14) continue;
				level.color[10][i] = 1;
			}
			for(int i = 8; i < 16; i++) {
				if(i == 9) continue;
				level.color[11][i] = 1;
			}
			for(int i = 8; i < 15; i++) {
				if(i == 13) continue;
				level.color[12][i] = 1;
			}
			for(int i = 11; i < 15; i++) {
				level.color[13][i] = 1;
			}
			
			level.addTele(9, 10, 8, 10);
			level.addTele(9, 12, 9, 13);
			level.addTele(13, 12, 13, 11);
			break;
		case 28:
			level = new Level(10, 10, 16, 3);
			
			for(int i = 10; i < 15; i++) {
				level.color[7][i] = 1;
			}
			for(int i = 8; i < 15; i++) {
				level.color[8][i] = 1;
			}
			for(int i = 8; i < 15; i++) {
				level.color[9][i] = 1;
			}
			for(int i = 8; i < 15; i++) {
				level.color[10][i] = 1;
			}
			for(int i = 8; i < 15; i++) {
				level.color[11][i] = 1;
			}
			for(int i = 8; i < 16; i++) {
				level.color[12][i] = 1;
			}
			for(int i = 9; i < 16; i++) {
				level.color[13][i] = 1;
			}
			for(int i = 9; i < 13; i++) {
				level.color[14][i] = 1;
			}
			
			level.addTele(9, 12, 8, 9);
			level.addTele(12, 10, 7, 14);
			level.addTele(9, 13, 10, 14);
			break;
		case 29:
			level = new Level(11, 11, 19, 1);
			
			for(int i = 9; i < 16; i++) {
				level.color[8][i] = 1;
			}
			for(int i = 8; i < 16; i++) {
				if(i == 12) continue;
				level.color[9][i] = 1;
			}
			for(int i = 8; i < 18; i++) {
				if(i == 9) continue;
				level.color[10][i] = 1;
			}
			for(int i = 8; i < 18; i++) {
				level.color[11][i] = 1;
			}
			for(int i = 9; i < 18; i++) {
				level.color[12][i] = 1;
			}
			for(int i = 9; i < 18; i++) {
				if(i == 16) continue;
				level.color[13][i] = 1;
			}
			for(int i = 11; i < 18; i++) {
				level.color[14][i] = 1;
			}
			for(int i = 13; i < 15; i++) {
				level.color[15][i] = 1;
			}
			
			level.addTele(12, 13, 11, 17);
			break;
		case 30:
			level = new Level(9, 9, 21, 4);
			
			for(int i = 11; i < 14; i++) {
				level.color[8][i] = 1;
			}
			for(int i = 9; i < 18; i++) {
				level.color[9][i] = 1;
			}
			for(int i = 9; i < 18; i++) {
				if(i == 16) continue;
				level.color[10][i] = 1;
			}
			for(int i = 9; i < 18; i++) {
				level.color[11][i] = 1;
			}
			for(int i = 7; i < 17; i++) {
				level.color[12][i] = 1;
			}
			for(int i = 7; i < 17; i++) {
				level.color[13][i] = 1;
			}
			for(int i = 7; i < 16; i++) {
				level.color[14][i] = 1;
			}
			for(int i = 7; i < 16; i++) {
				level.color[15][i] = 1;
			}
			level.color[16][7] = 1;
			
			level.addTele(8, 13, 14, 12);
			level.addTele(10, 10, 11, 12);
			level.addTele(11, 14, 10, 15);
			level.addTele(12, 11, 11, 10);
			break;	
		case 31:
			level = new Level(9, 8, 3, 0);
			
			level.color[7][9] = 1;
			for(int i = 9; i < 12; i++) {
				level.color[8][i] = 1;
			}
			for(int i = 8; i < 12; i++) {
				level.color[9][i] = 1;
			}
			for(int i = 10; i < 12; i++) {
				level.color[10][i] = 1;
			}
			
			level.addTele(10, 11, 7, 9);
			break;
		case 32:
			level = new Level(8, 8, 5, 1);
			
			for(int i = 11; i < 13; i++) {
				level.color[7][i] = 1;
			}
			for(int i = 8; i < 13; i++) {
				level.color[8][i] = 1;
			}
			for(int i = 8; i < 13; i++) {
				level.color[9][i] = 1;
			}
			for(int i = 8; i < 13; i++) {
				level.color[10][i] = 1;
			}
			
			level.addTele(9, 10, 10, 10);
			level.addTele(9, 11, 8, 9);
			break;
		case 33:
			level = new Level(9, 9, 7, 1);
			
			for(int i = 8; i < 11; i++) {
				level.color[8][i] = 1;
			}
			for(int i = 7; i < 13; i++) {
				level.color[9][i] = 1;
			}
			for(int i = 7; i < 13; i++) {
				if(i == 8) continue;
				level.color[10][i] = 1;
			}
			for(int i = 7; i < 13; i++) {
				level.color[11][i] = 1;
			}
			for(int i = 8; i < 11; i++) {
				level.color[12][i] = 1;
			}
			
			level.addTele(10, 11, 11, 7);
			level.addTele(9, 7, 11, 11);
			break;
		case 34:
			level = new Level(10, 10, 9, 1);
			
			for(int i = 11; i < 14; i++) {
				level.color[7][i] = 1;
			}
			for(int i = 11; i < 14; i++) {
				if(i == 12) continue;
				level.color[8][i] = 1;
			}
			for(int i = 9; i < 14; i++) {
				level.color[9][i] = 1;
			}
			for(int i = 9; i < 15; i++) {
				level.color[10][i] = 1;
			}
			for(int i = 9; i < 14; i++) {
				level.color[11][i] = 1;
			}
			for(int i = 10; i < 14; i++) {
				level.color[12][i] = 1;
			}
			for(int i = 10; i < 14; i++) {
				level.color[13][i] = 1;
			}
			
			level.addTele(10, 12, 10, 14);
			level.addTele(8, 11, 13, 12);
			level.addTele(9, 12, 7, 13);
			break;
		case 35:
			level = new Level(10, 10, 14, 2);
			
			for(int i = 10; i < 16; i++) {
				level.color[7][i] = 1;
			}
			for(int i = 9; i < 16; i++) {
				if(i == 14) continue;
				level.color[8][i] = 1;
			}
			for(int i = 9; i < 16; i++) {
				if(i == 10 || i == 12) continue;
				level.color[9][i] = 1;
			}
			for(int i = 9; i < 17; i++) {
				level.color[10][i] = 1;
			}
			for(int i = 10; i < 17; i++) {
				level.color[11][i] = 1;
			}
			for(int i = 9; i < 16; i++) {
				level.color[12][i] = 1;
			}
			for(int i = 9; i < 16; i++) {
				if(i == 14) continue;
				level.color[13][i] = 1;
			}
			
			level.addTele(8, 9, 8, 10);
			level.addTele(13, 13, 13, 15);
			level.addTele(12, 13, 11, 16);
			level.addTele(7, 13, 7, 12);
			break;
		case 36:
			level = new Level(10, 10, 14, 2);
			
			for(int i = 9; i < 15; i++) {
				if(i == 12) continue;
				level.color[7][i] = 1;
			}
			for(int i = 9; i < 15; i++) {
				level.color[8][i] = 1;
			}
			for(int i = 9; i < 15; i++) {
				level.color[9][i] = 1;
			}
			for(int i = 9; i < 15; i++) {
				level.color[10][i] = 1;
			}
			for(int i = 8; i < 15; i++) {
				level.color[11][i] = 1;
			}
			for(int i = 8; i < 15; i++) {
				level.color[12][i] = 1;
			}
			for(int i = 7; i < 12; i++) {
				level.color[13][i] = 1;
			}
			for(int i = 7; i < 10; i++) {
				level.color[14][i] = 1;
			}
			
			level.addTele(9, 12, 11, 8);
			level.addTele(8, 9, 7, 9);
			level.addTele(10, 14, 11, 13);
			break;
		case 37:
			level = new Level(11, 11, 15, 3);
			
			for(int i = 10; i < 17; i++) {
				if(i == 13) continue;
				level.color[9][i] = 1;
			}
			for(int i = 8; i < 17; i++) {
				if(i == 11) continue;
				level.color[10][i] = 1;
			}
			for(int i = 8; i < 16; i++) {
				level.color[11][i] = 1;
			}
			for(int i = 7; i < 16; i++) {
				level.color[12][i] = 1;
			}
			for(int i = 7; i < 16; i++) {
				level.color[13][i] = 1;
			}
			for(int i = 7; i < 16; i++) {
				level.color[14][i] = 1;
			}
			
			level.addTele(12, 9, 12, 10);
			level.addTele(12, 13, 11, 12);
			level.addTele(13, 12, 12, 12);
			level.addTele(13, 10, 13, 9);
			level.addTele(12, 14, 12, 15);
			break;
		case 38:
			level = new Level(9, 12, 19, 2);
			
			for(int i = 10; i < 14; i++) {
				level.color[7][i] = 1;
			}
			for(int i = 10; i < 14; i++) {
				level.color[8][i] = 1;
			}
			for(int i = 9; i < 15; i++) {
				level.color[9][i] = 1;
			}
			for(int i = 7; i < 17; i++) {
				level.color[10][i] = 1;
			}
			for(int i = 7; i < 17; i++) {
				level.color[11][i] = 1;
			}
			for(int i = 9; i < 15; i++) {
				level.color[12][i] = 1;
			}
			for(int i = 8; i < 16; i++) {
				level.color[13][i] = 1;
			}
			for(int i = 8; i < 16; i++) {
				if(i == 11) i = 13;
				level.color[14][i] = 1;
			}
			for(int i = 10; i < 14; i++) {
				if(i == 11) i = 13;
				level.color[15][i] = 1;
			}
			for(int i = 10; i < 14; i++) {
				level.color[16][i] = 1;
			}
			
			level.addTele(16, 12, 16, 11);
			level.addTele(10, 14, 10, 9);
			level.addTele(10, 13, 10, 10);
			level.addTele(13, 9, 13, 14);
			level.addTele(12, 11, 12, 12);
			break;
		case 39:
			level = new Level(13, 10, 18, 2);
			
			for(int i = 14; i < 16; i++) {
				level.color[7][i] = 1;
			}
			for(int i = 10; i < 16; i++) {
				level.color[8][i] = 1;
			}
			for(int i = 10; i < 16; i++) {
				level.color[9][i] = 1;
			}
			for(int i = 9; i < 16; i++) {
				level.color[10][i] = 1;
			}
			for(int i = 9; i < 16; i++) {
				level.color[11][i] = 1;
			}
			for(int i = 9; i < 17; i++) {
				level.color[12][i] = 1;
			}
			for(int i = 9; i < 17; i++) {
				level.color[13][i] = 1;
			}
			for(int i = 9; i < 15; i++) {
				level.color[14][i] = 1;
			}
			for(int i = 8; i < 15; i++) {
				level.color[15][i] = 1;
			}
			
			level.addTele(10, 11, 9, 11);
			level.addTele(11, 12, 10, 12);
			level.addTele(11, 13, 10, 13);
			level.addTele(11, 14, 10, 14);
			level.addTele(10, 15, 9, 15);
			break;
		case 40:
			level = new Level(7, 13, 31, 4);
			
			for(int i = 9; i < 19; i++) {
				level.color[7][i] = 1;
			}
			for(int i = 9; i < 19; i++) {
				level.color[8][i] = 1;
			}
			for(int i = 9; i < 19; i++) {
				level.color[9][i] = 1;
			}
			for(int i = 9; i < 21; i++) {
				level.color[10][i] = 1;
			}
			for(int i = 8; i < 21; i++) {
				level.color[11][i] = 1;
			}
			for(int i = 8; i < 19; i++) {
				if(i == 13) continue;
				level.color[12][i] = 1;
			}
			for(int i = 9; i < 21; i++) {
				level.color[13][i] = 1;
			}
			for(int i = 9; i < 21; i++) {
				if(i == 10) continue;
				level.color[14][i] = 1;
			}
			for(int i = 9; i < 19; i++) {
				level.color[15][i] = 1;
			}
			
			level.addTele(9, 14, 13, 14);
			level.addTele(11, 11, 11, 16);
			level.addTele(13, 10, 10, 16);
			level.addTele(13, 18, 12, 18);
			level.addTele(7, 14, 10, 15);
			break;
		default:
			break;
		}
		
	}
}
