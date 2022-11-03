package Scripts.TestMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Level.Script;
import Level.ScriptState;

// trigger script at beginning of game to set that heavy emotional plot
public class IntroScript extends Script {
	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
//		String[] selections = { "Here", "   Summer", "   Fall", "Winter" };
//		String[] answers = { "I guess I should look around for anything useful here\nfirst. Time to explore!",
//				"Summer should be a good start and I can get some\nsun. Off to find the burning flower!",
//				"Fall is festive and should have the golden leaf.\nLets go!",
//				"I better get ready for the cold in Winter.\nAt least the magic ice will be there" };

//		addTextToTextboxQueue(
//				"and a rare flower that burns with red fire but is\ncool to the touch in the Summer area.");
//		addTextToTextboxQueue("Hmmm, where should I start?", selections, answers);

		File tester = new File("Resources/BeginningScript.txt");
		Scanner fileInput = null;

		try {
			fileInput = new Scanner(tester);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to load file!"); // print out to user that file cannot be loaded in
			e.printStackTrace();
			System.exit(1);
		}

		for (int i = 0; i <= 4; i++) {
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

	@Override
	protected void cleanup() {
		setFlag("hasBeginning");
		hideTextbox();
		unlockPlayer();
	}

	@Override
	public ScriptState execute() {
		if (!isFlagSet("hasBeginning")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		return ScriptState.COMPLETED;
	}
}
