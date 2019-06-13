package algocraft.mapa;

import algocraft.material.*;
import algocraft.jugador.*;
import algocraft.matriz.*;
import algocraft.matriz.Celda;
import algocraft.utilidades.VectorPosicion2I;

import java.util.concurrent.ThreadLocalRandom;

// Utilizamos patron Singleton
public class Mapa {

    private static final Mapa instancia = new Mapa();

    // Medidas en casilleros
    private static final int LARGO = 20;
    private static final int ANCHO = 20;
    private static Matriz tablero;

    public static Mapa obtenerInstancia() {
        return instancia;
    }

    private Mapa() {
         tablero =  new Matriz(LARGO, ANCHO);

         for( int i = 0; i < LARGO; i++ ){

             for( int j = 0; j< ANCHO; j++){

                 if (i > 0 && i < 3 && j > 6 && j < 14) { this.insertarMaterial(i, j, new Metal()); }

                 else if (i > 2 && i < 6 && j > 16 && j < 19) { this.insertarMaterial(i, j, new Diamante()); }

                 else if (i > 8 && i < 12 && j > 0 && j < 7) { this.insertarMaterial(i, j, new Piedra()); }

                 else if (i > 13 && i < 19 && j > 2 && j < 11) { this.insertarMaterial(i, j, new Madera());
                 }
             }
         }

    }

    // El Jugador se inserta en una celda Random vacía.
    public void insertarJugador(Jugador jugador) {

        int coordenadaX;
        int coordenadaY;
        Celda celda;

        do {
            coordenadaX = ThreadLocalRandom.current().nextInt(0, ANCHO);
            coordenadaY = ThreadLocalRandom.current().nextInt(0, LARGO);
            celda = tablero.obtenerCelda(coordenadaY, coordenadaX);
        }
        while (celda.colocarJugador(jugador));

        jugador.setCoordenadas(coordenadaX, coordenadaY);
    }

    // El Jugador se inserta en una posición pasada por parámetro.
    public boolean insertarJugador(int coordenadaY, int coordenadaX, Jugador jugador) {

        Celda celda = tablero.obtenerCelda(coordenadaY, coordenadaX);
        if (celda.colocarJugador(jugador)) {
            jugador.setCoordenadas(coordenadaY, coordenadaX);
            return true;
        }
        return false;
    }

    public void removerJugador(int coordenadaY, int coordenadaX) {

        Celda celda = tablero.obtenerCelda(coordenadaY, coordenadaX);
        celda.removerJugador();
    }

    public boolean insertarMaterial(int coordenadaY, int coordenadaX, Material material) {

        Celda celda = tablero.obtenerCelda(coordenadaY, coordenadaX);
        return celda.colocarMaterial(material);
    }

    public void removerMaterial(int coordenadaY, int coordenadaX) {

        Celda celda = tablero.obtenerCelda(coordenadaY, coordenadaX);
        celda.removerMaterial();
    }

    public boolean celdaEstaVacia(int coordenadaY, int coordenadaX) {

        Celda celda = tablero.obtenerCelda(coordenadaY, coordenadaX);
        return celda.estaVacia();
    }


    public boolean moverJugadorArriba(Jugador jugador) {

        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        if (coordenadaY == 0) { return false; }           // LIMITE DE MAPA NO SE MUEVE

        Celda celdaActual = tablero.obtenerCelda(coordenadaY , coordenadaX);
        Celda celdaAVisitar = tablero.obtenerCelda(coordenadaY - 1, coordenadaX);

        if (celdaAVisitar.colocarJugador(jugador)) {
            celdaActual.removerJugador();
            return true;
        }
        return false;
    }

    public boolean moverJugadorAbajo(Jugador jugador) {

        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        if (coordenadaY == LARGO - 1) { return false; }       // LIMITE DE MAPA NO SE MUEVE

        Celda celdaActual = tablero.obtenerCelda(coordenadaY , coordenadaX);
        Celda celdaAVisitar = tablero.obtenerCelda(coordenadaY + 1, coordenadaX);

        if (celdaAVisitar.colocarJugador(jugador)) {
            celdaActual.removerJugador();
            return true;
        }
        return false;
    }

    public boolean moverJugadorIzquierda(Jugador jugador) {

        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        if (coordenadaX == 0) { return false; }           // LIMITE DE MAPA NO SE MUEVE

        Celda celdaActual = tablero.obtenerCelda(coordenadaY , coordenadaX);
        Celda celdaAVisitar = tablero.obtenerCelda(coordenadaY, coordenadaX - 1);

        if (celdaAVisitar.colocarJugador(jugador)) {
            celdaActual.removerJugador();
            return true;
        }
        return false;
    }

    public boolean moverJugadorDerecha(Jugador jugador) {

        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        if (coordenadaX == ANCHO - 1) { return false; }       // LIMITE DE MAPA NO SE MUEVE

        Celda celdaActual = tablero.obtenerCelda(coordenadaY , coordenadaX);
        Celda celdaAVisitar = tablero.obtenerCelda(coordenadaY, coordenadaX + 1);

        if (celdaAVisitar.colocarJugador(jugador)) {
            celdaActual.removerJugador();
            return true;
        }
        return false;
    }

    public static int getAncho() { return ANCHO; }

    public static int getLargo() { return  LARGO; }

    // Hecho con el VectorPosicion2I //

    // Propuesta de movimiento: Cuando funcione el juego vos apretas una tecla y se mueve. Depende la tecla
    // le pasas un vector distinto y se mueve a donde corresponde
    public boolean moverJugador(Jugador jugador, VectorPosicion2I movimiento) {

        // Tecla arriba: + (0 -1)
        // Tecla abajo: + (0 1)
        // Tecla izquierda: + (-1 0)
        // Tecla derecha: + (1 0)
        // Tambien en diagonal se podria con (1 1), (-1 1), etc.
        Celda celdaActual = tablero.obtenerCelda(jugador.getPosicion());

        VectorPosicion2I nuevaPosicion = jugador.getPosicion().sumar(movimiento);

        Celda celdaAVisitar = tablero.obtenerCelda(nuevaPosicion);

        if (celdaAVisitar == null) return false;

        if (!celdaAVisitar.colocar(jugador)) return false;

        celdaActual.removerJugador();

        return true;
    }

    public boolean insertarJugador(Jugador jugador, VectorPosicion2I posicion) {

        Celda celda = tablero.obtenerCelda(posicion);
        if (celda.colocar(jugador)) {
            jugador.setCoordenadas(posicion);
            return true;
        }
        return false;
    }

    public void removerJugador(VectorPosicion2I posicion) {

        Celda celda = tablero.obtenerCelda(posicion);
        celda.removerJugador();
    }

    public boolean insertarMaterial(Material material, VectorPosicion2I posicion) {
        Celda celda = tablero.obtenerCelda(posicion);
        return celda.colocar(material);
    }

    public void removerMaterial(VectorPosicion2I posicion) {
        Celda celda = tablero.obtenerCelda(posicion);
        celda.removerMaterial();
    }
}
