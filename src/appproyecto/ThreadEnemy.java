
package appproyecto;
import personajes.MainCharacter;

public class ThreadEnemy extends Thread{
    
    private MainCharacter enemy;
    private MainCharacter principal;
    
    public ThreadEnemy(MainCharacter enemy, MainCharacter principal){
        this.enemy = enemy;
        this.principal = principal;
    }
    
 
    public void run(){
        executeAction();       
    }
    
    public void executeAction(){
        
        while(true){
            while(principal.getPositionX()>enemy.getPositionX()){
                enemy.moveRigth();
                try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
            }
            while(principal.getPositionX()<enemy.getPositionX()){
                try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
                enemy.moveLeft();
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
}
    