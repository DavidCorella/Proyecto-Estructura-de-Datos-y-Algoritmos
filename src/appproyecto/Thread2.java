
package appproyecto;

import personajes.MainCharacter;


public class Thread2 extends Thread {
    
    private MainCharacter principal;
    private MainCharacter enemy;
    
    public Thread2(MainCharacter principal, MainCharacter enemy){
        this.principal = principal;
        this.enemy = enemy;
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
        switch(enemy.getisAction()){
            case "isAttacking":
                enemy.attacking();
                enemy.setisAction("Idle");
                enemy.idle();
                break;
            case "isJumping":
                enemy.jumping();
                enemy.setisAction("Idle");
                enemy.idle();
                break;
            default: enemy.idle();
        }
    }
}
