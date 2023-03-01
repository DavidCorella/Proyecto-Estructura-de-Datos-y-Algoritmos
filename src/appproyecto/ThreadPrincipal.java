
package appproyecto;

import personajes.MainCharacter;


public class ThreadPrincipal extends Thread {
    
    private MainCharacter principal;
    
    public ThreadPrincipal(MainCharacter principal){
        this.principal = principal;
    }
    
    public void run(){
        executeAction();       
    }
    
    public void executeAction(){
        switch(principal.getisAction()){
            case "isAttacking":
                principal.attacking();
                principal.setisAction("Idle");
                principal.idle();
                break;
            case "isJumping":
                principal.jumping();
                principal.setisAction("Idle");
                principal.idle();
                break;
            default: principal.idle();
        }
    }
}
