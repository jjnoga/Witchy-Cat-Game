package Screens;

import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.FloatControl;
import javax.swing.JButton;

import Engine.GamePanel;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;

import Level.*;
import Maps.SummerMap;
import Maps.TestMap;
import Maps.WinterMap;
import Maps.FallMap;
import Maps.InteriorMap;
import Players.Cat;
import Scripts.Sounds;
import Scripts.UI;
import Utils.Direction;
import Utils.Point;

// This class is for when the platformer game is actually being played
public class PlayLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Map springMap;
    protected Map summerMap;
    protected Map winterMap;
    protected Map fallMap;
    protected Map interiorMap;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    // protected OptionsState optionsMenuState;
    protected WinScreen winScreen;
    protected UI options;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
    private Key volUpKey = Key.A;
    private Key volDownKey = Key.D;
    private Key volMuteKey = Key.S;
    private boolean mapChanged;
    protected GamePanel gp;
    Sounds sound = new Sounds();
    // protected int count = 0;
    // int value = 0;
    boolean isInitialPreviousX;
    int previousX;

    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
	this.screenCoordinator = screenCoordinator;

	playMusic(0);
    }

    public void initialize() {
	// setup state
	flagManager = new FlagManager();
	flagManager.addFlag("rightSpot", false);
	flagManager.addFlag("hasBeginning", false);
	flagManager.addFlag("hasTalkedToWalrus", false);
	flagManager.addFlag("hasTalkedToDinosaur", false);
	flagManager.addFlag("hasFoundBall", false);
	flagManager.addFlag("hasTalkedToBlorbo", false);
	flagManager.addFlag("hasTalkedtoPizza", false);
	flagManager.addFlag("hasTalkedtoTerry", false);
	flagManager.addFlag("hasGivenSwordItem", false);
	flagManager.addFlag("hasBoughtShears", false);
	flagManager.addFlag("hasDropped", false);
	flagManager.addFlag("hasTalkedtoBruce", false);
	flagManager.addFlag("hasGoldLeaf", false);
	flagManager.addFlag("hasIceSphere", false);
	flagManager.addFlag("hasFireRose", false);
	flagManager.addFlag("inSpringArea", false);
	flagManager.addFlag("inventoryCheck", true);
	flagManager.addFlag("optionsCheck", true);
	flagManager.addFlag("hasGivenStaffItem", false);
	flagManager.addFlag("hasDroppedStaff", false);
	flagManager.addFlag("hasGivenFishItem", false);
	flagManager.addFlag("hasDroppedFish", false);
	flagManager.addFlag("hasGivenSkatesItem", false);
	flagManager.addFlag("hasTalkedtoPercival", false);
	flagManager.addFlag("hasTalkedtoPercivalTwo", false);
	flagManager.addFlag("hasDroppedSkates", false);
	flagManager.addFlag("discoveredSword", false);
	flagManager.addFlag("discoveredStaff", false);
	flagManager.addFlag("discoveredFish", false);
	flagManager.addFlag("discoveredSkates", false);
	flagManager.addFlag("hasTalkedToBlorboTwo", false);
	flagManager.addFlag("hasTalkedtoBruceTwo", false);
	flagManager.addFlag("hasTalkedtoPizzaTwo", false);

	previousX = 0;
	isInitialPreviousX = true;

	// define/setup map
	mapChanged = false;
	springMap = new TestMap();
	summerMap = new SummerMap();
	summerMap.setCameraX(48);
	winterMap = new WinterMap();
	winterMap.setCameraY(winterMap.getEndBoundY() - 604);
	fallMap = new FallMap();
	fallMap.setCameraX(fallMap.getEndBoundX() - 867);
	interiorMap = new InteriorMap();
	this.map = springMap;
	map.reset();
	map.setFlagManager(flagManager);

	// setup player
	this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
	this.player.setMap(map);
	Point playerStartPosition = map.getPlayerStartPosition();
	this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
	this.playLevelScreenState = PlayLevelScreenState.RUNNING;
	this.player.setFacingDirection(Direction.LEFT);

	this.options = new UI(gp);

	// let pieces of map know which button to listen for as the "interact" button
	map.getTextbox().setInteractKey(player.getInteractKey());

	// setup map scripts to have references to the map and player
	for (MapTile mapTile : map.getMapTiles()) {
	    if (mapTile.getInteractScript() != null) {
		mapTile.getInteractScript().setMap(map);
		mapTile.getInteractScript().setPlayer(player);
	    }
	}
	for (NPC npc : map.getNPCs()) {
	    if (npc.getInteractScript() != null) {
		npc.getInteractScript().setMap(map);
		npc.getInteractScript().setPlayer(player);
	    }
	}
	for (EnhancedMapTile enhancedMapTile : map.getEnhancedMapTiles()) {
	    if (enhancedMapTile.getInteractScript() != null) {
		enhancedMapTile.getInteractScript().setMap(map);
		enhancedMapTile.getInteractScript().setPlayer(player);
	    }
	}
	for (Trigger trigger : map.getTriggers()) {
	    if (trigger.getTriggerScript() != null) {
		trigger.getTriggerScript().setMap(map);
		trigger.getTriggerScript().setPlayer(player);
	    }
	}

	winScreen = new WinScreen(this);
    }

    public void update() {
	// based on screen state, perform specific actions
	switch (playLevelScreenState) {
	// if level is "running" update player and map to keep game logic for the
	// platformer level going
	case RUNNING:
	    player.update();
	    map.update(player);
	    break;
	// if level has been completed, bring up level cleared screen
	case LEVEL_COMPLETED:
	    winScreen.update();
	    break;
	}

	if (Keyboard.isKeyDown(volUpKey) && !keyLocker.isKeyLocked(volUpKey)) {
	    keyLocker.lockKey(volUpKey);
	    sound.volumeUp();
	    System.out.println("works");
	} else if (Keyboard.isKeyUp(volUpKey)) {
	    keyLocker.unlockKey(volUpKey);
	}

	if (Keyboard.isKeyDown(volDownKey) && !keyLocker.isKeyLocked(volDownKey)) {
	    keyLocker.lockKey(volDownKey);
	    sound.volumeDown();
	} else if (Keyboard.isKeyUp(volDownKey)) {
	    keyLocker.unlockKey(volDownKey);
	}

	if (Keyboard.isKeyDown(volMuteKey) && !keyLocker.isKeyLocked(volMuteKey)) {
	    keyLocker.lockKey(volMuteKey);
	    sound.volumeMute();
	} else if (Keyboard.isKeyUp(volMuteKey)) {
	    keyLocker.unlockKey(volMuteKey);
	}

	// if flag is set at any point during gameplay, game is "won"
	if (map.getFlagManager().isFlagSet("hasFoundBall")) {
	    playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
	}

	//////////// Temporary thing, get player and camera location by pressing B
	//////////// ///////////
	if (Keyboard.isKeyDown(Key.B) && !keyLocker.isKeyLocked(Key.B)) {
	    System.out.println("player coords: " + player.getLocation());
	    System.out.println(
		    "camera coords: (" + this.map.getCamera().getX() + ", " + this.map.getCamera().getY() + ")");
	    System.out.println("Current volume: " + sound.getCurrentVolume());
	}
	////////////////////////////////////////////////////////////////////////////////////////

	// map switching, saves state of current map, changes map, places player at
	// certain location

	// leaving spring
	if (map.getMapFileName().equals("test_map.txt")) {
	    /*
	     * if (value > 15 && (sound.getCurrentVolume() >= -81 ||
	     * sound.getCurrentVolume() <= -1)) {
	     * if (player.getLocation().x > springMap.getEndBoundX() - 730 ||
	     * player.getLocation().x < 600) {
	     * sound.volumeDown();
	     * } else {
	     * sound.volumeUp();
	     * }
	     * value = 0;
	     * }
	     * value++;
	     */

	    ///////// sound fade spring////////
	    if (player.getLocation().x > springMap.getEndBoundX() - 930) {
		if (isInitialPreviousX == true) {
		    if (player.getCurrentWalkingXDirection() == Direction.RIGHT) {
			previousX = springMap.getEndBoundX() - 930;
			System.out.println("set preX to start");

		    } else {
			previousX = springMap.getEndBoundX();
			System.out.println("set preX to end");
		    }
		    isInitialPreviousX = false;
		}
		int dif = (int) player.getLocation().x - previousX;
		if (dif > 10) {
		    System.out.println(player.getLocation().x - previousX);
		    previousX = (int) player.getLocation().x;
		    sound.volumeDown();
		    previousX = (int) player.getLocation().x;
		} else if (previousX - player.getLocation().x > 10) {
		    previousX = (int) player.getLocation().x;
		    sound.volumeUp();
		}
	    } else if (player.getLocation().x < 790) {
		if (isInitialPreviousX == true) {
		    if (player.getCurrentWalkingXDirection() == Direction.RIGHT) {
			previousX = 0;
			System.out.println("set preX to end");

		    } else {
			previousX = 790;
			System.out.println("set preX to end");
		    }
		    isInitialPreviousX = false;
		}
		int dif = (int) player.getLocation().x - previousX;
		if (dif > 10) {
		    System.out.println(player.getLocation().x - previousX);
		    previousX = (int) player.getLocation().x;
		    sound.volumeUp();
		    previousX = (int) player.getLocation().x;
		} else if (previousX - player.getLocation().x > 10) {
		    previousX = (int) player.getLocation().x;
		    sound.volumeDown();
		}
	    }

	    /*
	     * if (player.getLocation().x > springMap.getEndBoundX() - 730) {
	     * if (value > 10 && sound.getCurrentVolume() >= -60) {
	     * sound.volumeDown();
	     * value = 0;
	     * }
	     * value++;
	     * } else if (player.getLocation().x < 600) {
	     * if (value > 10 && sound.getCurrentVolume() >= -60) {
	     * sound.volumeDown();
	     * value = 0;
	     * }
	     * value++;
	     * } else {
	     * if (value > 10 && sound.getCurrentVolume() <= -1) {
	     * sound.volumeUp();
	     * value = 0;
	     * }
	     * value++;
	     * }
	     */

	    // Walrus house interior
	    if (player.getLocation().x > 606 && player.getLocation().x < 618 && player.getLocation().y == 1596)

	    {
		springMap = this.map;
		interiorMap.setCoinCounter(this.map.getCoinCounter());
		this.map = interiorMap;
		this.player.setLocation(374, 408);
		map.setFlagManager(flagManager);
		this.player.setMap(map);
		if (map.getFlagManager().isFlagSet("inventoryCheck"))
		    map.getInventory().setIsActive(false);
		else
		    map.getInventory().setIsActive(true);

		if (map.getFlagManager().isFlagSet("optionsCheck"))
		    map.getOptions().setIsActive(false);
		else
		    map.getOptions().setIsActive(true);
		mapChanged = true;
	    }

	    // summer map
	    else if (player.getLocation().x > this.map.getEndBoundX() - 426) {
		stopMusic();
		playMusicZero(11);
		springMap = this.map;
		summerMap.setCoinCounter(this.map.getCoinCounter());
		summerMap.setCameraY(this.map.getCamera().getY() - 336);

		/*
		 * while(count < 80){
		 * count += 1;
		 * try{
		 * Thread.sleep(25);
		 * }catch(InterruptedException ex){
		 * System.out.println("Welp");
		 * }
		 * // for (float f = 0; f > sound.getVolMin(); f--) {
		 * sound.volumeDown();
		 * //stopMusic();
		 * // }
		 * 
		 * }
		 * count = 0;
		 */
		// stopMusic();
		for (int i = 0; i < springMap.getEnhancedMapTiles().size(); i++) {
		    if (springMap.getEnhancedMapTiles().get(i).getX() > springMap.getEndBoundX() - 730) {
			EnhancedMapTile enhancedMapTile = springMap.getEnhancedMapTiles().get(i);
			enhancedMapTile
				.setX(springMap.getEnhancedMapTiles().get(i).getX() - (springMap.getEndBoundX() - 864));
			enhancedMapTile.setY(springMap.getEnhancedMapTiles().get(i).getY() - 336);
			enhancedMapTile.setMap(summerMap);
			summerMap.addEnhancedMapTile(enhancedMapTile);

//<<<<<<< HEAD
////			stopMusic();
////			playMusic(11);
//=======
//>>>>>>> 240ab0988003ee626e77937fd4bfa8e21557d59f
		    }
		}
		for (int i = 0; i < springMap.getNPCs().size(); i++) {
		    if (springMap.getNPCs().get(i).getX() > springMap.getEndBoundX() - 730) {
			NPC npc = springMap.getNPCs().get(i);
			npc.setX(springMap.getNPCs().get(i).getX() - (springMap.getEndBoundX() - 864));
			npc.setY(springMap.getNPCs().get(i).getY() - 336);
			npc.setMap(summerMap);
			summerMap.addNPC(npc);
		    }
		}
		this.player.setLocation(438, (player.getLocation().y - 336));
		this.map = summerMap;
		map.setFlagManager(flagManager);
		this.player.setMap(map);
//		stopMusic();
//		playMusic(11);

		if (map.getFlagManager().isFlagSet("inventoryCheck"))
		    map.getInventory().setIsActive(false);
		else
		    map.getInventory().setIsActive(true);

		if (map.getFlagManager().isFlagSet("optionsCheck"))
		    map.getOptions().setIsActive(false);
		else
		    map.getOptions().setIsActive(true);

		mapChanged = true;
	    }

	    // winter map
	    else if (player.getLocation().y < 300) {
		stopMusic();
		playMusicZero(13);
		springMap = this.map;
		winterMap.setCoinCounter(this.map.getCoinCounter());
		winterMap.setCameraX(this.map.getCamera().getX() - 384);
		/*
		 * while (count < 80) {
		 * count += 1;
		 * try {
		 * Thread.sleep(25);
		 * } catch (InterruptedException ex) {
		 * System.out.println("Welp");
		 * }
		 * // for (float f = 0; f > sound.getVolMin(); f--) {
		 * sound.volumeDown();
		 * // stopMusic();
		 * // }
		 * 
		 * }
		 * count = 0;
		 */
		for (int i = 0; i < springMap.getEnhancedMapTiles().size(); i++) {
		    if (springMap.getEnhancedMapTiles().get(i).getY() < 548) {
			EnhancedMapTile enhancedMapTile = springMap.getEnhancedMapTiles().get(i);
			enhancedMapTile.setX(springMap.getEnhancedMapTiles().get(i).getX() - 384);
			enhancedMapTile
				.setY(springMap.getEnhancedMapTiles().get(i).getY() + (winterMap.getEndBoundY() - 622));
			enhancedMapTile.setMap(winterMap);
			winterMap.addEnhancedMapTile(enhancedMapTile);
		    }
		}
		for (int i = 0; i < springMap.getNPCs().size(); i++) {
		    if (springMap.getNPCs().get(i).getY() < 548) {
			NPC npc = springMap.getNPCs().get(i);
			npc.setX(springMap.getNPCs().get(i).getX() - 384);
			npc.setY(springMap.getNPCs().get(i).getY() + (winterMap.getEndBoundY() - 634));
			npc.setMap(winterMap);
			winterMap.addNPC(npc);
			;
		    }

		    if (map.getFlagManager().isFlagSet("inventoryCheck"))
			map.getInventory().setIsActive(false);
		    else
			map.getInventory().setIsActive(true);

		    if (map.getFlagManager().isFlagSet("optionsCheck"))
			map.getOptions().setIsActive(false);
		    else
			map.getOptions().setIsActive(true);
		}
		this.player.setLocation((player.getLocation().x - 384), (winterMap.getEndBoundY() - 322));
		this.map = winterMap;
		map.setFlagManager(flagManager);
		this.player.setMap(map);

		if (map.getFlagManager().isFlagSet("inventoryCheck"))
		    map.getInventory().setIsActive(false);
		else
		    map.getInventory().setIsActive(true);

		if (map.getFlagManager().isFlagSet("optionsCheck"))
		    map.getOptions().setIsActive(false);
		else
		    map.getOptions().setIsActive(true);
		mapChanged = true;
	    }

	    // fall map
	    else if (player.getLocation().x < 390) {
		stopMusic();
		playMusicZero(10);
		springMap = this.map;
		fallMap.setCoinCounter(this.map.getCoinCounter());
		fallMap.setCameraY(this.map.getCamera().getY() - 336);
		/*
		 * while (count < 80) {
		 * count += 1;
		 * try {
		 * Thread.sleep(25);
		 * } catch (InterruptedException ex) {
		 * System.out.println("Welp");
		 * }
		 * // for (float f = 0; f > sound.getVolMin(); f--) {
		 * sound.volumeDown();
		 * // stopMusic();
		 * // }
		 * 
		 * }
		 * count = 0;
		 */
		for (int i = 0; i < springMap.getEnhancedMapTiles().size(); i++) {
		    if (springMap.getEnhancedMapTiles().get(i).getX() < 730) {
			EnhancedMapTile enhancedMapTile = springMap.getEnhancedMapTiles().get(i);
			enhancedMapTile
				.setX(springMap.getEnhancedMapTiles().get(i).getX() + (fallMap.getEndBoundX() - 864));
			enhancedMapTile.setY(springMap.getEnhancedMapTiles().get(i).getY() - 336);
			enhancedMapTile.setMap(fallMap);
			fallMap.addEnhancedMapTile(enhancedMapTile);
//<<<<<<< HEAD
////			stopMusic();
////			playMusic(10);
//=======
//>>>>>>> 240ab0988003ee626e77937fd4bfa8e21557d59f
		    }
		}
		for (int i = 0; i < springMap.getNPCs().size(); i++) {
		    if (springMap.getNPCs().get(i).getX() < 730) {
			NPC npc = springMap.getNPCs().get(i);
			npc.setX(springMap.getNPCs().get(i).getX() + (fallMap.getEndBoundX() - 864));
			npc.setY(springMap.getNPCs().get(i).getY() - 336);
			npc.setMap(fallMap);
			fallMap.addNPC(npc);
			;
		    }

		}
		this.player.setLocation(fallMap.getEndBoundX() - 474, (player.getLocation().y - 336));
		this.map = fallMap;
		map.setFlagManager(flagManager);
		this.player.setMap(map);
		/*
		 * while (count < 80) {
		 * count += 1;
		 * try {
		 * Thread.sleep(25);
		 * } catch (InterruptedException ex) {
		 * System.out.println("Welp");
		 * }
		 * // for (float f = 0; f > sound.getVolMin(); f--) {
		 * sound.volumeDown();
		 * // stopMusic();
		 * // }
		 * 
		 * }
		 * count = 0;
		 */

		if (map.getFlagManager().isFlagSet("inventoryCheck"))
		    map.getInventory().setIsActive(false);
		else
		    map.getInventory().setIsActive(true);

		if (map.getFlagManager().isFlagSet("optionsCheck"))
		    map.getOptions().setIsActive(false);
		else
		    map.getOptions().setIsActive(true);
		mapChanged = true;
	    }

	}

	// leaving winter
	if (map.getMapFileName().equals("winter_map.txt")) {

	    // spring map
	    if (player.getLocation().y > this.map.getEndBoundY() - 322) {
		stopMusic();
		playMusicZero(0);
		winterMap = this.map;
		springMap.setCoinCounter(this.map.getCoinCounter());
		springMap.setCameraX(this.map.getCamera().getX() + 384);
		/*
		 * while (count < 80) {
		 * count += 1;
		 * try {
		 * Thread.sleep(25);
		 * } catch (InterruptedException ex) {
		 * System.out.println("Welp");
		 * }
		 * // for (float f = 0; f > sound.getVolMin(); f--) {
		 * sound.volumeDown();
		 * // stopMusic();
		 * // }
		 * 
		 * }
		 * count = 0;
		 */

		for (int i = 0; i < winterMap.getEnhancedMapTiles().size(); i++) {
		    if (winterMap.getEnhancedMapTiles().get(i).getY() > winterMap.getEndBoundY() - 682) {
			EnhancedMapTile enhancedMapTile = winterMap.getEnhancedMapTiles().get(i);
			enhancedMapTile.setX(winterMap.getEnhancedMapTiles().get(i).getX() + 384);
			enhancedMapTile
				.setY(winterMap.getEnhancedMapTiles().get(i).getY() - (winterMap.getEndBoundY() - 622));
			enhancedMapTile.setMap(springMap);
			springMap.addEnhancedMapTile(enhancedMapTile);
		    }

		}
		for (int i = 0; i < winterMap.getNPCs().size(); i++) {
		    if (winterMap.getNPCs().get(i).getY() > winterMap.getEndBoundY() - 682) {
			NPC npc = winterMap.getNPCs().get(i);
			npc.setX(winterMap.getNPCs().get(i).getX() + 384);
			npc.setY(winterMap.getNPCs().get(i).getY() - (winterMap.getEndBoundY() - 634));
			npc.setMap(springMap);
			springMap.addNPC(npc);
			;
		    }
		}
		this.player.setLocation(player.getLocation().x + 384, 300);
		this.map = springMap;
		map.setFlagManager(flagManager);
		this.player.setMap(map);

		if (map.getFlagManager().isFlagSet("inventoryCheck"))
		    map.getInventory().setIsActive(false);
		else
		    map.getInventory().setIsActive(true);

		if (map.getFlagManager().isFlagSet("optionsCheck"))
		    map.getOptions().setIsActive(false);
		else
		    map.getOptions().setIsActive(true);
		mapChanged = true;
	    }
	}

	// leaving fall
	if (map.getMapFileName().equals("fall_map.txt")) {

	    // spring map
	    if (player.getLocation().x > this.map.getEndBoundX() - 474) {
		stopMusic();
		playMusicZero(0);
		fallMap = this.map;
		springMap.setCoinCounter(this.map.getCoinCounter());
		springMap.setCameraY(this.map.getCamera().getY() + 336);
		for (int i = 0; i < fallMap.getEnhancedMapTiles().size(); i++) {
		    if (fallMap.getEnhancedMapTiles().get(i).getX() > fallMap.getEndBoundX() - 730) {
			EnhancedMapTile enhancedMapTile = fallMap.getEnhancedMapTiles().get(i);
			enhancedMapTile
				.setX(fallMap.getEnhancedMapTiles().get(i).getX() - (fallMap.getEndBoundX() - 864));
			enhancedMapTile.setY(fallMap.getEnhancedMapTiles().get(i).getY() + 336);
			enhancedMapTile.setMap(springMap);
			springMap.addEnhancedMapTile(enhancedMapTile);
//<<<<<<< HEAD
////			stopMusic();
////			playMusic(0);
//=======
//>>>>>>> 240ab0988003ee626e77937fd4bfa8e21557d59f
		    }
		}
		for (int i = 0; i < fallMap.getNPCs().size(); i++) {
		    if (fallMap.getNPCs().get(i).getX() > fallMap.getEndBoundX() - 730) {
			NPC npc = fallMap.getNPCs().get(i);
			npc.setX(fallMap.getNPCs().get(i).getX() - (fallMap.getEndBoundX() - 864));
			npc.setY(fallMap.getNPCs().get(i).getY() + 336);
			npc.setMap(springMap);
			springMap.addNPC(npc);
		    }
		}
		this.player.setLocation(390, (player.getLocation().y + 336));
		this.map = springMap;
		map.setFlagManager(flagManager);
		this.player.setMap(map);
		/*
		 * while (count < 80) {
		 * count += 1;
		 * try {
		 * Thread.sleep(25);
		 * } catch (InterruptedException ex) {
		 * System.out.println("Welp");
		 * }
		 * // for (float f = 0; f > sound.getVolMin(); f--) {
		 * sound.volumeDown();
		 * // stopMusic();
		 * // }
		 * 
		 * }
		 * count = 0;
		 */

		if (map.getFlagManager().isFlagSet("inventoryCheck"))
		    map.getInventory().setIsActive(false);
		else
		    map.getInventory().setIsActive(true);

		if (map.getFlagManager().isFlagSet("optionsCheck"))
		    map.getOptions().setIsActive(false);
		else
		    map.getOptions().setIsActive(true);
		mapChanged = true;
	    }
	}

	// leaving summer
	if (map.getMapFileName().equals("summer_map.txt")) {

	    // spring map
	    if (player.getLocation().x < 438) {
		stopMusic();
		playMusicZero(0);
		isInitialPreviousX = true;
		summerMap = this.map;
		springMap.setCoinCounter(this.map.getCoinCounter());
		springMap.setCameraY(this.map.getCamera().getY() + 336);
		// playMusic(0);
		for (int i = 0; i < summerMap.getEnhancedMapTiles().size(); i++) {
		    if (summerMap.getEnhancedMapTiles().get(i).getX() < 730) {
			EnhancedMapTile enhancedMapTile = summerMap.getEnhancedMapTiles().get(i);
			enhancedMapTile
				.setX(summerMap.getEnhancedMapTiles().get(i).getX() + (springMap.getEndBoundX() - 864));
			enhancedMapTile.setY(summerMap.getEnhancedMapTiles().get(i).getY() + 336);
			enhancedMapTile.setMap(springMap);
			springMap.addEnhancedMapTile(enhancedMapTile);
//<<<<<<< HEAD
////			stopMusic();
////			playMusic(0);
//=======
//>>>>>>> 240ab0988003ee626e77937fd4bfa8e21557d59f
		    }
		}
		for (int i = 0; i < summerMap.getNPCs().size(); i++) {
		    if (summerMap.getNPCs().get(i).getX() < 730) {
			NPC npc = summerMap.getNPCs().get(i);
			npc.setX(summerMap.getNPCs().get(i).getX() + (springMap.getEndBoundX() - 864));
			npc.setY(summerMap.getNPCs().get(i).getY() + 336);
			npc.setMap(springMap);
			springMap.addNPC(npc);
		    }
		}
		this.player.setLocation(springMap.getEndBoundX() - 426, (player.getLocation().y + 336));
		this.map = springMap;
		map.setFlagManager(flagManager);
		this.player.setMap(map);
		/*
		 * while (count < 80) {
		 * count += 1;
		 * try {
		 * Thread.sleep(25);
		 * } catch (InterruptedException ex) {
		 * System.out.println("Welp");
		 * }
		 * // for (float f = 0; f > sound.getVolMin(); f--) {
		 * sound.volumeDown();
		 * // stopMusic();
		 * // }
		 * 
		 * }
		 * count = 0;
		 */

		if (map.getFlagManager().isFlagSet("inventoryCheck"))
		    map.getInventory().setIsActive(false);
		else
		    map.getInventory().setIsActive(true);

		if (map.getFlagManager().isFlagSet("optionsCheck"))
		    map.getOptions().setIsActive(false);
		else
		    map.getOptions().setIsActive(true);
		mapChanged = true;
	    }

	}

	// leaving interior
	if (map.getMapFileName().equals("interior_map.txt")) {
	    if (player.getLocation().x > 364 && player.getLocation().x < 380 && player.getLocation().y > 422) {
		interiorMap = this.map;
		springMap.setCoinCounter(this.map.getCoinCounter());
		this.map = springMap;
		this.player.setLocation(612, 1600);
		map.setFlagManager(flagManager);
		this.player.setMap(map);

		if (map.getFlagManager().isFlagSet("inventoryCheck"))
		    map.getInventory().setIsActive(false);
		else
		    map.getInventory().setIsActive(true);

		if (map.getFlagManager().isFlagSet("optionsCheck"))
		    map.getOptions().setIsActive(false);
		else
		    map.getOptions().setIsActive(true);
		mapChanged = true;
	    }
	}

	if (mapChanged) {
	    for (MapTile mapTile : map.getMapTiles()) {
		if (mapTile.getInteractScript() != null) {
		    mapTile.getInteractScript().setMap(map);
		    mapTile.getInteractScript().setPlayer(player);
		}
	    }
	    for (NPC npc : map.getNPCs()) {
		if (npc.getInteractScript() != null) {
		    npc.getInteractScript().setMap(map);
		    npc.getInteractScript().setPlayer(player);
		}
	    }
	    for (EnhancedMapTile enhancedMapTile : map.getEnhancedMapTiles()) {
		if (enhancedMapTile.getInteractScript() != null) {
		    enhancedMapTile.getInteractScript().setMap(map);
		    enhancedMapTile.getInteractScript().setPlayer(player);
		}
	    }
	    for (Trigger trigger : map.getTriggers()) {
		if (trigger.getTriggerScript() != null) {
		    trigger.getTriggerScript().setMap(map);
		    trigger.getTriggerScript().setPlayer(player);
		}
	    }
	    mapChanged = false;
	}
    }

    public void draw(GraphicsHandler graphicsHandler) {
// based on screen state, draw appropriate graphics
	switch (playLevelScreenState) {
	case RUNNING:
	    map.draw(player, graphicsHandler);
	    break;
	case LEVEL_COMPLETED:
	    winScreen.draw(graphicsHandler);
	    break;
	}

    }

    public PlayLevelScreenState getPlayLevelScreenState() {
	return playLevelScreenState;
    }

    public void resetLevel() {
	initialize();
    }

    public void goBackToMenu() {
	screenCoordinator.setGameState(GameState.MENU);
    }

//This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
	RUNNING, LEVEL_COMPLETED
    }

    public void playMusic(int i) {
	sound.setFile(i);
	sound.play();
	sound.loop();
    }

    public void playMusicZero(int i) {
	sound.setFile(i, -80.0f);
	sound.setCurrentVolume(-80.0f);
	sound.play();
	sound.loop();
    }

    public void playSE(int i) {
	sound.setFile(i);
	sound.play();
    }

    public void stopMusic() {
	sound.stop();
    }

}