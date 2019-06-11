package algocraft.mapa;

import algocraft.material.*;
import algocraft.jugador.*;
import java.util.concurrent.ThreadLocalRandom;

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

                 else if (i > 2 && i < 6 && j > 16 && j < 19) { tablero [i][j] = new Celda(new Diamante()); }

                 else if (i > 8 && i < 12 && j > 0 && j < 7) { tablero [i][j] = new Celda(new Piedra()); }

                 else if (i > 13 && i < 19 && j > 2 && j < 11) { tablero [i][j] = new Celda(new Madera()); }

               tablero[i][j] = new Celda();
             }
         }


    }

    public void maparandom(){
        for( int i = 0; i < ANCHO; i++ ){

            for( int j = 0; j< LARGO; j++){


                tablero[i][j] = new Celda();
            }
        }
        RandomMap generador = new RandomMap(this,ANCHO,LARGO);
        generador.disponerMaterialMadera(30,20);
        generador.disponerMaterialPiedra(25,15);
        generador.disponerMaterialMetal(20,10);
        generador.disponerMaterialDiamante(6,4);

    }

    public void imprimirMapa(){
        for(int i = 0; i< ANCHO; i++){
            for(int j = 0 ; j< LARGO ;  j++ ){
                System.out.print(tablero[i][j].obtenerMaterial() + " ");
            }
            System.out.println();
        }
    }


    // El Jugador se inserta en una celda Random vacía.
    public void insertarJugador(Jugador jugador) {
        int coordenadaX;
        int coordenadaY;

        do {
            coordenadaX = ThreadLocalRandom.current().nextInt(0, ANCHO);
            coordenadaY = ThreadLocalRandom.current().nextInt(0, LARGO);
        }
        while (!tablero [coordenadaY][coordenadaX].colocarJugador(jugador));

        jugador.setCoordenadas(coordenadaX, coordenadaY);
    }

    public boolean insertarMaterial(Material material, int coordenadaX, int coordenadaY){

        return tablero[coordenadaY][coordenadaX].colocarMaterial(material);



    }

    //public boolean coordenadaEnMapa(int coordenadaX, int coordenadaY){

    //}


    public void insertarJugador(Jugador jugador, int x, int y) {
        jugador.setCoordenadas(x, y);
    }

    public boolean moverJugadorArriba(Jugador jugador) {


        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        if (coordenadaY == 0) { return false; }           // LIMITE DE MAPA NO SE MUEVE
        if (tablero [coordenadaY - 1][coordenadaX].colocarJugador(jugador)) {
            tablero [coordenadaY][coordenadaX].removerJugador();
            return true;
        }
        return false;
    }

    public boolean moverJugadorAbajo(Jugador jugador) {

        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        if (coordenadaY == LARGO - 1) { return false; }       // LIMITE DE MAPA NO SE MUEVE
        if (tablero [coordenadaY + 1][coordenadaX].colocarJugador(jugador)) {
            tablero [coordenadaY][coordenadaX].removerJugador();
            return true;
        }
        return false;
    }

    public boolean moverJugadorIzquierda(Jugador jugador) {

        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        if (coordenadaX == 0) { return false; }           // LIMITE DE MAPA NO SE MUEVE
        if (tablero [coordenadaY][coordenadaX - 1].colocarJugador(jugador)) {
            tablero [coordenadaY][coordenadaX].removerJugador();
            return true;
        }
        return false;

    }

    public boolean moverJugadorDerecha(Jugador jugador) {

        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        if (coordenadaX == ANCHO - 1) { return false; }       // LIMITE DE MAPA NO SE MUEVE
        if (tablero [coordenadaY][coordenadaX + 1].colocarJugador(jugador)) {
            tablero [coordenadaY][coordenadaX].removerJugador();
            return true;
        }
        return false;
    }

    public Celda[][] getTablero() { return tablero; }
}
