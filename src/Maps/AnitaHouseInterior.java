package Maps;

import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Blorbo;
import NPCs.Cauldron;
import Scripts.TestMap.BlorboScript;
import Scripts.TestMap.CauldronScript;
import Scripts.TestMap.HouseIntro;
import Tilesets.CommonTileset;
import Utils.Point;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class AnitaHouseInterior extends Map {

	public AnitaHouseInterior() {
		super("anita_house_interior_map.txt", new CommonTileset());	
		this.playerStartPosition = getMapTile(7, 10).getLocation();
		this.isSpring = false;
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
		return enhancedMapTiles;
	}
	
	@Override
	public ArrayList<Trigger> loadTriggers() {
		ArrayList<Trigger> triggers = new ArrayList<>();	
		triggers.add(new Trigger(343, 450, 100, 25, new HouseIntro(), "firstTimeInHouse"));
		return triggers;
	}

	@Override
	public ArrayList<NPC> loadNPCs() {
		ArrayList<NPC> npcs = new ArrayList<>();
		
		Cauldron cauldron = new Cauldron(4, getMapTile(8, 2).getLocation());
		cauldron.setInteractScript(new CauldronScript());
		npcs.add(cauldron);
		
		return npcs;
	}

	public Point getStartPosition() {
		return playerStartPosition;
	}

	@Override
	public void loadScripts() {	
	}
}