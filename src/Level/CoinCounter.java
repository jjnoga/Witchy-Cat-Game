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
    protected boolean isActive;
    protected final int x = 18;
    protected final int bottomY = 460;
    protected final int topY = 22;
    protected final int fontX = 20;
    protected final int fontBottomY = 490;
    protected final int fontTopY = 62;
    protected final int width = 60;
    protected final int height = 30;

    
    private SpriteFont text = null;
    private KeyLocker keyLocker = new KeyLocker();
    private Map map;
    
    int count = 1;

    public CoinCounter(Map map) {
        this.map = map;
    }

    public void addCoin(int coin) {
        count = count + coin;
    }


    public void update() {
        	String next = String.valueOf(count);

            // if camera is at bottom of screen, text is drawn at top of screen instead of the bottom like usual
            // to prevent it from covering the player
            int fontY;
            if (!map.getCamera().isAtBottomOfMap()) {
                fontY = fontBottomY;
            }
            else {
                fontY = fontTopY;
            }
            text = new SpriteFont(next, fontX, fontY, "Arial", 12, Color.black);

        
        

    }

    public void draw(GraphicsHandler graphicsHandler) {
        // if camera is at bottom of screen, textbox is drawn at top of screen instead of the bottom like usual
        // to prevent it from covering the player
        if (!map.getCamera().isAtBottomOfMap()) {
            graphicsHandler.drawFilledRectangleWithBorder(x, topY, width, height, Color.white, Color.black, 2);
        }
        else {
            graphicsHandler.drawFilledRectangleWithBorder(x, bottomY, width, height, Color.white, Color.black, 2);
        }
        if (text != null) {
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

