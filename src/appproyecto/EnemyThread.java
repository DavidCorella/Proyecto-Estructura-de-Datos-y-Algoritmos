/*
    Este Hilo es exclusivo para los movimientos o la logica del Enemigo
    Se usa como base el objeto del personaje principal, nada mas que se controla automaticamente.
 */
package appproyecto;

import java.awt.Rectangle;
import LogicaPersonajes.GameCharacter;

public class EnemyThread extends Thread {

    private GameCharacter enemy;
    private GameCharacter principal;
    private int sequenceJump;
    private int sequenceWalk;
    private int sequenceAttack;
    private int sequenceIdle;

    public EnemyThread(GameCharacter enemy, GameCharacter principal, int sequenceJump, int sequenceWalk, int sequenceAttack, int sequenceIdle) {       // Se usan los 2 objetos que se han usado en todo el programa
        this.enemy = enemy;
        this.principal = principal;
        this.sequenceAttack = sequenceAttack;
        this.sequenceIdle = sequenceIdle;
        this.sequenceWalk = sequenceWalk;
        this.sequenceJump = sequenceJump;
    }

    public void run() {
        executeAction(sequenceJump, sequenceWalk, sequenceAttack, sequenceIdle);
    }

    public void executeAction(int sequenceJump, int sequenceWalk, int sequnceAttack, int sequenceIdle) {
        if (enemy.getisAction().compareTo("Dying") != 0) {
            if (enemy.getisAction().compareTo("Dying") != 0) {
                while (principal.getPositionX() - 250 < enemy.getPositionX() && principal.getPositionX() - 30 > enemy.getPositionX() && enemy.getLife() > 0) {    //Si el personaje se encuentra a 250px el enemigo camina para llegar
                    enemy.setisAction("Walking");                                                                     //a el hasta que se acerque 30px antes
                    enemy.moveRigth(sequenceWalk);
                    try {
                        Thread.sleep(30);         //cada 30ms se mueve un paso hasta que llegue o se aleje lo configurado
                    } catch (InterruptedException ex) {
                    }
                }
                while (principal.getPositionX() + 250 > enemy.getPositionX() && principal.getPositionX() + 30 < enemy.getPositionX() && enemy.getLife() > 0) {
                    enemy.setisAction("Walking");   //Se setea la accion para saber que hace en cada momento
                    enemy.moveLeft(sequenceWalk);
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException ex) {
                    }
                }
                while ((principal.getPositionX() + 31 > enemy.getPositionX() && principal.getPositionX() - 31 < enemy.getPositionX()) && 0 != (enemy.getisAction().compareTo("Attaking")) && enemy.getLife() > 0) { //Mientras el personaje se encuentre en un rango de 30, El enemigo
                    enemy.setisAction("Attacking");                                                                //Ataca
                    try {
                        Thread.sleep(200);
                        if (enemy.getType().compareTo("Boss2") == 0) {
                            if (enemy.getLife() < 50) {
                                enemy.attacking(sequnceAttack, "Attacking2");
                            } else {
                                enemy.attacking(sequnceAttack, "Attacking");
                            }
                        } else {
                            enemy.attacking(sequnceAttack);
                        }
                        if (new Rectangle(enemy.getPositionX(), enemy.getPositionY(), enemy.getWidth() - 10, enemy.getHeight() - 10).intersects //Si colicionan baja 10 de vida al principal.
                                (principal.getPositionX(), principal.getPositionY(), principal.getWidth() - 10, principal.getHeight() - 10)) {

                            principal.setLife(-10);
                        }
                        if (principal.getLife() < 0) {
                            principal.setisAction("Die");
                            principal.dying(14);
                            Thread.sleep(200);
                            principal.setisAction("Dying");
                        }
                    } catch (InterruptedException ex) {
                    }
                }
                if (enemy.getisAction().compareTo("Idle") != 0 && enemy.getLife() > 0) {
                    enemy.setisAction("Idle");          //Al final o si no se cumple nada el enemigo queda espeando.
                    enemy.idle(sequenceIdle);
                }
            }
        }
    }
}
