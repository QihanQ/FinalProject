import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundManager {
    private Clip clip;
    private File[] soundFiles = new File[2];

    public SoundManager() {
        soundFiles[0] = new File("Sounds/menuMusic.wav");
        soundFiles[1] = new File("Sounds/PlayingMusic.wav");
    }

    public void setFile(int ind)
    {
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFiles[ind].getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play()
    {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop()
    {
        clip.stop();
    }
}
