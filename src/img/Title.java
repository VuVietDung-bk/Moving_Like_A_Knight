package img;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import movinglikeaknight.WindowGame;

public class Title extends Image {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BufferedImage img;

	public Title(WindowGame window){
		super(window);
        img = ImageLoader.loadImage("title.png");
	}

	
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}

	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == KeyEvent.VK_SPACE) {
            window.startGame();
        }
	}

	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
