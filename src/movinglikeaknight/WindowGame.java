package movinglikeaknight;


import java.awt.Component;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JFrame;

import customlevel.CustomLevel;
import img.*;

/**
 * The main window of the game
 */

public class WindowGame {
	public static final int WIDTH = 1055, HEIGHT = 730;
	
	private JFrame window;
	private Board board;
	private Level level;
	private Image title;
	private int currLevel = 0, finalLevel = 50, flags = 0;
	public int[] flagPos;
	private int totalPoint = 0;
	private LevelReader lvlReader;
	private MusicPlayer musicPlayer;
	private CustomLevel customLevel;
	private String theme;
	private String horseyTheme;
	
	private int menuVolume = -30, gameVolume = -30;

	public WindowGame(){
		window = new JFrame("movinglikeaknight");
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        lvlReader = new LevelReader();
        
        lvlReader.readData(this);
        lvlReader.readSetting(this);
        
        flagPos = lvlReader.readFlagPos(currLevel);
        
        musicPlayer = new MusicPlayer();
        
        title = new Title(this);
        
        window.addKeyListener(title);
        window.setVisible(true);
        window.add(title);
        
        musicPlayer.loop("titlemusic.wav", menuVolume);
	}
	
	public void startGame() {
		levelCreate(currLevel);
		
		window.remove(title);
		window.removeKeyListener(title);
		
		board = new Board(level, this, false);
		
		window.add(board);
		window.addKeyListener(board);
		window.revalidate();
		
		musicPlayer.stop("amthanhchienthang.wav");
		musicPlayer.loop("nhacvip.wav", gameVolume);
	}
	
	public void levelComplete(boolean isEasterEgg) {
		if(isEasterEgg) flags++;
		totalPoint += board.levelPoint;
		
		window.remove(board);
		window.removeKeyListener(board);
		
		currLevel++;
		levelCreate(currLevel);
		
		lvlReader.updateData(currLevel, flags, totalPoint);
		
		flagPos = lvlReader.readFlagPos(currLevel);
		board = new Board(level, this, false);
		title = new WinLevel(this, isEasterEgg);
		
		musicPlayer.stop("nhacvip.wav");
		
		window.add(title);
		window.addKeyListener(title);
		window.revalidate();
		musicPlayer.play("amthanhchienthang.wav", gameVolume);
	}
	
	public void loadEasterEgg(int id) {
		currLevel--;
		window.remove(board);
		window.removeKeyListener(board);
		levelCreate(id);
		board = new Board(level, this, true);
		
		musicPlayer.stop("nhacvip.wav");
		
		window.add(board);
		window.addKeyListener(board);
		window.revalidate();
	}
	
	public void victory() {
		window.remove(board);
		window.removeKeyListener(board);
		title = new Victory(this);
		window.add(title);
		window.revalidate();
	}
	
	public void resetData() {
		window.remove(board);
		window.removeKeyListener(board);
		
		lvlReader.updateData(0, 0, 0);
		lvlReader.readData(this);
		
		levelCreate(currLevel);
		
		flagPos = lvlReader.readFlagPos(currLevel);
		board = new Board(level, this, false);
		title = new ResetScreen(this);
		
		window.add(title);
		window.addKeyListener(title);
		window.revalidate();
	}
	
	public static void main(String[] args) {
        new WindowGame();
    }
	
	public void levelCreate(int currLevel) {
		level = lvlReader.readLevel(currLevel);
		//stage 6: 2-times tiles + teleporters
		//stage 7: stage 6 but teleporters may be skipped
		//stage 8: 3-times tiles + teleporters
		//stage 9: stage 8 but teleporters may be skipped
		//stage 10: ultimate bosses
	} 
	
	public void moreAndMore() {
		Component[] components = window.getContentPane().getComponents();
	    for (Component component : components) {
	        window.remove(component);
	        if (component instanceof KeyListener) {
	            window.removeKeyListener((KeyListener) component);
	        }
	    }
		
		title = new MidScreen(this);
		
		window.add(title);
		window.addKeyListener(title);
		window.revalidate();
	}
	
	public void returnToMenu() {
		window.remove(title);
		window.removeKeyListener(title);
		
		if(board != null) {
			window.remove(board);
			window.removeKeyListener(board);
		}
		
		lvlReader.updateData(currLevel, flags, totalPoint);
		
		title = new Title(this);
		
		window.add(title);
		window.addKeyListener(title);
		window.revalidate();
		
		musicPlayer.stop("nhacvip.wav");
		musicPlayer.stop("amthanhchienthang.wav");
		musicPlayer.loop("titlemusic.wav", menuVolume);
	}
	
	public void enterCustomLevel() {
		window.remove(title);
		window.removeKeyListener(title);
		
		customLevel = new CustomLevel(this);
		
		window.add(customLevel);
		window.addKeyListener(customLevel);
		window.revalidate();
	}
	
	public void editSavedLevel(File file) {
		level = lvlReader.readLevel(file);
		
		window.remove(title);
		window.removeKeyListener(title);
		
		musicPlayer.stop("titlemusic.wav");
		
		customLevel = new CustomLevel(this, level);
		
		window.add(customLevel);
		window.addKeyListener(customLevel);
		window.revalidate();
		
		musicPlayer.loop("titlemusic.wav", menuVolume);
	}
	
	public void savedLevels() {
		if(board != null) {
			window.remove(board);
			window.removeKeyListener(board);
		}
		window.remove(title);
		window.removeKeyListener(title);
		
		title = new SavedLevelScreen(this);
		
		window.add(title);
		window.addKeyListener(title);
		window.revalidate();
		
		musicPlayer.stop("nhacvip.wav");
		musicPlayer.stop("amthanhchienthang.wav");
	    musicPlayer.play("titlemusic.wav", menuVolume);
	}
	
	public void loadSavedLevel(File file) {
		level = lvlReader.readLevel(file);
				
		window.remove(title);
		window.removeKeyListener(title);
		
		musicPlayer.stop("titlemusic.wav");
		
		board = new Board(level, this, false);
		board.setCustom(file.getName());
		
		window.add(board);
		window.addKeyListener(board);
		window.revalidate();
		musicPlayer.loop("nhacvip.wav", gameVolume);
	}
	
	public void ggSpecialLevel(int state) {
		window.remove(board);
		window.removeKeyListener(board);
		
		title = new WinCustomLevel(this, state);
		
		musicPlayer.stop("nhacvip.wav");
		
		window.add(title);
		window.addKeyListener(title);
		window.revalidate();
		musicPlayer.play("amthanhchienthang.wav", gameVolume);
	}
	
	public void replay(int n) {
		levelCreate(n);
		
		window.remove(title);
		window.removeKeyListener(title);
		
		board = new Board(level, this, false);
		board.setReplay(n);
		
		window.add(board);
		window.addKeyListener(board);
		window.revalidate();
		
		musicPlayer.stop("titlemusic.wav");
		musicPlayer.loop("nhacvip.wav", gameVolume);
	}
	
	public void setting() {
		window.remove(title);
		window.removeKeyListener(title);
		
		title = new SettingScreen(this);
		
		window.add(title);
		window.addKeyListener(title);
		window.revalidate();
		
		musicPlayer.stop("titlemusic.wav");
	}
	
	public int getCurrLevel() {
		return currLevel;
	}
	
	public void setCurrLevel(int num) {
		if(num >= 0) {
			currLevel = num;
		}
	}
	
	public int getFlags() {
		return flags;
	}
	
	public void setFlags(int num) {
		if(num >= 0) {
			flags = num;
		}
	}
	
	public boolean isVictory() {
		return currLevel == finalLevel;
	}
	
	public int getTotalPoint() {
		return totalPoint;
	}
	
	public void setTotalPoint(int num) {
		if(num >= 0) {
			totalPoint = num;
		}
	}
	
	public void quit() {
	    window.dispose();
	    System.exit(0);
	}
	
	public JFrame getWindow() {
		return window;
	}
	
	public MusicPlayer getMusicPlayer() {
		return musicPlayer;
	}

	public int getMenuVolume() {
		return menuVolume;
	}

	public void setMenuVolume(int menuVolume) {
		this.menuVolume = menuVolume;
		lvlReader.updateSetting(this.menuVolume, gameVolume, theme, horseyTheme);
	}

	public int getGameVolume() {
		return gameVolume;
	}

	public void setGameVolume(int gameVolume) {
		this.gameVolume = gameVolume;
		lvlReader.updateSetting(menuVolume, this.gameVolume, theme, horseyTheme);
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
		lvlReader.updateSetting(menuVolume, gameVolume, this.theme, horseyTheme);
	}

	public String getHorseyTheme() {
		return horseyTheme;
	}

	public void setHorseyTheme(String horseyTheme) {
		this.horseyTheme = horseyTheme;
		lvlReader.updateSetting(menuVolume, gameVolume, theme, this.horseyTheme);
	}
	
	
}
