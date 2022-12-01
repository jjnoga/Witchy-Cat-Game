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
		addTextToTextboxQueue("\"Is this thing on? It is? Great. Hi there, this is basically \nwhat you call God speaking, or one of them\"");
		addTextToTextboxQueue("\"If you are reading this, you must either be really nosy, \nlost, or both, who knows?\"");
		//addTextToTextboxQueue("\"You may be wondering, what does GM stand for? And that is simple...I completely forgot. Its been too long.\"");
		addTextToTextboxQueue("\"Regardless, this is known as the Board of Shame, and \nfor good reason,\"");
		addTextToTextboxQueue("\"as your world was based off of so much stuff its funny.\"");
		addTextToTextboxQueue("\"Like the music you hear whenever you walk around \nthe area and interact with thing");
		addTextToTextboxQueue("\"Yeah those are from games like Legend of Zelda, \nas well as Pokemon\"");
		addTextToTextboxQueue("\"And for your world, we were originally going for a \nLegend of Zelda vibe\"");
		addTextToTextboxQueue("\"But then it became a mix of that and Animal Crossing \nfor all you gamers out there.\"");
		addTextToTextboxQueue("\"I know, crazy right? Imagine learning your life is a \nstitich of multiple francises together!\"");
		addTextToTextboxQueue("\"You should honestly feel honored.\"");
		addTextToTextboxQueue("\"Anyway, regardless of that, this place is special, as \nwe, me and the others, have created a gift\"");
		addTextToTextboxQueue("\"when all three artifacts are collected.\"");
		addTextToTextboxQueue("\"And why did we make it? Cause why not, we are gods \nafterall. Though no one has reached it before.\"");
		addTextToTextboxQueue("\"Maybe you could be the first one to reach it.\"");
		addTextToTextboxQueue("\"I have rambled on for too long, anyways, you should \nfinish your adventure, Anita!\"");
		addTextToTextboxQueue("\"Oh shoot, I wasn't supposed to say your name! \nWelp, there goes that surprise. Can't take it back now.\"");
		addTextToTextboxQueue("\"Also, if you thought this was a hint to see what you \nwill find at the end, too bad!!!\"");
		addTextToTextboxQueue("\"Now be like Ash as he remains 10 and continue your \njourney!\"");
		
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
