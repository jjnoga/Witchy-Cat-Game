package Scripts.TestMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;

import Level.Script;
import Level.ScriptState;
import SpriteFont.SpriteFont;

// trigger script at beginning of game to set that heavy emotional plot
public class IntroScript extends Script {
	
	File tester = new File("Resources/BeginningScript.txt");
	Scanner fileInput = null;
	String[] selections = { "Here", "  Summer", " Fall" , "Winter" };
	String [] answers = new String [4];
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
		
		for (int i = 0; i <= 8; i++) {
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
		
		addTextToTextboxQueue("Hmmm, where should I start?", selections, answers);
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
