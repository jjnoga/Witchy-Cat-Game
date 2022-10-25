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
	protected Font font;

	protected static int currentMenuItemHovered = 0;
	protected static int menuItemSelected = -1;
	protected static Stopwatch keyTimer = new Stopwatch();
	protected static int pointerLocationX;
	protected static int pointerLocationY;
	protected int textX;
	protected int textY;


	private KeyLocker keyLocker = new KeyLocker();
	private Map map;
	private Key interactKey = Key.O;

	public Options(Map map) {
		this.map = map;
	}

	public void intialize() {
	
		String text = "Options";
		font = new Font(text, 10, (int) 6.5);
		
		g2.drawString(text, textX, textY);
	}

	public void update() {

		if (Keyboard.isKeyDown(interactKey) && !keyLocker.isKeyLocked(interactKey)) {
			keyLocker.lockKey(interactKey);
		} else if (Keyboard.isKeyUp(interactKey)) {
			keyLocker.unlockKey(interactKey);
		}

		if (Keyboard.isKeyDown(Key.DOWN) && keyTimer.isTimeUp()) {
			keyTimer.reset();
			currentMenuItemHovered++;
		} else if (Keyboard.isKeyDown(Key.UP) && keyTimer.isTimeUp()) {
			keyTimer.reset();
			currentMenuItemHovered--;
		}

		if (currentMenuItemHovered > 2 || currentMenuItemHovered < 0) {
			currentMenuItemHovered = 0;
		} else if (currentMenuItemHovered > 0 && currentMenuItemHovered < 2) {
			currentMenuItemHovered = 1;
		} else if (currentMenuItemHovered > 1) {
			currentMenuItemHovered = 2;
		}
		System.out.println(g2.getFontMetrics());

	}

	public void draw(GraphicsHandler graphicsHandler) {
		//displays the options menu near the center of the screen, from the top.
		if (!map.getCamera().isAtTopOfMap()) {
			graphicsHandler.drawFilledRectangleWithBorder(x, topY, width, height, Color.black, Color.white, 5);
			// graphicsHandler.drawFilledRectangleWithBorder(x, bottomY, width / 2, height,
			// Color.black, Color.white, 4);
		} else {
			graphicsHandler.drawFilledRectangleWithBorder(x, bottomY, width, height, Color.black, Color.white, 5);
			// graphicsHandler.drawFilledRectangleWithBorder(x, topY, width / 2, height,
			// Color.black, Color.white, 4);
		}

		String text = "Options";
		textX = getXCenteredText(text);
		textY = topY + width;
		g2.drawString(text, textX, textY);

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

	public int getMenuItemSelected() {
		return menuItemSelected;
	}

	public int getXCenteredText(String text) {

		// String textS = "Options";
		font = new Font(Font.SANS_SERIF, Font.ITALIC, 11);
		g2.getFontMetrics(font);
		int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = this.width / 2 - length / 2;
		return x;
	}
}
