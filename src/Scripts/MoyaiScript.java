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
	
	addTextToTextboxQueue("Finally you are here. For the special event\nBut, where is it?");
	addTextToTextboxQueue("It's supposed to be here! But it is just this\nMoyai");
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
