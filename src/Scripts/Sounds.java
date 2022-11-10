package Scripts;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sounds {
    Clip clip;
    URL soundURL[] = new URL[30];
    FloatControl fc;
    float previousVolume = 0;
    float currentVolume = 0;
    boolean mute = false;
    int volumeScale = 3;
    float volume;

    public Sounds() {

	soundURL[0] = getClass().getResource("/Sounds/The_Winds_of_Destiny_Beckon_Anita_Spring.wav"); // using
	soundURL[1] = getClass().getResource("/Sounds/mixkit-space-coin-win-notification-271.wav"); // using
	soundURL[2] = getClass().getResource("/Sounds/itemPickedUp.wav"); // using
	soundURL[3] = getClass().getResource("/Sounds/KeyItemFound.wav"); // using
	soundURL[4] = getClass().getResource("/Sounds/pokemon-a-button.wav"); // using
	soundURL[5] = getClass().getResource("/Sounds/se_gui_choose.wav"); // using
	soundURL[6] = getClass().getResource("/Sounds/beep-6-96243.wav"); // using
	soundURL[7] = getClass().getResource("/Sounds/GUI menu open.wav");
	soundURL[8] = getClass().getResource("/Sounds/VineCut.wav"); // using
	soundURL[9] = getClass().getResource("/Sounds/OptionsMenu.wav"); // using
	soundURL[10] = getClass().getResource("/Sounds/Auburn_Thicket_Autumn.wav"); // using
	soundURL[11] = getClass().getResource("/Sounds/Sandy_Barrens_Summer1.wav"); // using
	soundURL[12] = getClass().getResource("/Sounds/77-How-About-a-Song-An-Unwavering-Heart.wav");
	soundURL[13] = getClass().getResource("/Sounds/Frozen_Grounds_Winter.wav");

    }

    public void setFile(int i) {

	try {
	    AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
	    clip = AudioSystem.getClip();
	    clip.open(ais);
	    fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	} catch (Exception e) {

	}

    }
    
    public void setFile(int i, float v) {

	try {
	    AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
	    clip = AudioSystem.getClip();
	    clip.open(ais);
	    fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	    fc.setValue(v);
	} catch (Exception e) {

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

    public void volumeMute() {
	if (mute == false) {
	    previousVolume = currentVolume;
	    currentVolume = -80.0f;
	    // System.out.println(currentVolume);
	    fc.setValue(currentVolume);
	    mute = true;
	} else if (mute == true) {
	    currentVolume = previousVolume;
	    previousVolume = 6.0f;
	    fc.setValue(currentVolume);
	    mute = false;
	}
    }

    public void volumeUp() {
	currentVolume += 3.0f;
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

    public void volumeChangeDown(float f) {
	currentVolume -= f;
	System.out.println(currentVolume);
	if (currentVolume < -29.0) {
	    currentVolume = -29.0f;
	}
    }
//<<<<<<< HEAD
//	
//	public void volumeUp() {
//		currentVolume += 1.0f;
//		System.out.println("Current Volume: " + currentVolume);
//		if (currentVolume > 6.0f) {
//			currentVolume = 6.0f;
//		}
//		fc.setValue(currentVolume);
//=======
//	fc.setValue(currentVolume);
//    }

    public void volumeChangeUp(float f) {
	currentVolume += f;
	System.out.println(currentVolume);
	if (currentVolume > 6.0) {
	    currentVolume = 6.0f;

	}
	fc.setValue(currentVolume);
    }

    public FloatControl getFc() {
	return this.fc;
    }

    public void setFc(FloatControl fc) {
	this.fc = fc;
    }

    public float getVolume() {
	return currentVolume;
    }

    public void setVolume(float volume) {
	this.volume = volume;
    }

    public float getCurrentVolume() {
	return currentVolume;
    }

    public void setCurrentVolume(float currentVolume) {
	if (this.currentVolume < currentVolume) {
	    while (this.currentVolume < currentVolume) {
		volumeUp();
	    }
	} else if (this.currentVolume > currentVolume) {
	    while (this.currentVolume > currentVolume) {
		volumeDown();
	    }
	}

    }

    public float getVolMin() {
	currentVolume = -80.0f;

	return currentVolume;
    }

    // May use this to completely redo the volume system and eliminate the mute
    // button and just make a volume control
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