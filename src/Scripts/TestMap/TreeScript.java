package Scripts.TestMap;

import java.util.Queue;

import Level.Script;
import Level.ScriptState;
import SpriteFont.SpriteFont;

// script for talking to tree with hole in it
public class TreeScript extends Script {

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue("...");
        addTextToTextboxQueue("I found my ball inside of the tree!\nYippee!");
    }

    @Override
    protected void cleanup() {
        setFlag("hasFoundBall");
        hideTextbox();
        unlockPlayer();
    }

    @Override
    public ScriptState execute() {
        if (!isFlagSet("hasFoundBall") && isFlagSet("hasTalkedToDinosaur") && isPlayerBelowEntity()) {
            start();
            if (!isTextboxQueueEmpty()) {
                return ScriptState.RUNNING;
            }
            end();
        }
        return ScriptState.COMPLETED;
    }

	@Override
	protected SpriteFont spriteFontCompile(Queue selectionQueue) {
		// TODO Auto-generated method stub
		return null;
	}
}

