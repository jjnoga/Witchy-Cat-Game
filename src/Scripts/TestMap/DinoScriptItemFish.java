package Scripts.TestMap;

import java.util.Queue;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import GameObject.Frame;
import Level.*;
import Maps.TestMap;
import SpriteFont.SpriteFont;
import Utils.Direction;
import Utils.Point;

// script for talking to dino npc
// the script is segmented -- it has multiple setups, cleanups, and executions based on its current action
public class DinoScriptItemFish extends Script<NPC> {
	
	private boolean given = false;
	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		
		
		if (!isFlagSet("hasGivenFishItem") && !given) {
			addTextToTextboxQueue("Have a fish!");
			
			

		} else if (given) {
			addTextToTextboxQueue("...I'm not giving you another fish.");
		}
		entity.facePlayer(player);

	}

	  @Override
	    protected void cleanup() {
	        unlockPlayer();
	        hideTextbox();

	        if (!isFlagSet("hasGivenSwordItem") && !isFlagSet("hasGivenStaffItem") && !isFlagSet("hasGivenFishItem") && !isFlagSet("hasGivenSkatesItem") && !given) {
				setFlag("hasGivenFishItem");
				setFlag("discoveredFish");
				given = true;
				//unsetFlag("hasDroppedSword");
			}
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

