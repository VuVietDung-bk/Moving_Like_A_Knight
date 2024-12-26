package img;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import movinglikeaknight.FontLoader;
import movinglikeaknight.WindowGame;

public class SavedLevelScreen extends Image {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BufferedImage img, arrowLeft, arrowRight, ins;
	
	private final int PAGE_SIZE = 10;
	private int currIndex = 0, currPage = 1, pageLength = 10;
	
	private List<File> savedLevels;
	private Font font1, font2;
	
	private int numberOfPages;
	private boolean deletingState = false;

	public SavedLevelScreen(WindowGame window){
		super(window);
        img = ImageLoader.loadImage("savedlevelscreen.png");
        arrowLeft = ImageLoader.loadImage("arrowleft.png");
        arrowRight = ImageLoader.loadImage("arrowright.png");
        ins = ImageLoader.loadImage("ins_saved_levels.png");
        savedLevels = new ArrayList<>();
        loadSavedLevels();
        numberOfPages = (savedLevels.size() - 1) / PAGE_SIZE + 1;
	}

	
	private void loadSavedLevels() {
		File folder = new File(System.getProperty("user.dir") + "\\data\\levels\\customlevels");
		File[] files = folder.listFiles();
        
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    savedLevels.add(file);
                }
            }
        }
        
        Collections.sort(savedLevels, Comparator.comparingLong(File::lastModified).reversed());
        
        font1 = FontLoader.loadFont("SVN-Comic Sans MS.ttf");
        font1 = FontLoader.modify(font1, 35, Font.BOLD);
        
        font2 = FontLoader.loadFont("ShopeeDisplay-Medium.ttf");
        font2 = FontLoader.modify(font2, 35, Font.BOLD);
        
        pageLength = Math.min(savedLevels.size() - (currPage - 1) * PAGE_SIZE, PAGE_SIZE);
	}


	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
		g.drawImage(ins, 0, 0, null);
		displayLevels(g);
		if(hasNextPage()) {
			g.drawImage(arrowRight, 941, 300, null);
		}
		if(hasPrevPage()) {
			g.drawImage(arrowLeft, 23, 300, null);
		}
		if(deletingState) {
			g.setColor(Color.WHITE);
        	g.drawString("Delete?", 800, 107 + 60 * currIndex);
		}
	}
	
	private void displayLevels(Graphics g) {
		int startIndex = (currPage - 1) * PAGE_SIZE;
        int endIndex = Math.min(startIndex + PAGE_SIZE, savedLevels.size());
        
        g.setColor(Color.WHITE);
        g.setFont(font2);
        
        String pageString = "Page " + Integer.toString(currPage) + "/" + Integer.toString(numberOfPages);
        g.drawString(pageString, 740, 32);
        
        g.setColor(Color.GRAY);
        g.setFont(font1);

        for (int i = startIndex; i < endIndex; i++) {
            File file = savedLevels.get(i);
            String fileName = file.getName();
            StringBuilder sb = new StringBuilder(fileName);
            sb.setLength(sb.length() - 4);
            String levelName = sb.toString();
            if(i - startIndex == currIndex) {
            	g.setColor(Color.WHITE);
            	g.drawString(levelName.toUpperCase(), 300, 107 + 60 * currIndex);
            	g.setColor(Color.GRAY);
            } else
            g.drawString(levelName.toUpperCase(), 300, 107 + 60 * (i - startIndex));
        }
	}
	
	private boolean hasNextPage() {
		return currPage * PAGE_SIZE < savedLevels.size();
	}
	
	private boolean hasPrevPage() {
		return currPage > 1;
	}

	private void progress() {
		window.loadSavedLevel(savedLevels.get((currPage - 1) * PAGE_SIZE + currIndex));
	}
	
	private void load() {
		window.editSavedLevel(savedLevels.get((currPage - 1) * PAGE_SIZE + currIndex));
	}
	
	private void nextPage() {
		if(hasNextPage()) {
			currPage++;
			pageLength = Math.min(savedLevels.size() - (currPage - 1) * PAGE_SIZE, PAGE_SIZE);
			currIndex = 0;
			deletingState = false;
		}
	}
	
	private void prevPage() {
		if(hasPrevPage()) {
			currPage--;
			pageLength = 10;
			currIndex = 0;
			deletingState = false;
		}
	}
	
	private void delete() {
		File file = savedLevels.remove((currPage - 1) * PAGE_SIZE + currIndex);
		file.delete();
		deletingState = false;
		numberOfPages = (savedLevels.size() - 1) / PAGE_SIZE + 1;
		if(currPage > numberOfPages && currPage > 1) {
			currPage--;
			pageLength = 10;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
        	nextPage();
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
        	prevPage();
        } else if(e.getKeyCode() == KeyEvent.VK_UP) {
        	currIndex = (currIndex + pageLength - 1) % pageLength;
        	deletingState = false;
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
        	currIndex = (currIndex + 1) % pageLength;
        	deletingState = false;
        } else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
        	if(!deletingState) progress();
        		else delete();
        } else if(e.getKeyCode() == KeyEvent.VK_E) {
        	window.moreAndMore();
        } else if(e.getKeyCode() == KeyEvent.VK_X) {
        	deletingState = true;
        } else if(e.getKeyCode() == KeyEvent.VK_L) {
        	load();
        } 
	}
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}