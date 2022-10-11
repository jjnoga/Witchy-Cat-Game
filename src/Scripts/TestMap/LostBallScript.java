package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

// trigger script at beginning of game to set that heavy emotional plot
public class LostBallScript extends Script {
	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		String[] selections = { "Here", "   Summer", "   Fall", "Winter" };
		String[] answers = { "I guess I should look around for anything useful here\nfirst. Time to explore!",
				"Summer should be a good start and I can get some\nsun. Off to find the burning flower!",
				"Fall is festive and should have the golden leaf.\nLets go!",
				"I better get ready for the cold in Winter.\nAt least the magic ice will be there" };
		addTextToTextboxQueue("Come on Anita, I can't believe you forgot to restock\nthe ingredients.");
		addTextToTextboxQueue("Welp, time to go get them. I got to collect just 3\nspecial ingredients though.");
		addTextToTextboxQueue("A perfect sphere of ice that never warms or melts\nfrom the Winter area,");
		addTextToTextboxQueue("a golden leaf from the biggest and oldest tree in\nthe Fall area,");
		addTextToTextboxQueue(
				"and a rare flower that burns with red fire but is\ncool to the touch in the Summer area.");
		addTextToTextboxQueue("Hmmm, where should I start?", selections, answers);
	}

	@Override
	protected void cleanup() {
		setFlag("hasLostBall");
		hideTextbox();
		unlockPlayer();
	}

	@Override
	public ScriptState execute() {
		if (!isFlagSet("hasLostBall")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		return ScriptState.COMPLETED;
	}
}
