package Scripts.TestMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

//script for talking to Blorbo npc
public class BlorboScript extends Script<NPC> {
	
	File tester = new File("Resources/testerScript.txt");
	Scanner fileInput = null;
	String[] selections = new String[2];
	String[] answers = new String[2];
	int numAnswer = -1;
	String choice = "empty";

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		selections[0] = "Yes";
		selections[1] = "No";

		try {
			fileInput = new Scanner(tester);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to load file!"); // print out to user that file cannot be loaded in
			e.printStackTrace();
			System.exit(1);
		}

		if (!isFlagSet("hasTalkedToBlorbo")) {
			for (int i = 0; i <= 6; i++) {
				String str = fileInput.nextLine();
				String multiLine = "\\n";
				String select = "*ans";
				Boolean isMulti = str.contains(multiLine);
				Boolean isAns = str.contains(select);
				if (isAns == true && isMulti == true) {
					numAnswer += 1;
					answers[numAnswer] = fileInput.nextLine() + "\n" + fileInput.nextLine();
				} else if (isAns == true && isMulti == false) {
					numAnswer += 1;
					answers[numAnswer] = fileInput.nextLine();
				} else if (isMulti == true) {
					addTextToTextboxQueue(fileInput.nextLine() + "\n" + fileInput.nextLine());
				} else if (isMulti == false) {
					addTextToTextboxQueue(str);
				}

			}
		} else {
			for (int i = 0; i <= 14; i++) {
				fileInput.nextLine();
			}

//			if (getChoice() == 0) {
//				choice = "Spring";
//			}

			addTextToTextboxQueue(fileInput.nextLine(), selections, answers);

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
