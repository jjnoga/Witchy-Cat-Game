package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the credits screen with the updated information from our group
public class CreditsScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont creditsLabel;
    protected SpriteFont createdByLabel;
    protected SpriteFont createdByLabelb;
    protected SpriteFont createdByLabelc;
    protected SpriteFont createdByLabeld;
    protected SpriteFont createdByLabele;
    protected SpriteFont createdByLabela;
    protected SpriteFont returnInstructionsLabel;

    public CreditsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        creditsLabel = new SpriteFont("Credits", 15, 35, "Times New Roman", 30, Color.black);
        createdByLabel = new SpriteFont("Created by Team Anita the Cat:", 130, 120, "Times New Roman", 20, Color.black);
        createdByLabela = new SpriteFont("Madi Smith,", 130, 140, "Times New Roman", 20, Color.black);
        createdByLabelb = new SpriteFont("Michael Ruocco,", 130, 160, "Times New Roman", 20, Color.black);
        createdByLabelc = new SpriteFont("Camryn Keller,", 130, 180, "Times New Roman", 20, Color.black);
        createdByLabeld = new SpriteFont("Joe Noga,", 130, 200, "Times New Roman", 20, Color.black);
        createdByLabele = new SpriteFont("and Nicholas Centeno", 130, 220, "Times New Roman", 20, Color.black);
        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 20, 560, "Times New Roman", 30, Color.black);
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        background.update(null);

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.MENU);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        creditsLabel.draw(graphicsHandler);
        createdByLabel.drawWithParsedNewLines(graphicsHandler);
        createdByLabela.drawWithParsedNewLines(graphicsHandler);
        createdByLabelb.drawWithParsedNewLines(graphicsHandler);
        createdByLabelc.drawWithParsedNewLines(graphicsHandler);
        createdByLabeld.drawWithParsedNewLines(graphicsHandler);
        createdByLabele.drawWithParsedNewLines(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}
