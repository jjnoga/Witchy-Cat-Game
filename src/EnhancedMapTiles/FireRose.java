package EnhancedMapTiles;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import Engine.Key;
import Engine.Keyboard;
import GameObject.Frame;
import GameObject.GameObject;
import GameObject.SpriteSheet;
import Level.CoinCounter;
import Level.EnhancedMapTile;
import Level.Map;
import Level.Player;
import Level.PlayerState;
import Level.TileType;
import Maps.TestMap;
import Scripts.Sounds;
import Utils.Direction;
import Utils.Point;

// for collecting the coins
public class FireRose extends EnhancedMapTile {
	protected Sounds sound;
	protected Map map;
	
    public FireRose(Point location, Map testMap) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("FireRose.png"),16, 16), TileType.NOT_PASSABLE);
        sound  = new Sounds();
        this.map = testMap;
    }

	@Override
    public void update(Player player) {
        super.update(player);
        if (player.overlaps(this) && Keyboard.isKeyDown(Key.SPACE) && !this.isHidden) {
      		map.getFlagManager().setFlag("hasFireRose");
      		//sound.stop();
            playSE(3);
            this.isHidden = true;
      	}
        else this.isHidden = false;
        
        
    }
    
    public void playSE(int i) {
		sound.setFile(i);
		sound.play();
	}

    @Override
    protected GameObject loadBottomLayer(SpriteSheet spriteSheet) {
        Frame frame = new FrameBuilder(spriteSheet.getSubImage(0, 0))
                .withScale(1.5f)
                .build();
        		
        return new GameObject(x+12, y, frame);
    }
}
