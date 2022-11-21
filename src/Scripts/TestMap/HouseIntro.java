package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class HouseIntro extends Script{

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();

		if (!isFlagSet("firstTimeInHouse")) {
			addTextToTextboxQueue("You made it to just the right spot");
		}

	}

	@Override
	protected void cleanup() {
		setFlag("firstTimeInHouse");
		hideTextbox();
		unlockPlayer();
	}

	@Override
	public ScriptState execute() {
		if (!isFlagSet("firstTimeInHouse")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		return ScriptState.COMPLETED;
	}

}
