package Scripts.TestMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Level.Script;
import Level.ScriptState;

public class HouseIntro extends Script {

	File tester = new File("Resources/HouseScript.txt");
	Scanner fileInput = null;
	int numAnswer = -1;

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

		if (!isFlagSet("firstTimeInHouse")) {
			for (int i = 0; i <= 3; i++) {
				String str = fileInput.nextLine();
				String multiLine = "\\n";
				Boolean isMulti = str.contains(multiLine);
				if (isMulti == true) {
					addTextToTextboxQueue(fileInput.nextLine() + "\n" + fileInput.nextLine());
				} else if (isMulti == false) {
					addTextToTextboxQueue(str);
				}

			}

		}

	}

	@Override
	protected void cleanup() {
		setFlag("firstTimeInHouse");
		hideTextbox();
		unlockPlayer();
	}

	@Override
	public ScriptState execute() {
		if (!isFlagSet("firstTimeInHouse")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		return ScriptState.COMPLETED;
	}

}
