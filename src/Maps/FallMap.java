package Maps;

import Level.EnhancedMapTile;

import Level.Map;
import Level.NPC;
import Level.Trigger;
import Tilesets.CommonTileset;
import EnhancedMapTiles.Sword;
import EnhancedMapTiles.Coin;
import EnhancedMapTiles.Vines;
import EnhancedMapTiles.GoldLeaf;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class FallMap extends Map {

	public FallMap() {
		super("fall_map.txt", new CommonTileset());
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();	
		enhancedMapTiles.add(new GoldLeaf(getMapTile(21, 15).getLocation(), this));
		
		enhancedMapTiles.add(new Vines(getMapTile(21, 21).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(22, 21).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(31, 21).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(33, 21).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(32, 20).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(26, 20).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(25, 20).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(24, 20).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(21, 20).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(21, 19).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(23, 19).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(24, 19).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(26, 19).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(31, 19).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(32, 18).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(29, 18).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(18, 18).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(26, 18).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(23, 18).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(21, 18).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(20, 18).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(21, 17).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(23, 17).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(25, 17).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(26, 17).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(28, 17).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(29, 17).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(30, 17).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(33, 17).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(33, 16).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(30, 16).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(28, 16).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(26, 16).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(20, 16).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(20, 15).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(22, 15).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(22, 15).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(21, 15).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(25, 15).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(26, 15).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(30, 15).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(33, 15).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(30, 14).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(22, 14).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(20, 13).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(21, 14).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(21, 13).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(22, 13).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(25, 13).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(28, 13).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(29, 13).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(30, 13).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(28, 12).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(27, 12).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(26, 12).getLocation(), this));
		enhancedMapTiles.add(new Vines(getMapTile(25, 12).getLocation(), this));
		
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
