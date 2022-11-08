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

public class Boat extends EnhancedMapTile {
	protected Map map;
	public int vineCounter = 0;
	protected Sounds sound = new Sounds();

	public Boat(Point location, Map map) {
		 super(location.x + 16, location.y + 12, new SpriteSheet(ImageLoader.load("Boat.png"),16, 16), TileType.PASSABLE);
	        this.map = map;
	}
	
	  @Override
	    public void update(Player player) {
	        super.update(player);
	      
	   }
	  
	  @Override
	    protected GameObject loadBottomLayer(SpriteSheet spriteSheet) {
	        Frame frame = new FrameBuilder(spriteSheet.getSubImage(0, 0))
	                .withScale(4f)
	                .build();
	        		
	        return new GameObject(x, y, frame);
	    }

}
