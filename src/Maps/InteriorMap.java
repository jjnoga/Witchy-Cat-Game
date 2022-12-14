package Maps;

import Level.EnhancedMapTile;
import EnhancedMapTiles.Barrel;
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
public class InteriorMap extends Map {

	public InteriorMap() {
		super("interior_map.txt", new CommonTileset());	
		this.playerStartPosition = getMapTile(8, 8).getLocation();
		this.isSpring = false;
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
		enhancedMapTiles.add(new Barrel(getMapTile(6, 7).getLocation(), this));
		return enhancedMapTiles;
	}

	@Override
	public ArrayList<NPC> loadNPCs() {
		ArrayList<NPC> npcs = new ArrayList<>();
		
		Terry terry = new Terry(1, getMapTile(5, 3).getLocation());
		terry.setInteractScript(new TerryScript());
		npcs.add(terry);
		
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