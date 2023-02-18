
package funcionesJuego;

import javax.swing.ImageIcon;

public class Images {
    
    private ImageIcon main_Character_Walking_Right [] = new ImageIcon[18];
    private ImageIcon main_Character_Walking_Left [] = new ImageIcon[18];
    private ImageIcon main_Character_Jumping_Left [] = new ImageIcon[6];
    private ImageIcon main_Character_Jumping_Right [] = new ImageIcon[6];
    private ImageIcon main_Character_Attacking_Left [] = new ImageIcon[12];
    private ImageIcon main_Character_Attacking_Right [] = new ImageIcon[12];
        
    public void mainCharacterImag(){
        String path = null;
        for(int i = 0; i<main_Character_Walking_Right.length;i++){
            path = ".\\src\\funcionesJuego\\Principal\\Derecha\\Walking\\Satyr_01_Walking_";
            main_Character_Walking_Right[i] = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
        }
        for(int i = 0; i<main_Character_Walking_Left.length;i++){
            path = ".\\src\\funcionesJuego\\Principal\\Izquierda\\Walking\\Satyr_01_Walking_";
            main_Character_Walking_Left[i] = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
        }
        for(int i = 0; i<main_Character_Jumping_Left.length;i++){
            path = ".\\src\\funcionesJuego\\Principal\\Izquierda\\Jump_Loop\\Satyr_01_Jump_Loop_";
            main_Character_Jumping_Left[i] = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
        }
        for(int i = 0; i<main_Character_Jumping_Right.length;i++){
            path = ".\\src\\funcionesJuego\\Principal\\Derecha\\Jump_Loop\\Satyr_01_Jump_Loop_";
            main_Character_Jumping_Right[i] = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
        }
        for(int i = 0; i<main_Character_Attacking_Right.length;i++){
            path = ".\\src\\funcionesJuego\\Principal\\Derecha\\Attacking\\Satyr_01_Attacking_";
            main_Character_Attacking_Right[i] = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
        }
        for(int i = 0; i<main_Character_Attacking_Left.length;i++){
            path = ".\\src\\funcionesJuego\\Principal\\Izquierda\\Attacking\\Satyr_01_Attacking_";
            main_Character_Attacking_Left[i] = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
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
            case "Jumping_Right":
                retorno = main_Character_Jumping_Right[i];
                break;
            case "Jumping_Left":
                retorno = main_Character_Jumping_Left[i];
                break;
            case "Attacking_Left":
                retorno = main_Character_Attacking_Left[i];
                break;
            case "Attacking_Right":
                retorno = main_Character_Attacking_Right[i];
                break;
            default: 
                retorno = main_Character_Walking_Right[i];
                break;
        }
        
        return retorno;  
    }
    
    
}
