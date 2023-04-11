package appproyecto;

import LogicaPersonajes.GameCharacter;

public class Stamina extends Thread {

    private GameCharacter principal;
    private boolean estado;

    public Stamina(GameCharacter principal) {
        this.principal = principal;
        estado = true;
    }

    public void run() {
        sumar();
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void sumar() {
        while (estado) {
            if (principal.getStamina() < 100) {
                if(5+principal.getStamina()>100){
                    principal.setStamina0(100);
                }else{
                    principal.setStamina(5);
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
        }
    }
}
