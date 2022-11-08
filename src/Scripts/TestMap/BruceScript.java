package Scripts.TestMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

//script for talking to Pizza npc
public class BruceScript extends Script<NPC> {

	File tester = new File("Resources/BruceScript.txt");
	Scanner fileInput = null;
	String[] selections = { "Yes ", "No " };
	String[] answers = new String[2];
	int numAnswer = -1;
	String option = "empty";

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();

		try {
			fileInput = new Scanner(tester);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to load file!"); // print out to user that file cannot be loaded in
			e.printStackTrace();
			System.exit(1);
		}

		// changes what Bruce says when talking to him the first time (flag is not set)
		// vs talking to him afterwards (flag is set)
		if (!isFlagSet("hasTalkedtoBruce")) {
			for (int i = 0; i <= 15; i++) {
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
			
			setFlag("hasTalkedtoBruce");

		} else {
			for (int i = 0; i <= 34; i++) {
				fileInput.nextLine();
			}
			
			addTextToTextboxQueue(fileInput.nextLine());
			System.out.println(IntroScript.firstPick);
		}
		entity.facePlayer(player);

	}

	@Override
	protected void cleanup() {
		unlockPlayer();
		hideTextbox();
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
