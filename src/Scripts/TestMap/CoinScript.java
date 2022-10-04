package Scripts.TestMap;

import Level.CoinCounter;
import Level.Map;
import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Level.Textbox;
import Scripts.Sounds;

public class CoinScript extends Script {
	protected CoinCounter counter;
	Sounds sound = new Sounds();
	private Map map;

	@Override
	protected void setup() {
		counter = new CoinCounter(map);
		showTextbox();
		addTextToTextboxQueue("You found a coin! Now you have 1 coin");

	}

	@Override
	protected void cleanup() {
		setFlag("hasFoundCoin");
		counter.addCoin(1);
		hideTextbox();

	}

	@Override
	public ScriptState execute() {
		if (!isFlagSet("hasFoundCoin")) {
			start();
			playSE(1);
			
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		return ScriptState.COMPLETED;
		
	}
	
	 public void playSound(int i) {
			sound.setFile(i);
			sound.play();
			sound.loop();
		}
		
	 public void stopSound() {
			sound.stop();
	 	}
		
	 public void playSE(int i) {
			sound.setFile(i);
			sound.play();
		}
		
}