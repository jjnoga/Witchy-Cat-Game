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
			addTextToTextboxQueue("You have everything! Put it all in, quickly");
			addTextToTextboxQueue("Outside there is a rumble and a shake.");
			addTextToTextboxQueue("A voice booms \"No one has called on the great\nPoseidon in years.\"");
			addTextToTextboxQueue("\"Kinda weird I'm hearing from anyone now.\"");
			addTextToTextboxQueue("\"Anyway, here's the boat. I assume you are going to\nTHAT special event. Have fun little cat!\"");
			addTextToTextboxQueue("\"Oh! Remember to press space on the boat. Bye now!\"");
		} else {
			addTextToTextboxQueue("You don't have everything! You need a Fire Rose, a\nIce Sphere, and Golden Leaf");
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
