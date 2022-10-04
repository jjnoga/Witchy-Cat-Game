package Scripts;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sounds {
	Clip clip;
	URL soundURL[] = new URL[30];
	
	public Sounds() {
		soundURL[0] = getClass().getResource("/Utils/brilliant-life-60sec.wav");
		soundURL[1] = getClass().getResource("/Utils/mixkit-space-coin-win-notification-271.wav");
		soundURL[2] = getClass().getResource("/Utils/mixkit-arcade-game-complete-or-approved-mission-205.wav");
	}
	
	public void setFile(int i) {
		
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		}catch(Exception e) {
			
		}
	}
	
	public void play() {
		clip.start();
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		clip.stop();
	}
	
;}
