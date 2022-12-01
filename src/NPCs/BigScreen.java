package NPCs;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Level.Player;
import Utils.Point;

public class BigScreen extends NPC{
	 public BigScreen(int id, Point location) {
	        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("BigScreen.png"), 32, 32), "STAND_LEFT");
	    }

	    public void update(Player player) {
	        super.update(player);
	    }

	    @Override
	    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
	        return new HashMap<String, Frame[]>() {{
	            put("STAND_LEFT", new Frame[] {
	                    new FrameBuilder(spriteSheet.getSprite(0, 0))
	                            .withScale(3)
	                            .withBounds(7, 13, 11, 7)
	                            .build()
	            });
	            put("STAND_RIGHT", new Frame[] {
	                   new FrameBuilder(spriteSheet.getSprite(0, 0))
	                           .withScale(3)
	                           .withBounds(7, 13, 11, 7)
	                           .build()
	           });
	        }};
	    }

	    @Override
	    public void draw(GraphicsHandler graphicsHandler) {
	        super.draw(graphicsHandler);
	    }
}
