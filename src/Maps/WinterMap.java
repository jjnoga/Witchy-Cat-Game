package Maps;

import Level.EnhancedMapTile;

import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Percival;
import Scripts.WinterMap.PercivalScript;
import Tilesets.CommonTileset;
import EnhancedMapTiles.Boat;
import EnhancedMapTiles.IceSphere;
import EnhancedMapTiles.Coin;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class WinterMap extends Map {

	public WinterMap() {
		super("winter_map.txt", new CommonTileset());
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
		enhancedMapTiles.add(new IceSphere(getMapTile(24, 20).getLocation(), this));
		enhancedMapTiles.add(new Coin(getMapTile(12, 21).getLocation(), this));
		enhancedMapTiles.add(new Coin(getMapTile(21, 20).getLocation(), this));
		enhancedMapTiles.add(new Coin(getMapTile(7, 17).getLocation(), this));
		enhancedMapTiles.add(new Coin(getMapTile(36, 18).getLocation(), this));
		enhancedMapTiles.add(new Coin(getMapTile(34, 30).getLocation(), this));
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
