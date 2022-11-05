package Maps;

import Level.EnhancedMapTile;

import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Percival;
import Scripts.TestMap.PercivalScript;
import Tilesets.CommonTileset;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class WinterMap extends Map {

	public WinterMap() {
		super("winter_map.txt", new CommonTileset());
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();	
		return enhancedMapTiles;
	}

	@Override
	public ArrayList<NPC> loadNPCs() {
		ArrayList<NPC> npcs = new ArrayList<>();
		Percival percival = new Percival(2, getMapTile(5, 23).getLocation());
		percival.setInteractScript(new PercivalScript());
		npcs.add(percival);
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
