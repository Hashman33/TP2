package algocraft.matriz;

import java.util.ArrayList;
import java.util.List;

public class Fila {

    private List<Celda> fila;

    public Fila(int anchoX) {

        fila = new ArrayList<Celda>();
        this.inicilizarFila(anchoX);
    }


    public void inicilizarFila(int anchoX) {

        for (int i = 0; i < anchoX; i++) {
            fila.add(new Celda()); }
    }

    public Celda obtenerCelda(int coordX) {

        return fila.get(coordX);
    }

}
