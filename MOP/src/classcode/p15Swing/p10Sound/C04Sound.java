package classcode.p15Swing.p10Sound;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Um sound manager de sobrevivência.
 * 
 * @author ateofilo
 * 
 */
public class C04Sound {

	// sound file name
	private String soundFileName = null;

	// clip to load the sound file
	private Clip clip;

	public C04Sound(String soundFileName) {
		this.soundFileName = soundFileName;
	}

	public void load() {
		try {
			URL url = this.getClass().getResource("sounds/" + soundFileName);
			System.out.println(url);

			// Get a clip resource.
			clip = AudioSystem.getClip();

			// Set up an audio input stream piped from the sound file.
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(url); // new File(soundFileName));

			// Open audio clip and load samples from the audio input stream.
			clip.open(audioInputStream);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void play() {
		clip.start();
	}

	public void stop() {
		if (clip.isRunning())
			clip.stop(); // Stop the player if it is still running
		rewind();
	}

	public void pause() {
		if (clip.isRunning())
			clip.stop(); // Stop the player if it is still running
	}

	public void rewind() {
		clip.setFramePosition(0); // rewind to the beginning
	}
}
