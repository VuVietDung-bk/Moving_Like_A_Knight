package movinglikeaknight;

import java.awt.image.BufferedImage;

import img.ImageLoader;

public class ThemeLoader {
	public static BufferedImage[] loadTileTheme(String theme) {
		BufferedImage[] colors = new BufferedImage[4];
		colors[0] = ImageLoader.loadImage(theme + "_0.png");
		colors[1] = ImageLoader.loadImage(theme + "_1.png");
		colors[2] = ImageLoader.loadImage(theme + "_2.png");
		colors[3] = ImageLoader.loadImage(theme + "_3.png");
		return colors;
	}
	
	public static BufferedImage loadDirtTheme(String theme) {
		return ImageLoader.loadImage(theme + "_dirt.png");
	}
	
	public static BufferedImage loadHorseyThemeLeft(String theme) {
		return ImageLoader.loadImage(theme + "horseyleft.png");
	}
	
	public static BufferedImage loadHorseyThemeRight(String theme) {
		return ImageLoader.loadImage(theme + "horseyright.png");
	}
}
