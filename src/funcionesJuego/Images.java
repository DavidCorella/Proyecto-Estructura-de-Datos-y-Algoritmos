
package funcionesJuego;

import javax.swing.ImageIcon;

public class Images {
    
    private ImageIcon main_Character_Walking_Right [] = new ImageIcon[18];
    private ImageIcon main_Character_Walking_Left [] = new ImageIcon[18];
        
    public void mainCharacterImag(){
        String path = null;
        for(int i = 0; i<main_Character_Walking_Right.length;i++){
            path = ".\\src\\funcionesJuego\\Principal\\Derecha\\Walking\\Satyr_01_Walking_";
            main_Character_Walking_Right[i] = new ImageIcon(path.concat(String.valueOf(i)).concat(".png"));
        }
        for(int i = 0; i<main_Character_Walking_Left.length;i++){
            path = ".\\src\\funcionesJuego\\Principal\\Izquierda\\Walking\\Satyr_01_Walking_";
            main_Character_Walking_Left[i] = new ImageIcon(path.concat(String.valueOf(i)).concat(".png"));
        }
    }
    
    public ImageIcon getMain_Character_Walking(int i, String action){
        ImageIcon retorno = null;
        switch(action){
            case "Walking_Right":
                retorno = main_Character_Walking_Right[i];
                break;
            case "Walking_Left": 
                retorno = main_Character_Walking_Left[i];
                break;
            default: 
                retorno = main_Character_Walking_Right[i];
                break;
        }
        
        return retorno;  
    }
}
