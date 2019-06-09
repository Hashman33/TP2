package algocraft.material;

import algocraft.herramienta.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        PicoFino picoFinoPiedra = new PicoFino();
        Metal bloqueMetal = new Metal();

        picoFinoPiedra.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial() - picoFinoPiedra.getFuerza(), bloqueMetal.getDurabilidadActual());
    }
}
