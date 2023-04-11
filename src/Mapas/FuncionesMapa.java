//Funciones de Lista para guardar datos de cada mapa
package Mapas;

import javax.swing.ImageIcon;

public class FuncionesMapa {

    private Mapa nodo;

    public FuncionesMapa() {
        nodo = null;
    }

    public void insertMapa(int numeroMapa, int xPrincipal, int yPrincipal, int xEnemy1, int yEnemy1, int xEnemy2, int yEnemy2,
            int yBoss, int xBoss, String bossType, ImageIcon fondo, int xLampara, int yLampara, String audio, int yPosima) {
        Mapa nodoNuevo = new Mapa();
        nodoNuevo.siguiente = null;
        nodoNuevo.fondo = fondo;
        nodoNuevo.numeroMapa = numeroMapa;
        nodoNuevo.xPrincipal = xPrincipal;
        nodoNuevo.yPrincipal = yPrincipal;
        nodoNuevo.xEnemy1 = xEnemy1;
        nodoNuevo.yEnemy1 = yEnemy1;
        nodoNuevo.xEnemy2 = xEnemy2;
        nodoNuevo.yEnemy2 = yEnemy2;
        nodoNuevo.yBoss = yBoss;
        nodoNuevo.xBoss = xBoss;
        nodoNuevo.bossType = bossType;
        nodoNuevo.xLampara = xLampara;
        nodoNuevo.yLampara = yLampara;
        nodoNuevo.audio = audio;
        nodoNuevo.yPosima = yPosima;
        if (nodo == null) {
            nodo = nodoNuevo;

        } else {
            nodoNuevo.siguiente = nodo;
            nodo = nodoNuevo;
        }
    }

    public int getXPrincipal(int mapa) {
        int xPrincipal = 0;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.numeroMapa == mapa) {
                xPrincipal = aux.xPrincipal;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return xPrincipal;
    }

    public int getYPrincipal(int mapa) {
        int yPrincipal = 0;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.numeroMapa == mapa) {
                yPrincipal = aux.yPrincipal;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return yPrincipal;
    }

    public int getXEnemy1(int mapa) {
        int xEnemy = 0;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.numeroMapa == mapa) {
                xEnemy = aux.xEnemy1;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return xEnemy;
    }

    public int getXEnemy2(int mapa) {
        int xEnemy = 0;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.numeroMapa == mapa) {
                xEnemy = aux.xEnemy2;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return xEnemy;
    }

    public int getYEnemy1(int mapa) {
        int yEnemy = 0;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.numeroMapa == mapa) {
                yEnemy = aux.yEnemy1;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return yEnemy;
    }

    public int getYEnemy2(int mapa) {
        int yEnemy = 0;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.numeroMapa == mapa) {
                yEnemy = aux.yEnemy2;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return yEnemy;
    }

    public int getYBoss(int mapa) {
        int yBoss = 0;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.numeroMapa == mapa) {
                yBoss = aux.yBoss;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return yBoss;
    }

    public int getXBoss(int mapa) {
        int xBoss = 0;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.numeroMapa == mapa) {
                xBoss = aux.xBoss;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return xBoss;
    }

    public String getBossType(int mapa) {
        String bossType = "";
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.numeroMapa == mapa) {
                bossType = aux.bossType;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return bossType;
    }

    public ImageIcon getFondo(int mapa) {
        ImageIcon fondo = null;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.numeroMapa == mapa) {
                fondo = aux.fondo;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return fondo;
    }

    public int getxLampara(int mapa) {
        int x = 0;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.numeroMapa == mapa) {
                x = aux.xLampara;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return x;
    }

    public int getyLampara(int mapa) {
        int y = 0;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.numeroMapa == mapa) {
                y = aux.yLampara;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return y;
    }

    public int getyPosima(int mapa) {
        int y = 0;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.numeroMapa == mapa) {
                y = aux.yPosima;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return y;
    }

    public String getAudio(int mapa) {
        String audio = "";
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.numeroMapa == mapa) {
                audio = aux.audio;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return audio;
    }
}
