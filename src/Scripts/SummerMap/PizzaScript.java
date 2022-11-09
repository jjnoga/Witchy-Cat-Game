package Scripts.SummerMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

//script for talking to Pizza npc
public class PizzaScript extends Script<NPC> {

	private boolean hasGivenStaff = false;
	File tester = new File("Resources/PizzaScript.txt");
	Scanner fileInput = null;
	String[] selections = { "Yes ", "No " };
	String[] answers = new String[2];
	int numAnswer;
	String option = "empty";
	int nicknameChoice;
	String nickname = "";

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

		// changes what pizza says when talking to him the first time (flag is not set)
		// vs talking to him afterwards (flag is set)
		numAnswer = -1;

		if (!isFlagSet("hasTalkedtoPizza")) {

			nicknameChoice = -1;

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
			addTextToTextboxQueue(fileInput.nextLine(), selections, answers);

			for (int i = 0; i <= 9; i++) {
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
			hasGivenStaff = true;
			setFlag("hasTalkedtoPizza");
		} else if (isFlagSet("hasTalkedtoPizza") && !isFlagSet("hasTalkedtoPizzaTwo")) {
			for (int i = 0; i <= 45; i++) {
				fileInput.nextLine();
			}
			
			numAnswer = -1;
			
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
			
			if (nicknameChoice == 0) {
				nickname = "Pizza Slice";
			} else if (nicknameChoice == 1) {
				nickname = "Anita";
			} else {
				nickname = "fail";
			}
			
			addTextToTextboxQueue(fileInput.nextLine() + nickname + "?", selections, answers);
		}
		entity.facePlayer(player);

	}

	@Override
	protected void cleanup() {
		unlockPlayer();
		hideTextbox();

		// set flag so that if walrus is talked to again after the first time, what he
		// says change
		
		if (nicknameChoice == -1) {
			nicknameChoice = getChoice();
			
		}
		if (!isFlagSet("hasGivenSwordItem") && !isFlagSet("hasGivenStaffItem") && !isFlagSet("hasGivenFishItem")
				&& !isFlagSet("hasGivenSkatesItem") && hasGivenStaff) {
			setFlag("hasGivenStaffItem");
			setFlag("discoveredStaff");
			hasGivenStaff = false;
		}
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
