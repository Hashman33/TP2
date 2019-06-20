package algocraft.juego.material;

import algocraft.juego.jugador.herramienta.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MetalTests {

    @Test
    public void test00SeCreaMetalConUnaDurabilidad() {

        Metal bloqueMetal = new Metal();

        assertEquals(50, bloqueMetal.getDurabilidadActual());
    }

    @Test
    public void test01SeUsaHachaDeMaderaContraMetalNoReduceDurabilidad() {
        Hacha hachaMadera = new Hacha(new HerramientaMadera());
        Metal bloqueMetal = new Metal();

        hachaMadera.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial(), bloqueMetal.getDurabilidadActual());
    }

    @Test
    public void test02SeUsaHachaDePiedraContraMetalNoReduceDurabilidad() {

        Hacha hachaPiedra = new Hacha(new HerramientaPiedra());
        Metal bloqueMetal = new Metal();

        hachaPiedra.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial(), bloqueMetal.getDurabilidadActual());
    }

    @Test
    public void test03SeUsaHachaDeMetalContraMetalNoReduceDurabilidad() {
        Hacha hachaMetal = new Hacha(new HerramientaMetal());
        Metal bloqueMetal = new Metal();

        hachaMetal.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial(), bloqueMetal.getDurabilidadActual());
    }

    @Test
    public void test04SeUsaPicoDeMaderaContraMetalNoReduceDurabilidad() {
        Pico picoMadera = new Pico(new HerramientaMadera());
        Metal bloqueMetal = new Metal();

        picoMadera.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial(), bloqueMetal.getDurabilidadActual());
    }

    @Test
    public void test05SeUsaPicoDePiedraContraMetalSeReduceDurabilidad() {
        Pico picoPiedra = new Pico(new HerramientaPiedra());
        Metal bloqueMetal = new Metal();

        picoPiedra.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial() - picoPiedra.getFuerza(), bloqueMetal.getDurabilidadActual());
    }

    @Test
    public void test06SeUsaPicoDeMetalContraMetalSeReduceDurabilidad() {
        Pico picoMetal = new Pico(new HerramientaMetal());
        Metal bloqueMetal = new Metal();

        picoMetal.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial() - picoMetal.getFuerza(), bloqueMetal.getDurabilidadActual());
    }

    @Test
    public void test07SeUsaPicoFinoContraMetalSeReduceDurabilidad() {
        PicoFino picoFino = new PicoFino();
        Metal bloqueMetal = new Metal();

        picoFino.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial() - picoFino.getFuerza(), bloqueMetal.getDurabilidadActual());
    }

    @Test
    public void test08SeUsaManoContraMetalNoReduceDurabilidad() {
        Mano mano = new Mano();
        Metal bloqueMetal = new Metal();

        mano.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial(), bloqueMetal.getDurabilidadActual());
    }

    @Test
    public void test09SeUsaPicoFinoEnMaterialMetalTresVecesYLanzaMaterialDestruidoException() {
        PicoFino picoFino = new PicoFino();
        Metal bloqueMetal = new Metal();

        picoFino.desgastar(bloqueMetal);
        picoFino.desgastar(bloqueMetal);

        assertThrows(MaterialDestruidoException.class,
                ()->{ picoFino.desgastar(bloqueMetal);});
    }

    @Test
    public void test10SeUsaPicoDeMetalEnMaterialMetalCincoVecesYLanzaMaterialDestruidoException() {
        Pico picoMetal = new Pico(new HerramientaMetal());
        Metal bloqueMetal = new Metal();

        for (int i = 0; i < 4; i++) picoMetal.desgastar(bloqueMetal);

        assertThrows(MaterialDestruidoException.class,
                ()->{ picoMetal.desgastar(bloqueMetal);});
    }

    @Test
    public void test11SeUsaPicoDePiedraEnMaterialMetalTreceVecesYLanzaMaterialDestruidoException() {
        Pico picoPiedra = new Pico(new HerramientaPiedra());
        Metal bloqueMetal = new Metal();

        for (int i = 0; i < 12; i++) picoPiedra.desgastar(bloqueMetal);

        assertThrows(MaterialDestruidoException.class,
                ()->{ picoPiedra.desgastar(bloqueMetal);});
    }
}
