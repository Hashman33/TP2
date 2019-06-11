package algocraft.jugador;

import algocraft.herramienta.*;
import algocraft.mapa.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class JugadorTests {

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
        mapa.getTablero()[coordX][coordY].removerJugador();

        assert(coordX >= 0 && coordX < 20 && coordY >= 0 && coordY < 20 );
    }

    @Test
    public void test03JugadorSeInsertaEnElMapaEnPosicionDefinidaCorrectamente() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, 14, 14);
        int coordX = jugador.getCoordenadaX();
        int coordY = jugador.getCoordenadaY();
        mapa.getTablero()[coordX][coordY].removerJugador();

        assert(coordX == 14 && coordY == 14);
    }

    @Test
    public void test04JugadorSeMueveHaciaArribaSiLaCeldaEstaVacia() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador);
        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        int coordenadaYFinal = coordenadaY;
        if (mapa.getTablero()[coordenadaY - 1][coordenadaX].estaVacia()) coordenadaYFinal --;
        jugador.moverArriba(mapa);
        mapa.getTablero()[coordenadaX][coordenadaY].removerJugador();

        assertEquals(coordenadaYFinal, jugador.getCoordenadaY());
        assertEquals(coordenadaX, jugador.getCoordenadaX());
    }

    @Test
    public void test05JugadorSeMueveHaciaAbajoSiLaCeldaEstaVacia() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador);
        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        int coordenadaYFinal = coordenadaY;
        if (mapa.getTablero()[coordenadaY + 1][coordenadaX].estaVacia()) coordenadaYFinal ++;
        jugador.moverAbajo(mapa);
        mapa.getTablero()[coordenadaX][coordenadaY].removerJugador();

        assertEquals(coordenadaYFinal, jugador.getCoordenadaY());
        assertEquals(coordenadaX, jugador.getCoordenadaX());
    }

    @Test
    public void test06JugadorSeMueveHaciaLaIzquierdaSiLaCeldaEstaVacia() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador);
        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        int coordenadaXFinal = coordenadaX;
        if (mapa.getTablero()[coordenadaY][coordenadaX - 1].estaVacia()) coordenadaXFinal --;
        jugador.moverIzquierda(mapa);
        mapa.getTablero()[coordenadaX][coordenadaY].removerJugador();

        assertEquals(coordenadaXFinal, jugador.getCoordenadaX());
        assertEquals(coordenadaY, jugador.getCoordenadaY());
    }

    @Test
    public void test07JugadorSeMueveHaciaLaDerechaSiLaCeldaEstaVacia() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador);
        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        int coordenadaXFinal = coordenadaX;
        if (mapa.getTablero()[coordenadaY][coordenadaX + 1].estaVacia()) coordenadaXFinal ++;
        jugador.moverDerecha(mapa);
        mapa.getTablero()[coordenadaX][coordenadaY].removerJugador();

        assertEquals(coordenadaXFinal, jugador.getCoordenadaX());
        assertEquals(coordenadaY, jugador.getCoordenadaY());
    }
}