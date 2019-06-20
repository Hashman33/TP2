package algocraft.juego.material;

import algocraft.juego.jugador.herramienta.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PiedraTests {

    @Test
    public void test00SeCreaPiedraConUnaDurabilidad() {

        Piedra bloquePiedra = new Piedra();

        assertEquals(30, bloquePiedra.getDurabilidadActual());
    }

    @Test
    public void test01SeUsaHachaDeMaderaContraPiedraNoReduceDurabilidad() {

        Hacha hachaMadera = new Hacha(new HerramientaMadera());
        Piedra bloquePiedra = new Piedra();

        hachaMadera.desgastar(bloquePiedra);

        assertEquals(bloquePiedra.getDurabilidadInicial(), bloquePiedra.getDurabilidadActual());
    }

    @Test
    public void test02SeUsaHachaDePiedraContraPiedraNoReduceDurabilidad() {

        Hacha hachaPiedra = new Hacha(new HerramientaPiedra());
        Piedra bloquePiedra = new Piedra();

        hachaPiedra.desgastar(bloquePiedra);

        assertEquals(bloquePiedra.getDurabilidadInicial(), bloquePiedra.getDurabilidadActual());
    }

    @Test
    public void test03SeUsaHachaDeMetalContraPiedraNoReduceDurabilidad() {

        Hacha hachaMetal = new Hacha(new HerramientaMetal());
        Piedra bloquePiedra = new Piedra();

        hachaMetal.desgastar(bloquePiedra);

        assertEquals(bloquePiedra.getDurabilidadInicial(), bloquePiedra.getDurabilidadActual());
    }

    @Test
    public void test04SeUsaPicoDeMaderaContraPiedraSeReduceDurabilidad() {

        Pico picoMadera = new Pico(new HerramientaMadera());
        Piedra bloquePiedra = new Piedra();

        picoMadera.desgastar(bloquePiedra);

        assertEquals(bloquePiedra.getDurabilidadInicial() - picoMadera.getFuerza(), bloquePiedra.getDurabilidadActual());
    }

    @Test
    public void test05SeUsaPicoDePiedraContraPiedraSeReduceDurabilidad() {

        Pico picoPiedra = new Pico(new HerramientaPiedra());
        Piedra bloquePiedra = new Piedra();

        picoPiedra.desgastar(bloquePiedra);

        assertEquals(bloquePiedra.getDurabilidadInicial() - picoPiedra.getFuerza(), bloquePiedra.getDurabilidadActual());
    }

    @Test
    public void test06SeUsaPicoDeMetalContraPiedraSeReduceDurabilidad() {
        Pico picoMetal = new Pico(new HerramientaMetal());
        Piedra bloquePiedra = new Piedra();

        picoMetal.desgastar(bloquePiedra);

        assertEquals(bloquePiedra.getDurabilidadInicial() - picoMetal.getFuerza(), bloquePiedra.getDurabilidadActual());
    }

    @Test
    public void test07SeUsaPicoFinoContraPiedraSeReduceDurabilidad() {
        PicoFino picoFinoPiedra = new PicoFino();
        Piedra bloquePiedra = new Piedra();

        picoFinoPiedra.desgastar(bloquePiedra);

        assertEquals(bloquePiedra.getDurabilidadInicial() - picoFinoPiedra.getFuerza(), bloquePiedra.getDurabilidadActual());
    }

    @Test
    public void test08SeUsaManoContraPiedraNoReduceDurabilidad() {
        Mano mano = new Mano();
        Piedra bloquePiedra = new Piedra();

        mano.desgastar(bloquePiedra);

        assertEquals(bloquePiedra.getDurabilidadInicial(), bloquePiedra.getDurabilidadActual());
    }

    @Test
    public void test09SeUsaPicoFinoEnMaterialPiedraDosVecesYLanzaMaterialDestruidoException() {
        PicoFino picoFino = new PicoFino();
        Piedra bloquePiedra = new Piedra();

        picoFino.desgastar(bloquePiedra);

        assertThrows(MaterialDestruidoException.class,
                ()->{ picoFino.desgastar(bloquePiedra);});
    }

    @Test
    public void test10SeUsaPicoDeMetalEnMaterialPiedraTresVecesYLanzaMaterialDestruidoException() {
        Pico picoMetal = new Pico(new HerramientaMetal());
        Piedra bloquePiedra = new Piedra();

        for (int i = 0; i < 2; i++) picoMetal.desgastar(bloquePiedra);

        assertThrows(MaterialDestruidoException.class,
                ()->{ picoMetal.desgastar(bloquePiedra);});
    }

    @Test
    public void test11SeUsaPicoDePiedraEnMaterialPiedraOchoVecesYLanzaMaterialDestruidoException() {
        Pico picoPiedra = new Pico(new HerramientaPiedra());
        Piedra bloquePiedra = new Piedra();

        for (int i = 0; i < 7; i++) picoPiedra.desgastar(bloquePiedra);

        assertThrows(MaterialDestruidoException.class,
                ()->{ picoPiedra.desgastar(bloquePiedra);});
    }

    @Test
    public void test12SeUsaPicoDeMaderaEnMaterialPiedraQuinceVecesYLanzaMaterialDestruidoException() {
        Pico picoMadera = new Pico(new HerramientaMadera());
        Piedra bloquePiedra = new Piedra();

        for (int i = 0; i < 14; i++) picoMadera.desgastar(bloquePiedra);

        assertThrows(MaterialDestruidoException.class,
                ()->{ picoMadera.desgastar(bloquePiedra);});
    }


}
