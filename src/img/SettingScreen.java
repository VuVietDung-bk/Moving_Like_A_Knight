package img;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import movinglikeaknight.FontLoader;
import movinglikeaknight.ThemeLoader;
import movinglikeaknight.WindowGame;

public class SettingScreen extends Image {

	private static final long serialVersionUID = 1L;

	private BufferedImage exitIcon, mouse;

	private final int MENU_MUSIC_STATE = 0, GAME_MUSIC_STATE = 1, THEME_STATE = 2, HORSEY_STATE = 3;
	private String[] str = new String[] { "MENU MUSIC", "INGAME MUSIC", "THEME", "HORSEY" };
	private int currState = 0;
	private int menuVolume, gameVolume, currTheme, currHorseyTheme;

	private String[] themes = { "grass", "stone" };
	private BufferedImage[][] themeImages = new BufferedImage[themes.length][];
	private BufferedImage[] themeDirts = new BufferedImage[themes.length];

	private String[] horseyThemes = { "default", "mad" };
	private BufferedImage[][] horseyImages = new BufferedImage[horseyThemes.length][2];

	private Font font1, font2;

	public SettingScreen(WindowGame window) {
		super(window);
		// TODO Auto-generated constructor stub
		exitIcon = ImageLoader.loadImage("exiticon.png");
		mouse = ImageLoader.loadImage("mouse.png");

		font1 = FontLoader.loadFont("ShopeeDisplay-Medium.ttf");
		font1 = FontLoader.modify(font1, 26, Font.BOLD);

		font2 = FontLoader.loadFont("ShopeeDisplay-Medium.ttf");
		font2 = FontLoader.modify(font2, 45, Font.BOLD);

		menuVolume = window.getMenuVolume();
		gameVolume = window.getGameVolume();

		for (int i = 0; i < themes.length; i++) {
			if (themes[i].equals(window.getTheme())) {
				currTheme = i;
				break;
			}
		}

		for (int i = 0; i < themes.length; i++) {
			themeImages[i] = ThemeLoader.loadTileTheme(themes[i]);
			themeDirts[i] = ThemeLoader.loadDirtTheme(themes[i]);
		}
		
		for (int i = 0; i < horseyThemes.length; i++) {
			if (horseyThemes[i].equals(window.getHorseyTheme())) {
				currHorseyTheme = i;
				break;
			}
		}
		
		for (int i = 0; i < horseyThemes.length; i++) {
			horseyImages[i][0] = ThemeLoader.loadHorseyThemeLeft(horseyThemes[i]);
			horseyImages[i][1] = ThemeLoader.loadHorseyThemeRight(horseyThemes[i]);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.drawImage(exitIcon, 10, 10, null);

		g.setFont(font2);
		g.setColor(Color.WHITE);
		g.drawString("SETTINGS", 410, 50);

		g.setFont(font1);

		for (int i = 0; i < 4; i++) {
			if (i == currState) {
				g.setColor(Color.WHITE);
			} else
				g.setColor(Color.GRAY);
			if (i == 3) {
				g.drawString(str[i], 60, 450);
			} else
				g.drawString(str[i], 60, 110 + 60 * i);
		}

		if (currState == MENU_MUSIC_STATE) {
			g.setColor(Color.WHITE);
		} else
			g.setColor(Color.GRAY);

		int temp = menuVolume + 80;
		g.drawString("" + temp, 300, 110);
		g.fillRect(350, 90, 606, 20);
		g.fillRect(350 + 6 * (menuVolume + 80), 80, 6, 40);

		if (currState == GAME_MUSIC_STATE) {
			g.setColor(Color.WHITE);
		} else
			g.setColor(Color.GRAY);

		temp = gameVolume + 80;
		g.drawString("" + temp, 300, 170);
		g.fillRect(350, 150, 606, 20);
		g.fillRect(350 + 6 * (gameVolume + 80), 140, 6, 40);

		for (int i = 0; i < themes.length; i++) {
			g.drawImage(themeDirts[i], 175 + 125 * i, 275, 100, 100, null);
			for (int j = 0; j < 4; j++) {
				g.drawImage(themeImages[i][j], 200 + 125 * i + 25 * (j % 2), 300 + 25 * (j / 2), null);
			}
		}
		if (currState == THEME_STATE) {
			g.drawImage(mouse, 200 + 125 * currTheme, 200, null);
		}
		
		g.setColor(Color.GRAY);
		for (int i = 0; i < horseyThemes.length; i++) {
			g.fillRect(200 + 125 * i, 475, 50, 25);
			for (int j = 0; j < 2; j++) {
				g.drawImage(horseyImages[i][j], 200 + 125 * i + 25 * j, 475, null);
			}
		}
		if (currState == HORSEY_STATE) {
			g.drawImage(mouse, 200 + 125 * currHorseyTheme, 400, null);
		}

	}

	private void modifySettings(int i) {
		if (currState == MENU_MUSIC_STATE) {
			menuVolume += i;
			if (menuVolume <= 20 && menuVolume >= -80) {
				window.setMenuVolume(menuVolume);
			} else
				menuVolume -= i;
		} else if (currState == GAME_MUSIC_STATE) {
			gameVolume += i;
			if (gameVolume <= 20 && gameVolume >= -80) {
				window.setGameVolume(gameVolume);
			} else
				gameVolume -= i;
		} else if (currState == THEME_STATE) {
			currTheme = (currTheme + themes.length - i) % themes.length;
			window.setTheme(themes[currTheme]);
		} else if (currState == HORSEY_STATE) {
			currHorseyTheme = (currHorseyTheme + horseyThemes.length - i) % horseyThemes.length;
			window.setHorseyTheme(horseyThemes[currHorseyTheme]);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_E) {
			window.returnToMenu();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			currState = (currState + 1) % 4;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			currState = (currState + 3) % 4;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			modifySettings(-1);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			modifySettings(1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
