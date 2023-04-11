/*
    Este Hilo es exclusivo para los movimientos o la logica del Enemigo
    Se usa como base el objeto del personaje principal, nada mas que se controla automaticamente.
 */
package LogicaPersonajes;

import java.awt.Rectangle;

public class EnemyThread extends Thread {

    private GameCharacter enemy;
    private GameCharacter principal;
    private int sequenceJump;
    private int sequenceWalk;
    private int sequenceAttack;
    private int sequenceIdle;

    public EnemyThread(GameCharacter enemy, GameCharacter principal, int sequenceJump, int sequenceWalk, int sequenceAttack, int sequenceIdle) {
        this.enemy = enemy;
        this.principal = principal;                 // Se las mismas direcciones de memoria de los objetos de personajes
        this.sequenceAttack = sequenceAttack;
        this.sequenceIdle = sequenceIdle;
        this.sequenceWalk = sequenceWalk;
        this.sequenceJump = sequenceJump;
    }

    public void run() {
        executeAction(sequenceJump, sequenceWalk, sequenceAttack, sequenceIdle);
    }

    public void executeAction(int sequenceJump, int sequenceWalk, int sequnceAttack, int sequenceIdle) {
        if (enemy.getLife() > 0) {
            while (principal.getPositionX() - 250 < enemy.getPositionX() && principal.getPositionX() - 30 > enemy.getPositionX() && enemy.getLife() > 0) {
                enemy.setisAction("Walking");                       //Si el personaje se encuentra a 250px el enemigo camina para llegar
                enemy.moveRigth(sequenceWalk);                   //O a el hasta que se acerque 30px antes o despues
                try {
                    Thread.sleep(30);         //cada 30ms se mueve un paso hasta que llegue o se aleje lo configurado
                } catch (InterruptedException ex) {
                }
            }
            while (principal.getPositionX() + 250 > enemy.getPositionX() && principal.getPositionX() + 30 < enemy.getPositionX() && enemy.getLife() > 0) {
                enemy.setisAction("Walking");                       //Se setea la accion para saber que hace en cada momento
                enemy.moveLeft(sequenceWalk);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException ex) {
                }
            }
            while ((principal.getPositionX() + 31 > enemy.getPositionX() && principal.getPositionX() - 31 < enemy.getPositionX()) && 0 != (enemy.getisAction().compareTo("Attaking")) && enemy.getLife() > 0) {
                enemy.setisAction("Attacking");
                try {                                                       //Mientras el personaje se encuentre en un rango de 30, El enemigo ataca.
                    Thread.sleep(200);
                    if (enemy.getType().compareTo("Boss2") == 0 || enemy.getType().compareTo("Boss3") == 0) {
                        if (enemy.getLife() < 50) {
                            enemy.attacking(sequnceAttack, "Attacking2");
                        } else {
                            enemy.attacking(sequnceAttack, "Attacking");
                        }
                    } else {
                        enemy.attacking(sequnceAttack);
                    }
                    if (new Rectangle(enemy.getPositionX(), enemy.getPositionY(), enemy.getWidth() - 10, enemy.getHeight() - 10).intersects(principal.getPositionX(), principal.getPositionY(), principal.getWidth() - 10, principal.getHeight() - 10)) {

                        principal.setLife(-10);                         //Si colicionan baja 10 de vida al principal.
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
                enemy.setisAction("Idle");                          //Al final o si no se cumple nada, el enemigo queda espeando
                enemy.idle(sequenceIdle);                        // en idle.
            }
        }
    }

}
