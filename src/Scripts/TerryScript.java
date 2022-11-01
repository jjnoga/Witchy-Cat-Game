package Scripts;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

//script for talking to Pizza npc
public class TerryScript extends Script<NPC> {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();

		// changes what pizza says when talking to him the first time (flag is not set)
		// vs talking to him afterwards (flag is set)
		if (!isFlagSet("hasTalkedtoTerry")) {
			addTextToTextboxQueue("Hi I'm Terry the turtle, you can speak to me \nwhenever there's something you need to buy!");

		} else {
			addTextToTextboxQueue("What would you like to buy?");
		}
		entity.facePlayer(player);

	}

	  @Override
	    protected void cleanup() {
	        unlockPlayer();
	        hideTextbox();

	        // set flag so that if walrus is talked to again after the first time, what he says changes
	        setFlag("hasTalkedtoTerry");
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
