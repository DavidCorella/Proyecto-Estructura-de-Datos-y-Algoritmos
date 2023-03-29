/*  Este es el hilo del persoaje principal
    Donde se ejecutan las acciones de atacar y/o saltar
*/

package appproyecto;

import java.awt.Rectangle;
import personajes.GameCharacter;

public class PrincipalThread extends Thread {
    
    private GameCharacter principal;
    private GameCharacter enemy;
    private int sequenceJump;
    private int sequenceWalk;
    private int sequenceAttack;
    private int sequenceIdle;
    
    public PrincipalThread(GameCharacter principal,GameCharacter enemy, int sequenceJump, int sequenceWalk, int sequenceAttack, int sequenceIdle ){  // Se piden los mismos objetos de personaje y enemigo que ha usado el mismo programa.
        this.principal = principal;
        this.enemy = enemy;
        this.enemy = enemy;
        this.principal = principal;
        this.sequenceAttack = sequenceAttack;
        this.sequenceIdle = sequenceIdle;
        this.sequenceWalk = sequenceWalk;
        this.sequenceJump = sequenceJump;
    }
    
    public void run(){
        executeAction();       
    }
    
    public void executeAction(){
        switch(principal.getisAction()){
            case "isAttacking":
                principal.attacking(sequenceAttack);
                if(new Rectangle(enemy.getPositionX(),enemy.getPositionY(),enemy.getWidth()-10,enemy.getHeight()-10).intersects(    // Si los 2 objetos o el area de los objetos se interseca
                    principal.getPositionX(),principal.getPositionY(),principal.getWidth()-10,principal.getHeight()-10)){
                    
                    enemy.setLife(-20);
                }
                principal.setisAction("Idle");
                principal.idle(sequenceIdle);
                break;
                
            case "isJumping":
                principal.jumping(sequenceJump);
                principal.setisAction("Idle");
                principal.idle(sequenceIdle);
                break;
                
            default: principal.idle(sequenceIdle);
        }
    }
    
}
