package Maps;

import Level.EnhancedMapTile;

import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Blorbo;
import NPCs.Bruce;
import NPCs.Moyai;
import NPCs.Walrus;
import Scripts.MoyaiScript;
import Scripts.FallMap.BruceScript;
import Scripts.TestMap.BlorboScript;
import Scripts.TestMap.WalrusScript;
import Tilesets.CommonTileset;
import EnhancedMapTiles.Sword;
import EnhancedMapTiles.Boat;
import EnhancedMapTiles.Coin;
import EnhancedMapTiles.Vines;
import EnhancedMapTiles.GoldLeaf;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class MourningWoodMap extends Map {

	public MourningWoodMap() {
		super("mourning_wood_map.txt", new CommonTileset());
		this.playerStartPosition = getMapTile(5, 1).getLocation();
		this.isSpring = false;
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();	
		enhancedMapTiles.add(new Boat(getMapTile(5, 1).getLocation(), this));
		
		return enhancedMapTiles;
	}

	@Override
	public ArrayList<NPC> loadNPCs() {
		ArrayList<NPC> npcs = new ArrayList<>();
		
		Moyai moyai = new Moyai(3, getMapTile(24, 5).getLocation());
		moyai.setInteractScript(new MoyaiScript());
		npcs.add(moyai);

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