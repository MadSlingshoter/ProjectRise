package startMenu;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * This class is used to select a music file. The chosen music file
 * can be player and stopped via the GUI.
 * 
 * @author AevanDino
 */
public class BackgroundMusic extends Thread {
 
	private Clip clip;
	private Thread musicPlayer;
	public Boolean isPlaying;
	private int musicPausedAt = 0;
	
	public BackgroundMusic() {
		this.clip = null;
	}

	/**
	 * If music isn't already playing, this method will start
	 * playing the chosen file, that is if there is a file to be played.
	 */
	public void startMusic() {
		
		if(clip!=null && isPlaying) {
			clip.setFramePosition(musicPausedAt);
			clip.start();
			
		
		} else if(musicPlayer==null) {
			musicPlayer = new Thread(this);
			isPlaying=true;
			musicPlayer.start();
		}
	}    

	/**
	 * Pauses music, music continues where it stopped when player asks for music again.
	 */
	public void pauseMusic() {
		if(clip!=null) {
			musicPausedAt = clip.getFramePosition();
			clip.stop();
		}
	}

	/**
	 * Run method from Thread class. This method starts playing music until told to stop.
	 */
	public void run() {
		while(isPlaying && clip == null) {
			try {
				File musicPath = new File("music/bgMusic.wav");				
				AudioInputStream ais = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip();
				clip.open(ais);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				clip.start();
			}
			catch(Exception e)
			{
				System.out.println("You did not choose a WAV file");
			}
		}
	}
}