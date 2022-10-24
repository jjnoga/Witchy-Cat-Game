package Scripts;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sounds {
	static Clip clip;
	static URL soundURL[] = new URL[30];
	static FloatControl fc;
	static float previousVolume = 0;
    static float currentVolume = 0;
	static boolean mute = false;
	int volumeScale = 3;
	float volume;
	
	public Sounds() {
		soundURL[0] = getClass().getResource("/Sounds/brilliant-life-60sec.wav");
		soundURL[1] = getClass().getResource("/Sounds/mixkit-space-coin-win-notification-271.wav");
		soundURL[2] = getClass().getResource("/Sounds/mixkit-arcade-game-complete-or-approved-mission-205.wav");
		soundURL[3] = getClass().getResource("/Sounds/KeyItemFound.wav");
	}
	
	public void setFile(int i) {
		
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		}catch(Exception e) {
			
		}
	}
	
	public void play() {
		clip.start();
	}
	
	public static void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		clip.stop();
	}
	
	public void volumeMute() {
		if (mute == false) {
			previousVolume = currentVolume;
			currentVolume = -80.0f;
			//System.out.println(currentVolume);
			fc.setValue(currentVolume);
			mute = true;
		}
		else if(mute == true) {
			currentVolume = previousVolume;
			previousVolume = 6.0f;
			fc.setValue(currentVolume);
			mute = false;
		}
	}
	
	public void volumeUp() {
		currentVolume += 1.0f;
		//System.out.println("Current Volume: " + currentVolume);
		if (currentVolume > 6.0f) {
			currentVolume = 6.0f;
		}
		fc.setValue(currentVolume);
	}
	
	public void volumeDown() {
		currentVolume -= 1.0f;
		//System.out.println("Current Volume: " + currentVolume);
		if (currentVolume < -80.0f) {
			currentVolume = -80.0f;
		}
		fc.setValue(currentVolume);
	}
	
	
	//May use this to completely redo the volume system and eliminate the mute button and just make a volume control
//	public void checkVolume() {
//		switch(volumeScale) {
//		case 0: volume = -80f; break;
//		case 1: volume = -20f; break;
//		case 2: volume = -12f; break;
//		case 3: volume = -5f; break;
//		case 4: volume = 1f; break;
//		case 5: volume = 6f; break; //could be 1 if i only want the two options
//		}
//		fc.setValue(volume);
//	}
}