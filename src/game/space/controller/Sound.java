package game.space.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Logger;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	private static final Logger LOGGER = Logger.getAnonymousLogger();
    private Clip bgSoundClip;
    private Clip shotSoundClip;
    private Clip bombSoundClip;
    private FloatControl gainControl;
    
    public void loadSound() {
       
        try {
        	
//        	InputStream test = getClass().getResourceAsStream("bgSound4.wav"); //NULLPOINTER EXCEPTION
//        	System.out.println(getClass().getResource("bgSound4.wav"));
//        	AudioInputStream sound = AudioSystem.getAudioInputStream(test);

//        	File file = new File(Sound.class.getClass().getResource("/bgSound3.wav").getPath()); //.jar findet res nicht.																
//        	File file2 = new File(Sound.class.getClass().getResource("shotSound1.wav").getPath());
//        	File file3 = new File(Sound.class.getClass().getResource("bomb.wav").getPath());
    
//            if (file.exists()) {
        	
            	AudioInputStream sound1 = AudioSystem.getAudioInputStream(Sound.class.getClass().getResource("/bgSound4.wav"));
            	AudioInputStream sound2 = AudioSystem.getAudioInputStream(Sound.class.getClass().getResource("/shotSound1.wav"));
            	AudioInputStream sound3 = AudioSystem.getAudioInputStream(Sound.class.getClass().getResource("/bomb.wav"));
            	
            	
//            	AudioInputStream sound2 = AudioSystem.getAudioInputStream(file2);
//            	AudioInputStream sound3 = AudioSystem.getAudioInputStream(file3);
//              load the sound into memory (a Clip)
                
                bgSoundClip = AudioSystem.getClip();
                bgSoundClip.open(sound1);
                shotSoundClip = AudioSystem.getClip();
                shotSoundClip.open(sound2);
                bombSoundClip = AudioSystem.getClip();
                bombSoundClip.open(sound3);
                bgVolumeDown();
//        	}
            
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Malformed URL: " + e);
        }
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Unsupported Audio File: " + e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Input/Output Error: " + e);
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
        }

    // play, stop, loop the sound clip
    }
    public void playBg(){
        bgSoundClip.setFramePosition(0);  // zum Anfang springen
        bgSoundClip.start();
    }
    
    public void bgVolumeDown(){
    	gainControl = (FloatControl)bgSoundClip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(gainControl.getValue()-5);
        //System.out.println("volume down");
    }
    
    public void bgVolumeUp(){
    	gainControl = (FloatControl)bgSoundClip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(gainControl.getValue()+5);
       // System.out.println("volume up");
        LOGGER.info("leiser");
    }
    
    public void loopBg(){
        bgSoundClip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stopBg(){
        bgSoundClip.stop();
    }
    
    public void playShot(){
    	shotSoundClip.setFramePosition(0);  // zum Anfang springen
    	shotSoundClip.start();
    }
    public void loopShot(){
    	shotSoundClip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stopShot(){
    	shotSoundClip.stop();
    }
    
    public void playBomb(){
    	bombSoundClip.setFramePosition(0);  // zum Anfang springen
    	bombSoundClip.start();
    }
    public void loopBomb(){
    	bombSoundClip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stopBomb(){
    	bombSoundClip.stop();
    }
}
