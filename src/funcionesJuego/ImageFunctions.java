
package funcionesJuego;

import java.awt.Image;
import javax.swing.ImageIcon;


public class ImageFunctions {
    
    private Images images;
    
    public ImageFunctions(){
        images = new Images();
        images.mainCharacterImag();
    }
    public ImageIcon mcWalking(int sequence, int width, int height, String action){
        ImageIcon icon = new ImageIcon(images.getMain_Character_Walking(sequence,action).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        return icon;
    }
    
    
}
