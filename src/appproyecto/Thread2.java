
package appproyecto;

import personajes.MainCharacter;


public class Thread2 extends Thread {
    
    private MainCharacter principal;
    
    public Thread2(MainCharacter principal){
        this.principal = principal;
    }
    
 
    public void run(){
        executeAction();       
    }
    
    public void executeAction(){
        switch(principal.getisAction()){
            case "isAttacking":
                principal.attacking();
                break;
            case "isJumping":
                principal.jumping();
                break;
            default: principal.idle();
        }
    }
}
