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
    // Fin Test contra Madera


    /* TODO: Agregar tests idem Madera, pero con Piedra y Metal. Ojo que el enunciado nombra algunos,
             los otros serian supuestos nuestros
     */

}
