/*Esta es la interfaz grafica del juego*/
package appproyecto;

import LogicaObjetos.Lamp;
import LogicaPersonajes.Stamina;
import Audio.Sonido;
import LogicaPersonajes.EnemyThread;
import LogicaPersonajes.PrincipalThread;
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
    private Lamp lampara;
    private FuncionesMapa mapa;
    private int actualMap;
    private int walk;
    private int attack;
    private int idle;
    private int muertes;
    private Sonido audio;
    private Stamina stamina;
    private FuncionesPartidas partidasJugadas;
    public jFrmVentana() {
        muertes = 0;
        partidasJugadas = new FuncionesPartidas();
        lampara = new Lamp();
        initComponents();
        actualMap = 0;
        mapa = new FuncionesMapa();
        loadMaps();
        stamina = null;
        useMap(actualMap);
        JOptionPane.showMessageDialog(null, "Use \"W\" para saltar\nUse \"D\" para caminar a la derecha\nUse \"A\" para caminar a la izquierda\nUse \"X\" para seleccionar objetos\nUse \"F\" para atcar", "Instrucciones", HEIGHT);
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
        jLblPosima = new javax.swing.JLabel();
        jPrbStamina = new javax.swing.JProgressBar();
        jLblLampara = new javax.swing.JLabel();
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
        getContentPane().add(jLblPosima);
        jLblPosima.setBounds(320, 150, 0, 0);
        getContentPane().add(jPrbStamina);
        jPrbStamina.setBounds(20, 40, 100, 20);
        getContentPane().add(jLblLampara);
        jLblLampara.setBounds(200, 200, 0, 0);
        getContentPane().add(jLblFondo);
        jLblFondo.setBounds(340, 50, 0, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        char key = evt.getKeyChar();
        if ((key == 'X' || key == 'x')) {
            if (jLblLampara.getX() - 15 < principal.getPositionX() && jLblLampara.getX() + 15 > principal.getPositionX()) {
                principal.setLife0(100);
                useMap(actualMap);
                menuViajes();
            } else {
                if (jLblPosima.getX() - 90 < principal.getPositionX() && jLblPosima.getX() - 40 > principal.getPositionX()) {
                    jLblPosima.setLocation(0, -500);
                    if (principal.getLife() + 50 > 100) {
                        principal.setLife0(100);
                    } else {
                        principal.setLife(50);
                    }
                }
            }
        } else {
            boolean action = principal.getisAction().compareTo("Attacking") == 0 || principal.getisAction().compareTo("isJumping") == 0;
            principalThread = new PrincipalThread(principal, enemy, enemy2, 5, 17, 11, 11, !action ? key : ' ', actualMap);
            principalThread.start();
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        char key = evt.getKeyChar();
        if (key != 'x' && key != 'X') {
            boolean action = principal.getisAction().compareTo("Attacking") == 0 || principal.getisAction().compareTo("isJumping") == 0;
            principalThread = new PrincipalThread(principal, enemy, enemy2, 5, 17, 11, 11, !action ? '~' : ' ');
            principalThread.start();
            if (enemy.getisAction().compareTo("Idle") == 0 && enemy.getLife() > 0) {
                enemyThread = new EnemyThread(enemy, principal, 0, walk, attack, idle);
                enemyThread.start();
            }
            if (enemy2.getisAction().compareTo("Idle") == 0 && enemy2.getLife() > 0) {
                enemyThread2 = new EnemyThread(enemy2, principal, 0, walk, attack, idle);
                enemyThread2.start();
            }
        }
    }//GEN-LAST:event_formKeyReleased

    public void setjLblMain_Character() {
        jLblMainCharacter.setIcon(principal.getIcon());
        jLblMainCharacter.setLocation(principal.getPositionX(), principal.getPositionY());     // Actualizacion del label del principal
        SwingUtilities.updateComponentTreeUI(this);
        if (principal.getPositionX() > 1350) {
            actualMap = actualMap + 1;
            useMap(actualMap);
        }
    }

    public void setjLblEnemy() {
        jLblEnemy.setIcon(enemy.getIcon());
        jLblEnemy.setLocation(enemy.getPositionX(), enemy.getPositionY());                     //Actualizacion del label del enemigo.
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void setjLblEnemy2() {
        jLblEnemy2.setIcon(enemy2.getIcon());
        jLblEnemy2.setLocation(enemy2.getPositionX(), enemy2.getPositionY());                     //Actualizacion del label del enemigo.
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void setLifeBar() {
        jPrbStamina.setValue(principal.getStamina()>-1?principal.getStamina():1);
        jPrbEnemy.setValue(enemy.getLife()>-1?enemy.getLife():1);
        jPrbEnemy2.setValue(enemy2.getLife()>-1?enemy2.getLife():1);
        jPrbLife.setValue(principal.getLife()>-1?principal.getLife():1);                                                 //Actualizacion de las barras de vida y stamina.
        jPrbEnemy.setLocation(enemy.getPositionX() + 40, enemy.getPositionY() - 20);
        if (enemy2.getType().compareTo("Boss1") == 0 || enemy2.getType().compareTo("Boss2") == 0) {
            jPrbEnemy2.setSize(500, 20);
            jPrbEnemy2.setLocation(450, 50);
        } else {
            jPrbEnemy2.setSize(90, 20);
            jPrbEnemy2.setLocation(enemy2.getPositionX() + 40, enemy2.getPositionY() - 20);
        }
        if (principal.getLife()<1) {
            muertes++;
            principal.setLife0(100);
            principal.setStamina0(100);
            useMap(0);
            JOptionPane.showMessageDialog(null, "YOU DIE");
        }
        if(enemy2.getType().compareTo("Boss3")==0&&enemy2.getisAction().compareTo("Dying")==0){
            partidasJugadas.insertarPartida(muertes,partidasJugadas.getNodo()==null?1:partidasJugadas.getNodoInicioPartida()+1);
            menuContinuar();
            
        }
    }

    private void loadMaps() {
        ImageIcon fondo = new ImageIcon(".\\src\\Fondos\\Fondo0.png");
        mapa.insertMapa(0, 1100, 350, -500, 146, -500, 146, 0, -500, "", fondo, 1100, 250, ".\\src\\Audio\\SoundTrack0.wav", -500);
        fondo = new ImageIcon(".\\src\\Fondos\\Fondo1.png");
        mapa.insertMapa(1, 60, 154, 500, 146, 1000, 146, -0, -500, "", fondo, 100, 60, ".\\src\\Audio\\SoundTrack0.wav", 190);
        mapa.insertMapa(2, 60, 154, -500, -50, -500, -50, 136, 1000, "Boss1", fondo, 100, 60, ".\\src\\Audio\\SoundTrack1.wav", -500);
        fondo = new ImageIcon(".\\src\\Fondos\\Fondo2.png");
        mapa.insertMapa(3, 100, 310, 500, 310, 1000, 310, -0, -500, "", fondo, 100, 210, ".\\src\\Audio\\SoundTrack0.wav", 350);
        mapa.insertMapa(4, 100, 310, -500, -50, -500, -50, 310, 1000, "Boss2", fondo, 100, 210, ".\\src\\Audio\\SoundTrack2.wav", -500);
        fondo = new ImageIcon(".\\src\\Fondos\\Fondo3.png");
        mapa.insertMapa(5, 100, 360, 500, 360, 1000, 360, -0, -500, "", fondo, 100, 270, ".\\src\\Audio\\SoundTrack0.wav", 400);
        mapa.insertMapa(6, 100, 360, -500, -50, -500, -50, 355, 1000, "Boss3", fondo, 100, 270, ".\\src\\Audio\\SoundTrack3.wav", -500);
    }

    private void useMap(int typeMap) {
        int life = 0;
        int aStamina = 0;
        if (principal != null) {
            life = principal.getLife();
            aStamina = principal.getStamina();
        }
        principal = new GameCharacter(mapa.getXPrincipal(typeMap), mapa.getYPrincipal(typeMap), 180, 120, "Principal");
        if (life != 0) {
            principal.setLife0(life);
            principal.setStamina0(aStamina);
        }
        jLblMainCharacter.setBounds(principal.getPositionX(), principal.getPositionY(), principal.getWidth(), principal.getHeight());
        jLblMainCharacter.setIcon(principal.getIcon());
        principal.setisAction("Idle");
        principalThread = new PrincipalThread(principal, enemy, enemy2, 5, 17, 11, 11, '~');
        principalThread.start();

        enemy = new GameCharacter(mapa.getXEnemy1(typeMap), mapa.getYEnemy1(typeMap), 180, 120, "Enemy");
        jLblEnemy.setBounds(enemy.getPositionX(), enemy.getPositionY(), enemy.getWidth(), enemy.getHeight());
        jLblEnemy.setIcon(enemy.getIcon());
        enemy.setisAction("Idlee");

        jLblPosima.setSize(50, 40);
        jLblPosima.setLocation(750, mapa.getyPosima(typeMap));
        jLblPosima.setIcon(new ImageIcon(new ImageIcon(".//src//Imagenes//Posima.png").getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH)));

        switch (typeMap) {
            case 0:
            case 1:
            case 3:
            case 5:
                enemy2 = new GameCharacter(mapa.getXEnemy2(typeMap), mapa.getYEnemy2(typeMap), 180, 120, "Enemy");
                jLblEnemy2.setBounds(enemy2.getPositionX(), enemy2.getPositionY(), enemy2.getWidth(), enemy2.getHeight());
                jLblEnemy2.setIcon(enemy2.getIcon());
                enemy2.setisAction("Idlee");
                break;
            case 2:
            case 4:
            case 6:
                enemy.setLife0(0);
                enemy2 = new GameCharacter(mapa.getXBoss(typeMap), mapa.getYBoss(typeMap), 180, 120, mapa.getBossType(typeMap));
                jLblEnemy2.setBounds(enemy2.getPositionX(), enemy2.getPositionY(), enemy2.getWidth(), enemy2.getHeight());
                jLblEnemy2.setIcon(enemy2.getIcon());
                enemy2.setisAction("Idlee");
                break;
        }
        switch (enemy2.getType()) {
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
                break;
            case "Boss3":
                walk = 23;
                attack = 11;
                idle = 17;
        }
        if (audio != null) {
            audio.getAudio().stop();
        }
        audio = new Sonido(mapa.getAudio(typeMap));
        audio.start();

        enemyThread = new EnemyThread(enemy, principal, 0, 23, 11, 17);
        enemyThread.start();

        enemyThread2 = new EnemyThread(enemy2, principal, 0, walk, attack, idle);
        enemyThread2.start();

        jLblFondo.setLocation(0, 0);
        jLblFondo.setSize(1500, 500);
        ImageIcon fondo = mapa.getFondo(typeMap);
        jLblFondo.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(1500, 500, Image.SCALE_SMOOTH)));
        actualMap = typeMap;
        jLblLampara.setIcon(lampara.lampState(typeMap));
        jLblLampara.setLocation(mapa.getxLampara(typeMap), mapa.getyLampara(typeMap));
        jLblLampara.setSize(200, 200);
        if (stamina != null) {
            stamina.setEstado(false);
        }
        stamina = new Stamina(principal);
        stamina.start();

    }

    private void menuViajes() {

        if (actualMap == 2 && lampara.getLampState2().compareTo("Off") == 0) {
            lampara.setLampState2("On");
        }
        if (actualMap == 3 && lampara.getLampState3().compareTo("Off") == 0) {
            lampara.setLampState3("On");
        }
        if (actualMap == 4 && lampara.getLampState4().compareTo("Off") == 0) {
            lampara.setLampState4("On");
        }
        if (actualMap == 5 && lampara.getLampState5().compareTo("Off") == 0) {
            lampara.setLampState5("On");
        }
        if (actualMap == 6 && lampara.getLampState6().compareTo("Off") == 0) {
            lampara.setLampState6("On");
        }

        int lugar = JOptionPane.showOptionDialog(
                null,
                "A donde quieres viajar?",
                "Viajes",
                0,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[]{"Mapa 0", "Mapa 1", "Mapa 2", "Mapa 3", "Mapa 4", "Mapa 5", "Mapa 6"},
                "opcion 1");

        if (lugar != -1) {
            if (lugar == 0 && lampara.getLampState0().compareTo("On") == 0) {
                actualMap = 0;
                useMap(actualMap);
            } else {
                if (lugar == 1 && lampara.getLampState1().compareTo("On") == 0) {
                    actualMap = 1;
                    useMap(actualMap);
                } else {
                    if (lugar == 2 && lampara.getLampState2().compareTo("On") == 0) {
                        actualMap = 2;
                        useMap(actualMap);
                    } else {
                        if (lugar == 3 && lampara.getLampState3().compareTo("On") == 0) {
                            actualMap = 3;
                            useMap(actualMap);
                        } else {
                            if (lugar == 4 && lampara.getLampState4().compareTo("On") == 0) {
                                actualMap = 4;
                                useMap(actualMap);
                            } else {
                                if (lugar == 5 && lampara.getLampState5().compareTo("On") == 0) {
                                    actualMap = 5;
                                    useMap(actualMap);
                                } else {
                                    if (lugar == 6 && lampara.getLampState6().compareTo("On") == 0) {
                                        actualMap = 6;
                                        useMap(actualMap);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void menuContinuar(){
        int option = JOptionPane.showOptionDialog(
                null,
                "Desea Jugar otra vez?",
                "Continuar",
                0,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[]{"Si","No"},
                "opcion 1");

        if (option != -1) {
            if (option == 0) {
                muertes = 0;
                lampara = new Lamp();
                actualMap = 0;
                mapa = new FuncionesMapa();
                loadMaps();
                stamina = null;
                principal.setLife0(100);
                principal.setStamina0(100);
                useMap(actualMap);
            } else {
                partidasJugadas.ordenarLista();
                JOptionPane.showMessageDialog(null, partidasJugadas.toString());
                System.exit(0);
            }
            
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblBoss;
    private javax.swing.JLabel jLblEnemy;
    private javax.swing.JLabel jLblEnemy2;
    private javax.swing.JLabel jLblFondo;
    private javax.swing.JLabel jLblLampara;
    private javax.swing.JLabel jLblMainCharacter;
    private javax.swing.JLabel jLblPosima;
    private javax.swing.JProgressBar jPrbEnemy;
    private javax.swing.JProgressBar jPrbEnemy2;
    private javax.swing.JProgressBar jPrbLife;
    private javax.swing.JProgressBar jPrbStamina;
    // End of variables declaration//GEN-END:variables
}
