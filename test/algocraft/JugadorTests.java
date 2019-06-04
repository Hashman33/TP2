package algocraft;

import algocraft.herramienta.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class JugadorTests {

    @Test
    public void test01JugadorIniciaConHachaDeMadera() {

        Jugador jugador = new Jugador();

        assert(jugador.herramientaEquipada() instanceof Hacha);
        assert(((Hacha) jugador.herramientaEquipada()).getMaterial() instanceof HerramientaMadera);
    }
}