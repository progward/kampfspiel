import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound  {
	
	
	InputStream audioclip1 = getClass().getResourceAsStream("/skelettbattle.mid");
	InputStream audioclip2 = getClass().getResourceAsStream("/geistbattle.mid");
	InputStream audioclip3 = getClass().getResourceAsStream("/scavengerbattle.mid");
	InputStream audioclip4 = getClass().getResourceAsStream("/background.mid");
	InputStream audioclip5 = getClass().getResourceAsStream("/angriff.wav");
	
	AudioInputStream skelettAudio = AudioSystem.getAudioInputStream(new BufferedInputStream(audioclip1));
	Clip skelettMusic = AudioSystem.getClip();
	AudioInputStream geistAudio = AudioSystem.getAudioInputStream(new BufferedInputStream(audioclip2));
	Clip geistMusic = AudioSystem.getClip();
	AudioInputStream scavengerAudio = AudioSystem.getAudioInputStream(new BufferedInputStream(audioclip3));
	Clip scavengerMusic = AudioSystem.getClip();
	AudioInputStream backgroundAudio = AudioSystem.getAudioInputStream(new BufferedInputStream(audioclip4));
	Clip backgroundMusic = AudioSystem.getClip();
	AudioInputStream angriffsAudio = AudioSystem.getAudioInputStream(new BufferedInputStream(audioclip5));
	Clip angriffsMusic = AudioSystem.getClip();
	
	Sound() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		skelettMusic.open(skelettAudio);
		geistMusic.open(geistAudio);
		scavengerMusic.open(scavengerAudio);
		backgroundMusic.open(backgroundAudio);
	}
	
	// Extra Konstruktor für Angriffssound, weil erster Konstruktor länger zum Laden braucht, der Zweite durch die kleine 
	// Angriffssound-Datei jedoch nicht, und bei jedem Angriff den ersten Konstruktor zu laden das Spielgefühl krass beeinträchtigt
	
	Sound(boolean angriffSound) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		angriffsMusic.open(angriffsAudio);
	}
	
	void playSkelettMusic() {
		skelettMusic.start();
		skelettMusic.loop(skelettMusic.LOOP_CONTINUOUSLY);	
	}	
	
	void stopSkelettMusic() {
		skelettMusic.stop();
		skelettMusic.flush();
		skelettMusic.drain();
	}
	
	void playGeistMusic() {
		geistMusic.start();
		geistMusic.loop(geistMusic.LOOP_CONTINUOUSLY);	
	}
	
	void stopGeistMusic() {
		geistMusic.stop();
		geistMusic.flush();
		geistMusic.drain();
	}
	
	void playScavengerMusic(){
		scavengerMusic.start();
		scavengerMusic.loop(scavengerMusic.LOOP_CONTINUOUSLY);	
	}
	
	void stopScavengerMusic() {
		scavengerMusic.stop();
		scavengerMusic.flush();
		scavengerMusic.drain();

	}
	
	void playBackgroundMusic(){
		backgroundMusic.start();
		backgroundMusic.loop(backgroundMusic.LOOP_CONTINUOUSLY);	
	}
	
	void stopBackgroundMusic() {
		backgroundMusic.stop();

		
	}
	
	void playAngriffsMusic() {
		angriffsMusic.start();	
	}
	
	void stopAngriffsMusic() {
		angriffsMusic.stop();
	}
}
