package algocraft.material;

import algocraft.herramienta.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiamanteTests {

    @Test
    public void test00SeCreaDiamanteConUnaDurabilidad() {

        Diamante diamante = new Diamante();

        assertEquals(100, diamante.getDurabilidadActual());
    }

    @Test
    public void test01SeUsaHachaDeMaderaContraDiamanteNoReduceDurabilidad() {

        Hacha hachaMadera = new Hacha(new HerramientaMadera());
        Diamante bloqueDiamante = new Diamante();

        hachaMadera.desgastar(bloqueDiamante);

        assertEquals(bloqueDiamante.getDurabilidadInicial(), bloqueDiamante.getDurabilidadActual());
    }

    @Test
    public void test02SeUsaHachaDePiedraContraDiamanteNoReduceDurabilidad() {
        Hacha hachaPiedra = new Hacha(new HerramientaPiedra());
        Diamante bloqueDiamante = new Diamante();

        hachaPiedra.desgastar(bloqueDiamante);

        assertEquals(bloqueDiamante.getDurabilidadInicial(), bloqueDiamante.getDurabilidadActual());
    }

    @Test
    public void test03SeUsaHachaDeMetalContraDiamanteNoReduceDurabilidad() {
        Hacha hachaMetal = new Hacha(new HerramientaMetal());
        Diamante bloqueDiamante = new Diamante();

        hachaMetal.desgastar(bloqueDiamante);

        assertEquals(bloqueDiamante.getDurabilidadInicial(), bloqueDiamante.getDurabilidadActual());
    }

    @Test
    public void test04SeUsaPicoDeMaderaContraDiamanteNoReduceDurabilidad() {
        Pico picoMadera = new Pico(new HerramientaMadera());
        Diamante bloqueDiamante = new Diamante();

        picoMadera.desgastar(bloqueDiamante);

        assertEquals(bloqueDiamante.getDurabilidadInicial(), bloqueDiamante.getDurabilidadActual());
    }

    @Test
    public void test05SeUsaPicoDePiedraContraDiamanteNoReduceDurabilidad() {
        Pico picoPiedra = new Pico(new HerramientaPiedra());
        Diamante bloqueDiamante = new Diamante();

        picoPiedra.desgastar(bloqueDiamante);

        assertEquals(bloqueDiamante.getDurabilidadInicial(), bloqueDiamante.getDurabilidadActual());
    }

    @Test
    public void test06SeUsaPicoDeMetalContraDiamanteNoReduceDurabilidad() {
        Pico picoMetal = new Pico(new HerramientaMetal());
        Diamante bloqueDiamante = new Diamante();

        picoMetal.desgastar(bloqueDiamante);

        assertEquals(bloqueDiamante.getDurabilidadInicial(), bloqueDiamante.getDurabilidadActual());
    }

    @Test
    public void test07SeUsaPicoFinoContraDiamanteSeReduceDurabilidad() {
        PicoFino picoFinoPiedra = new PicoFino();
        Diamante bloqueDiamante = new Diamante();

        picoFinoPiedra.desgastar(bloqueDiamante);

        assertEquals(bloqueDiamante.getDurabilidadInicial() - picoFinoPiedra.getFuerza(), bloqueDiamante.getDurabilidadActual());
    }

    @Test
    public void test08SeUsaManoContraDiamanteNoReduceDurabilidad() {
        Mano mano = new Mano();
        Diamante bloqueDiamante = new Diamante();

        mano.desgastar(bloqueDiamante);

        assertEquals(bloqueDiamante.getDurabilidadInicial(), bloqueDiamante.getDurabilidadActual());
    }

    @Test
    public void test09SeUsaPicoFinoEnMaterialDiamanteCincoVecesYLanzaMaterialDestruidoException() {
        PicoFino picoFino = new PicoFino();
        Diamante bloqueDiamante = new Diamante();

        for (int i = 0; i < 4; i++) picoFino.desgastar(bloqueDiamante);

        assertThrows(MaterialDestruidoException.class,
                ()->{ picoFino.desgastar(bloqueDiamante);});
    }

}
