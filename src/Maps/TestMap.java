package Maps;

import EnhancedMapTiles.Rock;
import EnhancedMapTiles.Sword;
import EnhancedMapTiles.Coin;

import Level.EnhancedMapTile;
import Level.Inventory;
import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Dinosaur;
import NPCs.Pizza;
import NPCs.Walrus;
import NPCs.Blorbo;
import NPCs.Bruce;
import Scripts.SimpleTextScript;
import Scripts.TestMap.PizzaScript;
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
	this.playerStartPosition = getMapTile(17, 20).getLocation();
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
	ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
	enhancedMapTiles.add(new Rock(getMapTile(2, 7).getLocation()));

	enhancedMapTiles.add(new Coin(getMapTile(14, 20).getLocation(), this));
	enhancedMapTiles.add(new Coin(getMapTile(15, 19).getLocation(), this));
	enhancedMapTiles.add(new Coin(getMapTile(13, 19).getLocation(), this));
	enhancedMapTiles.add(new Coin(getMapTile(12, 20).getLocation(), this));

	/*
	 * enhancedMapTiles.add(new Coin(getMapTile(55, 23).getLocation(), this));
	 * enhancedMapTiles.add(new Coin(getMapTile(65, 3).getLocation(), this));
	 * 
	 */
	// enhancedMapTiles.add(new Sword(getMapTile(11, 19).getLocation(), this));

	return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
	ArrayList<NPC> npcs = new ArrayList<>();

	Walrus walrus = new Walrus(1, getMapTile(4, 28).getLocation().subtractY(40));
	walrus.setInteractScript(new WalrusScript());
	npcs.add(walrus);

	Dinosaur dinosaur = new Dinosaur(2, getMapTile(10, 26).getLocation());
	dinosaur.setInteractScript(new DinoScriptItemGive());
	npcs.add(dinosaur);

	Pizza pizza = new Pizza(3, getMapTile(10, 25).getLocation());
	pizza.setInteractScript(new PizzaScript());
	npcs.add(pizza);

	Blorbo blorbo = new Blorbo(4, getMapTile(12, 21).getLocation());
	blorbo.setInteractScript(new BlorboScript());
	npcs.add(blorbo);

	Bruce bruce = new Bruce(5, getMapTile(26, 19).getLocation());
	bruce.setInteractScript(new BruceScript());
	npcs.add(bruce);

	return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
	ArrayList<Trigger> triggers = new ArrayList<>();
	triggers.add(new Trigger(790, 1030, 100, 10, new LostBallScript(), "hasLostBall"));
	triggers.add(new Trigger(790, 960, 10, 80, new LostBallScript(), "hasLostBall"));
	triggers.add(new Trigger(890, 960, 10, 80, new LostBallScript(), "hasLostBall"));
	triggers.add(new Trigger(890, 780, 100, 25, new CertainAreaScript(), "rightSpot"));

	return triggers;
    }

    @Override
    public void loadScripts() {
	getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));

	getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));

	getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

	getMapTile(2, 6).setInteractScript(new TreeScript());

    }
}
