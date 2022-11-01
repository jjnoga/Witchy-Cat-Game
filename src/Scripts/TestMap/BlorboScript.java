package Scripts.TestMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

//script for talking to Blorbo npc
public class BlorboScript extends Script<NPC> {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		File tester = new File("testerScript.txt");
		Scanner fileInput = null;
		if (!isFlagSet("hasTalkedToBlorbo")) {
//			addTextToTextboxQueue("You talked to Blorbo, Hooray!");
			try {
				// **** THIS IS THE LINE WHERE THE FILE IS ACTUALLY READ INTO THE SCANNER ****
				fileInput = new Scanner(tester);
			} catch (FileNotFoundException e) {
				System.out.println("Unable to load file!"); // print out to user that file cannot be loaded in
				e.printStackTrace();
				System.exit(1); 
			}
			addTextToTextboxQueue(fileInput.nextLine());


		} else {
			addTextToTextboxQueue("Hi Anita!");
		}
		entity.facePlayer(player);

	}

	@Override
	protected void cleanup() {
		unlockPlayer();
		hideTextbox();

		// set flag so that if walrus is talked to again after the first time, what he
		// says changes
		setFlag("hasTalkedToBlorbo");
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
