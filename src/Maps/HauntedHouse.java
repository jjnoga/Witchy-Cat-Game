package Maps;
import Level.EnhancedMapTile;
import EnhancedMapTiles.Barrel;
import EnhancedMapTiles.Coin;
import EnhancedMapTiles.Fish;
import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Terry;
import NPCs.Walrus;
import Scripts.TestMap.TerryScript;
import Scripts.TestMap.WalrusScript;
import Tilesets.CommonTileset;
import Utils.Point;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class HauntedHouse extends Map {

	public HauntedHouse() {
		super("haunted_house_map.txt", new CommonTileset());	
		this.playerStartPosition = getMapTile(6, 9).getLocation();
		this.isSpring = false;
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
		enhancedMapTiles.add(new Fish(getMapTile(7, 3).getLocation(), this));
		enhancedMapTiles.add(new Coin(getMapTile(2, 9).getLocation(), this));
		enhancedMapTiles.add(new Coin(getMapTile(11, 9).getLocation(), this));
		return enhancedMapTiles;
	}

	@Override
	public ArrayList<NPC> loadNPCs() {
		ArrayList<NPC> npcs = new ArrayList<>();
			
		return npcs;
	}

	@Override
	public ArrayList<Trigger> loadTriggers() {
		ArrayList<Trigger> triggers = new ArrayList<>();		
		return triggers;
	}
	
	public Point getStartPosition() {
		return playerStartPosition;
	}

	@Override
	public void loadScripts() {	
	}
}
