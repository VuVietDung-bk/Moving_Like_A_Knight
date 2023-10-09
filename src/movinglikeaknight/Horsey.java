package movinglikeaknight;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import img.ImageLoader;

public class Horsey {
	private int x, y;
	private Board board;
	private boolean shownDirection = false;
	private boolean choseDirection = false;
	private int currDirection = 0;
	private int steps = 0;
	private int currStep = 0;
	private BufferedImage horsey, smallDot, bigDot;
	
	private int[][][] directions;
	public boolean gameOver = false;
	
	public Horsey(int x, int y, int steps, Board board) {
		this.x = x;
		this.y = y;
		this.steps = steps;
		this.board = board;
		horsey = ImageLoader.loadImage("horsey.png");
		smallDot = ImageLoader.loadImage("smalldot.png");
		bigDot = ImageLoader.loadImage("bigdot.png");
		
		directions = new int[][][] {
			{
				{0, -1}, {0, -2}, {1, -2}
			}, 
			{
				{0, -1}, {0, -2}, {-1, -2}
			},
			{
				{-1, 0}, {-1, -1}, {-1, -2}
			},
			{
				{0, -1}, {-1, -1}, {-2, -1}
			},
			{
				{-1, 0}, {-2, 0}, {-2, -1}
			},
			{
				{-1, 0}, {-2, 0}, {-2, 1}
			},
			{
				{0, 1}, {-1, 1}, {-2, 1}
			},
			{
				{-1, 0}, {-1, 1}, {-1, 2}
			},
			{
				{0, 1}, {0, 2}, {-1, 2}
			},
			{
				{0, 1}, {0, 2}, {1, 2}
			},
			{
				{1, 0}, {1, 1}, {1, 2}
			},
			{
				{0, 1}, {1, 1}, {2, 1}
			},
			{
				{1, 0}, {2, 0}, {2, 1}
			},
			{
				{1, 0}, {2, 0}, {2, -1}
			},
			{
				{0, -1}, {1, -1}, {2, -1}
			},
			{
				{1, 0}, {1, -1}, {1, -2}
			},
		};
	}
	
	public void update() {
		if(winLevel()) return;
		checkGameOver();
	}
	
	public void render(Graphics g) {
		g.drawImage(horsey, (y + 1) * Board.blockSize, (x + 1) * Board.blockSize, null);
		if(shownDirection) {
			for(int i = 0; i < 2; i++) {
				g.drawImage(smallDot ,(y + directions[currDirection][i][1] + 1) * Board.blockSize, (x + directions[currDirection][i][0] + 1) * Board.blockSize, null);
			}
			g.drawImage(bigDot, (y + directions[currDirection][2][1] + 1) * Board.blockSize, (x + directions[currDirection][2][0] + 1) * Board.blockSize, null);
		} else if(choseDirection) {
			choseDirection = false;
			board.getBoard()[x][y]--;
			for(int i = 0; i < 2; i++) {
				board.getBoard()[x + directions[currDirection][i][0]][y + directions[currDirection][i][1]]--;
			}
			y = y + directions[currDirection][2][1];
			x = x + directions[currDirection][2][0];
			currStep++;
		}
	}
	
	public void checkGameOver() {
		for(int curr = 0; curr < 16; curr++) {
			int count = 0;
			for(int i = 0; i < 3; i++) {
				if(board.getBoard()[x + directions[curr][i][0]][y + directions[curr][i][1]] > 0) {
					count++;
				}
			}
			if(count == 3) {
				return;
			} 
		}
		gameOver = true;
	}
	
	public boolean winLevel() {
		if(currStep == steps)
			return true;
		else return false;
	}
	
	public void showDirection() {
		if(!shownDirection) {
			shownDirection = true;
			currDirection = 0;
		}
		currDirection = (currDirection + 1) % 16;
		int trial = 16;
		while(trial --> 0) {
			int count = 0;
			for(int i = 0; i < 3; i++) {
				if(board.getBoard()[x + directions[currDirection][i][0]][y + directions[currDirection][i][1]] > 0) {
					count++;
				}
			}
			if(count == 3) {
				break;
			} else currDirection = (currDirection + 1) % 16;
		}
		if(trial < 0) {
			//GAME OVER code here
			shownDirection = false;
			gameOver = true;
		}
	}
	
	public void chooseDirection() {
		if(shownDirection) {
			shownDirection = false;
			choseDirection = true;
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
