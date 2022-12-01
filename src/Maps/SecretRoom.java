package Maps;
import Level.EnhancedMapTile;
import EnhancedMapTiles.Barrel;
import EnhancedMapTiles.Coin;
import EnhancedMapTiles.Fish;
import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Him;
import NPCs.Terry;
import NPCs.Walrus;
import Scripts.Boom;
import Scripts.TestMap.CertainAreaScript;
import Scripts.TestMap.TerryScript;
import Scripts.TestMap.WalrusScript;
import Tilesets.CommonTileset;
import Utils.Point;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class SecretRoom extends Map {

	public SecretRoom() {
		super("secret_room.txt", new CommonTileset());	
		this.playerStartPosition = getMapTile(6, 38).getLocation();
		this.isSpring = false;
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

		return enhancedMapTiles;
	}

	@Override
	public ArrayList<NPC> loadNPCs() {
		ArrayList<NPC> npcs = new ArrayList<>();
		
		Him him = new Him(1, getMapTile(5, 3).getLocation(), this);
		npcs.add(him);
		return npcs;
	}

	@Override
	public ArrayList<Trigger> loadTriggers() {
		ArrayList<Trigger> triggers = new ArrayList<>();	
		triggers.add(new Trigger(200, 350, 350, 100, new Boom(), "hasBoomed"));
		return triggers;
	}
	
	public Point getStartPosition() {
		return playerStartPosition;
	}

	@Override
	public void loadScripts() {	
		
	}
}
