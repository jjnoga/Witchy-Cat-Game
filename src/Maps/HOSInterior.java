package Maps;

import java.util.ArrayList;

import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.BigScreen;
import NPCs.Cauldron;
import Scripts.SummerMap.BigScreenScript;
//import Scripts.SummerMap.BigScreenScript;
import Scripts.TestMap.HouseIntro;
import Tilesets.CommonTileset;
import Utils.Point;

public class HOSInterior extends Map{
	public HOSInterior() {
		super("hall_of_shame.txt", new CommonTileset());	
		this.playerStartPosition = getMapTile(7, 10).getLocation();
		this.isSummer = false;
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
		return enhancedMapTiles;
	}
	
	@Override
	public ArrayList<Trigger> loadTriggers() {
		ArrayList<Trigger> triggers = new ArrayList<>();		
		return triggers;
	}

	@Override
	public ArrayList<NPC> loadNPCs() {
		ArrayList<NPC> npcs = new ArrayList<>();
		
		BigScreen bigScreen = new BigScreen(5, getMapTile(7, 1).getLocation());
		bigScreen.setInteractScript(new BigScreenScript());
		npcs.add(bigScreen);
//		
		return npcs;
	}

	public Point getStartPosition() {
		return playerStartPosition;
	}

	@Override
	public void loadScripts() {	
	}
}


