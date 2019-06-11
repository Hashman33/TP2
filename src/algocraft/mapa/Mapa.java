package algocraft.mapa;

import algocraft.material.*;
import algocraft.jugador.*;

// Utilizamos patron Singleton
public class Mapa {

    private static final Mapa instancia = new Mapa();

    // Medidas en casilleros
    private static final int LARGO = 20;
    private static final int ANCHO = 20;
    private static Celda tablero[][];

    public static Mapa obtenerInstancia() {
        return instancia;
    }

    private Mapa() {
         tablero =  new Celda[LARGO][ANCHO];

         for( int i = 0; i < ANCHO; i++ ){

             for( int j = 0; j< LARGO; j++){

                 if (i > 0 && i < 3 && j > 6 && j < 14) { tablero [i][j] = new Celda(new Metal()); }

                 if (i > 2 && i < 6 && j > 16 && j < 19) { tablero [i][j] = new Celda(new Diamante()); }

                 if (i > 8 && i < 12 && j > 0 && j < 7) { tablero [i][j] = new Celda(new Piedra()); }

                 if (i > 13 && i < 19 && j > 2 && j < 11) { tablero [i][j] = new Celda(new Madera()); }

                 if (i == 14 && j == 14) { tablero [i][j] = new Celda(new Jugador()); }

                 else { tablero[i][j] = new Celda(); }
             }
         }

    }
}
