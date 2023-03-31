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
    private int walk;
    private int attack;
    private int idle;
    
    public jFrmVentana() {
        
        initComponents();
        actualMap = "Mapa4";
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
        jLblBoss = new javax.swing.JLabel();
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
        getContentPane().add(jLblBoss);
        jLblBoss.setBounds(270, 160, 0, 0);

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
            enemyThread = new EnemyThread(enemy,principal,0,walk,attack,idle);
            enemyThread.start();
        }
        if(enemy2.getisAction().compareTo("Idle")==0&&enemy2.getLife()>0){
            enemyThread2 = new EnemyThread(enemy2,principal,0,walk,attack,idle);
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
        if(enemy2.getType().compareTo("Boss1")==0 || enemy2.getType().compareTo("Boss2")==0){
            jPrbEnemy2.setSize(500, 20);
            jPrbEnemy2.setLocation(450,100);
        }else{
            jPrbEnemy2.setSize(150, 20);
            jPrbEnemy2.setLocation(enemy2.getPositionX()+40,enemy2.getPositionY()-20);
        }
        if(principal.getisAction().compareTo("Dying")==0){
            useMap(actualMap);
            JOptionPane.showMessageDialog(null, "YOU DIE");
        }    
    }
    private void loadMaps(){
        ImageIcon fondo = new ImageIcon(".\\src\\Fondos\\Fondo0.png");
        mapa.insertMapa("Mapa0", 800, 350, -500, 146, -500, 146, 0, -500, "", fondo);
        fondo = new ImageIcon(".\\src\\Fondos\\Fondo1.png");
        mapa.insertMapa("Mapa1", 24, 154, 500, 146, 1000, 146, -0, -500, "", fondo);
        mapa.insertMapa("Mapa2", 24, 154, -500, -50, -500, -50, 136, 1000, "Boss1", fondo);
        fondo = new ImageIcon(".\\src\\Fondos\\Fondo2.png");
        mapa.insertMapa("Mapa3", 24, 310, 500, 310, 1000, 310, -0, -500, "", fondo);
        mapa.insertMapa("Mapa4", 24, 310, -500, -50, -500, -50, 310, 1000, "Boss2", fondo);
        fondo = new ImageIcon(".\\src\\Fondos\\Fondo3.png");
        mapa.insertMapa("Mapa5", 24, 360, 500, 360, 1000, 360, -0, -500, "", fondo);
        mapa.insertMapa("Mapa6", 24, 360, -500, -50, -500, -50, 360, 1000, "Boss3", fondo);
    }
    private void useMap(String typeMap){ 
        principal = new GameCharacter(mapa.getXPrincipal(typeMap), mapa.getYPrincipal(typeMap), 180,120,"Principal");
        jLblMainCharacter.setBounds(principal.getPositionX(),principal.getPositionY(),principal.getWidth(),principal.getHeight());
        jLblMainCharacter.setIcon(principal.getIcon());
        principal.setisAction("Idle");
        principalThread = new PrincipalThread(principal,enemy,enemy2,5,17,11,11,'~');
        principalThread.start();
        
        enemy = new GameCharacter(mapa.getXEnemy1(typeMap), mapa.getYEnemy1(typeMap), 180,120,"Enemy");
        jLblEnemy.setBounds(enemy.getPositionX(),enemy.getPositionY(),enemy.getWidth(),enemy.getHeight());
        jLblEnemy.setIcon(enemy.getIcon());
        enemy.setisAction("Idlee");
        enemyThread = new EnemyThread(enemy,principal,0,23,11,17);
        enemyThread.start();
        switch(typeMap){
            case "Mapa0":
            case "Mapa1":
            case "Mapa3":
            case "Mapa5":
                enemy2 = new GameCharacter(mapa.getXEnemy2(typeMap), mapa.getYEnemy2(typeMap), 180,120,"Enemy");
                jLblEnemy2.setBounds(enemy2.getPositionX(),enemy2.getPositionY(),enemy2.getWidth(),enemy2.getHeight());
                jLblEnemy2.setIcon(enemy2.getIcon());
                enemy2.setisAction("Idlee");
            break;
            case "Mapa2":
            case "Mapa4":
            case "Mapa6":
                enemy2 = new GameCharacter(mapa.getXBoss(typeMap), mapa.getYBoss(typeMap), 180,120,mapa.getBossType(typeMap));
                jLblEnemy2.setBounds(enemy2.getPositionX(),enemy2.getPositionY(),enemy2.getWidth(),enemy2.getHeight());
                jLblEnemy2.setIcon(enemy2.getIcon());
                enemy2.setisAction("Idlee");;
            break;
        }
        switch(enemy2.getType()){
            case "Enemy":
                walk = 23;
                attack = 11;
                idle = 17;
             break;
            case "Boss1":
                walk = 11;
                attack = 11;
                idle = 11;
            break;
            case "Boss2":
                walk = 23;
                attack = 11;
                idle = 17;
        }        
        enemyThread2 = new EnemyThread(enemy2,principal,0,walk,attack,idle);
        enemyThread2.start();
        jLblFondo.setLocation(0, 0);
        jLblFondo.setSize(1500, 500);
        ImageIcon fondo = mapa.getFondo(typeMap);
        jLblFondo.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(1500, 500, Image.SCALE_SMOOTH)));
        actualMap = typeMap;
    }
        
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblBoss;
    private javax.swing.JLabel jLblEnemy;
    private javax.swing.JLabel jLblEnemy2;
    private javax.swing.JLabel jLblFondo;
    private javax.swing.JLabel jLblMainCharacter;
    private javax.swing.JProgressBar jPrbEnemy;
    private javax.swing.JProgressBar jPrbEnemy2;
    private javax.swing.JProgressBar jPrbLife;
    // End of variables declaration//GEN-END:variables
}
