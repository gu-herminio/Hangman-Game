
package jogoforcaa3;

//Importação de bibliotecas para funcionamento dos métodos.
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


// Classe para execução dos áudios de trilha sonora do game e feedback de final de jogo.
public class AudioManager {
    private static AudioManager instance;
    private Clip clip;

    private AudioManager() {}

    public static AudioManager getInstance() {
        if (instance == null) {
            instance = new AudioManager();
        }
        return instance;
    }

    
    // Método para execução do áudio de trilha sonora do jogo.
    public void tocarAudio(String filename) {
        try {
            if (clip != null && clip.isRunning()) {
                clip.stop();
            }

            String url = "/Sounds/" + filename;
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(url));

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    
    //Método para pausar áudio da música principal.
    public void pararAudio() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
