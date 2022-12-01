package EnhancedMapTiles;
import Builders.FrameBuilder;
import Engine.ImageLoader;
import Engine.Key;
import Engine.KeyLocker;
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
import Maps.MourningWoodMap;
import Maps.TestMap;
import Scripts.Sounds;
import Utils.Direction;
import Utils.Point;

public class Boat extends EnhancedMapTile {
	protected Map map;
	public int vineCounter = 0;
	protected Sounds sound = new Sounds();
	private int iterations = 0;
	private KeyLocker keyLocker = new KeyLocker();

	public Boat(Point location, Map map) {
		 super(location.x + 16, location.y + 12, new SpriteSheet(ImageLoader.load("Boat.png"),16, 16), TileType.PASSABLE);
	        this.map = map;
	        this.setExistenceFlag("himExistenceFlag");
	}
	
	  @Override
	    public void update(Player player) {
	        super.update(player);
	        
	     
	        	
	        
	        if (player.overlaps(this) && Keyboard.isKeyDown(Key.SPACE) && !this.isHidden && map.getFlagManager().isFlagSet("canBeRidden")) {
	        	keyLocker.lockKey(Key.SPACE);
	      		map.getFlagManager().setFlag("isOnBoat");
	      		//player.setLocation(this.x, this.y);
	      		player.setLeftKey(null);
	      		player.setUpKey(null);
	      		player.setRightKey(null);
	      		player.setDownKey(null);
	      	}
	        
	        if(map.getFlagManager().isFlagSet("isOnBoat") && iterations != 50) {
	        	this.y += 1;
	        	this.setLocation(this.x, this.y);
	        	player.setLocation(this.x, this.y);
	        	int count = 0;
	        	while(count < 800) {
	        		count++;
	        	}
	        	if(count == 800) {
	        		count = 0;
	        		iterations++;
	        		this.y += 1f;
	        		this.setLocation(this.x, this.y);
		        	player.setLocation(this.x, this.y);
	        	}
	        	
	        	if(iterations == 50) {
	        		map.getFlagManager().unsetFlag("isOnBoat");
	        		map.getFlagManager().unsetFlag("canBeRidden");
	        		map.getFlagManager().setFlag("hasLandedOnIsland");
	        		//map = new MourningWoodMap();
	        		player.setLeftKey(Key.LEFT);
		        	player.setUpKey(Key.UP);
		        	player.setRightKey(Key.RIGHT);
		        	player.setDownKey(Key.DOWN);
	        	}
	        }
	          
	      
	   }
	  
	  public void playSE(int i) {
			sound.setFile(i);
			sound.play();
		}
	  
	  @Override
	    protected GameObject loadBottomLayer(SpriteSheet spriteSheet) {
	        Frame frame = new FrameBuilder(spriteSheet.getSubImage(0, 0))
	                .withScale(4f)
	                .build();
	        		
	        return new GameObject(x, y, frame);
	    }

}
