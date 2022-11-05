package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

//script for talking to Pizza npc
public class PercivalScript extends Script<NPC> {

	private boolean doneIntro = false;
	private boolean givenFish = false;
	
	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();

		// changes what Bruce says when talking to him the first time (flag is not set)
		// vs talking to him afterwards (flag is set)
		if (!doneIntro) {
			addTextToTextboxQueue("Oh, Anita, your timing is impeccable!");
			addTextToTextboxQueue("Pray tell you could not forget me? After all,\nI am Percival the Great!");
			addTextToTextboxQueue("...Well, not 'the Great' just yet, I'm still working\non that.");
			addTextToTextboxQueue("*ehem* Anyways, I fear my insatiable appetite has\nonce again arisen from its slumber.");
			addTextToTextboxQueue("Why, by Jove, this pain in my gut has me rendered \nimmobile!");
			addTextToTextboxQueue("Anita, could you be a doll and fetch me some fish?\nPreferably one that has sufficiently aged.");
			addTextToTextboxQueue("Oh, who am I kidding, you will deliver this to me.");
			addTextToTextboxQueue("After all, your reward for doing so will be quite\nhandsome, indeed.");
			addTextToTextboxQueue("I hear you're pursuing the Sphere of Ice beyond\nthose frozen ponds.");
			addTextToTextboxQueue("Bold indeed, but a useless pursuit without ice\nskates.");
			addTextToTextboxQueue("What say you scratch my back and I scratch yours?\nI'll be waiting here.");
			doneIntro = true;

		} else if (!givenFish && !isFlagSet("hasGivenFishItem") && doneIntro) {
			addTextToTextboxQueue("Well, Anita? Quit loitering and get me that fish\nalready!");
		} else if (isFlagSet("hasGivenFishItem")) {
			addTextToTextboxQueue("*sniff* *sniff* ...Is that...?");
			addTextToTextboxQueue("Ohhhhhh~~, divinely malodorous indeed! This fish will\ndo just fine, I daresay.");
			addTextToTextboxQueue("*GULP GULP GULP GULP*");
			addTextToTextboxQueue("I knew I could rely on your service. As promise, here\nare the skates.");
			addTextToTextboxQueue("Movement with them is limited on ice, but I'm positive\nyou will get the hang of it!");
			givenFish = true;
		} else if (givenFish){
			addTextToTextboxQueue("I'd love to have casual banter with you, but currently\nI'm occupied. Kindly go away.");
		}
		entity.facePlayer(player);

	}

	  @Override
	    protected void cleanup() {
	        unlockPlayer();
	        hideTextbox();

	        if (givenFish && isFlagSet("hasGivenFishItem")) {
	        	unsetFlag("discoveredFish");
	        	unsetFlag("hasGivenFishItem");
	        	setFlag("discoveredSkates");
	        	setFlag("hasGivenSkatesItem");
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
