package algocraft.jugador;

import algocraft.herramienta.*;
import algocraft.mapa.*;

import algocraft.utilidades.VectorPosicion2I;
import org.junit.jupiter.api.Test;


public class JugadorTests {


    @Test
    public void test01JugadorIniciaConHachaDeMadera() {

        Jugador jugador = new Jugador();

        assert (jugador.herramientaEquipada() instanceof Hacha);
        assert (((Hacha) jugador.herramientaEquipada()).getMaterial() instanceof HerramientaMadera);
    }

    @Test
    public void test02JugadorSeInsertaEnElOrigenDelMapaCorrectamente() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(0, 0)));

        mapa.removerJugador(jugador.getPosicion());
    }

    @Test
    public void test03JugadorSeInsertaEnElMapaEnPosicionDefinidaCorrectamente() {
        Jugador jugador = new Jugador(new VectorPosicion2I(14, 14));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(14, 14)));

        mapa.removerJugador(jugador.getPosicion());
    }
}