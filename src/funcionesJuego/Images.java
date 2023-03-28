/* Esta clase se encarga de traer la imagenes desde la carpeta hasta el programa*/
package funcionesJuego;

import javax.swing.ImageIcon;

public class Images {

    public ImageIcon getMain_Character_Walking(int i, String action, String type) { // Segun accion, numero de sequencia y tipo de personaje se escoge la imagen.
        ImageIcon retorno = null;
        String path = null;
        switch (action) {
            case "Walking_Right":
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Derecha\\Walking\\Walking_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
            case "Walking_Left":
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Izquierda\\Walking\\Walking_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
            case "Jump_Loop_Right":
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Derecha\\Jump_Loop\\Jump_Loop_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
            case "Jump_Loop_Left":
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Izquierda\\Jump_Loop\\Jump_Loop_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
            case "Jump_Start_Right":
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Derecha\\Jump_Start\\Jump_Start_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
            case "Jump_Start_Left":
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Izquierda\\Jump_Start\\Jump_Start_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
            case "Attacking_Right":
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Derecha\\Attacking\\Attacking_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
            case "Attacking_Left":
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Izquierda\\Attacking\\Attacking_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
            case "Attacking2_Right":
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Derecha\\Attacking2\\Attacking2_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
            case "Attacking2_Left":
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Izquierda\\Attacking2\\Attacking2_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
            case "Idle_Right":
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Derecha\\Idle\\Idle_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
            case "Idle_Left":
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Izquierda\\Idle\\Idle_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
            case "Hurt_Right":
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Derecha\\Hurt\\Hurt_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
            case "Hurt_Left":
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Izquierda\\Hurt\\Hurt_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
            case "Dying_Right":
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Derecha\\Dying\\Dying_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
            case "Dying_Left":
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Izquierda\\Dying\\Dying_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
            default:
                path = ".\\src\\funcionesJuego\\".concat(type.concat("\\Derecha\\Walking\\Walking_"));
                retorno = new ImageIcon(path.concat(String.valueOf(i).concat(".png")));
                break;
        }

        return retorno;
    }
}
