package endGame;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * @author Aevan Dino
 *
 */
public class WinMusic extends Thread {


	private Clip clip;
	private Thread musicPlayer;
	public Boolean isPlaying;

	public WinMusic() {
		clip = null;
	}

	/**
	 * Starts music
	 */
	public void startMusic() {

		if(musicPlayer==null) {
			musicPlayer = new Thread(this);
			isPlaying=true;
			musicPlayer.start();
		}
	}

	/**
	 * Stops the music
	 */
	public void stopMusic() {
		
		if(musicPlayer != null) {
			clip.stop();
			musicPlayer = null;
			isPlaying = false;
			clip = null;
		}
	}

	/**
	 * Run method from Thread class. This method starts playing music until told to stop.
	 */
	public void run() {
		File musicPath;
		AudioInputStream ais;
		while(isPlaying && clip == null) {
			try {
				musicPath = new File("music/victory.wav");				
				ais = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip();
				clip.open(ais);
				clip.start();
			} catch(Exception e) {
				System.out.println("You did not choose a WAV file");
			}
		}
	}
}
