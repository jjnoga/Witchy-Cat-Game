package Screens;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenManager;
import Game.ScreenCoordinator;
import Scripts.Sounds;
import SpriteFont.SpriteFont;

import java.awt.*;

import javax.swing.ImageIcon;

public class HOS2Screen extends Screen{
	protected SpriteFont hos2Message;
	protected ScreenCoordinator screenCoordinator;
	protected KeyLocker keyLocker;
	
	public HOS2Screen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        initialize();
    }


	public void initialize() {
		hos2Message = new SpriteFont("If you are reading this, you must've stumbled upon it on your adventure...or you thought you would find something interesting.", 225, 270, "Comic Sans", 50, Color.white);
		hos2Message.setFontStyle(Font.BOLD);
        //instructions = new SpriteFont("Share with your friends to totally troll them!!!", 120, 300,"Comic Sans", 30, Color.white);
        keyLocker.lockKey(Key.SPACE);
        keyLocker.lockKey(Key.ESC);
		
	}

	
	public void update() {
		if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, it goes to the next screen
        if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)) {
//        	screenCoordinator.setGameState(null);
            
        }
	}

	
	public void draw(GraphicsHandler graphicsHandler) {
		
		
	}

}
