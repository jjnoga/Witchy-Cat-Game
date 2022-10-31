package Maps;

import EnhancedMapTiles.Rock;
import EnhancedMapTiles.Sword;
import EnhancedMapTiles.Coin;
import EnhancedMapTiles.Vines;

import EnhancedMapTiles.GoldLeaf;
import EnhancedMapTiles.IceSphere;
import Level.EnhancedMapTile;
import Level.Inventory;
import Level.Options;
import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Dinosaur;
import NPCs.Walrus;
import NPCs.Blorbo;
import NPCs.Bruce;
import Scripts.SimpleTextScript;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.DinoScriptItemGive;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.WalrusScript;
import Scripts.TestMap.BlorboScript;
import Scripts.TestMap.BruceScript;
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
	enhancedMapTiles.add(new Rock(getMapTile(11, 14).getLocation()));
	enhancedMapTiles.add(new Rock(getMapTile(45, 16).getLocation()));
	enhancedMapTiles.add(new Rock(getMapTile(30, 9).getLocation()));

	enhancedMapTiles.add(new Coin(getMapTile(23, 27).getLocation(), this));
	enhancedMapTiles.add(new Coin(getMapTile(24, 26).getLocation(), this));
	enhancedMapTiles.add(new Coin(getMapTile(22, 26).getLocation(), this));
	enhancedMapTiles.add(new Coin(getMapTile(21, 27).getLocation(), this));
	
	//vines for the demo
	enhancedMapTiles.add(new Vines(getMapTile(18, 11).getLocation(), this));
	enhancedMapTiles.add(new Vines(getMapTile(18, 12).getLocation(), this));
	enhancedMapTiles.add(new Vines(getMapTile(18, 13).getLocation(), this));
	enhancedMapTiles.add(new Vines(getMapTile(19, 13).getLocation(), this));
	enhancedMapTiles.add(new Vines(getMapTile(20, 13).getLocation(), this));
	enhancedMapTiles.add(new Vines(getMapTile(21, 13).getLocation(), this));
	enhancedMapTiles.add(new Vines(getMapTile(22, 13).getLocation(), this));
	enhancedMapTiles.add(new Vines(getMapTile(22, 12).getLocation(), this));
	enhancedMapTiles.add(new Vines(getMapTile(22, 11).getLocation(), this));
	enhancedMapTiles.add(new Vines(getMapTile(22, 10).getLocation(), this));
	enhancedMapTiles.add(new Vines(getMapTile(21, 10).getLocation(), this));
	enhancedMapTiles.add(new Vines(getMapTile(20, 10).getLocation(), this));
	enhancedMapTiles.add(new Vines(getMapTile(19, 10).getLocation(), this));
	enhancedMapTiles.add(new Vines(getMapTile(18, 10).getLocation(), this));
	enhancedMapTiles.add(new Vines(getMapTile(19, 11).getLocation(), this));
	enhancedMapTiles.add(new GoldLeaf(getMapTile(24, 32).getLocation(), this));
	enhancedMapTiles.add(new IceSphere(getMapTile(25, 32).getLocation(), this));


	/*
	 * enhancedMapTiles.add(new Coin(getMapTile(55, 23).getLocation(), this));
	 * enhancedMapTiles.add(new Coin(getMapTile(65, 3).getLocation(), this));
	 * 
	 */
	//enhancedMapTiles.add(new Sword(getMapTile(18, 23).getLocation(), this));

	return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
	ArrayList<NPC> npcs = new ArrayList<>();

	Walrus walrus = new Walrus(1, getMapTile(13, 35).getLocation().subtractY(40));
	walrus.setInteractScript(new WalrusScript());
	npcs.add(walrus);

	Dinosaur dinosaur = new Dinosaur(2, getMapTile(19, 33).getLocation());
	dinosaur.setInteractScript(new DinoScriptItemGive());
	npcs.add(dinosaur);

	Blorbo blorbo = new Blorbo(3, getMapTile(21, 28).getLocation());
	blorbo.setInteractScript(new BlorboScript());
	npcs.add(blorbo);

	Bruce bruce = new Bruce(4, getMapTile(35, 26).getLocation());
	bruce.setInteractScript(new BruceScript());
	npcs.add(bruce);

	return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
	ArrayList<Trigger> triggers = new ArrayList<>();
	triggers.add(new Trigger(1222, 1366, 100, 10, new LostBallScript(), "hasLostBall"));
	triggers.add(new Trigger(1222, 1296, 10, 80, new LostBallScript(), "hasLostBall"));
	triggers.add(new Trigger(1322, 1296, 10, 80, new LostBallScript(), "hasLostBall"));
	triggers.add(new Trigger(1322, 1116, 100, 25, new CertainAreaScript(), "rightSpot"));

	return triggers;
    }

    @Override
    public void loadScripts() {
	getMapTile(30, 26).setInteractScript(new SimpleTextScript("Cat's house"));

	getMapTile(16, 33).setInteractScript(new SimpleTextScript("Walrus's house"));

	getMapTile(29, 11).setInteractScript(new SimpleTextScript("Dino's house"));

	getMapTile(11, 13).setInteractScript(new TreeScript());
	
	//getMapTile(24, 32).setInteractScript(new GoldLeafScript());

    }
}
