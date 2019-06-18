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

        jugador.equipar(new Pico(new HerramientaMadera()));
        jugador.usarHerramienta(mapa);
        assertEquals(piedra.getDurabilidadActual(), piedra.getDurabilidadInicial() - 2);

        mapa.resetear();
    }

    @Test
    public void test03JugadorDesgastaMetalConPicoDePiedra() {
        //Inicia justo abajo del Metal
        Jugador jugador = new Jugador(new VectorPosicion2I(7, 3));

        Mapa mapa = Mapa.obtenerInstancia();
        Material metal = mapa.obtenerMaterial(new VectorPosicion2I(7, 2));
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.equipar(new Pico(new HerramientaPiedra()));
        jugador.usarHerramienta(mapa);
        assertEquals(metal.getDurabilidadActual(), metal.getDurabilidadInicial() - 4);

        mapa.resetear();
    }

    @Test
    public void test04JugadorDesgastaDiamanteConPicoFino() {
        //Inicia justo abajo del Diamante
        Jugador jugador = new Jugador(new VectorPosicion2I(17, 6));

        Mapa mapa = Mapa.obtenerInstancia();
        Material diamante = mapa.obtenerMaterial(new VectorPosicion2I(17, 5));
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.usarHerramienta(mapa);
        assertEquals(diamante.getDurabilidadActual(), diamante.getDurabilidadInicial());

        jugador.equipar(new PicoFino());
        jugador.usarHerramienta(mapa);
        assertEquals(diamante.getDurabilidadActual(), diamante.getDurabilidadInicial() - 20);

        mapa.resetear();
    }

    @Test
    public void test05JugadorDesgastaMaderaHastaObtenerloYElMaterialDesapareceDelMapa() {
        //Inicia justo abajo de la Madera
        Jugador jugador = new Jugador(new VectorPosicion2I(3, 19));

        Mapa mapa = Mapa.obtenerInstancia();
        Material madera = mapa.obtenerMaterial(new VectorPosicion2I(3, 18));
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.equipar(new Hacha(new HerramientaMetal()));
        jugador.usarHerramienta(mapa);
        assertEquals(jugador.inventario.pertenece(madera), true);
        assertEquals(mapa.obtenerMaterial(new VectorPosicion2I(3, 18)), null);

        mapa.resetear();
    }

    @Test
    public void test06JugadorDesgastaPiedraHastaObtenerloYElMaterialDesapareceDelMapa() {
        //Inicia justo abajo de la Piedra
        Jugador jugador = new Jugador(new VectorPosicion2I(7, 3));

        Mapa mapa = Mapa.obtenerInstancia();
        Material piedra = mapa.obtenerMaterial(new VectorPosicion2I(7, 2));
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.equipar(new Pico(new HerramientaMetal()));
        for (int i = 0; i < 5; i++) jugador.usarHerramienta(mapa);

        assertEquals(jugador.inventario.pertenece(piedra), true);
        assertEquals(mapa.obtenerMaterial(new VectorPosicion2I(7, 3)), null);

        mapa.resetear();
    }

    @Test
    public void test07JugadorDesgastaMetalHastaObtenerloYElMaterialDesapareceDelMapa() {
        //Inicia justo abajo del Metal
        Jugador jugador = new Jugador(new VectorPosicion2I(3, 12));

        Mapa mapa = Mapa.obtenerInstancia();
        Material metal = mapa.obtenerMaterial(new VectorPosicion2I(3, 11));
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.equipar(new Pico(new HerramientaMetal()));
        for (int i = 0; i < 3; i++) jugador.usarHerramienta(mapa);

        assertEquals(jugador.inventario.pertenece(metal), true);
        assertEquals(mapa.obtenerMaterial(new VectorPosicion2I(3, 11)), null);

        mapa.resetear();
    }

    @Test
    public void test08JugadorDesgastaDiamanteHastaObtenerloYElMaterialDesapareceDelMapa() {
        //Inicia justo abajo del Diamante
        Jugador jugador = new Jugador(new VectorPosicion2I(17, 6));

        Mapa mapa = Mapa.obtenerInstancia();
        Material diamante = mapa.obtenerMaterial(new VectorPosicion2I(17, 5));
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.equipar(new PicoFino());
        for (int i = 0; i < 5; i++) jugador.usarHerramienta(mapa);

        assertEquals(jugador.inventario.pertenece(diamante), true);
        assertEquals(mapa.obtenerMaterial(new VectorPosicion2I(17, 5)), null);

        mapa.resetear();
    }

    @Test
    public void test09JugadorUsaHachaDeMaderaHastaRomperlaSeQuitaDelInventarioYQuedaSuManoEquipada() {
        //Inicia justo abajo del Diamante
        Jugador jugador = new Jugador(new VectorPosicion2I(17, 6));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        Herramienta hachaMadera = jugador.herramientaEquipada();
        for (int i = 0; i < 51; i++) jugador.usarHerramienta(mapa);

        assertEquals(jugador.inventario.pertenece(hachaMadera), false);
        assert(jugador.herramientaEquipada() instanceof Mano);

        mapa.resetear();
    }

    @Test
    public void test10JugadorUsaHachaDePiedraHastaRomperlaSeQuitaDelInventarioYQuedaSuManoEquipada() {
        //Inicia justo abajo del Diamante
        Jugador jugador = new Jugador(new VectorPosicion2I(17, 6));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        Hacha hachaPiedra = new Hacha(new HerramientaPiedra());
        jugador.equipar(hachaPiedra);
        jugador.agregar(hachaPiedra);
        for (int i = 0; i < 41; i++) jugador.usarHerramienta(mapa);

        assertEquals(jugador.inventario.pertenece(hachaPiedra), false);
        assert(jugador.herramientaEquipada() instanceof Mano);

        mapa.resetear();
    }

    @Test
    public void test11JugadorUsaHachaDeMetalHastaRomperlaSeQuitaDelInventarioYQuedaSuManoEquipada() {
        //Inicia justo abajo del Diamante
        Jugador jugador = new Jugador(new VectorPosicion2I(17, 6));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        Hacha hachaMetal = new Hacha(new HerramientaMetal());
        jugador.equipar(hachaMetal);
        jugador.agregar(hachaMetal);
        for (int i = 0; i < 81; i++) jugador.usarHerramienta(mapa);

        assertEquals(jugador.inventario.pertenece(hachaMetal), false);
        assert(jugador.herramientaEquipada() instanceof Mano);

        mapa.resetear();
    }

    @Test
    public void test11JugadorUsaPicoDeMaderaHastaRomperloSeQuitaDelInventarioYQuedaSuManoEquipada() {
        //Inicia justo abajo del Diamante
        Jugador jugador = new Jugador(new VectorPosicion2I(17, 6));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        Pico picoMadera = new Pico(new HerramientaMadera());
        jugador.equipar(picoMadera);
        jugador.agregar(picoMadera);
        for (int i = 0; i < 51; i++) jugador.usarHerramienta(mapa);

        assertEquals(jugador.inventario.pertenece(picoMadera), false);
        assert(jugador.herramientaEquipada() instanceof Mano);

        mapa.resetear();
    }

    @Test
    public void test12JugadorUsaPicoDePiedraHastaRomperloSeQuitaDelInventarioYQuedaSuManoEquipada() {
        //Inicia justo abajo del Diamante
        Jugador jugador = new Jugador(new VectorPosicion2I(17, 6));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        Pico picoPiedra = new Pico(new HerramientaPiedra());
        jugador.equipar(picoPiedra);
        jugador.agregar(picoPiedra);
        for (int i = 0; i < 77; i++) jugador.usarHerramienta(mapa);

        assertEquals(jugador.inventario.pertenece(picoPiedra), false);
        assert(jugador.herramientaEquipada() instanceof Mano);

        mapa.resetear();
    }

    @Test
    public void test13JugadorUsaPicoDeMetalHastaRomperloSeQuitaDelInventarioYQuedaSuManoEquipada() {
        //Inicia justo abajo del Diamante
        Jugador jugador = new Jugador(new VectorPosicion2I(17, 6));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        Pico picoMetal = new Pico(new HerramientaMetal());
        jugador.equipar(picoMetal);
        jugador.agregar(picoMetal);
        for (int i = 0; i < 11; i++) jugador.usarHerramienta(mapa);

        assertEquals(jugador.inventario.pertenece(picoMetal), false);
        assert(jugador.herramientaEquipada() instanceof Mano);

        mapa.resetear();
    }

    // PICOFINO NO SE ROMPE

}
