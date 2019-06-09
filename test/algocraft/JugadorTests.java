package algocraft;

import algocraft.herramienta.*;

import algocraft.jugador.Jugador;
import org.junit.jupiter.api.Test;


public class JugadorTests {

    @Test
    public void test01JugadorIniciaConHachaDeMadera() {

        Jugador jugador = new Jugador();

        assert(jugador.herramientaEquipada() instanceof Hacha);
        assert(((Hacha) jugador.herramientaEquipada()).getMaterial() instanceof HerramientaMadera);
    }
}