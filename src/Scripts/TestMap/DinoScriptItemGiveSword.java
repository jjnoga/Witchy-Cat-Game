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
public class DinoScriptItemGiveSword extends Script<NPC> {
	
	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		
		if (!isFlagSet("hasGivenSwordItem")) {
			addTextToTextboxQueue("Have some shears!");
			

		} else if (isFlagSet("hasGivenSwordItem")) {
			addTextToTextboxQueue("Gimme your shears!");
		}
		entity.facePlayer(player);

	}

	  @Override
	    protected void cleanup() {
	        unlockPlayer();
	        hideTextbox();
	        if (!isFlagSet("hasGivenSwordItem") && !isFlagSet("hasGivenStaffItem") && !isFlagSet("hasGivenFishItem") && !isFlagSet("hasGivenSkatesItem")) {
	        	
	        	setFlag("hasGivenSwordItem");
				setFlag("discoveredSword");
				//unsetFlag("hasDroppedSword");
			} else if (isFlagSet("hasGivenSwordItem")) {
				//unsetFlag("hasGivenStaffItem");
				unsetFlag("hasGivenSwordItem");
				unsetFlag("discoveredSword");
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

		@Override
		protected SpriteFont spriteFontCompile(Queue<String> selectionQueue) {
			// TODO Auto-generated method stub
			return null;
		}
}

