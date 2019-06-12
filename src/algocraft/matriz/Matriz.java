package algocraft.matriz;

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
}
