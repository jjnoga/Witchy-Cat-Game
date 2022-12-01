package NPCs;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Map;
import Level.NPC;
import Level.Player;
import Utils.Point;

public class NotMoyai extends NPC {
	private Map map;
	
	public NotMoyai(int id, Point location, Map map) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("moyai_head.png"), 25, 25), "STAND_LEFT");
        this.map = map;
    }

    public void update(Player player) {
        super.update(player);
        
        if(map.getFlagManager().isFlagSet("giveAllCoins")) {
        	this.isHidden = true;
        }
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(4)
                            .withBounds(7, 13, 11, 7)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(4)
                           .withBounds(7, 13, 11, 7)
                           .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                           .build()
           });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
