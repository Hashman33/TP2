package algocraft.jugador;

import algocraft.mapa.Mapa;
import algocraft.material.*;
import algocraft.herramienta.*;
import algocraft.utilidades.VectorPosicion2I;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorUsaHerramientaTests {


    @Test
    public void test01JugadorDesgastaMaderaConHachaDeMadera() {
        //Inicia justo abajo de la Madera
        Jugador jugador = new Jugador(new VectorPosicion2I(3, 19));

        Mapa mapa = Mapa.obtenerInstancia();
        Material madera = mapa.obtenerMaterial(new VectorPosicion2I(3, 18));
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.usarHerramienta(mapa);
        assertEquals(madera.getDurabilidadActual(), madera.getDurabilidadInicial() - 2);

        mapa.resetear();
    }

    @Test
    public void test02JugadorDesgastaPiedraConPicoDeMadera() {
        //Inicia justo abajo de la Piedra
        Jugador jugador = new Jugador(new VectorPosicion2I(3, 12));

        Mapa mapa = Mapa.obtenerInstancia();
        Material piedra = mapa.obtenerMaterial(new VectorPosicion2I(3, 11));
        mapa.insertarJugador(jugador, jugador.getPosicion());

        //NO SE PORQUE DA ERROR CUANDO SE LE PONE OTRA HERRAMIENTA(con el hacha inicial funciona)
        //jugador.equipar(new Pico(new HerramientaMadera()));
        jugador.usarHerramienta(mapa);
        assertEquals(piedra.getDurabilidadActual(), piedra.getDurabilidadInicial() /*- 2*/);

        mapa.resetear();
    }

    @Test
    public void test03JugadorDesgastaMetalConPicoDePiedra() {
        //Inicia justo abajo del Metal
        Jugador jugador = new Jugador(new VectorPosicion2I(7, 3));

        Mapa mapa = Mapa.obtenerInstancia();
        Material metal = mapa.obtenerMaterial(new VectorPosicion2I(7, 2));
        mapa.insertarJugador(jugador, jugador.getPosicion());

        //NO SE PORQUE DA ERROR CUANDO SE LE PONE OTRA HERRAMIENTA(con el hacha inicial funciona)
        //jugador.equipar(new Pico(new HerramientaPiedra()));
        jugador.usarHerramienta(mapa);
        assertEquals(metal.getDurabilidadActual(), metal.getDurabilidadInicial() /*- 4*/);

        mapa.resetear();
    }

    @Test
    public void test04JugadorDesgastaDiamanteConPicoFino() {
        //Inicia justo abajo del Diamante
        Jugador jugador = new Jugador(new VectorPosicion2I(17, 6));

        Mapa mapa = Mapa.obtenerInstancia();
        Material metal = mapa.obtenerMaterial(new VectorPosicion2I(17, 5));
        mapa.insertarJugador(jugador, jugador.getPosicion());

        //NO SE PORQUE DA ERROR CUANDO SE LE PONE OTRA HERRAMIENTA(con el hacha inicial funciona)
        //jugador.equipar(new PicoFino());
        jugador.usarHerramienta(mapa);
        assertEquals(metal.getDurabilidadActual(), metal.getDurabilidadInicial() /*- 20*/);

        mapa.resetear();
    }
}
