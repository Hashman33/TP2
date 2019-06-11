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
    public void test02JugadorSeInsertaEnElMapaCorrectamente() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador);
        int coordX = jugador.getCoordenadaX();
        int coordY = jugador.getCoordenadaY();

        assert(coordX >= 0 && coordX < 20 && coordY >= 0 && coordY < 20 );
    }

    @Test
    public void test03JugadorSeMueveHaciaArribaSiLaCeldaEstaVacia() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador);
        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        int coordenadaYFinal = coordenadaY;
        if (mapa.getTablero()[coordenadaY - 1][coordenadaX].estaVacia()) coordenadaYFinal --;
        jugador.moverArriba(mapa);

        assertEquals(coordenadaYFinal, jugador.getCoordenadaY());
        assertEquals(coordenadaX, jugador.getCoordenadaX());
    }

    @Test
    public void test04JugadorSeMueveHaciaAbajoSiLaCeldaEstaVacia() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador);
        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        int coordenadaYFinal = coordenadaY;
        if (mapa.getTablero()[coordenadaY + 1][coordenadaX].estaVacia()) coordenadaYFinal ++;
        jugador.moverAbajo(mapa);

        assertEquals(coordenadaYFinal, jugador.getCoordenadaY());
        assertEquals(coordenadaX, jugador.getCoordenadaX());
    }

    @Test
    public void test05JugadorSeMueveHaciaLaIzquierdaSiLaCeldaEstaVacia() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador);
        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        int coordenadaXFinal = coordenadaX;
        if (mapa.getTablero()[coordenadaY][coordenadaX - 1].estaVacia()) coordenadaXFinal --;
        jugador.moverIzquierda(mapa);

        assertEquals(coordenadaXFinal, jugador.getCoordenadaX());
        assertEquals(coordenadaY, jugador.getCoordenadaY());
    }

    @Test
    public void test06JugadorSeMueveHaciaLaDerechaSiLaCeldaEstaVacia() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador);
        int coordenadaX = jugador.getCoordenadaX();
        int coordenadaY = jugador.getCoordenadaY();

        int coordenadaXFinal = coordenadaX;
        if (mapa.getTablero()[coordenadaY][coordenadaX + 1].estaVacia()) coordenadaXFinal ++;
        jugador.moverDerecha(mapa);

        assertEquals(coordenadaXFinal, jugador.getCoordenadaX());
        assertEquals(coordenadaY, jugador.getCoordenadaY());
    }
}