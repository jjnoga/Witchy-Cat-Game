package Level;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import SpriteFont.SpriteFont;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

// Represents the game's textbox
// will display the text it is given to its textQueue
// each String in the textQueue will be displayed in the textbox, and hitting the interact key will cycle between additional Strings in the queue
// use the newline character in a String in the textQueue to break the text up into a second line if needed
public class CoinCounter {
    protected boolean isActive = true;
    protected final int x = 10;
    protected final int bottomY = 444;
    protected final int topY = 4;
    protected final int fontX = 15;
    protected final int fontBottomY = 420;
    protected final int fontTopY = 23;
    protected final int width = 60;
    protected final int height = 30;

    
    private SpriteFont text = null;
    private Map map;
    
    int count = 0;

    public CoinCounter(Map map) {
        this.map = map;
        text = new SpriteFont("Coins: " + String.valueOf(count), fontX, fontTopY, "Arial", 12, Color.white);
    }

    public void addCoin(int coin) {
        count = count + coin;
        update();
       
    }

    public void update() {
    	text = new SpriteFont("Coins: " + String.valueOf(count), fontX, fontTopY, "Arial", 12, Color.white);
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // if camera is at bottom of screen, textbox is drawn at top of screen instead of the bottom like usual
        // to prevent it from covering the player
        if (!map.getCamera().isAtBottomOfMap()) {
            graphicsHandler.drawFilledRectangleWithBorder(x, topY, width, height, Color.black, Color.white, 2);
            text.draw(graphicsHandler);
        }
        else {
            graphicsHandler.drawFilledRectangleWithBorder(x, bottomY, width, height, Color.black, Color.white, 2);
            text.draw(graphicsHandler);
            
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    

}

