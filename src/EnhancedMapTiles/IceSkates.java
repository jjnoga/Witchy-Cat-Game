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
public class IceSkates extends EnhancedMapTile {
	protected Sounds sound;
	protected Map map;
	
    public IceSkates(Point location, Map testMap) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("IceSkate.png"),16, 16), TileType.PASSABLE);
        sound  = new Sounds();
        this.map = testMap;
    }

	@Override
    public void update(Player player) {
        super.update(player);
        
        
        
        if (player.overlaps(this) && Keyboard.isKeyDown(Key.SPACE) && !this.isHidden) {
      		map.getFlagManager().setFlag("hasGivenSkatesItem");
      		map.getFlagManager().unsetFlag("hasGivenSwordItem");
      		map.getFlagManager().unsetFlag("hasGivenStaffItem");
      		map.getFlagManager().unsetFlag("hasGivenFishItem");
          	map.getFlagManager().unsetFlag("hasDroppedSkates");
          	if(map.getFlagManager().isFlagSet("discoveredSword")) map.getFlagManager().setFlag("hasDropped");
          	if(map.getFlagManager().isFlagSet("discoveredStaff")) map.getFlagManager().setFlag("hasDroppedStaff");
          	if(map.getFlagManager().isFlagSet("discoveredFish")) map.getFlagManager().setFlag("hasDroppedFish");
              playSE(2);
             this.isHidden = true;
      	}
          else this.isHidden = true;
        
        
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
