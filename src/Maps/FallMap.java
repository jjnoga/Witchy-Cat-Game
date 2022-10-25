package Maps;

import Level.EnhancedMapTile;

import Level.Map;
import Level.NPC;
import Level.Trigger;
import Tilesets.CommonTileset;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class FallMap extends Map {

	public FallMap() {
		super("fall_map.txt", new CommonTileset());
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();	
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
