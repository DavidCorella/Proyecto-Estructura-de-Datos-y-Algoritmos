/*Esta es la interfaz grafica del juego*/

package appproyecto;
import personajes.GameCharacter;
import funcionesJuego.ImageFunctions;
import javax.swing.SwingUtilities;

public class jFrmVentana extends javax.swing.JFrame {

    private GameCharacter principal;
    private GameCharacter enemy;
    private ImageFunctions image;
    private PrincipalThread principalThread;
    private EnemyThread enemyThread;
    
    public jFrmVentana() {
        
        initComponents();
        image = new ImageFunctions();
        //Se instancia y se configura el inicio del personaje principal.
        jLblMainCharacter.setBounds(24,364,180,120);
        principal = new GameCharacter(jLblMainCharacter.getX(), jLblMainCharacter.getY(), jLblMainCharacter.getWidth(),jLblMainCharacter.getHeight(),"Principal");
        jLblMainCharacter.setIcon(principal.getIcon());
        principal.setisAction("Idle");
        
        /*Se instancia y se configura el inicio del enemigo.*/
        jLblEnemy.setBounds(600,346,180,120);
        enemy = new GameCharacter(jLblEnemy.getX(), jLblEnemy.getY(), jLblEnemy.getWidth(),jLblEnemy.getHeight(),"Enemy");
        jLblEnemy.setIcon(enemy.getIcon());
        enemy.setisAction("Idle");
        
        //Se inian los hilos de ambos personajes.
        principalThread = new PrincipalThread(principal,enemy);
        principalThread.start();
        enemyThread = new EnemyThread(enemy,principal);
        enemyThread.start(); 
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblMainCharacter = new javax.swing.JLabel();
        jLblEnemy = new javax.swing.JLabel();
        jPrbLife = new javax.swing.JProgressBar();
        jPrbEnemy = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(jLblMainCharacter);
        jLblMainCharacter.setBounds(24, 364, 0, 0);

        jLblEnemy.setName("jLblEnemy"); // NOI18N
        getContentPane().add(jLblEnemy);
        jLblEnemy.setBounds(0, 0, 0, 0);

        jPrbLife.setForeground(new java.awt.Color(153, 255, 153));
        jPrbLife.setValue(100);
        getContentPane().add(jPrbLife);
        jPrbLife.setBounds(20, 10, 150, 20);

        jPrbEnemy.setForeground(new java.awt.Color(255, 102, 102));
        jPrbEnemy.setValue(100);
        getContentPane().add(jPrbEnemy);
        jPrbEnemy.setBounds(20, 80, 90, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        char key = evt.getKeyChar();                                
        if(key == 'D' || key == 'd' ){
           principal.setisAction("Walking");
           principal.moveRigth();
        }
        if(key == 'A' || key == 'a' ){
            principal.setisAction("Walking");                   //Segun la tecla presionada se ejecuta la accion o el hilo configurado
            principal.moveLeft();
        }
        if(key == 'W' || key == 'w' ){
            principal.setisAction("isJumping");
            principalThread = new PrincipalThread(principal,enemy);
            principalThread.start();
        }
        
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        char key = evt.getKeyChar();
        if(key == 'A' || key == 'a' ){
            principal.setisAction("Idle");
            principalThread = new PrincipalThread(principal,enemy);
            principalThread.start();
            enemyThread = new EnemyThread(enemy,principal);
            enemyThread.start(); 
        }
        if(key == 'D' || key == 'd' ){
            principal.setisAction("Idle");                      //Segun la tecla que se suelte, se ejecuta el hilo configurado
            principalThread = new PrincipalThread(principal, enemy);
            principalThread.start();
            enemyThread = new EnemyThread(enemy,principal);
            enemyThread.start();
        }
        if(key == 'F' || key == 'f' ){
            principal.setisAction("isAttacking");
            principalThread = new PrincipalThread(principal,enemy);
            principalThread.start();
        }
        
    }//GEN-LAST:event_formKeyReleased

    public void setjLblMain_Character(){
        jLblMainCharacter.setIcon(principal.getIcon());
        jLblMainCharacter.setLocation(principal.getPositionX(), principal.getPositionY());     // Actualizacion del label del principal
        SwingUtilities.updateComponentTreeUI(this);
    }
    public void setjLblEnemy(){
        jLblEnemy.setIcon(enemy.getIcon());
        jLblEnemy.setLocation(enemy.getPositionX(), enemy.getPositionY());                     //Actualizacion del label del enemigo.
        SwingUtilities.updateComponentTreeUI(this);
    }
    public void setLifeBar(){
        jPrbEnemy.setValue(enemy.getLife());
        jPrbLife.setValue(principal.getLife());                                                  //Actualizacion de las barras de vida.
        jPrbEnemy.setLocation(enemy.getPositionX()+40,enemy.getPositionY()-20);
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblEnemy;
    private javax.swing.JLabel jLblMainCharacter;
    private javax.swing.JProgressBar jPrbEnemy;
    private javax.swing.JProgressBar jPrbLife;
    // End of variables declaration//GEN-END:variables
}
