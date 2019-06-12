package algocraft.jugador;

import algocraft.herramienta.*;
import algocraft.mapa.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class JugadorTests {


    @Test
    public void test01JugadorIniciaConHachaDeMadera() {

        Jugador jugador = new Jugador();

        assert (jugador.herramientaEquipada() instanceof Hacha);
        assert (((Hacha) jugador.herramientaEquipada()).getMaterial() instanceof HerramientaMadera);
    }

    @Test
    public void test02JugadorSeInsertaEnElMapaEnPosicionRandomCorrectamente() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador);
        int coordX = jugador.getCoordenadaX();
        int coordY = jugador.getCoordenadaY();
        mapa.removerJugador(coordY, coordX);

        assert (coordX >= 0 && coordX < 20 && coordY >= 0 && coordY < 20);
    }

    @Test
    public void test03JugadorSeInsertaEnElMapaEnPosicionDefinidaCorrectamente() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(14, 14, jugador);
        int coordX = jugador.getCoordenadaX();
        int coordY = jugador.getCoordenadaY();
        mapa.removerJugador(14, 14);

        assert (coordX == 14 && coordY == 14);
    }
}