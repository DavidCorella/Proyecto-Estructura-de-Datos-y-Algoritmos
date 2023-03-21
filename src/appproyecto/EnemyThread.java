/*
    Este Hilo es exclusivo para los movimientos o la logica del Enemigo
    Se usa como base el objeto del personaje principal, nada mas que se controla automaticamente.
*/

package appproyecto;
import java.awt.Rectangle;
import personajes.GameCharacter;

public class EnemyThread extends Thread{
    
    private GameCharacter enemy;
    private GameCharacter principal;
    
    public EnemyThread(GameCharacter enemy, GameCharacter principal){       // Se usan los 2 objetos que se han usado en todo el programa
        this.enemy = enemy;
        this.principal = principal;
    }
    
 
    public void run(){
        executeAction();       
    }
    
    public void executeAction(){
        
       
            while(principal.getPositionX()-250<enemy.getPositionX()&principal.getPositionX()-30>enemy.getPositionX()){    //Si el personaje se encuentra a 250px el enemigo camina para llegar
                enemy.setisAction("Walking");                                                                     //a el hasta que se acerque 30px antes
                enemy.moveRigth();
                try {
                    Thread.sleep(30);         //cada 30ms se mueve un paso hasta que llegue o se aleje lo configurado
                } catch (InterruptedException ex) {
                }
            }
            while(principal.getPositionX()+250>enemy.getPositionX()&&principal.getPositionX()+30<enemy.getPositionX()){
                enemy.setisAction("Walking");   //Se setea la accion para saber que hace en cada momento
                enemy.moveLeft();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException ex) {
                }
            }  
            while(principal.getPositionX()+30>enemy.getPositionX()&&principal.getPositionX()-30<enemy.getPositionX()&&0!=(enemy.getisAction().compareTo("Attaking"))){ //Mientras el personaje se encuentre en un rango de 30, El enemigo
                enemy.setisAction("Attacking");                                                                //Ataca
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                }
                enemy.attacking();
                if(new Rectangle(enemy.getPositionX(),enemy.getPositionY(),enemy.getWidth()-10,enemy.getHeight()-10).intersects //Si colicionan baja 10 de vida al principal.
                    (principal.getPositionX(),principal.getPositionY(),principal.getWidth()-10,principal.getHeight()-10)){
                    
                    principal.setLife(-10);
                }
            }
            if(0!=(enemy.getisAction().compareTo("Idle"))){
                enemy.setisAction("Idle");          //Al final o si no se cumple nada el enemigo queda espeando.
                enemy.idle();
            }
    }
    
}
    