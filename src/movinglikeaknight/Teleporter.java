package movinglikeaknight;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import img.ImageLoader;

public class Teleporter {
	public int startX, startY, endX, endY, count;
	private BufferedImage teleIn, teleOut;
	
	public Teleporter(int startX, int startY, int endX, int endY, int count) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.count = count;
		teleIn = ImageLoader.loadImage("telein.png");
		teleOut = ImageLoader.loadImage("teleout.png");
	}
	
	public void render(Graphics g) {
		g.drawImage(teleIn, (startY + 1) * Board.blockSize, (startX + 1) * Board.blockSize, null);
		g.drawImage(teleOut, (endY + 1) * Board.blockSize, (endX + 1) * Board.blockSize, null);
		g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(Integer.toString(count), (startY + 1) * Board.blockSize + 7, (startX + 2) * Board.blockSize - 5);
        g.drawString(Integer.toString(count), (endY + 1) * Board.blockSize + 7, (endX + 2) * Board.blockSize - 5);
	}
	
	public void undoTele(Horsey horsey) {
		if(horsey.getX() == endX && horsey.getY() == endY) {
			horsey.setX(startX);
			horsey.setY(startY);
		}
	}
}
