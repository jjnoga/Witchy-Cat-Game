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
import Scripts.Sounds;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;

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
	protected Font font= new Font(Font.SANS_SERIF, Font.BOLD, 15);
	protected SpriteFont sFont;

//	protected static int currentMenuItemHovered = 0;
//	protected static int menuItemSelected = -1;
//	protected static Stopwatch keyTimer = new Stopwatch();
//	protected static int pointerLocationX;
//	protected static int pointerLocationY;
//	protected int textX;
//	protected int textY;
	protected Sounds sound;
	protected String text = "Volume Controls";


	private KeyLocker keyLocker = new KeyLocker();
	private Map map;
	private Key interactKey = Key.I;

	public Options(Map map) {
		this.map = map;
	}

	public void update() {

		if (Keyboard.isKeyDown(interactKey) && !keyLocker.isKeyLocked(interactKey)) {
			keyLocker.lockKey(interactKey);
		} else if (Keyboard.isKeyUp(interactKey)) {
			keyLocker.unlockKey(interactKey);
		}
		
		//font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
	}

	public void draw(GraphicsHandler graphicsHandler) {
		//displays the options menu near the center of the screen, from the top.
		if (!map.getCamera().isAtBottomOfMap()) {
			graphicsHandler.drawFilledRectangleWithBorder(x*7/2, topY/2, width/2, height/2, Color.black, Color.white, 5);
			// graphicsHandler.drawFilledRectangleWithBorder(x, bottomY, width / 2, height,
			// Color.black, Color.white, 4);
			graphicsHandler.drawString(text, x*(39/8), topY+12, font, Color.white);
			graphicsHandler.drawString("A: Volume Up", x*15/4, topY*3, font, Color.white);
			graphicsHandler.drawString("D: Volume Down", x*15/4, topY*5, font, Color.white);
			graphicsHandler.drawString("S: Mute", x*15/4, topY*7, font, Color.white);
			
		} else {
			graphicsHandler.drawFilledRectangleWithBorder(x*7/2, bottomY+75, width/2, height/2, Color.black, Color.white, 5);
			graphicsHandler.drawString(text, x*(39/8), bottomY+100, font, Color.white);
			graphicsHandler.drawString("A: Volume Up", x*15/4, bottomY+135, font, Color.white);
			graphicsHandler.drawString("D: Volume Down", x*15/4, bottomY+175, font, Color.white);
			graphicsHandler.drawString("S: Mute", x*15/4, bottomY+215, font, Color.white);
			// graphicsHandler.drawFilledRectangleWithBorder(x, topY, width / 2, height,
			// Color.black, Color.white, 4);
		}

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

	public Key getInteractKey() {
		return this.interactKey;
	}

	public KeyLocker getKeyLocker() {
		return keyLocker;
	}

}
