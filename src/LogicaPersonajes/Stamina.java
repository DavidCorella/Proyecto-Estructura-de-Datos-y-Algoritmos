//Hilo que se usa para sumar Stamina cada 0.5s.

package LogicaPersonajes;

public class Stamina extends Thread {

    private GameCharacter principal;
    private boolean estado;

    public Stamina(GameCharacter principal) {
        this.principal = principal;
        estado = true;
    }

    public void run() {
        while (estado) {                                      // Se usa una variable de control, ya que los personajes cambian de direccion de memoria segun el mapa.
            if (principal.getStamina() < 100) {
                if (5 + principal.getStamina() > 100) {       //Si la Stamina es menor de 100 se suma 5.
                    principal.setStamina0(100);
                } else {
                    principal.setStamina(5);
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
        }
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
