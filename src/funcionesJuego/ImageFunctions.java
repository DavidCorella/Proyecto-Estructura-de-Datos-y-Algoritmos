/*Esta Clase se encargar de traer las imagenes de todos los personajes*/

package funcionesJuego;

import java.awt.Image;
import javax.swing.ImageIcon;


public class ImageFunctions {
    
    private Images image;
    
    public ImageFunctions(){
        image = new Images();
    }
    public ImageIcon characterImages(int sequence, int width, int height, String action, String type){
        ImageIcon icon = new ImageIcon(image.getMain_Character_Walking(sequence,action,type).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        return icon;
    }
    
    
}
