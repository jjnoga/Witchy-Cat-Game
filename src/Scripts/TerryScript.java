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
		
		String[] selections = { "Shears", "Potion", "Nothing (Exit)" };
		String[] answers = { "Here you are, I reckon these could cut some vines.",
				"We're all out I'm afraid, \nlooks like you'll have to make your own.",
				"Have a nice day!"};

		// changes what pizza says when talking to him the first time (flag is not set)
		// vs talking to him afterwards (flag is set)
		if (!isFlagSet("hasTalkedtoTerry")) {
			addTextToTextboxQueue("Hi I'm Terry the turtle, you can speak to me \nwhenever there's something you need to buy!");

		} else if (!isFlagSet("hasBoughtShears")) {
			addTextToTextboxQueue("What would you like to buy?", selections, answers);
		} else {
		    for (int i = 0; i < selections.length - 1; i++) {
			selections[i] = answers[i + 1];
			answers[i] = answers[i + 1];
		    }
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
