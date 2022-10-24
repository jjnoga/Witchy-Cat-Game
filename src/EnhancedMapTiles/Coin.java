package EnhancedMapTiles;

import Builders.FrameBuilder;
import Engine.ImageLoader;
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
public class Coin extends EnhancedMapTile {
	protected Sounds sound;
	protected Map map;
	private boolean hasInteracted = false;
	
    public Coin(Point location, Map map) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Coinss.png"),16, 16), TileType.PASSABLE);
        sound  = new Sounds();
        this.map = map;
    }

    @Override
    public void update(Player player) {
        super.update(player);
        
        if (player.overlaps(this) && !hasInteracted)
        {
        	map.setHasChangedCoins(true);
            playSE(1);
            hasInteracted = true;
            this.isHidden = true;
        }
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
