
package appproyecto;

import personajes.MainCharacter;


public class Thread2 extends Thread {
    
    private MainCharacter principal;
    
    public Thread2(MainCharacter principal){
        this.principal = principal;
    }
    
    @Override
    public void run(){
        principal.Jumping();
    }
}
