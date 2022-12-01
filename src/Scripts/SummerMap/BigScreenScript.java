package Scripts.SummerMap;

import Level.Script;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Level.FlagManager;
import Level.NPC;
import Level.ScriptState;
import Maps.HOSInterior;
import Maps.TestMap;

public class BigScreenScript extends Script<NPC>{

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		
		addTextToTextboxQueue("There seems to be something here.\nLet's check it out.");
		addTextToTextboxQueue("Its a strangle tablet with a blurry figure on it.");
		addTextToTextboxQueue("The figure then starts to speak...");
		addTextToTextboxQueue("\"Is this thing on? It is? Great. Hi there, this is basically what you call God speaking, but could just call me GM for short.\"");
		addTextToTextboxQueue("\"If you are reading this, you must either be really nosy, lost, or both, who knows?\"");
		addTextToTextboxQueue("\"You may be wondering, what does GM stand for? And that is simple...I completely forgot. Its been too long.\"");
		addTextToTextboxQueue("\"Regardless, this is known as the Hall of Shame, and for good reason, as your world was based off of so much stuff its funny.\"");
		addTextToTextboxQueue("\"Like the music you hear whenever you walk around the area and interact with thing,\nyeah those are from games like Legend of Zelda, as well as Pokemon\"");
		addTextToTextboxQueue("\"And for your world, we were originally going for a Legend of Zelda vibe, but then it became a mix of that and Animal Crossing for all you gamers out there.\"");
		addTextToTextboxQueue("\"I know, crazy right? Imagine learning your life is a stitich of multiple francises together! You should honestly feel honored.\"");
		addTextToTextboxQueue("\"Anyway, regardless of that, this place is special, as we, me and the other gods, have devised a gift when all three artifacts are collected\"");
		addTextToTextboxQueue("\"And who do think created said gift and legend? It was us obviously, though no one has reached it before. Maybe you could be the first one to reach it.\"");
		addTextToTextboxQueue("\"I have rambled on for too long, anyways, you should finish your adventure, Anita! Oh shoot, I wasn't supposed to say your name! Welp, that's done now.\"");
		addTextToTextboxQueue("\"Also, if you thought this was a hint to see what you will find at the end, too bad!!! Now be like Ash as he remains 10 and continue your journey!\"");
		
		entity.facePlayer(player);
	}

	@Override
	protected void cleanup() {
		
		unlockPlayer();
		hideTextbox();
	}

	@Override
	protected ScriptState execute() {
		start();
		if (!isTextboxQueueEmpty()) {
			return ScriptState.RUNNING;
		}
		end();
		return ScriptState.COMPLETED;
	}

}
