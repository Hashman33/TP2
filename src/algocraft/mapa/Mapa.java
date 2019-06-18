package algocraft.mapa;

import algocraft.material.*;
import algocraft.jugador.*;
import algocraft.matriz.*;
import algocraft.matriz.Celda;
import algocraft.utilidades.VectorPosicion2I;

import java.util.concurrent.ThreadLocalRandom;

// Utilizamos patron Singleton
public class Mapa {

    private static Mapa instancia = new Mapa();

    // Medidas en casilleros
    private static final int LARGO = 20;
    private static final int ANCHO = 20;
    private static Matriz tablero;

    public static Mapa obtenerInstancia() {

        if (instancia == null) instancia = new Mapa();
        return instancia;
    }

    public static int getAncho() { return ANCHO; }

    public static int getLargo() { return  LARGO; }


    private Mapa() {
         tablero =  new Matriz(LARGO, ANCHO);

         for( int i = 0; i < LARGO; i++ ){

             for( int j = 0; j< ANCHO; j++){

                 if (i > 0 && i < 3 && j > 6 && j < 14) {
                     this.insertarMaterial(new Metal(), new VectorPosicion2I(j, i));
                 }

                 else if (i > 2 && i < 6 && j > 16 && j < 19) {
                     this.insertarMaterial(new Diamante(), new VectorPosicion2I(j, i));
                 }

                 else if (i > 8 && i < 12 && j > 0 && j < 7) {
                     this.insertarMaterial(new Piedra(), new VectorPosicion2I(j, i));
                 }

                 else if (i > 13 && i < 19 && j > 2 && j < 11) {
                     this.insertarMaterial(new Madera(), new VectorPosicion2I(j, i));
                 }
             }
         }

    }

    public void maparandom(){
        tablero = new Matriz(LARGO,ANCHO);
        RandomMap generador = new RandomMap(this, ANCHO, LARGO);
        generador.disponerMaterialMadera(30,20);
        generador.disponerMaterialPiedra(25,15);
        generador.disponerMaterialMetal(20,10);
        generador.disponerMaterialDiamante(6,4);

    }



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

        celdaActual.limpiar();

        return true;
    }

    public boolean insertarJugador(Jugador jugador, VectorPosicion2I posicion) {

        Celda celda = tablero.obtenerCelda(posicion);
        if (celda != null && celda.colocar(jugador)) {
            jugador.setCoordenadas(posicion);
            return true;
        }
        return false;
    }

    public void removerJugador(VectorPosicion2I posicion) {

        Celda celda = tablero.obtenerCelda(posicion);
        if (celda != null) celda.removerJugador();
    }

    public boolean insertarMaterial(Material material, VectorPosicion2I posicion) {
        Celda celda = tablero.obtenerCelda(posicion);
        return celda.colocar(material);
    }

    public void removerMaterial(VectorPosicion2I posicion) {
        Celda celda = tablero.obtenerCelda(posicion);
        celda.removerMaterial();
    }

    public Material obtenerMaterial(VectorPosicion2I posicion) {
        Celda celda = tablero.obtenerCelda(posicion);
        return celda.obtenerMaterial();
    }

    public Jugador obtenerJugador(VectorPosicion2I posicion) {
        Celda celda = tablero.obtenerCelda(posicion);
        return celda.obtenerJugador();
    }

    public void resetear() { instancia = null; }
}

/*public void imprimirMapa(){

        int cantPiedra = 0;

        for (int i = 0; i < ANCHO; i++){

            for(int j = 0 ; j < LARGO; j++ ){

                if(this.obtenerMaterial(new VectorPosicion2I(i,j)) != null) {
                    if (this.obtenerMaterial(new VectorPosicion2I(i, j)).getClass() == Piedra.class) {
                        cantPiedra++;

                    }
                }
                System.out.print(this.obtenerMaterial( new VectorPosicion2I(i,j)));
            }

            System.out.println();
        }


    }

     */
