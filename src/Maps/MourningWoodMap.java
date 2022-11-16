package Maps;

import Level.EnhancedMapTile;

import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Bruce;
import NPCs.Walrus;
import Scripts.FallMap.BruceScript;
import Scripts.TestMap.WalrusScript;
import Tilesets.CommonTileset;
import EnhancedMapTiles.Sword;
import EnhancedMapTiles.Coin;
import EnhancedMapTiles.Vines;
import EnhancedMapTiles.GoldLeaf;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class MourningWoodMap extends Map {

	public MourningWoodMap() {
		super("mourning_wood_map.txt", new CommonTileset());
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