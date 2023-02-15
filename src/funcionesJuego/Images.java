
package funcionesJuego;

import javax.swing.ImageIcon;

public class Images {
    
    private ImageIcon main_Character_Walking [];
    
    public Images(){
        main_Character_Walking = new ImageIcon [18];
        mainCharacterImag();
    }
    
    private void mainCharacterImag(){
        String direccion = null;
        for(int i = 0; i<main_Character_Walking.length;i++){
            direccion = ".\\src\\funcionesJuego\\Principal\\Walking\\Satyr_01_Walking_";
            main_Character_Walking[i] = new ImageIcon(direccion.concat(String.valueOf(i)).concat(".png"));
        }
    }
    
    public ImageIcon getMain_Character_Walking(int i){
        return main_Character_Walking[i];
    }
}
