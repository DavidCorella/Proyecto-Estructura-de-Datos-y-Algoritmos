/*Esta es la interfaz grafica del juego*/

//Esto es un comentario

package appproyecto;
import LogicaPersonajes.GameCharacter;
import LogicaImagenes.ImageFunctions;
import Mapas.FuncionesMapa;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class jFrmVentana extends javax.swing.JFrame {

    private GameCharacter principal;
    private GameCharacter enemy;
    private GameCharacter enemy2;
    private ImageFunctions image;
    private PrincipalThread principalThread;
    private EnemyThread enemyThread;
    private EnemyThread enemyThread2;
    private FuncionesMapa mapa;
    private String actualMap;
    
    public jFrmVentana() {
        
        initComponents();
        actualMap = "Mapa1";
        mapa = new FuncionesMapa();
        loadMaps();
        useMap(actualMap);  
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblEnemy2 = new javax.swing.JLabel();
        jLblEnemy = new javax.swing.JLabel();
        jLblMainCharacter = new javax.swing.JLabel();
        jPrbLife = new javax.swing.JProgressBar();
        jPrbEnemy = new javax.swing.JProgressBar();
        jPrbEnemy2 = new javax.swing.JProgressBar();
        jLblFondo = new javax.swing.JLabel();

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
        getContentPane().add(jLblEnemy2);
        jLblEnemy2.setBounds(300, 170, 0, 0);

        jLblEnemy.setName("jLblEnemy"); // NOI18N
        getContentPane().add(jLblEnemy);
        jLblEnemy.setBounds(0, 0, 0, 0);
        getContentPane().add(jLblMainCharacter);
        jLblMainCharacter.setBounds(24, 364, 0, 0);

        jPrbLife.setForeground(new java.awt.Color(153, 255, 153));
        jPrbLife.setValue(100);
        getContentPane().add(jPrbLife);
        jPrbLife.setBounds(20, 10, 150, 20);

        jPrbEnemy.setForeground(new java.awt.Color(255, 102, 102));
        jPrbEnemy.setValue(100);
        getContentPane().add(jPrbEnemy);
        jPrbEnemy.setBounds(20, 110, 90, 20);

        jPrbEnemy2.setForeground(new java.awt.Color(255, 102, 102));
        jPrbEnemy2.setValue(100);
        getContentPane().add(jPrbEnemy2);
        jPrbEnemy2.setBounds(20, 80, 90, 20);
        getContentPane().add(jLblFondo);
        jLblFondo.setBounds(340, 50, 0, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        char key = evt.getKeyChar();
        boolean action = principal.getisAction().compareTo("Attacking")==0||principal.getisAction().compareTo("isJumping")==0;
        principalThread = new PrincipalThread(principal,enemy,enemy2,5,17,11,11, !action?key:' ');
        principalThread.start();
        
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        char key = evt.getKeyChar();
        boolean action = principal.getisAction().compareTo("Attacking")==0||principal.getisAction().compareTo("isJumping")==0;
        principalThread = new PrincipalThread(principal,enemy,enemy2,5,17,11,11, !action?'~':' ');
        principalThread.start();
        if(enemy.getisAction().compareTo("Idle")==0 && enemy.getLife()>0){
            enemyThread = new EnemyThread(enemy,principal,0,23,11,17);
            enemyThread.start();
        }
        if(enemy2.getisAction().compareTo("Idle")==0&&enemy2.getLife()>0){
            enemyThread2 = new EnemyThread(enemy2,principal,0,23,11,17);
            enemyThread2.start();
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
    public void setjLblEnemy2(){
        jLblEnemy2.setIcon(enemy2.getIcon());
        jLblEnemy2.setLocation(enemy2.getPositionX(), enemy2.getPositionY());                     //Actualizacion del label del enemigo.
        SwingUtilities.updateComponentTreeUI(this);
    }
    public void setLifeBar(){
        jPrbEnemy.setValue(enemy.getLife());
        jPrbEnemy2.setValue(enemy2.getLife());
        jPrbLife.setValue(principal.getLife());                                                  //Actualizacion de las barras de vida.
        jPrbEnemy.setLocation(enemy.getPositionX()+40,enemy.getPositionY()-20);
        jPrbEnemy2.setLocation(enemy2.getPositionX()+40,enemy2.getPositionY()-20);
        if(principal.getisAction().compareTo("Dying")==0){
            useMap(actualMap);
            JOptionPane.showMessageDialog(null, "YOU DIE");
        }    
    }
    private void loadMaps(){
        ImageIcon fondo = new ImageIcon(".\\src\\Fondos\\Fondo1.png");
        mapa.insertMapa("Mapa1", 24, 154, 500, 146, 1000, 146, -50, -50, "", fondo);
        mapa.insertMapa("Mapa2", 24, 154, -50, -50, -50, -50, 136, 1000, "Boss1", fondo);            
    }
    private void useMap(String typeMap){ 
        
        principal = new GameCharacter(mapa.getXPrincipal(typeMap), mapa.getYPrincipal(typeMap), 180,120,"Principal");
        jLblMainCharacter.setBounds(principal.getPositionX(),principal.getPositionY(),principal.getWidth(),principal.getHeight());
        jLblMainCharacter.setIcon(principal.getIcon());
        principal.setisAction("Idle");
        
        /*Se instancia y se configura el inicio del enemigo.*/
        enemy = new GameCharacter(mapa.getXEnemy1(typeMap), mapa.getYEnemy1(typeMap), 180,120,"Enemy");
        jLblEnemy.setBounds(enemy.getPositionX(),enemy.getPositionY(),enemy.getWidth(),enemy.getHeight());
        jLblEnemy.setIcon(enemy.getIcon());
        enemy.setisAction("Idlee");
        
        enemy2 = new GameCharacter(mapa.getXEnemy2(typeMap), mapa.getYEnemy2(typeMap), 180,120,"Enemy");
        jLblEnemy2.setBounds(enemy2.getPositionX(),enemy2.getPositionY(),enemy2.getWidth(),enemy2.getHeight());
        jLblEnemy2.setIcon(enemy2.getIcon());
        enemy2.setisAction("Idlee");
        
        //Se inian los hilos de ambos personajes.
        principalThread = new PrincipalThread(principal,enemy,enemy2,5,17,11,11,'~');
        principalThread.start();
        enemyThread = new EnemyThread(enemy,principal,0,23,11,17);
        enemyThread.start();
        enemyThread2 = new EnemyThread(enemy2,principal,0,23,11,17);
        enemyThread2.start();
        
        jLblFondo.setLocation(0, 0);
        jLblFondo.setSize(1500, 500);
        ImageIcon fondo = mapa.getFondo(typeMap);
        jLblFondo.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(1500, 500, Image.SCALE_SMOOTH)));
        
        actualMap = typeMap;
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblEnemy;
    private javax.swing.JLabel jLblEnemy2;
    private javax.swing.JLabel jLblFondo;
    private javax.swing.JLabel jLblMainCharacter;
    private javax.swing.JProgressBar jPrbEnemy;
    private javax.swing.JProgressBar jPrbEnemy2;
    private javax.swing.JProgressBar jPrbLife;
    // End of variables declaration//GEN-END:variables
}
