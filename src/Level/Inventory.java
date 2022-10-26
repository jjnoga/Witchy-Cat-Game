package Level;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Scripts.Sounds;
import SpriteFont.SpriteFont;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Inventory {
    protected boolean isActive;
    protected final int x = 150;
    protected final int bottomY = 500;
    protected final int topY = 22;
    protected final int fontX = 35;
    protected final int fontBottomY = 500;
    protected final int fontTopY = 62;
    protected final int width = 500;
    protected final int height = 50;
    protected final int halfway = 250;
    protected final int imageWidth = 40;
    protected final int imageHeight = 40;
    
    public final int EMPTY = 0;
    public final int SWORD = 1;
    
    protected int currItem = EMPTY;
    private KeyLocker keyLocker = new KeyLocker();
    private Map map;
    private Key interactKey = Key.I;
    private Key dropKey = Key.E;
    
    //public Image testImage;
    private ImageIcon imageIcon;
    private ImageIcon goldLeaf;
    private ImageIcon iceSphere;
    private ImageIcon fireRose;
    private ImageIcon goldLeafHidden;
    private ImageIcon iceSphereHidden;
    private ImageIcon fireRoseHidden;
    
    protected Sounds sound = new Sounds();
    
    
    
    protected boolean dropCheck = false;
    
    private String sword = "Sword";
    private String swordFlavorText = "A blade far too big for a cat to carry. Use it to slash down vines!";

    public Inventory(Map map) {
        this.map = map;
        imageIcon = new ImageIcon("Resources/Sword.png");
        goldLeaf = new ImageIcon("Resources/GoldLeaf.png");
        iceSphere = new ImageIcon("Resources/iceSphere.png");
        fireRose = new ImageIcon("Resources/fireRose.png");
        goldLeafHidden = new ImageIcon("Resources/GoldLeaf_Hidden.png");
        iceSphereHidden = new ImageIcon("Resources/iceSphere_Hidden.png");
        fireRoseHidden = new ImageIcon("Resources/fireRose_Hidden.png");
    }
    

    public void update() {
    	
    	 if (Keyboard.isKeyDown(interactKey) && !keyLocker.isKeyLocked(interactKey)) {
             keyLocker.lockKey(interactKey);
         }
    	 else if (Keyboard.isKeyUp(interactKey)) {
             keyLocker.unlockKey(interactKey);
         }
    	 
    	 if(dropCheck) currItem = EMPTY;
         
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // if camera is at bottom of screen, textbox is drawn at top of screen instead of the bottom like usual
        // to prevent it from covering the player
    	
    		graphicsHandler.drawFilledRectangleWithBorder(3, halfway - 50, 50, 50, Color.gray, Color.black, 2);
    		graphicsHandler.drawFilledRectangleWithBorder(3, halfway, 50, 50, Color.gray, Color.black, 2);
    		graphicsHandler.drawFilledRectangleWithBorder(3, halfway + 50, 50, 50, Color.gray, Color.black, 2);
    		
    		if (map.getFlagManager().isFlagSet("hasIceSphere")) graphicsHandler.drawImage(iceSphere, 8, halfway - 45, imageWidth, imageHeight, null);
    		else graphicsHandler.drawImage(iceSphereHidden, 8, halfway - 45, imageWidth, imageHeight, null);
    		
    		if (map.getFlagManager().isFlagSet("hasFireRose")) graphicsHandler.drawImage(fireRose, 8, halfway + 5, imageWidth, imageHeight, null);
    		else graphicsHandler.drawImage(fireRoseHidden, 8, halfway + 5, imageWidth, imageHeight, null);
    		
    		if (map.getFlagManager().isFlagSet("hasGoldLeaf")) graphicsHandler.drawImage(goldLeaf, 8, halfway + 55, imageWidth, imageHeight, null);
    		else graphicsHandler.drawImage(goldLeafHidden, 8, halfway + 55, imageWidth, imageHeight, null);
    			
    		
    		
    	
            if (!map.getCamera().isAtBottomOfMap()) {
                graphicsHandler.drawFilledRectangleWithBorder(x, bottomY, width, height, Color.black, Color.white, 2);
                graphicsHandler.drawFilledRectangleWithBorder(x, bottomY, width / 3, height, Color.black, Color.white, 3);
            }
            else {
                graphicsHandler.drawFilledRectangleWithBorder(x, topY, width, height, Color.black, Color.white, 2);
                graphicsHandler.drawFilledRectangleWithBorder(x, topY, width / 3, height, Color.black, Color.white, 3);
            }
            
            switch(currItem)
            {
            	case SWORD: {
            		if (!map.getCamera().isAtBottomOfMap()) {
            			graphicsHandler.drawImage(imageIcon, x + 15, bottomY, width / 4, height, null);
            			graphicsHandler.drawString(sword, x + 172, bottomY + 18, new Font(Font.SANS_SERIF, Font.BOLD, 16), Color.orange);
            			graphicsHandler.drawString(swordFlavorText, x + 172, bottomY + 35, new Font(Font.SANS_SERIF, Font.ITALIC, 11), Color.lightGray);
            		}
                    else {
                    	graphicsHandler.drawImage(imageIcon, x + 15, topY, width / 4, height, null);
                    	graphicsHandler.drawString(sword, x + 172, topY + 18, new Font(Font.SANS_SERIF, Font.BOLD, 16), Color.orange);
            			graphicsHandler.drawString(swordFlavorText, x + 172, topY + 35, new Font(Font.SANS_SERIF, Font.ITALIC, 11), Color.lightGray);
                    }
            	}
            	break;
            };
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
        playSE(6);
    }

    public void setInteractKey(Key interactKey) {
        this.interactKey = interactKey;
    }
    
    public Key getInteractKey()
    {
    	return this.interactKey;
    }
    
    public void setDropKey(Key dropKey) {
        this.dropKey = dropKey;
    }
    
    public Key getDropKey()
    {
    	return this.dropKey;
    }

    public KeyLocker getKeyLocker()
    {
    	return keyLocker;
    }
    
    public int getCurrItem()
    {
    	return currItem;
    }
    
    public void setCurrItem(int item)
    {
    	this.currItem = item;
    }
    
    public void playSE(int i) {
    	sound.setFile(i);
    	sound.play();
    }
}