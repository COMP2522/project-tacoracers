package org.bcit.comp2522.dui.client;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


/**
 * The type Music player.
 */
public class MusicPlayer {
    private Clip clip;

    /**
     * Instantiates a new Music player.
     *
     * @param path the path
     */
    public MusicPlayer(String path) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Play.
     */
    public void play() {
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY); // Set the clip to loop indefinitely
    }


    /**
     * Stop.
     */
    public void stop() {
        clip.stop();
        clip.close();
    }

    /**
     * Gets microsecond position.
     *
     * @return the microsecond position
     */
    public long getMicrosecondPosition() {
        return clip.getMicrosecondPosition();
    }

    /**
     * Start.
     */
    public void start() {
        clip.start();
    }

    /**
     * Sets microsecond position.
     *
     * @param clipPosition the clip position
     */
    public void setMicrosecondPosition(long clipPosition) {
        clip.setMicrosecondPosition(clipPosition);
    }
}
