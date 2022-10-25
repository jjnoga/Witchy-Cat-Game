package Screens;

import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    protected OptionsState optionsMenuState;
    protected WinScreen winScreen;
    protected UI options;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
<<<<<<< HEAD
    protected GamePanel gp;
    
=======

>>>>>>> 76b9b7df3111fcf0df28252fbce6b01269ddfd45
    Sounds sound = new Sounds();

    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
<<<<<<< HEAD
        this.screenCoordinator = screenCoordinator;
        
       
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,3));
        
        JButton volUp = new JButton("Volume Up");
        volUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sound.volumeUp();
			}
		});
        frame.add(volUp);
        
        JButton volDown = new JButton("Volume Down");
        volDown.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sound.volumeDown();
			}
		});
        frame.add(volDown);
        
        JButton mute = new JButton("Mute/Unmute");
        mute.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sound.volumeMute();
			}
		});
        frame.add(mute);
        
        frame.pack();
        frame.setVisible(true);
        
        
        
        playMusic(0);
=======
	this.screenCoordinator = screenCoordinator;

	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(new GridLayout(1, 3));

	JButton volUp = new JButton("Volume Up");
	volUp.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		sound.volumeUp();
	    }
	});
	frame.add(volUp);

	JButton volDown = new JButton("Volume Down");
	volDown.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		sound.volumeDown();
	    }
	});
	frame.add(volDown);

	JButton mute = new JButton("Mute/Unmute");
	mute.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		sound.volumeMute();
	    }
	});
	frame.add(mute);

	frame.pack();
	frame.setVisible(true);

	playMusic(0);
>>>>>>> 76b9b7df3111fcf0df28252fbce6b01269ddfd45
    }

    public void initialize() {
	// setup state
	flagManager = new FlagManager();
	flagManager.addFlag("rightSpot", false);
	flagManager.addFlag("hasLostBall", false);
	flagManager.addFlag("hasTalkedToWalrus", false);
	flagManager.addFlag("hasTalkedToDinosaur", false);
	flagManager.addFlag("hasFoundBall", false);
	flagManager.addFlag("hasTalkedToBlorbo", false);
	flagManager.addFlag("hasTalkedtoPizza", false);
	flagManager.addFlag("hasGivenSwordItem", false);
	flagManager.addFlag("hasDropped", false);
	flagManager.addFlag("hasTalkedtoBruce", false);
	flagManager.addFlag("hasGoldLeaf", false);
	flagManager.addFlag("hasIceSphere", false);
	flagManager.addFlag("hasFireRose", false);

	// define/setup map
	springMap = new TestMap();
	summerMap = new SummerMap();
	winterMap = new WinterMap();
	fallMap = new FallMap();
	interiorMap = new InteriorMap();
	this.map = springMap;
	map.reset();
	map.setFlagManager(flagManager);

<<<<<<< HEAD
        // setup player
        this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        this.player.setMap(map);
        Point playerStartPosition = map.getPlayerStartPosition();
        this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
        this.playLevelScreenState = PlayLevelScreenState.RUNNING;
        this.player.setFacingDirection(Direction.LEFT);
        
       this.options = new UI(gp);
=======
	// setup player
	this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
	this.player.setMap(map);
	Point playerStartPosition = map.getPlayerStartPosition();
	this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
	this.playLevelScreenState = PlayLevelScreenState.RUNNING;
	this.player.setFacingDirection(Direction.LEFT);
>>>>>>> 76b9b7df3111fcf0df28252fbce6b01269ddfd45

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

	// if flag is set at any point during gameplay, game is "won"
	if (map.getFlagManager().isFlagSet("hasFoundBall")) {
	    playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
	}

<<<<<<< HEAD
        if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)) {
        	keyLocker.lockKey(Key.ESC);
        	optionsMenuState = OptionsState.OPEN;
        }
        else if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
            optionsMenuState = OptionsState.CLOSED;
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
        
//        switch (optionsMenuState) {
//        case OPEN:
//        	options.drawOptions(graphicsHandler);
//            break;
//        case CLOSED:
//        	map.draw(player, graphicsHandler);
//            break;
//    }
    }

   public PlayLevelScreenState getPlayLevelScreenState() {
        return playLevelScreenState;
=======
	if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)) {
	    keyLocker.lockKey(Key.ESC);
	} else if (Keyboard.isKeyUp(Key.ESC)) {
	    keyLocker.unlockKey(Key.ESC);
	}

	//////////// Temporary thing, get player location and map name by pressing B
	//////////// ///////////
	if (Keyboard.isKeyDown(Key.B) && !keyLocker.isKeyLocked(Key.B)) {
	    System.out.println(player.getLocation());
	    System.out.println(this.map.getMapFileName());
	    System.out.println(this.map.getEndBoundX());
	}
	////////////////////////////////////////////////////////////////////////////////////////

	// map switching, saves state of current map, changes map, places player at
	// certain location
	
	// leaving spring
	if (map.getMapFileName().equals("test_map.txt")) {

	    // Walrus house interior
	    if (player.getLocation().x > 160 && player.getLocation().x < 196 && player.getLocation().y == 1260) {
		springMap = this.map;
		interiorMap.setCoinCounter(this.map.getCoinCounter());
		this.map = interiorMap;
		this.player.setLocation(374, 408);
		map.setFlagManager(flagManager);
		this.player.setMap(map);
	    }

	    // summer map
	    if (player.getFacingDirection().getVelocity() > 0) {
		if (player.getLocation().x > this.map.getEndBoundX() - 426) {
		    springMap = this.map;
		    summerMap.setCoinCounter(this.map.getCoinCounter());
		    this.player.setLocation(438,
			    (player.getLocation().y / springMap.getHeight()) * summerMap.getHeight());
		    this.map = summerMap;
		    map.setFlagManager(flagManager);
		    this.player.setMap(map);
		}
	    }

	    // winter map

	    // fall map

	}
	
	// leaving summer
	if (map.getMapFileName().equals("summer_map.txt")) {

	    // spring map
	    if (player.getFacingDirection().getVelocity() < 0) {
		if (player.getLocation().x < 438) {
		    summerMap = this.map;
		    springMap.setCoinCounter(this.map.getCoinCounter());
		    this.player.setLocation(springMap.getEndBoundX() - 426,
			    (player.getLocation().y / summerMap.getHeight()) * springMap.getHeight());
		    this.map = springMap;
		    map.setFlagManager(flagManager);
		    this.player.setMap(map);
		}
	    }
	}
	
	
	// leaving interior
	if (map.getMapFileName().equals("interior_map.txt")) {
	    if (player.getLocation().x > 364 && player.getLocation().x < 380 && player.getLocation().y > 423) {
		interiorMap = this.map;
		springMap.setCoinCounter(this.map.getCoinCounter());
		this.map = springMap;
		this.player.setLocation(173, 1264);
		map.setFlagManager(flagManager);
		this.player.setMap(map);
	    }
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
>>>>>>> 76b9b7df3111fcf0df28252fbce6b01269ddfd45
    }
    
    public OptionsState getOptionsState() {
		return optionsMenuState;
    }

    public void resetLevel() {
	initialize();
    }

    public void goBackToMenu() {
	screenCoordinator.setGameState(GameState.MENU);
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
	RUNNING, LEVEL_COMPLETED
    }
<<<<<<< HEAD
    
    private enum OptionsState {
    	OPEN, CLOSED
    }
    
=======

>>>>>>> 76b9b7df3111fcf0df28252fbce6b01269ddfd45
    public void playMusic(int i) {
	sound.setFile(i);
	sound.play();
	sound.loop();
    }

    public void stopMusic() {
	sound.stop();
    }

}
