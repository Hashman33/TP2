package algocraft.utilidades.matriz;

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

    public List<Celda> getCeldas() {
        return fila;
    }

    public boolean estaVacia() {
        for (Celda celda: fila) {
            if(!celda.estaVacia()) return false;
        }
        return true;
    }

    public void limpiar() {
        for (Celda celda: this.fila) {
            celda.limpiar();
        }
    }
}
