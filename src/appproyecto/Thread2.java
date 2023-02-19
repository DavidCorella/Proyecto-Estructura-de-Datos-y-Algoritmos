
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
        if(principal.getisAction().equals("isAttacking")){
            principal.attacking();
        }else if (principal.getisAction().equals("isJumping")){
            principal.jumping();
        }
    }
}
