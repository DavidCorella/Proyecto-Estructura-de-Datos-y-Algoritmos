
package appproyecto;


public class AppProyecto {

   
    public static void main(String[] args) {
        jFrmVentana ventana = new jFrmVentana();
        ventana.setVisible(true);
        ventana.setSize(1000, 500);
        ventana.setLocationRelativeTo(null);
        Thread1 thread1 = new Thread1(ventana);
        thread1.run();
        
    }
    
}
