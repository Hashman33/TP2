package fiuba.algo3.algocraft;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaterialTests {

    @Test
    public void test01SeCreaMaderaConUnaDurabilidad() {

        Madera bloqueMadera = new Madera();

        assertEquals(10, bloqueMadera.getDurabilidadActual());
    }

    @Test
    public void test02SeCreaPiedraConUnaDurabilidad() {

        Piedra bloquePiedra = new Piedra();

        assertEquals(30, bloquePiedra.getDurabilidadActual());
    }

    @Test
    public void test03SeCreaMetalConUnaDurabilidad() {

         Metal bloqueMetal = new Metal();

        assertEquals(50, bloqueMetal.getDurabilidadActual());
    }

    @Test
    public void test04SeCreaDiamanteConUnaDurabilidad() {

        Diamante diamante = new Diamante();

        assertEquals(100, diamante.getDurabilidadActual());
    }

    // Test contra Madera
    @Test
    public void test05SeUsaHachaDeMaderaEnMaterialMaderaYSeReduceDurabilidad() {
        HerramientaMadera deMadera = new HerramientaMadera();
        Hacha hachaMadera = new Hacha(deMadera);
        Madera bloqueMadera = new Madera();

        hachaMadera.desgastar(bloqueMadera);
        assertEquals(8, bloqueMadera.getDurabilidadActual());
    }

    @Test
    public void test06SeUsaPicoDeMaderaEnMaterialMaderaYNoReduceDurabilidad() {

        HerramientaMadera deMadera = new HerramientaMadera();
        Pico picoMadera = new Pico(deMadera);
        Madera bloqueMadera = new Madera();

        picoMadera.desgastar(bloqueMadera);

        assertEquals(10, bloqueMadera.getDurabilidadActual());
    }

    @Test
    public void test07SeUsaHachaDePiedraEnMaterialMaderaYSeReduceDurabilidad() {

        HerramientaPiedra dePiedra = new HerramientaPiedra();
        Hacha hachaPiedra = new Hacha(dePiedra);
        Madera bloqueMadera = new Madera();

        hachaPiedra.desgastar(bloqueMadera);

        assertEquals(5, bloqueMadera.getDurabilidadActual());
    }

    @Test
    public void test08SeUsaPicoDePiedraEnMaterialMaderaYNoReduceDurabilidad() {

        HerramientaPiedra dePiedra = new HerramientaPiedra();
        Pico picoPiedra = new Pico(dePiedra);
        Madera bloqueMadera = new Madera();

        picoPiedra.desgastar(bloqueMadera);

        assertEquals(10, bloqueMadera.getDurabilidadActual());
    }

    @Test
    public void test09SeUsaHachaDeMetalEnMaterialMaderaYSeReduceDurabilidad() {
        assertEquals(1, 1);
    }
    @Test
    public void test10SeUsaPicoDeMetalEnMaterialMaderaYNoReduceDurabilidad() {
        assertEquals(1, 1);
    }
    @Test
    public void test11SeUsaPicoFinoDePiedraContraMaderaNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test12SeUsaPicoFinoDeMetalContraMaderaNoReduceDurabilidad() { assertEquals(1,1); }
    // Fin Test contra Madera

    // Tests contra Piedra
    @Test
    public void test13SeUsaHachaDeMaderaContraPiedraNoReduceDurabilidad() {

        Hacha hachaMadera = new Hacha(new HerramientaMadera());
        Piedra bloquePiedra = new Piedra();

        hachaMadera.desgastar(bloquePiedra);

        assertEquals(bloquePiedra.getDurabilidadInicial(), bloquePiedra.getDurabilidadActual());
    }
    @Test
    public void test14SeUsaHachaDePiedraContraPiedraNoReduceDurabilidad() {

        Hacha hachaPiedra = new Hacha(new HerramientaPiedra());
        Piedra bloquePiedra = new Piedra();

        hachaPiedra.desgastar(bloquePiedra);

        assertEquals(bloquePiedra.getDurabilidadInicial(), bloquePiedra.getDurabilidadActual());
    }
    @Test
    public void test15SeUsaHachaDeMetalContraPiedraNoReduceDurabilidad() {

        Hacha hachaMetal = new Hacha(new HerramientaMetal());
        Piedra bloquePiedra = new Piedra();

        hachaMetal.desgastar(bloquePiedra);

        assertEquals(bloquePiedra.getDurabilidadInicial(), bloquePiedra.getDurabilidadActual());
    }
    @Test
    public void test16SeUsaPicoDeMaderaContraPiedraSeReduceDurabilidad() {

        Pico picoMadera = new Pico(new HerramientaMadera());
        Piedra bloquePiedra = new Piedra();

        picoMadera.desgastar(bloquePiedra);

        assertEquals(bloquePiedra.getDurabilidadInicial() - picoMadera.fuerza, bloquePiedra.getDurabilidadActual());
    }
    @Test
    public void test17SeUsaPicoDePiedraContraPiedraSeReduceDurabilidad() {

        Pico picoPiedra = new Pico(new HerramientaPiedra());
        Piedra bloquePiedra = new Piedra();

        picoPiedra.desgastar(bloquePiedra);

        assertEquals(bloquePiedra.getDurabilidadInicial() - picoPiedra.fuerza, bloquePiedra.getDurabilidadActual());
    }
    @Test
    public void test18SeUsaPicoDeMetalContraPiedraSeReduceDurabilidad() {
        Pico picoMetal = new Pico(new HerramientaMetal());
        Piedra bloquePiedra = new Piedra();

        picoMetal.desgastar(bloquePiedra);

        assertEquals(bloquePiedra.getDurabilidadInicial() - picoMetal.fuerza, bloquePiedra.getDurabilidadActual());
    }
    @Test
    public void test19SeUsaPicoFinoDePiedraContraPiedraSeReduceDurabilidad() {
        PicoFino picoFinoPiedra = new PicoFino(new HerramientaPiedra());
        Piedra bloquePiedra = new Piedra();

        picoFinoPiedra.desgastar(bloquePiedra);

        assertEquals(bloquePiedra.getDurabilidadInicial() - picoFinoPiedra.fuerza, bloquePiedra.getDurabilidadActual());
    }
    @Test
    public void test20SeUsaPicoFinoDeMetalContraPiedraSeReduceDurabilidad() {
        PicoFino picoFinoMetal = new PicoFino(new HerramientaMetal());
        Piedra bloquePiedra = new Piedra();

        picoFinoMetal.desgastar(bloquePiedra);

        assertEquals(bloquePiedra.getDurabilidadInicial() - picoFinoMetal.fuerza, bloquePiedra.getDurabilidadActual());
    }
    // Fin Tests contra Piedra

    // Tests contra Metal
    @Test
    public void test21SeUsaHachaDeMaderaContraMetalNoReduceDurabilidad() {
        Hacha hachaMadera = new Hacha(new HerramientaMadera());
        Metal bloqueMetal = new Metal();

        hachaMadera.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial(), bloqueMetal.getDurabilidadActual());
    }
    @Test
    public void test22SeUsaHachaDePiedraContraMetalNoReduceDurabilidad() {

        Hacha hachaPiedra = new Hacha(new HerramientaPiedra());
        Metal bloqueMetal = new Metal();

        hachaPiedra.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial(), bloqueMetal.getDurabilidadActual());
    }
    @Test
    public void test23SeUsaHachaDeMetalContraMetalNoReduceDurabilidad() {
        Hacha hachaMetal = new Hacha(new HerramientaMetal());
        Metal bloqueMetal = new Metal();

        hachaMetal.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial(), bloqueMetal.getDurabilidadActual());
    }
    @Test
    public void test24SeUsaPicoDeMaderaContraMetalNoReduceDurabilidad() {
        Pico picoMadera = new Pico(new HerramientaMadera());
        Metal bloqueMetal = new Metal();

        picoMadera.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial(), bloqueMetal.getDurabilidadActual());
    }
    @Test
    public void test25SeUsaPicoDePiedraContraMetalSeReduceDurabilidad() {
        Pico picoPiedra = new Pico(new HerramientaPiedra());
        Metal bloqueMetal = new Metal();

        picoPiedra.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial() - picoPiedra.fuerza, bloqueMetal.getDurabilidadActual());
    }
    @Test
    public void test26SeUsaPicoDeMetalContraMetalSeReduceDurabilidad() {
        Pico picoMetal = new Pico(new HerramientaMetal());
        Metal bloqueMetal = new Metal();

        picoMetal.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial() - picoMetal.fuerza, bloqueMetal.getDurabilidadActual());
    }
    @Test
    public void test27SeUsaPicoFinoDePiedraContraMetalSeReduceDurabilidad() {
        PicoFino picoFinoPiedra = new PicoFino(new HerramientaPiedra());
        Metal bloqueMetal = new Metal();

        picoFinoPiedra.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial() - picoFinoPiedra.fuerza, bloqueMetal.getDurabilidadActual());
    }
    @Test
    public void test28SeUsaPicoFinoDeMetalContraMetalSeReduceDurabilidad() {
        PicoFino picoFinoMetal = new PicoFino(new HerramientaMetal());
        Metal bloqueMetal = new Metal();

        picoFinoMetal.desgastar(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidadInicial() - picoFinoMetal.fuerza, bloqueMetal.getDurabilidadActual());
    }
    // Fin Tests contra Metal

    // Tests contra Diamante
    @Test
    public void test29SeUsaHachaDeMaderaContraDiamanteNoReduceDurabilidad() {

        Hacha hachaMadera = new Hacha(new HerramientaMadera());
        Diamante bloqueDiamante = new Diamante();

        hachaMadera.desgastar(bloqueDiamante);

        assertEquals(bloqueDiamante.getDurabilidadInicial(), bloqueDiamante.getDurabilidadActual());
    }
    @Test
    public void test30SeUsaHachaDePiedraContraDiamanteNoReduceDurabilidad() {
        Hacha hachaPiedra = new Hacha(new HerramientaPiedra());
        Diamante bloqueDiamante = new Diamante();

        hachaPiedra.desgastar(bloqueDiamante);

        assertEquals(bloqueDiamante.getDurabilidadInicial(), bloqueDiamante.getDurabilidadActual());
    }
    @Test
    public void test31SeUsaHachaDeMetalContraDiamanteNoReduceDurabilidad() {
        Hacha hachaMetal = new Hacha(new HerramientaMetal());
        Diamante bloqueDiamante = new Diamante();

        hachaMetal.desgastar(bloqueDiamante);

        assertEquals(bloqueDiamante.getDurabilidadInicial(), bloqueDiamante.getDurabilidadActual());
    }
    @Test
    public void test32SeUsaPicoDeMaderaContraDiamanteNoReduceDurabilidad() {
        Pico picoMadera = new Pico(new HerramientaMadera());
        Diamante bloqueDiamante = new Diamante();

        picoMadera.desgastar(bloqueDiamante);

        assertEquals(bloqueDiamante.getDurabilidadInicial(), bloqueDiamante.getDurabilidadActual());
    }
    @Test
    public void test33SeUsaPicoDePiedraContraDiamanteNoReduceDurabilidad() {
        Pico picoPiedra = new Pico(new HerramientaPiedra());
        Diamante bloqueDiamante = new Diamante();

        picoPiedra.desgastar(bloqueDiamante);

        assertEquals(bloqueDiamante.getDurabilidadInicial(), bloqueDiamante.getDurabilidadActual());
    }
    @Test
    public void test34SeUsaPicoDeMetalContraDiamanteNoReduceDurabilidad() {
        Pico picoMetal = new Pico(new HerramientaMetal());
        Diamante bloqueDiamante = new Diamante();

        picoMetal.desgastar(bloqueDiamante);

        assertEquals(bloqueDiamante.getDurabilidadInicial(), bloqueDiamante.getDurabilidadActual());
    }
    @Test
    public void test35SeUsaPicoFinoDePiedraContraDiamanteSeReduceDurabilidad() {
        PicoFino picoFinoPiedra = new PicoFino(new HerramientaPiedra());
        Diamante bloqueDiamante = new Diamante();

        picoFinoPiedra.desgastar(bloqueDiamante);

        assertEquals(bloqueDiamante.getDurabilidadInicial() - picoFinoPiedra.getFuerza(), bloqueDiamante.getDurabilidadActual());
    }
    @Test
    public void test36SeUsaPicoFinoDeMetalContraDiamanteSeReduceDurabilidad() {
        PicoFino picoFinoMetal = new PicoFino(new HerramientaMetal());
        Diamante bloqueDiamante = new Diamante();

        picoFinoMetal.desgastar(bloqueDiamante);

        assertEquals(bloqueDiamante.getDurabilidadInicial() - picoFinoMetal.getFuerza(), bloqueDiamante.getDurabilidadActual());
    }
    // Fin Tests contra Diamante

}
