package Scripts.TestMap;

import java.awt.datatransfer.SystemFlavorMap;
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

		if (!isFlagSet("hasTalkedToBlorbo")) {
			for (int i = 0; i <= 7; i++) {
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
			
			setFlag("hasTalkedToBlorbo");
		} else if (isFlagSet("hasTalkedToBlorbo") && !isFlagSet("hasTalkedToBlorboTwo")){
			for (int i = 0; i <= 17; i++) {
				fileInput.nextLine();
			}

			if (IntroScript.firstPick == 0) {
				answers[1] = "Okay then, good luck exploring Spring! That's the area\nyou said you would look at first right?";
			} else if (IntroScript.firstPick == 1) {
				answers[1] = "Okay then, good luck exploring Summer! That's the area\nyou said you would look at first right?";
			} else if (IntroScript.firstPick == 2) {
				answers[1] = "Okay then, good luck exploring Fall! That's the area\nyou said you would look at first right?";
			} else if (IntroScript.firstPick == 3) {
				answers[1] = "Okay then, good luck exploring Winter! That's the area\nyou said you would look at first right?";
			}

			addTextToTextboxQueue(fileInput.nextLine(), selections, answers);
			setFlag("hasTalkedToBlorboTwo");
		} else {
			for (int i = 0; i <= 19; i++) {
				fileInput.nextLine();
			}
			numAnswer = -1;
			selections[0] = "Can I have the another hint?";
			selections[1] = "Nothing";

			for (int i = 0; i <= 1; i++) {
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
			addTextToTextboxQueue(fileInput.nextLine(), selections, answers);
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
