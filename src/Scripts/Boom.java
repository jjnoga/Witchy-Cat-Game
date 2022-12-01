package Scripts;

import java.util.Queue;

import Level.Script;
import Level.ScriptState;
import Scripts.Sounds;
import SpriteFont.SpriteFont;

public class Boom extends Script {
	
	private Sounds sounds = new Sounds();

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();

		
		if(!map.getFlagManager().isFlagSet("hasBoomed")) {
			sounds.setFile(16);
			sounds.play();
		}

	}

	@Override
	protected void cleanup() {
		hideTextbox();
		unlockPlayer();
		map.getFlagManager().setFlag("hasBoomed");
		map.getFlagManager().unsetFlag("himExistenceFlag");
	}

	@Override
	public ScriptState execute() {
		if (!map.getFlagManager().isFlagSet("hasBoomed")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		return ScriptState.COMPLETED;
	}
}
