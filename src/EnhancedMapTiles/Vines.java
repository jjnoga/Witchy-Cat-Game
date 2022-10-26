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

public class Vines extends EnhancedMapTile{
	protected TestMap map;
	public int vineCounter = 0;

	public Vines(Point location, TestMap testMap) {
		 super(location.x, location.y, new SpriteSheet(ImageLoader.load("Vines.png"),16, 16), TileType.NOT_PASSABLE);
	        this.map = testMap;
	}
	
	  @Override
	    public void update(Player player) {
	        super.update(player);
	        
	       if (player.overlaps(this) && Keyboard.isKeyDown(Key.SPACE) && !this.isHidden) 
	        {
	            this.isHidden = true;
	            
	       }
	   }
	  
	  @Override
	    protected GameObject loadBottomLayer(SpriteSheet spriteSheet) {
	        Frame frame = new FrameBuilder(spriteSheet.getSubImage(0, 0))
	                .withScale(1.5f)
	                .build();
	        		
	        return new GameObject(x + 16, y + 12, frame);
	    }
}
