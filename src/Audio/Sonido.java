//Clase para reproducir el audio de cada mapa.

package Audio;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonido extends Thread {

    private String audioPath;
    private Clip audio;

    public Sonido(String audio) {
        audioPath = audio;
        this.audio = null;
    }

    public void run() {
        reproducir();
    }

    public void reproducir() {
        if (audio != null) {
            //Si esta reproduciendo para el audio.
            audio.stop();
        }
        try {
            audio = AudioSystem.getClip();
            audio.open(AudioSystem.getAudioInputStream(new File(audioPath)));
            audio.start();
        } catch (Exception ex) {
        }
    }

    public Clip getAudio() {
        return audio;
    }
}
