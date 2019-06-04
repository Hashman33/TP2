package fiuba.algo3.algocraft;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class JugadorTest {

    @Test
    public void test01JugadorIniciaConHachaDeMadera() {

        Jugador jugador = new Jugador();

        assert(jugador.herramientaEquipada() instanceof Hacha);
        assert(((Hacha) jugador.herramientaEquipada()).material instanceof HerramientaMadera);
    }
}