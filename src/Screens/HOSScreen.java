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


public class HOSScreen extends Screen{
	protected SpriteFont hosMessage1;
	protected SpriteFont hosMessage2;
	protected SpriteFont instuctions;
	protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    protected ScreenCoordinator screenCoordinator;
    Sounds sound = new Sounds();
    boolean isPlaying = true;
    
    public HOSScreen(ScreenCoordinator screenCoordinator2) {
        this.screenCoordinator = screenCoordinator2;
        initialize();
    }
	
	public void initialize() {
		hosMessage1 = new SpriteFont("Welcome dear traveler to the Hall of S", 225, 270, "Comic Sans", 50, Color.white);
        hosMessage1.setFontStyle(Font.BOLD);
        //instructions = new SpriteFont("Share with your friends to totally troll them!!!", 120, 300,"Comic Sans", 30, Color.white);
        keyLocker.lockKey(Key.SPACE);
        keyLocker.lockKey(Key.ESC);
		
	}

	public void update() {
		if(isPlaying) {
    		playMusic(16);
    		isPlaying = false;
    	}
		
		if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, it goes to the next screen
        if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)) {
//        	screenCoordinator.setGameState(null);
            
        }
		
	}

	public void draw(GraphicsHandler graphicsHandler) {
		graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
		hosMessage1.draw(graphicsHandler);
		
	}
	
	public void playMusic(int i) {
    	sound.setFile(i);
    	sound.play();
    	sound.loop();
    }

}
