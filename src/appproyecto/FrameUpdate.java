/* Este Hilo se mantiene activo simpre para actualizar el frame, ya que si la clase del frame esta ocupada ejecutando algo mas, este hilo lo hace*/
package appproyecto;

public class FrameUpdate extends Thread {

    private jFrmVentana ventana;

    public void run() {
        while (true) {
            ventana.setjLblMain_Character();
            ventana.setjLblEnemy();
            ventana.setjLblEnemy2();
            ventana.setLifeBar();
        }
    }

    public FrameUpdate(jFrmVentana ventana) {
        this.ventana = ventana;                     //Se usa la misma direccion de menoria del objeto del Frame
    }

}
