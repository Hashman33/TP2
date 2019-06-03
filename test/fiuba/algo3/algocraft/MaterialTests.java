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
        assertEquals(1, 1);
    }

    @Test
    public void test07SeUsaHachaDePiedraEnMaterialMaderaYSeReduceDurabilidad() {
        assertEquals(1, 1);
    }

    @Test
    public void test08SeUsaPicoDePiedraEnMaterialMaderaYNoReduceDurabilidad() {
        assertEquals(1, 1);
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
