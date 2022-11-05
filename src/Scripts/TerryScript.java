package Scripts;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

//script for talking to Pizza npc
public class TerryScript extends Script<NPC> {

    // value of 0 means not purchases, 1 is purchased
    // sheers, potion, exit (always 0)
    private int[] itemsBought = new int[2];

    @Override
    protected void setup() {
	lockPlayer();
	showTextbox();
	setChoice(-1);
	String[] selections = { "Shears (2¢)", "Potion (10¢)", "Nothing (Exit)" };
	String[] answers = { "Here you are, I reckon these could cut some vines.",
		"We're all out I'm afraid, \nlooks like you'll have to make your own.", "Have a nice day!" };
	if (getMap().getCoinCounter().getCoinCount() < 2) {
	    answers[0] = "You can't afford these.";
	}
	for (int i = 0; i < itemsBought.length; i++) {
	    if (itemsBought[i] == 1) {
		answers[i] = "You already bought these.";
	    }
	}

	// changes what pizza says when talking to him the first time (flag is not set)
	// vs talking to him afterwards (flag is set)
	if (!isFlagSet("hasTalkedtoTerry")) {
	    addTextToTextboxQueue(
		    "Hi I'm Terry the turtle, you can speak to me \nwhenever there's something you need to buy!");

	} else {
	    addTextToTextboxQueue("What would you like to buy?", selections, answers);
	}

    }

    @Override
    protected void cleanup() {
	unlockPlayer();
	hideTextbox();
	if (getChoice() == 0) {
	    if (getMap().getCoinCounter().getCoinCount() >= 2 && !isFlagSet("hasGivenSwordItem")) {
		getMap().getCoinCounter().setCoinCount(getMap().getCoinCounter().getCoinCount() - 2);
		itemsBought[getChoice()] = 1;
		setFlag("hasGivenSwordItem");

	    }
	}

	entity.facePlayer(player);

	// set flag so that if walrus is talked to again after the first time, what he
	// says changes
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
