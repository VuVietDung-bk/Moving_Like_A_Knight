package img;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import movinglikeaknight.FontLoader;
import movinglikeaknight.WindowGame;

public class Title extends Image {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int continueState = 0, replayState = 1, moreAndMoreState = 2, exitState = 3;
	private int currState = 0;
	private int replayLevel = 0;
	
	private Font font1, font2;

	private BufferedImage img, settingIcon, arrows;

	public Title(WindowGame window){
		super(window);
        img = ImageLoader.loadImage("title.png");
        settingIcon = ImageLoader.loadImage("settingicon.png");
        arrows = ImageLoader.loadImage("arrows.png");
        
        font1 = FontLoader.loadFont("ShopeeDisplay-Medium.ttf");
		font1 = FontLoader.modify(font1, 40, Font.TRUETYPE_FONT);
		
		font2 = FontLoader.loadFont("ShopeeDisplay-Medium.ttf");
		font2 = FontLoader.modify(font2, 20, Font.TRUETYPE_FONT);
	}

	
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
		g.drawImage(settingIcon, 10, 600, null);
        g.setFont(font1);
        String[] str = new String[] {
        		"CONTINUE",
        		"REPLAY",
        		"MORE", 
        		"EXIT"
        };
        for(int i = 0; i < 4; i++) {
        	if(i == currState) {
        		g.setColor(Color.WHITE);
        	} else g.setColor(Color.GRAY);
        	g.drawString(str[i], 400, 475 + 50*i);
        }
        
        if(currState == continueState) {
        	g.setColor(Color.WHITE);
        } else g.setColor(Color.GRAY);
        g.drawString(Integer.toString(window.getCurrLevel()), 638, 475);
        
        if(currState == replayState) {
        	g.drawImage(arrows, 580, 492, null);
        	g.setColor(Color.WHITE);
        	g.drawString(replayLevel >= 10 ? Integer.toString(replayLevel) : "0" + Integer.toString(replayLevel), 638, 525);
        }
        
        if(window.getCurrLevel() <= 30) {
        	g.setFont(font2);
            g.setColor(Color.GRAY);
            g.drawString("Beat level 30 for more!", 600, 575);
        }
	}

	private void progress() {
		if(currState == continueState) {
			window.getMusicPlayer().stop("titlemusic.wav");
            window.startGame();
		} else if (currState == replayState) {
			window.replay(replayLevel);
		} else if (currState == moreAndMoreState) {
			window.moreAndMore();
		} else if (currState == exitState) {
			window.quit();
		}
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == KeyEvent.VK_ENTER) {
			progress();
        }
	}

	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
        	currState = (currState + 1) % 4;
        	if(window.getCurrLevel() <= 30 && currState == moreAndMoreState) {
        		currState = exitState;
    		}
        } else if(e.getKeyCode() == KeyEvent.VK_UP) {
        	currState = (currState + 3) % 4;
        	if(window.getCurrLevel() <= 30 && currState == moreAndMoreState) {
        		currState = replayState;
    		}
        } else if(currState == replayState && e.getKeyCode() == KeyEvent.VK_LEFT) {
        	if(replayLevel > 0) {
        		replayLevel--;
        	}
        } else if(currState == replayState && e.getKeyCode() == KeyEvent.VK_RIGHT) {
        	if(replayLevel < window.getCurrLevel() - 1) {
        		replayLevel++;
        	}
        } else if(e.getKeyCode() == KeyEvent.VK_S) {
        	window.setting();
        }
	}

	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
