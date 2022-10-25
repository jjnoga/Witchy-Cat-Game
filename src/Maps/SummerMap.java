package Maps;

import Level.EnhancedMapTile;

import Level.Map;
import Level.NPC;
import Level.Trigger;
import Tilesets.CommonTileset;

import java.util.ArrayList;

import EnhancedMapTiles.Coin;
import EnhancedMapTiles.Rock;
import EnhancedMapTiles.Vines;

// Represents a test map to be used in a level
public class SummerMap extends Map {

	public SummerMap() {
		super("summer_map.txt", new CommonTileset());
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();	
		
		enhancedMapTiles.add(new Rock(getMapTile(18, 19).getLocation()));
		enhancedMapTiles.add(new Rock(getMapTile(17, 19).getLocation()));
		enhancedMapTiles.add(new Rock(getMapTile(42, 4).getLocation()));
		enhancedMapTiles.add(new Rock(getMapTile(42, 5).getLocation()));
		enhancedMapTiles.add(new Rock(getMapTile(34, 4).getLocation()));
		enhancedMapTiles.add(new Rock(getMapTile(35, 4).getLocation()));
		enhancedMapTiles.add(new Rock(getMapTile(26, 4).getLocation()));
		enhancedMapTiles.add(new Rock(getMapTile(27, 4).getLocation()));
		
		
		
		enhancedMapTiles.add(new Coin(getMapTile(21, 23).getLocation(), this));
		enhancedMapTiles.add(new Coin(getMapTile(31, 3).getLocation(), this));
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

	@Override
	public void loadScripts() {	
	}
}
