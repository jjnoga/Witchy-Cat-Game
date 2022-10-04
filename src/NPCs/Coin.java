package NPCs;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import SpriteFont.SpriteFont;
import Utils.Point;

import java.awt.Color;
import java.util.HashMap;

// This class is for the coin
public class Coin extends NPC {
	protected SpriteFont counter;

    public Coin(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("Coinss.png"), 20,20), "STAND_LEFT");
    }

    
    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(1)
                            .withBounds(5, 6, 6, 11)
                            .build()
            });
            
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
