package burgeon;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlaySound {

	public static void playMusic() throws Throwable
	{

		Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("res/soundtrack.wav"));
        clip.open(inputStream);
        //clip.start();
        clip.loop(clip.LOOP_CONTINUOUSLY);
        
	}
	
}
