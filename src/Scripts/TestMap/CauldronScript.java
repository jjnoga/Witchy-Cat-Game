package Scripts.TestMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Level.FlagManager;
import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Maps.AnitaHouseInterior;
import Maps.TestMap;

public class CauldronScript extends Script<NPC> {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		
		if (isFlagSet("hasGoldLeaf") && isFlagSet("hasIceSphere") && isFlagSet("hasFireRose")) {
			addTextToTextboxQueue("You have everything! Congrats!\nPotion complete");
		} else {
			addTextToTextboxQueue("You still need to collect all of the ingredients");
		}
		
		
		entity.facePlayer(player);
	}

	@Override
	protected void cleanup() {
		
		if (isFlagSet("hasGoldLeaf") && isFlagSet("hasIceSphere") && isFlagSet("hasFireRose")) {
			map.getFlagManager().unsetFlag("boatSpawned");
		}
		unlockPlayer();
		hideTextbox();

	}

	@Override
	public ScriptState execute() {
		start();
		if (!isTextboxQueueEmpty()) {
			return ScriptState.RUNNING;
		}
		end();
		return ScriptState.COMPLETED;
	}

}
