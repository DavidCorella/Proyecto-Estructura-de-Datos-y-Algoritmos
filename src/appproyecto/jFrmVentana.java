
package appproyecto;
import personajes.MainCharacter;
import funcionesJuego.ImageFunctions;
import javax.swing.SwingUtilities;

public class jFrmVentana extends javax.swing.JFrame {

    private MainCharacter principal;
    private MainCharacter enemy;
    private ImageFunctions images;
    private ThreadPrincipal threadPrincipal;
    private ThreadEnemy threadEnemy;
    
    public jFrmVentana() {
        initComponents();
        images = new ImageFunctions();
        jLblMainCharacter.setBounds(24,364,180,120);
        principal = new MainCharacter(jLblMainCharacter.getX(), jLblMainCharacter.getY(), jLblMainCharacter.getWidth(),jLblMainCharacter.getHeight(),"Principal");
        jLblMainCharacter.setIcon(principal.getIcon());
        principal.setisAction("Idle");
        jLblEnemy.setBounds(400,346,180,120);
        enemy = new MainCharacter(jLblEnemy.getX(), jLblEnemy.getY(), jLblEnemy.getWidth(),jLblEnemy.getHeight(),"Enemy");
        jLblEnemy.setIcon(enemy.getIcon());
        enemy.setisAction("Idle");
        threadPrincipal = new ThreadPrincipal(principal);
        threadPrincipal.start();
        threadEnemy = new ThreadEnemy(enemy,principal);
        threadEnemy.start();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblMainCharacter = new javax.swing.JLabel();
        jLblEnemy = new javax.swing.JLabel();

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
        jLblEnemy.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        char key = evt.getKeyChar(); 
        if(key == 'D' || key == 'd' ){
            principal.setisAction("Walking");
           principal.moveRigth();
        }
        if(key == 'A' || key == 'a' ){
            principal.setisAction("Walking");
            principal.moveLeft();
        }
        if(key == 'F' || key == 'f' ){
            principal.setisAction("isAttacking");
            threadPrincipal = new ThreadPrincipal(principal);
            threadPrincipal.start();
        }
        if(key == 'W' || key == 'w' ){
            principal.setisAction("isJumping");
            threadPrincipal = new ThreadPrincipal(principal);
            threadPrincipal.start();
        }
        
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        char key = evt.getKeyChar();
        if(key == 'A' || key == 'a' ){
            principal.setisAction("Idle");
            threadPrincipal = new ThreadPrincipal(principal);
            threadPrincipal.start();       
        }
        if(key == 'D' || key == 'd' ){
            principal.setisAction("Idle");
            threadPrincipal = new ThreadPrincipal(principal);
            threadPrincipal.start();  
        }
        
        
    }//GEN-LAST:event_formKeyReleased

    public void setjLblMain_Character(){
            jLblMainCharacter.setIcon(principal.getIcon());
            jLblMainCharacter.setLocation(principal.getPositionX(), principal.getPositionY());     
            SwingUtilities.updateComponentTreeUI(this);
    }
    public void setjLblEnemy(){
            jLblEnemy.setIcon(enemy.getIcon());
            jLblEnemy.setLocation(enemy.getPositionX(), enemy.getPositionY());     
            SwingUtilities.updateComponentTreeUI(this);
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblEnemy;
    private javax.swing.JLabel jLblMainCharacter;
    // End of variables declaration//GEN-END:variables
}
