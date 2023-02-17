
package appproyecto;
import personajes.MainCharacter;
import funcionesJuego.ImageFunctions;

public class jFrmVentana extends javax.swing.JFrame {

    private MainCharacter principal;
    private ImageFunctions images;
    private MainCharacter principalCopy;
    private Thread2 thread2;
    
    public jFrmVentana() {
        initComponents();
        images = new ImageFunctions();
        jLblMainCharacter.setBounds(24,364,180,120);
        principal = new MainCharacter(jLblMainCharacter.getX(), jLblMainCharacter.getY(), jLblMainCharacter.getWidth(),jLblMainCharacter.getHeight());
        jLblMainCharacter.setIcon(principal.getIcon());
        principalCopy = new MainCharacter();
        clonarObject();
        thread2 = new Thread2(principal);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblMainCharacter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        char key = evt.getKeyChar();
        if(key == 'D' || key == 'd' ){
           principal.moveRigth();
        }
        if(key == 'A' || key == 'a' ){
           principal.moveLeft();
        }
        if(key == 'W' || key == 'w' ){
           thread2.start();
        }
    }//GEN-LAST:event_formKeyPressed

    public void setjLblMain_Character(){
        jLblMainCharacter.setLocation(principal.getPositionX(), principal.getPositionY());
        jLblMainCharacter.setIcon(principal.getIcon());
        if(!compareObject()){
            getContentPane().update(getContentPane().getGraphics());
            clonarObject();
        }
    }
    
    private void clonarObject(){
        principalCopy.setPositionX(principal.getPositionX());
        principalCopy.setPositionY(principal.getPositionY());
        principalCopy.setSequence(principal.getSequence());
        principalCopy.setIcon(principal.getIcon());
        principalCopy.setDirection(principal.getDirection());
    }
    
    private boolean compareObject(){
        if(
            principalCopy.getPositionX() == principal.getPositionX()&&
            principalCopy.getPositionY() == principal.getPositionY()&&
            principalCopy.getSequence() == principal.getSequence() &&
            Character.compare(principalCopy.getDirection(),principal.getDirection()) == 0
           ){
                return true;
            }
        else{
            return false;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblMainCharacter;
    // End of variables declaration//GEN-END:variables
}
