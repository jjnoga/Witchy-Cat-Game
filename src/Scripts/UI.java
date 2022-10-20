package Scripts;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Engine.GamePanel;
import Engine.GraphicsHandler;

public class UI {
	GamePanel gp;
	Graphics2D g2;
	UI ui;
	
	
	public UI(GamePanel gp) {
		this.gp = gp;
	}
	
	
	public void drawOptions(GraphicsHandler graphicsHandler) {
		Color c = new Color(0,0,0);
		g2.setColor(c);
		g2.setFont(g2.getFont().deriveFont(32F));
		
		//SUB WINDOW
		int frameX = gp.tileSize*6;
		int frameY= gp.tileSize;
		int frameWidth= gp.tileSize*6;
		int frameHeight= gp.tileSize*8;
		drawSubWindow(frameX, frameY, frameWidth, frameHeight);
	}
	public void drawSubWindow(int x, int y, int width, int height){
		Color c = new Color (0,0,0, 200);
		g2.setColor(c);
		g2.fillRoundRect(x+5, y+5, width-10, height-10, 25, 25);
		
		c = new Color(55,255,255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.fillRoundRect(x, y, width, height, width, height);
	}
	
}
