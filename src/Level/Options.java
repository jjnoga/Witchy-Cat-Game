package Level;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import Engine.GamePanel;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import SpriteFont.SpriteFont;

public class Options {
	protected boolean isActive;
    protected int x = 150;
    protected int bottomY = 300;
    protected int topY = 22;
//    protected final int fontX = 35;
//    protected final int fontBottomY = 300;
//    protected final int fontTopY = 62;
    protected int width = 500;
    protected int height = 350;
    protected Graphics2D g2;
    protected GamePanel gp;
    protected Font font;
    
    
    private KeyLocker keyLocker = new KeyLocker();
    private Map map;
    private Key interactKey = Key.O;
    
    public Options(Map map) {
        this.map = map;
    }
    
    public void intialize() {
    	int textX;
    	int textY;
    	
    	
    	String text = "Options";
    	font = new Font(text, 10,(int) 6.5);
    	textX = getXCenteredText(text);
    	textY = topY + width;
    	g2.drawString(text, textX, textY);
    }
    
    public void update() {
    	
   	 if (Keyboard.isKeyDown(interactKey) && !keyLocker.isKeyLocked(interactKey)) {
            keyLocker.lockKey(interactKey);
        }
   	 else if (Keyboard.isKeyUp(interactKey)) {
            keyLocker.unlockKey(interactKey);
        }
   	 
   	System.out.println(g2.getFontMetrics());
   	 
   
    }
    
    public void draw(GraphicsHandler graphicsHandler) {
        // if camera is at bottom of screen, textbox is drawn at top of screen instead of the bottom like usual
        // to prevent it from covering the player
            if (!map.getCamera().isAtTopOfMap()) {
                graphicsHandler.drawFilledRectangleWithBorder(x, topY, width, height, Color.black, Color.white, 5);
                //graphicsHandler.drawFilledRectangleWithBorder(x, bottomY, width / 2, height, Color.black, Color.white, 4); 
            }
            else {
                graphicsHandler.drawFilledRectangleWithBorder(x, bottomY, width, height, Color.black, Color.white, 5);
               // graphicsHandler.drawFilledRectangleWithBorder(x, topY, width / 2, height, Color.black, Color.white, 4);
            }
            
            String text = "Options";
            g2.drawString(text, x*2, topY);
           
    }
    
    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setInteractKey(Key interactKey) {
        this.interactKey = interactKey;
    }
    
    public Key getInteractKey()
    {
    	return this.interactKey;
    }
    
    public KeyLocker getKeyLocker()
    {
    	return keyLocker;
    }
    
    public int getXCenteredText(String text) {
    	
    	//String textS = "Options";
    	font = new Font(text, 10,(int) 6.5);
    	g2.getFontMetrics(font);
		int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
		int x = this.width/2 - length/2;
		return x;
    }
}
