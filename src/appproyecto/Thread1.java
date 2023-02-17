
package appproyecto;

public class Thread1 extends Thread {
    
    private jFrmVentana ventana;
    
    public void run(){
        while(true){          
            ventana.setjLblMain_Character();
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    public Thread1(jFrmVentana ventana){
        this.ventana = ventana;
    }
    
}
