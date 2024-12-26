package img;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import movinglikeaknight.Board;
import movinglikeaknight.WindowGame;

public class WinCustomLevel extends Image {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage img;
	private int state = 0;

	public WinCustomLevel(WindowGame window, int state) {
		super(window);
		img = ImageLoader.loadImage("gg.png");
		this.state = state;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyTyped(e);
		if(e.getKeyChar() == KeyEvent.VK_SPACE) {
			if(state == Board.CUSTOM)
				window.savedLevels();
			else if(state == Board.REPLAY) {
				window.returnToMenu();
			}
        }
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyReleased(e);
	}

}

