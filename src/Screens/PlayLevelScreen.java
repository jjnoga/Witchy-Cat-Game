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
import Maps.AnitaHouseInterior;
import Maps.FallMap;
import Maps.HOSInterior;
//import Maps.HOSInterior;
import Maps.InteriorMap;
import Maps.MourningWoodMap;
import Maps.SecretRoom;
import Maps.HauntedHouse;
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
    protected Map anitaHouseInteriorMap;
    protected Map islandMap;

    protected Map hallOfShame;

    protected Map hauntedHouseMap;
    protected Map secretMap;

    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    // protected OptionsState optionsMenuState;
    protected WinScreen winScreen;
    protected HOSScreen hosScreen;
    protected UI options;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
    private Key volUpKey = Key.A;
    private Key volDownKey = Key.D;
    private Key volMuteKey = Key.S;
    private boolean mapChanged;
    protected GamePanel gp;
    Sounds sound = new Sounds();

    protected int count = 0;
//<<<<<<< HEAD
//    protected int value = 0;
//=======
    int value = 0;
    boolean first;

    // protected int count = 0;
    // int value = 0;
    boolean isInitialPreviousX;

    int previousX;
    
    boolean isInitialPreviousY;

    int previousY;
//>>>>>>> 1c28ac2f19054bad41263aaccb71ad2ae37f3c27

    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
	this.screenCoordinator = screenCoordinator;

	playMusic(0);
    }

    public void initialize() {
	// setup state
	flagManager = new FlagManager();
	flagManager.addFlag("firstTimeInHouse", false);
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
	flagManager.addFlag("boatSpawned", true);
	flagManager.addFlag("isOnBoat", false);
	flagManager.addFlag("hasLandedOnIsland",false);
	flagManager.addFlag("canBeRidden",true);
	flagManager.addFlag("end",false);
	flagManager.addFlag("giveAllCoins",false);
	flagManager.addFlag("hasBoomed", false);
	flagManager.addFlag("himExistenceFlag",true);

	previousX = 0;
	isInitialPreviousX = true;
	previousY = 0;
	isInitialPreviousY = true;

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
	anitaHouseInteriorMap = new AnitaHouseInterior();
	islandMap = new MourningWoodMap();

	hallOfShame = new HOSInterior();

	hauntedHouseMap = new HauntedHouse();
	secretMap = new SecretRoom();
	

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

    	//System.out.println(npc.getClass().toString());
	    if (npc.getInteractScript() != null) {
	    	//System.out.println(npc.getInteractScript().getClass().toString());
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
	hosScreen = new HOSScreen(this);
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
		sound.stop();
	    winScreen.update();
	    break;
	case HALL_OF_S:
		sound.stop();
		hosScreen.update();
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
	if (map.getFlagManager().isFlagSet("end")) {
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
    
	
    
    //Anita House Interior
    if (player.getLocation().x > 1225 && player.getLocation().x < 1250 && player.getLocation().y == 1260)

    {
	springMap = this.map;
	anitaHouseInteriorMap.setCoinCounter(this.map.getCoinCounter());
	this.map = anitaHouseInteriorMap;
	this.player.setLocation(343, 480);
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
    

//  //Hall of Shame Interior
//    if (player.getLocation().x > 2338 && player.getLocation().x < 2350 && player.getLocation().y == 1260)
//    {
//	springMap = this.map;
//	hallOfShame.setCoinCounter(this.map.getCoinCounter());
//	this.map = hallOfShame;
//	this.player.setLocation(350, 480);
//	stopMusic();
//	playMusic(17);
//	map.setFlagManager(flagManager);
//	this.player.setMap(map);
//	if (map.getFlagManager().isFlagSet("inventoryCheck"))
//	    map.getInventory().setIsActive(false);
//	else
//	    map.getInventory().setIsActive(true);
//
//	if (map.getFlagManager().isFlagSet("optionsCheck"))
//	    map.getOptions().setIsActive(false);
//	else
//	    map.getOptions().setIsActive(true);
//	mapChanged = true;
//    }

	
	// leaving spring
	if (map.getMapFileName().equals("test_map.txt")) {

	    ///////// sound fade spring////////
	    if (player.getLocation().x > springMap.getEndBoundX() - 930 && player.getLocation().y > 570) {
		if (isInitialPreviousX == true) {
		    if (player.getCurrentWalkingXDirection() == Direction.RIGHT) {
			previousX = springMap.getEndBoundX() - 930;

		    } else {
			previousX = springMap.getEndBoundX();
		    }
		    isInitialPreviousX = false;
		}
		int dif = (int) player.getLocation().x - previousX;
		if (dif > 8) {
		    previousX = (int) player.getLocation().x;
		    sound.volumeDown();
		    previousX = (int) player.getLocation().x;
		} else if (previousX - player.getLocation().x > 8) {
		    previousX = (int) player.getLocation().x;
		    sound.volumeUp();
		}
	    } else if (player.getLocation().x < 790 && player.getLocation().y > 570) {
		if (isInitialPreviousX == true) {
		    if (player.getCurrentWalkingXDirection() == Direction.RIGHT) {
			previousX = 0;

		    } else {
			previousX = 790;
		    }
		    isInitialPreviousX = false;
		}
		int dif = (int) player.getLocation().x - previousX;
		if (dif > 6) {
		    previousX = (int) player.getLocation().x;
		    sound.volumeUp();
		    previousX = (int) player.getLocation().x;
		} else if (previousX - player.getLocation().x > 6) {
		    previousX = (int) player.getLocation().x;
		    sound.volumeDown();
		}

	    }else if (player.getLocation().y < 470) {
	    	if (isInitialPreviousY == true) {
			    if (player.getCurrentWalkingYDirection() == Direction.DOWN) {
				previousY = 0;

			    } else {
				previousY = 790;
			    }
			    isInitialPreviousY = false;
			}
			int dif = (int) player.getLocation().y - previousY;
			if (dif > 10) {
			    previousY = (int) player.getLocation().y;
			    sound.volumeUp();
			    previousY = (int) player.getLocation().y;
			} else if (previousY - player.getLocation().y > 10) {
			    previousY = (int) player.getLocation().y;
			    sound.volumeDown();
			}

	    } else if (player.getLocation().y < 690) {
		if (isInitialPreviousX == true) {
		    if (player.getCurrentWalkingYDirection() == Direction.UP) {
			previousX = 690;

		    } else {
			previousX = 0;
		    }
		    isInitialPreviousX = false;
		}
		int dif = (int) player.getLocation().y - previousX;
		if (dif > 4) {
		    previousX = (int) player.getLocation().y;
		    sound.volumeUp();
		    previousX = (int) player.getLocation().y;
		} else if (previousX - player.getLocation().y > 4) {
		    previousX = (int) player.getLocation().y;
		    sound.volumeDown();
		}

	    }

/*
	    // shop interior
	    if (player.getLocation().x > 606 && player.getLocation().x < 618 && player.getLocation().y == 1596)

	    {
	    */
	  //To Island
	    if (map.getFlagManager().isFlagSet("hasLandedOnIsland")) {
	    stopMusic();
		playMusic(14);
		springMap = this.map;
		islandMap.setCoinCounter(this.map.getCoinCounter());
		this.map = islandMap;
		player.setLeftKey(Key.LEFT);
		player.setUpKey(Key.UP);
		player.setRightKey(Key.RIGHT);
		player.setDownKey(Key.DOWN);
		this.player.setLocation(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
		
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
		

		
		//if (map.getFlagManager().isFlagSet("isOnBoat")) map.getFlagManager().unsetFlag("isOnBoat");
	    }
	    


	    // summer map
	    else if (player.getLocation().x > this.map.getEndBoundX() - 426) {
		stopMusic();
		playMusicZero(11);
		isInitialPreviousX = true;
		springMap = this.map;
		summerMap.setCoinCounter(this.map.getCoinCounter());
		summerMap.setCameraY(this.map.getCamera().getY() - 336);
		
		for (int i = 0; i < springMap.getEnhancedMapTiles().size(); i++) {
		    if (springMap.getEnhancedMapTiles().get(i).getX() > springMap.getEndBoundX() - 730) {
			EnhancedMapTile enhancedMapTile = springMap.getEnhancedMapTiles().get(i);
			enhancedMapTile
				.setX(springMap.getEnhancedMapTiles().get(i).getX() - (springMap.getEndBoundX() - 864));
			enhancedMapTile.setY(springMap.getEnhancedMapTiles().get(i).getY() - 336);
			enhancedMapTile.setMap(summerMap);
			summerMap.addEnhancedMapTile(enhancedMapTile);

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
		isInitialPreviousX = true;
		springMap = this.map;
		winterMap.setCoinCounter(this.map.getCoinCounter());
		winterMap.setCameraX(this.map.getCamera().getX() - 384);
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
		isInitialPreviousX = true;
		springMap = this.map;
		fallMap.setCoinCounter(this.map.getCoinCounter());
		fallMap.setCameraY(this.map.getCamera().getY() - 336);
		for (int i = 0; i < springMap.getEnhancedMapTiles().size(); i++) {
		    if (springMap.getEnhancedMapTiles().get(i).getX() < 730) {
			EnhancedMapTile enhancedMapTile = springMap.getEnhancedMapTiles().get(i);
			enhancedMapTile
				.setX(springMap.getEnhancedMapTiles().get(i).getX() + (fallMap.getEndBoundX() - 864));
			enhancedMapTile.setY(springMap.getEnhancedMapTiles().get(i).getY() - 336);
			enhancedMapTile.setMap(fallMap);
			fallMap.addEnhancedMapTile(enhancedMapTile);
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



//		 if (player.getLocation().y < 470) {
//				if (isInitialPreviousX == true) {
//				    if (player.getCurrentWalkingXDirection() == Direction.DOWN) {
//					previousY = 0;
//
//				    } else {
//					previousY = 470;
//				    }
//				    isInitialPreviousY = false;
//				}
//				int dif = (int) player.getLocation().y - previousY;
//				if (dif > 10) {
//				    previousY = (int) player.getLocation().y;
//				    sound.volumeUp();
//				    previousY = (int) player.getLocation().y;
//				} else if (previousX - player.getLocation().y > 10) {
//				    previousY = (int) player.getLocation().y;
//				    sound.volumeDown();
//				}
//			    }
		 
		 

		    if (player.getLocation().y > winterMap.getEndBoundY() - 470) {
			if (isInitialPreviousY == true) {
			    if (player.getCurrentWalkingYDirection() == Direction.DOWN) {
				previousY = winterMap.getEndBoundY() - 470;

			    } else {
				previousY = springMap.getEndBoundY();
			    }
			    isInitialPreviousY = false;
			}
			int dif = (int) player.getLocation().y - previousY;
			if (dif > 10) {
			    previousY = (int) player.getLocation().y;
			    sound.volumeDown();
			    previousY = (int) player.getLocation().y;
			} else if (previousY - player.getLocation().y > 10) {
			    previousY = (int) player.getLocation().y;
			    sound.volumeUp();
			}
		    }

//	    if (player.getLocation().y > winterMap.getEndBoundY() - 690) {
//=======
	    if (player.getLocation().y > winterMap.getEndBoundY() - 790) {
//>>>>>>> fc15582b8a07f6df43b2ed168654984cacfc19bb
		if (isInitialPreviousX == true) {
		    if (player.getCurrentWalkingYDirection() == Direction.UP) {
			previousX = winterMap.getEndBoundY();

		    } else {
			previousX = winterMap.getEndBoundY() - 790;
		    }
		    isInitialPreviousX = false;
		}
		int dif = (int) player.getLocation().y - previousX;
		if (dif > 8) {
		    previousX = (int) player.getLocation().y;
		    sound.volumeDown();
		    previousX = (int) player.getLocation().y;
		} else if (previousX - player.getLocation().y > 8) {
		    previousX = (int) player.getLocation().y;
		    sound.volumeUp();
		}
	    }


	    // spring map
	    if (player.getLocation().y > this.map.getEndBoundY() - 322) {
		stopMusic();
		playMusicZero(0);
		isInitialPreviousX = true;
		winterMap = this.map;
		springMap.setCoinCounter(this.map.getCoinCounter());
		springMap.setCameraX(this.map.getCamera().getX() + 384);

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
		
		

	    if (player.getLocation().x > fallMap.getEndBoundX() - 930) {
		if (isInitialPreviousX == true) {
		    if (player.getCurrentWalkingXDirection() == Direction.RIGHT) {
			previousX = fallMap.getEndBoundX() - 930;

		    } else {
			previousX = springMap.getEndBoundX();
		    }
		    isInitialPreviousX = false;
		}
		int dif = (int) player.getLocation().x - previousX;
		if (dif > 8) {
		    previousX = (int) player.getLocation().x;
		    sound.volumeDown();
		    previousX = (int) player.getLocation().x;
		} else if (previousX - player.getLocation().x > 8) {
		    previousX = (int) player.getLocation().x;
		    sound.volumeUp();
		}
	    }

	    // spring map
	    if (player.getLocation().x > this.map.getEndBoundX() - 474) {
		stopMusic();
		playMusicZero(0);
		isInitialPreviousX = true;
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
	  //Haunted house
        if (player.getLocation().x > 635 && player.getLocation().x < 675 && player.getLocation().y >= 1020 && player.getLocation().y <= 1021)

        {
    	fallMap = this.map;
    	hauntedHouseMap.setCoinCounter(this.map.getCoinCounter());
    	this.map = hauntedHouseMap;
    	this.player.setLocation(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
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

	// leaving summer
	if (map.getMapFileName().equals("summer_map.txt")) {
		
		

	    if (player.getLocation().x < 890) {
		if (isInitialPreviousX == true) {
		    if (player.getCurrentWalkingXDirection() == Direction.RIGHT) {
			previousX = 0;

		    } else {
			previousX = 890;
		    }
		    isInitialPreviousX = false;
		}
		int dif = (int) player.getLocation().x - previousX;
		if (dif > 8) {
		    previousX = (int) player.getLocation().x;
		    sound.volumeUp();
		    previousX = (int) player.getLocation().x;
		} else if (previousX - player.getLocation().x > 8) {
		    previousX = (int) player.getLocation().x;
		    sound.volumeDown();
		}
	    }

	    // spring map
	    if (player.getLocation().x < 438) {
		stopMusic();
		playMusicZero(0);
		isInitialPreviousX = true;
		summerMap = this.map;
		springMap.setCoinCounter(this.map.getCoinCounter());
		springMap.setCameraY(this.map.getCamera().getY() + 336);
		for (int i = 0; i < summerMap.getEnhancedMapTiles().size(); i++) {
		    if (summerMap.getEnhancedMapTiles().get(i).getX() < 730) {
			EnhancedMapTile enhancedMapTile = summerMap.getEnhancedMapTiles().get(i);
			enhancedMapTile
				.setX(summerMap.getEnhancedMapTiles().get(i).getX() + (springMap.getEndBoundX() - 864));
			enhancedMapTile.setY(summerMap.getEnhancedMapTiles().get(i).getY() + 336);
			enhancedMapTile.setMap(springMap);
			springMap.addEnhancedMapTile(enhancedMapTile);
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
	
	
	
	//leaving haunted house
    if (map.getMapFileName().equals("haunted_house_map.txt")) {
    	if (player.getLocation().x > 500 && player.getLocation().x < 525 && player.getLocation().y < 109) {
    		hauntedHouseMap = this.map;
    		secretMap.setCoinCounter(this.map.getCoinCounter());
    		this.map = secretMap;
    		stopMusic();
    		this.player.setLocation(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
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
    	
    	
	    if (player.getLocation().x > 269 && player.getLocation().x < 283 && player.getLocation().y > 490) {
		hauntedHouseMap = this.map;
		fallMap.setCoinCounter(this.map.getCoinCounter());
		this.map = fallMap;
		this.player.setLocation(656, 1020);
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
    
  //leaving secret room
    if (map.getMapFileName().equals("secret_room.txt")) {
    	if (player.getLocation().x > 200 && player.getLocation().x < 310 && player.getLocation().y > 1849) {
    		secretMap = this.map;
    		hauntedHouseMap.setCoinCounter(this.map.getCoinCounter());
    		this.map = hauntedHouseMap;
    		this.player.setLocation(517, 110);
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
	
	// leaving Anita's house
	if (map.getMapFileName().equals("anita_house_interior_map.txt")) {
	    if (player.getLocation().x > 315 && player.getLocation().x < 355 && player.getLocation().y > 519) {
		anitaHouseInteriorMap = this.map;
		springMap.setCoinCounter(this.map.getCoinCounter());
		this.map = springMap;
		this.player.setLocation(1236, 1263);
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

//		  //leaving Hall Of Shame
//	    if (map.getMapFileName().equals("hall_of_shame.txt")) {
//		    if (player.getLocation().x > 315 && player.getLocation().x < 380 && player.getLocation().y > 520) {
//			hallOfShame = this.map;
//			springMap.setCoinCounter(this.map.getCoinCounter());
//			this.map = springMap;
//			//this.player.setLocation(2339, 1272);
//			this.player.setLocation(1236, 1263);
//			stopMusic();
//			playMusic(11);
//			map.setFlagManager(flagManager);
//			this.player.setMap(map);
//
//			if (map.getFlagManager().isFlagSet("inventoryCheck"))
//			    map.getInventory().setIsActive(false);
//			else
//			    map.getInventory().setIsActive(true);
//
//			if (map.getFlagManager().isFlagSet("optionsCheck"))
//			    map.getOptions().setIsActive(false);
//			else
//			    map.getOptions().setIsActive(true);
//			mapChanged = true;
//		    }


	}

	if (mapChanged) {
	    for (MapTile mapTile : map.getMapTiles()) {
		if (mapTile.getInteractScript() != null) {
		    mapTile.getInteractScript().setMap(map);
		    mapTile.getInteractScript().setPlayer(player);
		}
	    }
	    for (NPC npc : map.getNPCs()) {
	    	//System.out.println(npc.getInteractScript().getClass().toString());
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
	RUNNING, LEVEL_COMPLETED, HALL_OF_S
    }

    public void playMusic(int i) {
	sound.setFile(i);
	sound.play();
	sound.loop();
    }

    public void playMusicZero(int i) {
	sound.setFile(i, -50.0f);
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