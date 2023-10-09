package img;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import movinglikeaknight.WindowGame;

public class Image extends JPanel implements KeyListener{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WindowGame window;
	private Timer timer;
	
	public Image(WindowGame window){
        timer = new Timer(1000/60, new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		repaint();
			}
        });
        timer.start();
        this.window = window;
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
