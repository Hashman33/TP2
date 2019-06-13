package algocraft.matriz;

import algocraft.utilidades.VectorPosicion2I;

import java.util.ArrayList;
import java.util.List;

public class Matriz {

    private static int ANCHO;
    private static int LARGO;
    private List<Fila> filas;


    public Matriz(int largoY, int anchoX) {

        ANCHO = anchoX;
        LARGO = largoY;
        filas = new ArrayList<Fila>();
        this.inicilizarMatriz();
    }

    public void inicilizarMatriz() {

        for (int i = 0; i < LARGO; i++) {
            filas.add(new Fila(ANCHO));
        }
    }

    public Celda obtenerCelda(int coordenadaY, int coordenadaX) {

        Fila fila = filas.get(coordenadaY);
        return fila.obtenerCelda(coordenadaX);
    }

    public Celda obtenerCelda(VectorPosicion2I coordenadas) {
        if (!esPosicionValida(coordenadas)) return null;
        Fila fila = filas.get(coordenadas.getY());
        return fila.obtenerCelda(coordenadas.getX());
    }

    public boolean esPosicionValida(VectorPosicion2I posicion) {
        return posicion.getX() >= 0 && posicion.getX() < ANCHO && posicion.getY() >= 0 && posicion.getY() < LARGO;
    }

}
