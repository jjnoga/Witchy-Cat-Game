package Screens;

import Engine.*;
import Scripts.Sounds;
import SpriteFont.SpriteFont;

import java.awt.*;

import javax.swing.ImageIcon;

// This class is for the win level screen
public class WinScreen extends Screen {
    protected SpriteFont winMessage;
    protected SpriteFont instructions;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    private ImageIcon rick;
    Sounds sound = new Sounds();
    boolean isPlaying = true;
    

    public WinScreen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        rick = new ImageIcon("Resources/rick.png");
        initialize();
    }

    @Override
    public void initialize() {
        winMessage = new SpriteFont("get trolled LOL", 225, 270, "Comic Sans", 50, Color.white);
        winMessage.setFontStyle(Font.BOLD);
        //instructions = new SpriteFont("Share with your friends to totally troll them!!!", 120, 300,"Comic Sans", 30, Color.white);
        keyLocker.lockKey(Key.SPACE);
        keyLocker.lockKey(Key.ESC);
    	
    }

    @Override
    public void update() {
    	
    	if(isPlaying) {
    		playMusic(15);
    		isPlaying = false;
    	}
    	
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, go back to main menu
        if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)) {
        	sound.stop();
            playLevelScreen.goBackToMenu();
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        //graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
    	graphicsHandler.drawImage(rick, 0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), null);
        winMessage.draw(graphicsHandler);
        //instructions.draw(graphicsHandler);
    }
    
    public void playMusic(int i) {
    	sound.setFile(i);
    	sound.play();
    	sound.loop();
    }
}
