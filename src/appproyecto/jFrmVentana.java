
package appproyecto;
import personajes.MainCharacter;
import funcionesJuego.ImageFunctions;

public class jFrmVentana extends javax.swing.JFrame {

    private MainCharacter principal;
    private ImageFunctions imags;
    
    public jFrmVentana() {
        imags = new ImageFunctions();
        initComponents();
        jLblMainCharacter.setLocation(24, 364);
        principal = new MainCharacter(jLblMainCharacter.getX(), jLblMainCharacter.getY(), 180,120);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLblMainCharacter)
                .addContainerGap(790, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(250, Short.MAX_VALUE)
                .addComponent(jLblMainCharacter)
                .addGap(191, 191, 191))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        char key = evt.getKeyChar();
        if(key == 'W' || key == 'w' ){
           principal.moveRigth();
           jLblMainCharacter.setLocation(principal.getPositionX(), principal.getPositionY());
           jLblMainCharacter.setIcon(principal.getIcon());
        }
    }//GEN-LAST:event_formKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblMainCharacter;
    // End of variables declaration//GEN-END:variables
}
