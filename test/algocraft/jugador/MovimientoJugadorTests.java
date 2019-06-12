package algocraft.jugador;

import algocraft.mapa.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovimientoJugadorTests {

    Mapa mapa = Mapa.obtenerInstancia();
    private int largo = mapa.getLargo();
    private int ancho = mapa.getAncho();

    @Test
    public void test01JugadorEnPosicionRandomSeMueveHaciaArribaSiLaCeldaEstaVaciaYNoEstaEnBordeSuperior() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador);
        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        int coordenadaYFinal = coordenadaY;
        if (mapa.celdaEstaVacia(coordenadaY - 1, coordenadaX) && coordenadaY != 0) {
            coordenadaYFinal --;
        }
        jugador.moverArriba(mapa);
        mapa.removerJugador(coordenadaY, coordenadaX);

        assertEquals(coordenadaYFinal, jugador.getCoordenadaY());
        assertEquals(coordenadaX, jugador.getCoordenadaX());
    }

    @Test
    public void test02JugadorEnPosicionRandomSeMueveHaciaAbajoSiLaCeldaEstaVaciaYNoEstaEnBordeInferior() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador);
        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        int coordenadaYFinal = coordenadaY;
        if (mapa.celdaEstaVacia(coordenadaY + 1, coordenadaX) && coordenadaY != largo - 1) {
            coordenadaYFinal ++;
        }
        jugador.moverAbajo(mapa);
        mapa.removerJugador(coordenadaY, coordenadaX);

        assertEquals(coordenadaYFinal, jugador.getCoordenadaY());
        assertEquals(coordenadaX, jugador.getCoordenadaX());
    }

    @Test
    public void test03JugadorEnPosicionRandomSeMueveHaciaIzquierdaSiLaCeldaEstaVaciaYNoEstaEnBordeIzquierdo() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador);
        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        int coordenadaXFinal = coordenadaX;
        if (mapa.celdaEstaVacia(coordenadaY, coordenadaX - 1) && coordenadaX != 0) {
            coordenadaXFinal --;
        }
        jugador.moverIzquierda(mapa);
        mapa.removerJugador(coordenadaY, coordenadaX);

        assertEquals(coordenadaXFinal, jugador.getCoordenadaX());
        assertEquals(coordenadaY, jugador.getCoordenadaY());
    }

    @Test
    public void test04JugadorEnPosicionRandomSeMueveHaciaArribaSiLaCeldaEstaVaciaYNoEstaEnBordeDerecho() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador);
        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        int coordenadaXFinal = coordenadaX;
        if (mapa.celdaEstaVacia(coordenadaY, coordenadaX + 1) && coordenadaX != ancho - 1) {
            coordenadaXFinal ++;
        }
        jugador.moverDerecha(mapa);
        mapa.removerJugador(coordenadaY, coordenadaX);

        assertEquals(coordenadaXFinal, jugador.getCoordenadaX());
        assertEquals(coordenadaY, jugador.getCoordenadaY());
    }

    @Test
    public void test05JugadorEnBordeSuperiorSeMueveHaciaArribaYNoSeDesplaza() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(0, 3, jugador);

        jugador.moverArriba(mapa);
        mapa.removerJugador(0, 3);

        assertEquals(0, jugador.getCoordenadaY());
        assertEquals(3, jugador.getCoordenadaX());
    }

    @Test
    public void test06JugadorEnBordeInferiorSeMueveHaciaAbajoYNoSeDesplaza() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(19, 3, jugador);

        jugador.moverAbajo(mapa);
        mapa.removerJugador(19, 3);

        assertEquals(19, jugador.getCoordenadaY());
        assertEquals(3, jugador.getCoordenadaX());
    }

    @Test
    public void test07JugadorEnBordeIzquierdoSeMueveHaciaIzquierdaYNoSeDesplaza() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(3, 0, jugador);

        jugador.moverIzquierda(mapa);
        mapa.removerJugador(3, 0);

        assertEquals(3, jugador.getCoordenadaY());
        assertEquals(0, jugador.getCoordenadaX());
    }

    @Test
    public void test08JugadorEnBordeDerechoSeMueveHaciaDerechaYNoSeDesplaza() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(3, 19, jugador);

        jugador.moverDerecha(mapa);
        mapa.removerJugador(3, 19);

        assertEquals(3, jugador.getCoordenadaY());
        assertEquals(19, jugador.getCoordenadaX());
    }

    @Test
    public void test09JugadorConMaterialArribaSeMueveHaciaArribaYNoSeDesplaza() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(3, 7, jugador);

        jugador.moverArriba(mapa);
        mapa.removerJugador(3, 7);

        assertEquals(3, jugador.getCoordenadaY());
        assertEquals(7, jugador.getCoordenadaX());
    }

    @Test
    public void test10JugadorConMaterialAbajoSeMueveHaciaAbajoYNoSeDesplaza() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(2, 17, jugador);

        jugador.moverAbajo(mapa);
        mapa.removerJugador(2, 17);

        assertEquals(2, jugador.getCoordenadaY());
        assertEquals(17, jugador.getCoordenadaX());
    }

    @Test
    public void test11JugadorConMaterialAIzquierdaSeMueveHaciaIzquierdaYNoSeDesplaza() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(9, 7, jugador);

        jugador.moverIzquierda(mapa);
        mapa.removerJugador(9, 7);

        assertEquals(9, jugador.getCoordenadaY());
        assertEquals(7, jugador.getCoordenadaX());
    }

    @Test
    public void test12JugadorConMaterialADerechaSeMueveHaciaDerechaYNoSeDesplaza() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(15, 2, jugador);

        jugador.moverDerecha(mapa);
        mapa.removerJugador(15, 2);

        assertEquals(15, jugador.getCoordenadaY());
        assertEquals(2, jugador.getCoordenadaX());
    }

    @Test
    public void test13JugadorEnBordeSuperiorIzquierdoNoPuedeDesplazarseParaArribaOIzquierda() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(0, 0, jugador);

        jugador.moverArriba(mapa);
        jugador.moverIzquierda(mapa);
        mapa.removerJugador(0, 0);

        assertEquals(0, jugador.getCoordenadaY());
        assertEquals(0, jugador.getCoordenadaX());
    }

    @Test
    public void test14JugadorEnBordeSuperiorDerechoNoPuedeDesplazarseParaArribaODerecha() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(0, ancho - 1, jugador);

        jugador.moverArriba(mapa);
        jugador.moverDerecha(mapa);
        mapa.removerJugador(0, ancho - 1);

        assertEquals(0, jugador.getCoordenadaY());
        assertEquals(ancho - 1, jugador.getCoordenadaX());
    }

    @Test
    public void test15JugadorEnBordeInferiorIzquierdoNoPuedeDesplazarseParaAbajoOIzquierda() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(largo - 1, 0, jugador);

        jugador.moverAbajo(mapa);
        jugador.moverIzquierda(mapa);
        mapa.removerJugador(largo - 1, 0);

        assertEquals(largo - 1, jugador.getCoordenadaY());
        assertEquals(0, jugador.getCoordenadaX());
    }

    @Test
    public void test16JugadorEnBordeInferiorDerechoNoPuedeDesplazarseParaAbajoODerecha() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(largo - 1, ancho - 1, jugador);

        jugador.moverAbajo(mapa);
        jugador.moverDerecha(mapa);
        mapa.removerJugador(largo - 1, ancho - 1);

        assertEquals(largo - 1, jugador.getCoordenadaY());
        assertEquals(ancho - 1, jugador.getCoordenadaX());
    }
}

