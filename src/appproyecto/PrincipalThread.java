/*  Este es el hilo del persoaje principal
    Donde se ejecutan las acciones de atacar y/o saltar
 */
package appproyecto;

import java.awt.Rectangle;
import LogicaPersonajes.GameCharacter;

public class PrincipalThread extends Thread {

    private GameCharacter principal;
    private GameCharacter enemy;
    private int sequenceJump;
    private int sequenceWalk;
    private int sequenceAttack;
    private int sequenceIdle;
    private char key;
    private GameCharacter enemy2;

    public PrincipalThread(GameCharacter principal, GameCharacter enemy, GameCharacter enemy2, int sequenceJump, int sequenceWalk, int sequenceAttack, int sequenceIdle, char key) {  // Se piden los mismos objetos de personaje y enemigo que ha usado el mismo programa.
        this.principal = principal;
        this.enemy = enemy;
        this.enemy = enemy;
        this.principal = principal;
        this.sequenceAttack = sequenceAttack;
        this.sequenceIdle = sequenceIdle;
        this.sequenceWalk = sequenceWalk;
        this.sequenceJump = sequenceJump;
        this.key = key;
        this.enemy2 = enemy2;
    }

    public void run() {
        executeAction();
    }

    public void executeAction() {
        if (principal.getLife() > 0) {
            switch (key) {
                case 'A':
                case 'a':
                    if (principal.getPositionX() > -30) {
                        principal.setisAction("Walking");
                        principal.moveLeft(17);
                    }
                    break;
                case 'd':
                case 'D':
                    principal.setisAction("Walking");
                    principal.moveRigth(17);
                    break;
                case 'F':
                case 'f':
                    principal.setisAction("Attacking");
                    principal.attacking(sequenceAttack);
                    if (new Rectangle(enemy.getPositionX(), enemy.getPositionY(), enemy.getWidth() - 90, enemy.getHeight() - 90).intersects( // Si los 2 objetos o el area de los objetos se interseca
                            principal.getPositionX(), principal.getPositionY(), principal.getWidth() - 90, principal.getHeight() - 90)) {
                        enemy.setLife(-20);
                    }
                    if (new Rectangle(enemy2.getPositionX(), enemy2.getPositionY(), enemy2.getWidth() - 90, enemy2.getHeight() - 90).intersects( // Si los 2 objetos o el area de los objetos se interseca
                            principal.getPositionX(), principal.getPositionY(), principal.getWidth() - 90, principal.getHeight() - 90)) {
                        enemy2.setLife(-20);
                    }
                    if (enemy.getLife() <= 0 && enemy.getPositionX()!=-500) {
                        enemy.setisAction("Dying");
                        enemy.dying(14);
                        enemy.setPositionX(-500);
                    }
                    if (enemy2.getLife() <= 0 && enemy2.getPositionX()!=-500) {
                        enemy2.setisAction("Dying");
                        enemy2.dying(14);
                        enemy2.setPositionX(-500);
                    }
                    principal.setisAction("Idle");
                    principal.idle(sequenceIdle);
                    break;

                case 'W':
                case 'w':
                    principal.setisAction("isJumping");
                    principal.jumping(sequenceJump);
                    principal.setisAction("Idle");
                    principal.idle(sequenceIdle);
                    break;
                case '~':
                    principal.setisAction("Idle");
                    principal.idle(11);
                    break;
            }

        }
    }

}
