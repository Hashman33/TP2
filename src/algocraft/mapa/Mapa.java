package algocraft.mapa;

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

                 tablero[i][j] = new Celda();
             }
         }



    }

}
