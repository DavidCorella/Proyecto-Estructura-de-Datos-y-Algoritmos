/* Esta clase se encarga de traer la imagenes desde la carpeta hasta el programa*/

package funcionesJuego;

import javax.swing.ImageIcon;

public class Images {
                
    public ImageIcon getMain_Character_Walking(int i, String action, String type){ // Segun accion, numero de sequencia y tipo de personaje se escoge la imagen.
        ImageIcon retorno = null;
        String path = null;
            switch(action){
                case "Walking_Right":
                    path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Derecha\\Walking\\Walking_"));
                    retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
                case "Walking_Left": 
                    path = ".\\src\\funcionesJuego\\Principal\\Izquierda\\Walking\\Satyr_01_Walking_";
                    retorno =  new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
                case "Jumping_Right":
                    path = ".\\src\\funcionesJuego\\Principal\\Derecha\\Jump_Loop\\Satyr_01_Jump_Loop_";
                    retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
                case "Jumping_Left":
                    path = ".\\src\\funcionesJuego\\Principal\\Izquierda\\Jump_Loop\\Satyr_01_Jump_Loop_";
                    retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
                case "Attacking_Left":
                    path = ".\\src\\funcionesJuego\\Principal\\Izquierda\\Attacking\\Satyr_01_Attacking_";
                    retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
                case "Attacking_Right":
                    path = ".\\src\\funcionesJuego\\Principal\\Derecha\\Attacking\\Satyr_01_Attacking_";
                    retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
                case "Idle_Right":
                    path = ".\\src\\funcionesJuego\\Principal\\Derecha\\Idle\\Satyr_01_Idle_";
                    retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
                case "Idle_Left":
                    path = ".\\src\\funcionesJuego\\Principal\\Izquierda\\Idle\\Satyr_01_Idle_";
                    retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
                default: 
                    path = ".\\src\\funcionesJuego\\Principal\\Derecha\\Walking\\Satyr_01_Walking_";
                    retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
            } 
 
    
        return retorno;
    }
}
