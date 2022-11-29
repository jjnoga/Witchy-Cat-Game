package Scripts;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

//script for talking to Pizza npc
public class MoyaiScript extends Script<NPC> {

    @Override
    protected void setup() {
	lockPlayer();
	showTextbox();

	addTextToTextboxQueue("The moyai stares ominously... \n...");
	addTextToTextboxQueue("...");
	addTextToTextboxQueue("......");
	addTextToTextboxQueue(".........");
	addTextToTextboxQueue("............");
	addTextToTextboxQueue("...............");
	addTextToTextboxQueue("The moyai is sucking Anita in?!");
    }

    @Override
    protected void cleanup() {
    	unlockPlayer();
    	hideTextbox();
    	setFlag("end");
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
