package Maps;

import EnhancedMapTiles.Coin;
import EnhancedMapTiles.Boat;
import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Dinosaur;
import NPCs.Walrus;
import NPCs.Blorbo;
import Scripts.SimpleTextScript;
import Scripts.TestMap.DinoScriptItemFish;
import Scripts.TestMap.IntroScript;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.WalrusScript;
import Scripts.TestMap.BlorboScript;
import Scripts.TestMap.CertainAreaScript;
import Tilesets.CommonTileset;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class TestMap extends Map {

    public TestMap() {
	super("test_map.txt", new CommonTileset());
	this.playerStartPosition = getMapTile(26, 27).getLocation();
	this.isSpring = true;
	
	
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
	ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

	enhancedMapTiles.add(new Coin(getMapTile(41, 33).getLocation(), this));
	enhancedMapTiles.add(new Coin(getMapTile(20, 26).getLocation(), this));
	enhancedMapTiles.add(new Coin(getMapTile(43, 11).getLocation(), this));
	enhancedMapTiles.add(new Coin(getMapTile(19, 11).getLocation(), this));
	
	
	enhancedMapTiles.add(new Boat(getMapTile(21, 38).getLocation(), this));

	return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
	ArrayList<NPC> npcs = new ArrayList<>();

	Blorbo blorbo = new Blorbo(3, getMapTile(21, 28).getLocation());
	blorbo.setInteractScript(new BlorboScript());
	npcs.add(blorbo);

	return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
	ArrayList<Trigger> triggers = new ArrayList<>();
	triggers.add(new Trigger(1222, 1366, 100, 10, new IntroScript(), "hasBeginning"));
	triggers.add(new Trigger(1222, 1296, 10, 80, new IntroScript(), "hasBeginning"));
	triggers.add(new Trigger(1322, 1296, 10, 80, new IntroScript(), "hasBeginning"));
	//triggers.add(new Trigger(1322, 1116, 100, 25, new CertainAreaScript(), "rightSpot"));

	return triggers;
    }

    @Override
    public void loadScripts() {
//	getMapTile(30, 26).setInteractScript(new SimpleTextScript("Cat's house"));
//
//	getMapTile(16, 33).setInteractScript(new SimpleTextScript("Walrus's house"));
//
//	getMapTile(29, 11).setInteractScript(new SimpleTextScript("Dino's house"));
//
//	getMapTile(11, 13).setInteractScript(new TreeScript());
	
	//getMapTile(24, 32).setInteractScript(new GoldLeafScript());

    }
}
