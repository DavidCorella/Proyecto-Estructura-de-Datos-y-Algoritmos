package appproyecto;

public class FuncionesPartidas {

    private Partidas nodo;

    public FuncionesPartidas() {
        nodo = null;
    }

    public void insertarPartida(int muertes, int partida) {
        Partidas nuevoNodo = new Partidas();
        nuevoNodo.siguiente = null;
        nuevoNodo.cantidadMuertes = muertes;
        nuevoNodo.cantidadPartidas = partida;

        if (nodo == null) {
            nodo = nuevoNodo;
        } else {
            nuevoNodo.siguiente = nodo;
            nodo = nuevoNodo;
        }
    }

    public String toString() {
        String texto = "";
        Partidas aux = nodo;
        while (aux != null) {
            texto = texto.concat("Muertes: ").concat(String.valueOf(aux.cantidadMuertes)).concat("      Partida: ").concat(String.valueOf(aux.cantidadPartidas)).concat("\n");
            aux = aux.siguiente;
        }
        return texto;
    }

    public void ordenarLista() {
        int valor = 0;
        Partidas aux = nodo;
        while (aux!=null) {
            Partidas aux1 = aux;
            while(aux1.siguiente!=null) {
                if (aux.cantidadMuertes > aux1.siguiente.cantidadMuertes) {
                    int aux2 = aux.cantidadMuertes;
                    aux.cantidadMuertes = aux1.siguiente.cantidadMuertes;
                    aux1.siguiente.cantidadMuertes = aux2;
                    aux2 = aux.cantidadPartidas;
                    aux.cantidadPartidas = aux1.siguiente.cantidadPartidas;
                    aux1.siguiente.cantidadPartidas = aux2;
                }
                aux1 = aux1.siguiente;
            }
            aux = aux.siguiente;
        }
    }


    public int getNodoInicioPartida() {
        return nodo.cantidadPartidas;
    }

    public Partidas getNodo() {
        return nodo;
    }
}
