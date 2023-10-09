package movinglikeaknight;

import java.util.Arrays;

public class Level {
	private final int boardHeight = 25, boardWidth = 35;
	public int[][] color = new int[boardHeight][boardWidth];
	public int horsey_x, horsey_y, horsey_step;
	Level(int x, int y, int step){
		horsey_x = x;
		horsey_y = y;
		horsey_step = step;
		for(int[] arr : color) {
			Arrays.fill(arr, -1);
		}
	}
}
