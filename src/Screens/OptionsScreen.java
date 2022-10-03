package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import Scripts.Sounds;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;

import java.awt.*;

import javax.swing.JToggleButton;


public class OptionsScreen extends Screen{
	protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont optionsLabel;
    protected SpriteFont volumeLabel;
    protected SpriteFont hintLabel;
    protected SpriteFont darkMLabel;
    protected SpriteFont returnInstructionsLabel;
    protected SpriteFont returnInstructionsLabel2;
    protected JToggleButton toggle1;
    protected JToggleButton toggle2;
    protected JToggleButton toggle3;
    protected SpriteFont on;
    protected SpriteFont on2;
    protected SpriteFont mute;
    protected Color col;
    
    protected int currentMenuItemHovered = 0;
    protected int menuItemSelected = -1;
    protected Stopwatch keyTimer = new Stopwatch();
    protected int pointerLocationX, pointerLocationY;
    
    Sounds sound = new Sounds();
  

    public OptionsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }
    
	@Override
	public void initialize() {
		 background = new TitleScreenMap();
	     background.setAdjustCamera(false);
	     col = Color.red;
	     optionsLabel = new SpriteFont("Options", 15, 35, "Times New Roman", 30, Color.black);
	     volumeLabel = new SpriteFont("Volume:", 150, 140, "Times New Roman", 20, Color.black);
	     volumeLabel.setOutlineColor(Color.gray);
	     volumeLabel.setOutlineThickness(2);
	     mute = new SpriteFont("Mute Off", 150, 190, "Times New Roman", 20, Color.black);
	     mute.setOutlineColor(Color.gray);
	     mute.setOutlineThickness(2);
	     hintLabel = new SpriteFont("Hints:",150, 240, "Times New Roman", 20, Color.black);
	     hintLabel.setOutlineColor(Color.gray);
	     hintLabel.setOutlineThickness(2);
	     on = new SpriteFont("Off", 150, 290, "Times New Roman", 20, Color.black);
	     on.setOutlineColor(Color.gray);
	     on.setOutlineThickness(2);
	     darkMLabel = new SpriteFont("Dark Mode:", 150, 340, "Times New Roman", 20, Color.black);
	     darkMLabel.setOutlineColor(Color.gray);
	     darkMLabel.setOutlineThickness(2);
	     on2 = new SpriteFont("Off", 150, 390, "Times New Roman", 20, Color.black);
	     on2.setOutlineColor(Color.gray);
	     on2.setOutlineThickness(2);
	     returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 20, 560, "Times New Roman", 30, Color.black);
	     returnInstructionsLabel2 = new SpriteFont("Press Enter/Esc to return to toggle the options", 250, 35, "Times New Roman", 30, Color.black);
	     toggle1 = new JToggleButton("Mute Off");
	     toggle2 = new JToggleButton("Off");
	     toggle3 = new JToggleButton("Off");
	     keyLocker.lockKey(Key.SPACE); //without this keyLock, the space button would continuously press, resulting in it not staying on the menu
	     keyLocker.lockKey(Key.ENTER);
	     keyLocker.lockKey(Key.ESC);
	     menuItemSelected = -1;
	     keyTimer.setWaitTime(200);
	}

	@Override
	public void update() {
		background.update(null);

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.MENU);
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
		}
            else if (currentMenuItemHovered > 1) {
        	currentMenuItemHovered = 2;
        }
        
        if (currentMenuItemHovered == 0) {
			mute.setColor(new Color(255, 215, 0));
			on.setColor(col);
			on2.setColor(col);
			pointerLocationX = 170;
			pointerLocationY = 190;
		} else if (currentMenuItemHovered == 1) {
			mute.setColor(col);
			on.setColor(new Color(255, 215, 0));
			on2.setColor(col);
			pointerLocationX = 170;
			pointerLocationY = 290;
		} else if (currentMenuItemHovered == 2) {
			mute.setColor(col);
			on.setColor(col);
			on2.setColor(new Color(255, 215, 0));
			pointerLocationX = 170;
			pointerLocationY = 390;
		}
        
    	if (Keyboard.isKeyUp(Key.ENTER)) {
			keyLocker.unlockKey(Key.ENTER);
		}
    	
    	if (Keyboard.isKeyUp(Key.ESC)) {
    		keyLocker.unlockKey(Key.ESC);
    	}
    	
    	
    	
		if (!keyLocker.isKeyLocked(Key.ENTER) && Keyboard.isKeyDown(Key.ENTER)) {
			menuItemSelected = currentMenuItemHovered;
			if (menuItemSelected == 0) {
//				mute.setColor(col);
//				on.setColor(Color.red);
//				on2.setColor(Color.red);
				//col = Color.blue;
				mute.setText("Mute On");
				mute.setColor(Color.green);
			} else if (menuItemSelected == 1) {
//				mute.setColor(Color.red);
//				on.setColor(col);
//				on2.setColor(Color.red);
				//col = Color.blue;
				on.setText("On");
				mute.setColor(Color.green);
			} else if (menuItemSelected == 2) {
//				mute.setColor(Color.red);
//				on.setColor(Color.red);
//				on2.setColor(col);
				//col = Color.blue;
				on2.setText("On");
				mute.setColor(Color.green);
			}
		}
		
		if (!keyLocker.isKeyLocked(Key.ESC) && Keyboard.isKeyDown(Key.ESC)) {
			menuItemSelected = currentMenuItemHovered;
			if (menuItemSelected == 0) {
//				mute.setColor(col);
//				on.setColor(Color.red);
//				on2.setColor(Color.red);
				//col = Color.blue;
				mute.setText("Mute Off");
				mute.setColor(Color.red);
			} else if (menuItemSelected == 1) {
//				mute.setColor(Color.red);
//				on.setColor(col);
//				on2.setColor(Color.red);
				//col = Color.blue;
				on.setText("Off");
				mute.setColor(Color.red);
			} else if (menuItemSelected == 2) {
//				mute.setColor(Color.red);
//				on.setColor(Color.red);
//				on2.setColor(col);
				//col = Color.blue;
				on2.setText("Off");
				mute.setColor(Color.red);
			}
		}
		
		if(mute.getText() == "Mute Off") {
			sound.stop();
		}else if (mute.getText() == "Mute On") {;
			sound.play();
		}
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		 background.draw(graphicsHandler);
	     optionsLabel.draw(graphicsHandler);
	     volumeLabel.drawWithParsedNewLines(graphicsHandler);
	     darkMLabel.drawWithParsedNewLines(graphicsHandler);
	     hintLabel.drawWithParsedNewLines(graphicsHandler);
	     mute.drawWithParsedNewLines(graphicsHandler);
	     on.drawWithParsedNewLines(graphicsHandler);
	     on2.drawWithParsedNewLines(graphicsHandler);
	     returnInstructionsLabel.draw(graphicsHandler);
	     returnInstructionsLabel2.draw(graphicsHandler);   
	}
	
	public int getMenuItemSelected() {
		return menuItemSelected;
	}
}
