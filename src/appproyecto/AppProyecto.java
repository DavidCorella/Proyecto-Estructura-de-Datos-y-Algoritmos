package appproyecto;

public class AppProyecto {

    public static void main(String[] args) {
        jFrmVentana ventana = new jFrmVentana();
        ventana.setVisible(true);
        ventana.setSize(1500, 500);
        ventana.setLocationRelativeTo(null);
        FrameUpdate update = new FrameUpdate(ventana);     // Se ejecuta y se inicia un hilo, que se encarga de actualizar visualmente el frame, sin importar si esta siendo usado, 
        update.start();                                    // por eso se usa el mismo objeto frame  
    }
}
