package Mapas;

import javax.swing.ImageIcon;

public class FuncionesMapa {

    private Mapa nodo;

    public FuncionesMapa() {
        nodo = null;
    }

    public void insertMapa(String nombre, int xPrincipal, int yPrincipal, int xEnemy1, int yEnemy1, int xEnemy2, int yEnemy2,
                            int yBoss, int xBoss, String bossType, ImageIcon fondo, int xLampara, int yLampara) {
        Mapa nodoNuevo = new Mapa();
        nodoNuevo.siguiente = null;
        nodoNuevo.fondo = fondo;
        nodoNuevo.nombre = nombre;
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
        if (nodo == null) {
            nodo = nodoNuevo;

        } else {
            nodoNuevo.siguiente = nodo;
            nodo = nodoNuevo;
        }
    }

    public int getXPrincipal(String mapa) {
        int xPrincipal = 0;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.nombre.compareTo(mapa) == 0) {
                xPrincipal = aux.xPrincipal;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return xPrincipal;
    }
    public int getYPrincipal(String mapa) {
        int yPrincipal = 0;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.nombre.compareTo(mapa) == 0) {
                yPrincipal = aux.yPrincipal;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return yPrincipal;
    }
    public int getXEnemy1(String mapa) {
        int xEnemy = 0;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.nombre.compareTo(mapa) == 0) {
                xEnemy = aux.xEnemy1;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return xEnemy;
    }
    public int getXEnemy2(String mapa) {
        int xEnemy = 0;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.nombre.compareTo(mapa) == 0) {
                xEnemy = aux.xEnemy2;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return xEnemy;
    }
    public int getYEnemy1(String mapa) {
        int yEnemy = 0;
        Mapa aux = nodo;
        while (aux != null) {
            if (aux.nombre.compareTo(mapa) == 0) {
                yEnemy = aux.yEnemy1;
                break;
            } else {
                aux = aux.siguiente;
            }
        }
        return yEnemy;
    }
    public int getYEnemy2(String mapa){
        int yEnemy = 0;
        Mapa aux = nodo;
        while(aux != null){
            if(aux.nombre.compareTo(mapa)==0){
                yEnemy = aux.yEnemy2;
                break;
            }
            else{
            aux = aux.siguiente;
            }
        }
        return yEnemy;
    }
    public int getYBoss(String mapa){
        int yBoss = 0;
        Mapa aux = nodo;
        while(aux != null){
            if(aux.nombre.compareTo(mapa)==0){
                yBoss = aux.yBoss;
                break;
            }
            else{
            aux = aux.siguiente;
            }
        }
        return yBoss;
    }
    public int getXBoss(String mapa){
        int xBoss = 0;
        Mapa aux = nodo;
        while(aux != null){
            if(aux.nombre.compareTo(mapa)==0){
                xBoss = aux.xBoss;
                break;
            }
            else{
            aux = aux.siguiente;
            }
        }
        return xBoss;
    }
    public String getBossType(String mapa){
        String bossType = "";
        Mapa aux = nodo;
        while(aux != null){
            if(aux.nombre.compareTo(mapa)==0){
                bossType = aux.bossType;
                break;
            }
            else{
            aux = aux.siguiente;
            }
        }
        return bossType;
    }
    public ImageIcon getFondo(String mapa){
        ImageIcon fondo = null;
        Mapa aux = nodo;
        while(aux != null){
            if(aux.nombre.compareTo(mapa)==0){
                fondo = aux.fondo;
                break;
            }
            else{
            aux = aux.siguiente;
            }
        }
        return fondo;
    }
     public int getxLampara(String mapa){
        int x = 0;
        Mapa aux = nodo;
        while(aux != null){
            if(aux.nombre.compareTo(mapa)==0){
                x = aux.xLampara;
                break;
            }
            else{
            aux = aux.siguiente;
            }
        }
        return x;
    }
     public int getyLampara(String mapa){
        int y = 0;
        Mapa aux = nodo;
        while(aux != null){
            if(aux.nombre.compareTo(mapa)==0){
                y = aux.yLampara;
                break;
            }
            else{
            aux = aux.siguiente;
            }
        }
        return y;
    }
}
