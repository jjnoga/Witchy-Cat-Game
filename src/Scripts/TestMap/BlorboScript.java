package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

//script for talking to Blorbo npc
public class BlorboScript extends Script<NPC> {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();

		// changes what walrus says when talking to him the first time (flag is not set)
		// vs talking to him afterwards (flag is set)
		if (!isFlagSet("hasTalkedToBlorbo")) {
			addTextToTextboxQueue("You talked to Blorbo, Hooray!");

		} else {
			addTextToTextboxQueue("Hi Anita!");
		}
		entity.facePlayer(player);

	}

	  @Override
	    protected void cleanup() {
	        unlockPlayer();
	        hideTextbox();

	        // set flag so that if walrus is talked to again after the first time, what he says changes
	        setFlag("hasTalkedToBlorbo");
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
