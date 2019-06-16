package algocraft.jugador;

import algocraft.mapa.Mapa;
import algocraft.material.Piedra;
import algocraft.utilidades.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MovimientoJugadorTests {

    private static final int LARGO = 20;
    private static final int ANCHO = 20;
    Direccion direccion = new Direccion();

    // Test de movimiento con el VectorPosicion2I //
    @Test
    public void test01JugadorEnElOrigenSeMueveHaciaAbajo() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.abajo());

        assert(jugador.getPosicion().esIgualA(new VectorPosicion2I(0, 1)));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(0, 1)));

        mapa.resetear();
    }

    @Test
    public void test02JugadorEnElOrigenSeMueveHaciaLaDerecha() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.derecha());

        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(1, 0)));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(1, 0)));

        mapa.resetear();
    }

    @Test
    public void test03JugadorEnElOrigenNoSeMueveHaciaLaIzquierda() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.izquierda());

        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(0, 0)));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(0, 0)));

        mapa.resetear();
    }

    @Test
    public void test04JugadorEnElOrigenNoSeMueveHaciaArriba() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.arriba());

        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(0, 0)));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(0, 0)));

        mapa.resetear();
    }

    @Test
    public void test05JugadorNoSeMueveSobreUnCasilleroOcupado() {
        Jugador jugador = new Jugador(new VectorPosicion2I(1, 1));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        // Rodeo al jugador de piedras
        mapa.insertarMaterial(new Piedra(), new VectorPosicion2I(0,0));
        mapa.insertarMaterial(new Piedra(), new VectorPosicion2I(1,0));
        mapa.insertarMaterial(new Piedra(), new VectorPosicion2I(2,0));
        mapa.insertarMaterial(new Piedra(), new VectorPosicion2I(0,1));
        mapa.insertarMaterial(new Piedra(), new VectorPosicion2I(0,2));
        mapa.insertarMaterial(new Piedra(), new VectorPosicion2I(1,2));
        mapa.insertarMaterial(new Piedra(), new VectorPosicion2I(2,2));
        mapa.insertarMaterial(new Piedra(), new VectorPosicion2I(2,1));

        jugador.mover(mapa, direccion.arriba());
        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(1, 1)));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(1, 1)));
        jugador.mover(mapa, direccion.abajo());
        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(1, 1)));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(1, 1)));
        jugador.mover(mapa, direccion.derecha());
        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(1, 1)));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(1, 1)));
        jugador.mover(mapa, direccion.izquierda());
        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(1, 1)));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(1, 1)));

        // Al final los saco porque es un singleton
        mapa.resetear();
    }

    @Test
    public void test06JugadorEnBordeSuperiorSeMueveHaciaArribaYNoSeDesplaza() {
        VectorPosicion2I posicionInicial = new VectorPosicion2I(3,0);
        Jugador jugador = new Jugador(posicionInicial);

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.arriba());

        assert(jugador.getPosicion().esIgualA(posicionInicial));
        assertEquals(jugador, mapa.obtenerJugador(posicionInicial));

        mapa.resetear();
    }

    @Test
    public void test07JugadorEnBordeInferiorSeMueveHaciaAbajoYNoSeDesplaza() {
        VectorPosicion2I posicionInicial = new VectorPosicion2I(3,LARGO - 1);
        Jugador jugador = new Jugador(posicionInicial);

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.abajo());

        assert(jugador.getPosicion().esIgualA(posicionInicial));
        assertEquals(jugador, mapa.obtenerJugador(posicionInicial));

        mapa.resetear();
    }

    @Test
    public void test08JugadorEnBordeIzquierdoSeMueveHaciaIzquierdaYNoSeDesplaza() {
        VectorPosicion2I posicionInicial = new VectorPosicion2I(0,3);
        Jugador jugador = new Jugador(posicionInicial);

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.izquierda());

        assert(jugador.getPosicion().esIgualA(posicionInicial));
        assertEquals(jugador, mapa.obtenerJugador(posicionInicial));

        mapa.resetear();
    }

    @Test
    public void test09JugadorEnBordeDerechoSeMueveHaciaDerechaYNoSeDesplaza() {
        VectorPosicion2I posicionInicial = new VectorPosicion2I(ANCHO - 1,3);
        Jugador jugador = new Jugador(posicionInicial);

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.derecha());

        assert(jugador.getPosicion().esIgualA(posicionInicial));
        assertEquals(jugador, mapa.obtenerJugador(posicionInicial));

        mapa.resetear();
    }


    @Test
    public void test10JugadorEnBordeSuperiorDerechoNoPuedeDesplazarseParaArribaODerecha() {
        VectorPosicion2I posicionInicial = new VectorPosicion2I(ANCHO - 1,0);
        Jugador jugador = new Jugador(posicionInicial);

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.arriba());
        jugador.mover(mapa, direccion.derecha());

        assert(jugador.getPosicion().esIgualA(posicionInicial));
        assertEquals(jugador, mapa.obtenerJugador(posicionInicial));

        mapa.removerJugador(jugador.getPosicion());
    }

    @Test
    public void test11JugadorEnBordeInferiorIzquierdoNoPuedeDesplazarseParaAbajoOIzquierda() {
        VectorPosicion2I posicionInicial = new VectorPosicion2I(0, LARGO - 1);
        Jugador jugador = new Jugador(posicionInicial);

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.abajo());
        jugador.mover(mapa, direccion.izquierda());

        assert (jugador.getPosicion().esIgualA(posicionInicial));
        assertEquals(jugador, mapa.obtenerJugador(posicionInicial));

        mapa.resetear();
    }

    @Test
    public void test12JugadorEnBordeInferiorDerechoNoPuedeDesplazarseParaAbajoODerecha() {
        VectorPosicion2I posicionInicial = new VectorPosicion2I(ANCHO - 1, LARGO - 1);
        Jugador jugador = new Jugador(posicionInicial);

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, direccion.abajo());
        jugador.mover(mapa, direccion.derecha());

        assert (jugador.getPosicion().esIgualA(posicionInicial));
        assertEquals(jugador, mapa.obtenerJugador(posicionInicial));

        mapa.resetear();
    }
}

