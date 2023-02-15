
package appproyecto;
import personajes.MainCharacter;
import funcionesJuego.ImageFunctions;
import static java.awt.ComponentOrientation.RIGHT_TO_LEFT;

public class jFrmVentana extends javax.swing.JFrame {

    private MainCharacter principal;
    private ImageFunctions imags;
    
    public jFrmVentana() {
        imags = new ImageFunctions();
        initComponents();
        jLblMainCharacter.setBounds(24,364,180,120);
        principal = new MainCharacter(jLblMainCharacter.getX(), jLblMainCharacter.getY(), jLblMainCharacter.getWidth(),jLblMainCharacter.getHeight());
        jLblMainCharacter.setIcon(principal.getIcon());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblMainCharacter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(jLblMainCharacter);
        jLblMainCharacter.setBounds(24, 364, 0, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        char key = evt.getKeyChar();
        if(key == 'D' || key == 'd' ){
           principal.moveRigth();
           jLblMainCharacter.setLocation(principal.getPositionX(), principal.getPositionY());
           jLblMainCharacter.setIcon(principal.getIcon());
        }
    }//GEN-LAST:event_formKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblMainCharacter;
    // End of variables declaration//GEN-END:variables
}
