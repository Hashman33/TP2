package algocraft.juego.jugador;

import algocraft.juego.mapa.Mapa;
import algocraft.utilidades.Direccion;
import algocraft.utilidades.VectorPosicion2I;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiradaTests {

    private final int LARGO = 20;
    private final int ANCHO = 20;
    Direccion direccion = new Direccion();

    @Test
    public void test01JugadorSeCreaConMiradaHaciaArriba() {
        Jugador jugador = new Jugador();

        assert(jugador.getMirada().esIgualA(direccion.arriba()));
    }

    @Test
    public void test02JugadorSeMueveArribaYQuedaMirandoHaciaArriba() {
        Jugador jugador = new Jugador(new VectorPosicion2I(14,14));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.arriba());

        assert(jugador.getMirada().esIgualA(direccion.arriba()));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(14,13)));

        mapa.resetear();
    }

    @Test
    public void test03JugadorSeMueveAbajoYQuedaMirandoHaciaAbajo() {
        Jugador jugador = new Jugador(new VectorPosicion2I(14,14));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.abajo());

        assert(jugador.getMirada().esIgualA(direccion.abajo()));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(14,15)));

        mapa.resetear();
    }

    @Test
    public void test04JugadorSeMueveIzquierdaYQuedaMirandoHaciaIzquierda() {
        Jugador jugador = new Jugador(new VectorPosicion2I(14,14));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.izquierda());

        assert(jugador.getMirada().esIgualA(direccion.izquierda()));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(13,14)));

        mapa.resetear();
    }

    @Test
    public void test05JugadorSeMueveDerechaYQuedaMirandoHaciaDerecha() {
        Jugador jugador = new Jugador(new VectorPosicion2I(14,14));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.derecha());

        assert(jugador.getMirada().esIgualA(direccion.derecha()));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(15,14)));

        mapa.resetear();
    }

    @Test
    public void test06JugadorEnBordeSupierorIzquierdoNoPuedeIrALaIzquierdaPeroQuedaMirandoAIzquierda() {
        Jugador jugador = new Jugador(new VectorPosicion2I(0,0));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.izquierda());

        assert(jugador.getMirada().esIgualA(direccion.izquierda()));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(0,0)));

        mapa.resetear();
    }

    @Test
    public void test07JugadorEnBordeSupierorIzquierdoNoPuedeIrArribaPeroQuedaMirandoArriba() {
        Jugador jugador = new Jugador(new VectorPosicion2I(0,0));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.arriba());

        assert(jugador.getMirada().esIgualA(direccion.arriba()));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(0,0)));

        mapa.resetear();
    }

    @Test
    public void test08JugadorEnBordeInferiorDerechoNoPuedeIrALaDerechaPeroQuedaMirandoADerecha() {
        Jugador jugador = new Jugador(new VectorPosicion2I(ANCHO - 1,LARGO -1));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.derecha());

        assert(jugador.getMirada().esIgualA(direccion.derecha()));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(ANCHO - 1,LARGO - 1)));

        mapa.resetear();
    }

    @Test
    public void test09JugadorEnBordeInferiorDerechoNoPuedeIrAbajoPeroQuedaMirandoAbajo() {
        Jugador jugador = new Jugador(new VectorPosicion2I(ANCHO - 1,LARGO -1));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.abajo());

        assert(jugador.getMirada().esIgualA(direccion.abajo()));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(ANCHO - 1,LARGO - 1)));

        mapa.resetear();
    }
}
