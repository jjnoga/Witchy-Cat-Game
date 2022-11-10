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

import java.util.ArrayList;

// Represents a test map to be used in a level
public class HauntedHouse extends Map {

	public HauntedHouse() {
		super("haunted_house_map.txt", new CommonTileset());	
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
		enhancedMapTiles.add(new Fish(getMapTile(7, 1).getLocation(), this));
		enhancedMapTiles.add(new Coin(getMapTile(1, 7).getLocation(), this));
		enhancedMapTiles.add(new Coin(getMapTile(10, 7).getLocation(), this));
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
