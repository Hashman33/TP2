package algocraft.jugador;

import algocraft.herramienta.*;
import algocraft.mapa.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class JugadorTests {

    Mapa mapa = Mapa.obtenerInstancia();
    private int largo = mapa.getLargo();
    private int ancho = mapa.getAncho();

    @Test
    public void test01JugadorIniciaConHachaDeMadera() {

        Jugador jugador = new Jugador();

        assert(jugador.herramientaEquipada() instanceof Hacha);
        assert(((Hacha) jugador.herramientaEquipada()).getMaterial() instanceof HerramientaMadera);
    }

    @Test
    public void test02JugadorSeInsertaEnElMapaEnPosicionRandomCorrectamente() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador);
        int coordX = jugador.getCoordenadaX();
        int coordY = jugador.getCoordenadaY();
        mapa.removerJugador(coordY, coordX);

        assert(coordX >= 0 && coordX < 20 && coordY >= 0 && coordY < 20 );
    }

    @Test
    public void test03JugadorSeInsertaEnElMapaEnPosicionDefinidaCorrectamente() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(14, 14, jugador);
        int coordX = jugador.getCoordenadaX();
        int coordY = jugador.getCoordenadaY();
        mapa.removerJugador(14, 14);

        assert(coordX == 14 && coordY == 14);
    }

    @Test
    public void test04JugadorEnPosicionRandomSeMueveHaciaArribaSiLaCeldaEstaVaciaYNoEstaEnUnBorde() {
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
    public void test05JugadorEnPosicionRandomSeMueveHaciaAbajoSiLaCeldaEstaVaciaYNoEstaEnUnBorde() {
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
    public void test06JugadorEnPosicionRandomSeMueveHaciaIzquierdaSiLaCeldaEstaVaciaYNoEstaEnUnBorde() {
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
    public void test07JugadorEnPosicionRandomSeMueveHaciaArribaSiLaCeldaEstaVaciaYNoEstaEnUnBorde() {
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
}