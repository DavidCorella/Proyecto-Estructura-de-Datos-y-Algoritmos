
package appproyecto;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonido extends Thread{
    
    private String audioPath;
    
    public Sonido(String audio){
        audioPath = audio;
    }
    
    public void run(){
        reproducir();
    }
    public void reproducir(){
        try{
            Clip audio = AudioSystem.getClip();
            audio.open(AudioSystem.getAudioInputStream(new File(audioPath)));
            while(true)
                audio.start();
        }catch(Exception ex){
        
        }
    }
}
