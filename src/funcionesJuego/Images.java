/* Esta clase se encarga de traer la imagenes desde la carpeta hasta el programa*/

package funcionesJuego;

import javax.swing.ImageIcon;

public class Images {
                
    public ImageIcon getMain_Character_Walking(int i, String action, String type){ // Segun accion, numero de sequencia y tipo de personaje se escoge la imagen.
        ImageIcon retorno = null;
        String path = null;
        if(type.equals("Principal")){
            switch(action){
                case "Walking_Right":
                    path = ".\\src\\funcionesJuego\\Principal\\Derecha\\Walking\\Satyr_01_Walking_";
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
        }else{
            switch(action){
                case "Walking_Right":
                    path = ".\\src\\funcionesJuego\\Enemy\\Derecha\\Walking\\Minotaur_03_Walking_";
                    retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
                case "Walking_Left": 
                    path = ".\\src\\funcionesJuego\\Enemy\\Izquierda\\Walking\\Minotaur_03_Walking_";
                    retorno =  new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
                case "Jumping_Right":
                    path = ".\\src\\funcionesJuego\\Enemy\\Derecha\\Jump_Loop\\Minotaur_03_Jump_Loop_";
                    retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
                case "Jumping_Left":
                    path = ".\\src\\funcionesJuego\\Enemy\\Izquierda\\Jump_Loop\\Minotaur_03_Jump_Loop_";
                    retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
                case "Attacking_Left":
                    path = ".\\src\\funcionesJuego\\Enemy\\Izquierda\\Attacking\\Minotaur_03_Attacking_";
                    retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
                case "Attacking_Right":
                    path = ".\\src\\funcionesJuego\\Enemy\\Derecha\\Attacking\\Minotaur_03_Attacking_";
                    retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
                case "Idle_Right":
                    path = ".\\src\\funcionesJuego\\Enemy\\Derecha\\Idle\\Minotaur_03_Idle_";
                    retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
                case "Idle_Left":
                    path = ".\\src\\funcionesJuego\\Enemy\\Izquierda\\Idle\\Minotaur_03_Idle_";
                    retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
                default: 
                    path = ".\\src\\funcionesJuego\\Enemy\\Derecha\\Walking\\Minotaur_03_Walking_";
                    retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                    break;
            } 
        }
    
        return retorno;
    }
}
