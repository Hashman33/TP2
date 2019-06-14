package algocraft.material;

import algocraft.herramienta.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaderaTests {

    @Test
    public void test00SeCreaMaderaConUnaDurabilidad() {

        Madera bloqueMadera = new Madera();

        assertEquals(10, bloqueMadera.getDurabilidadActual());
    }

    @Test
    public void test01SeUsaHachaDeMaderaEnMaterialMaderaYSeReduceDurabilidad() {
        HerramientaMadera deMadera = new HerramientaMadera();
        Hacha hachaMadera = new Hacha(deMadera);
        Madera bloqueMadera = new Madera();

        hachaMadera.desgastar(bloqueMadera);
        assertEquals(8, bloqueMadera.getDurabilidadActual());
    }

    @Test
    public void test02SeUsaPicoDeMaderaEnMaterialMaderaYNoReduceDurabilidad() {

        HerramientaMadera deMadera = new HerramientaMadera();
        Pico picoMadera = new Pico(deMadera);
        Madera bloqueMadera = new Madera();

        picoMadera.desgastar(bloqueMadera);

        assertEquals(10, bloqueMadera.getDurabilidadActual());
    }

    @Test
    public void test03SeUsaHachaDePiedraEnMaterialMaderaYSeReduceDurabilidad() {

        HerramientaPiedra dePiedra = new HerramientaPiedra();
        Hacha hachaPiedra = new Hacha(dePiedra);
        Madera bloqueMadera = new Madera();

        hachaPiedra.desgastar(bloqueMadera);

        assertEquals(5, bloqueMadera.getDurabilidadActual());
    }

    @Test
    public void test04SeUsaPicoDePiedraEnMaterialMaderaYNoReduceDurabilidad() {

        HerramientaPiedra dePiedra = new HerramientaPiedra();
        Pico picoPiedra = new Pico(dePiedra);
        Madera bloqueMadera = new Madera();

        picoPiedra.desgastar(bloqueMadera);

        assertEquals(10, bloqueMadera.getDurabilidadActual());
    }

    @Test
    public void test05SeUsaHachaDeMetalEnMaterialMaderaYSeReduceDurabilidad() {
        Hacha hachaMetal = new Hacha(new HerramientaMetal());
        Madera bloqueMadera = new Madera();

        hachaMetal.desgastar(bloqueMadera);

        assertEquals(bloqueMadera.getDurabilidadInicial() - hachaMetal.getFuerza(), bloqueMadera.getDurabilidadActual());
    }

    @Test
    public void test06SeUsaPicoDeMetalEnMaterialMaderaYNoReduceDurabilidad() {
        Pico picoMetal = new Pico(new HerramientaMetal());
        Madera bloqueMadera = new Madera();

        picoMetal.desgastar(bloqueMadera);

        assertEquals(bloqueMadera.getDurabilidadInicial(), bloqueMadera.getDurabilidadActual());
    }

    @Test
    public void test07SeUsaPicoFinoContraMaderaNoReduceDurabilidad() {
        PicoFino picoFino = new PicoFino();
        Madera bloqueMadera = new Madera();

        picoFino.desgastar(bloqueMadera);

        assertEquals(bloqueMadera.getDurabilidadInicial(), bloqueMadera.getDurabilidadActual());
    }

    @Test
    public void test08SeUsaManoContraMaderaNoReduceDurabilidad() {
        Mano mano = new Mano();
        Madera bloqueMadera = new Madera();

        mano.desgastar(bloqueMadera);

        assertEquals(bloqueMadera.getDurabilidadInicial(), bloqueMadera.getDurabilidadActual());
    }
}
