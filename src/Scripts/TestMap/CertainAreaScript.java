package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class CertainAreaScript extends Script {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();

		// changes what walrus says when talking to him the first time (flag is not set)
		// vs talking to him afterwards (flag is set)
		if (!isFlagSet("rightSpot")) {
			addTextToTextboxQueue("You made it to just the right spot");
			
		}

	}

	@Override
	protected void cleanup() {
		setFlag("rightSpot");
		hideTextbox();
		unlockPlayer();
	}

	@Override
	public ScriptState execute() {
		if (!isFlagSet("rightSpot")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		return ScriptState.COMPLETED;
	}

}
