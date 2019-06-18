package algocraft.juego;

import algocraft.jugador.Jugador;
import algocraft.mapa.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JuegoTests {

    @Test
    public void test01JuegoSeIniciaCorrectamenteConUnJugadorEnElMapa() {
        Juego juego = new Juego();

        Mapa mapa = juego.getMapa();
        Jugador jugador = juego.getJugador();

        assertEquals(jugador, mapa.obtenerJugador(jugador.getPosicion()));

        mapa.resetear();
    }
}
