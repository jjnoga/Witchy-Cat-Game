package Maps;

import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import Tilesets.CommonTileset;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class AnitaHouseInterior extends Map {

	public AnitaHouseInterior() {
		super("anita_house_interior_map.txt", new CommonTileset());	
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
	public void loadScripts() {	
	}
}