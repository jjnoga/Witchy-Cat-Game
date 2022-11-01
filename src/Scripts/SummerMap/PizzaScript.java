package Scripts.SummerMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Maps.SummerMap;

//script for talking to Pizza npc
public class PizzaScript extends Script<NPC> {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();

		// changes what pizza says when talking to him the first time (flag is not set)
		// vs talking to him afterwards (flag is set)
		if (!isFlagSet("hasTalkedtoPizza")) {
			addTextToTextboxQueue("You talked to Pizza the Snake, Hooray!");

		} else {
			addTextToTextboxQueue("Hi Anita, I love Pizza");
		}
		entity.facePlayer(player);

	}

	  @Override
	    protected void cleanup() {
	        unlockPlayer();
	        hideTextbox();

	        // set flag so that if walrus is talked to again after the first time, what he says changes
	        setFlag("hasTalkedtoPizza");
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
