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
public class DinoScriptItemGiveSkates extends Script<NPC> {
	
	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		
		
		if (!isFlagSet("hasGivenSkatesItem")) {
			addTextToTextboxQueue("Have some skates!");
			
			

		} else if (isFlagSet("hasGivenSkatesItem")) {
			addTextToTextboxQueue("Gimme your skates!");
		}
		entity.facePlayer(player);

	}

	  @Override
	    protected void cleanup() {
	        unlockPlayer();
	        hideTextbox();

	        if (!isFlagSet("hasGivenSwordItem") && !isFlagSet("hasGivenStaffItem") && !isFlagSet("hasGivenFishItem") && !isFlagSet("hasGivenSkatesItem")) {
				setFlag("hasGivenSkatesItem");
				setFlag("discoveredSkates");
				//unsetFlag("hasDroppedSword");
			} else if (isFlagSet("hasGivenSkatesItem")) {
				//unsetFlag("hasGivenSwordItem");
				unsetFlag("hasGivenSkatesItem");
				unsetFlag("discoveredSkates");
				//setFlag("hasDroppedSword");
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

