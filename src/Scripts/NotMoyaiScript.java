package Scripts;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

//script for talking to Pizza npc
public class NotMoyaiScript extends Script<NPC> {
	
	boolean givenCoins = false;

    @Override
    protected void setup() {
	lockPlayer();
	showTextbox();

	if(!map.getFlagManager().isFlagSet("giveAllCoins")) {
		addTextToTextboxQueue("DOIN DOIN GIVE ME COIN COIN");
		addTextToTextboxQueue("*The moyai opens its mouth\nexpectantly...*");
		if(map.getCoinCounter().getCoinCount() >= 15) {
			addTextToTextboxQueue("*You inserted all your leftover coins.*");
			addTextToTextboxQueue("MMMMMM GOOD COINS");
			addTextToTextboxQueue("COINS SO GOOD");
			addTextToTextboxQueue("TASTE ALMOST AS GOOD AS\nYOUR MOM");
			givenCoins = true;
		}
		else {
			addTextToTextboxQueue("*But you don't think you\ncan satisfy it right now...*");
			addTextToTextboxQueue("DUMB DUMB");
		}
	}
    }

    @Override
    protected void cleanup() {
    	unlockPlayer();
    	hideTextbox();
    	if(givenCoins) {
			map.getCoinCounter().addCoin(-15);
        	setFlag("giveAllCoins");
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
