package algocraft.test.herramienta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaterialTests {

    @Test
    public void test01SeCreaMaderaConUnaDurabilidad() {
        assertEquals(1, 1);
    }

    @Test
    public void test02SeCreaPiedraConUnaDurabilidad() {
        assertEquals(1, 1);
    }

    @Test
    public void test03SeCreaMetalConUnaDurabilidad() {
        assertEquals(1, 1);
    }

    @Test
    public void test04SeCreaDiamanteConUnaDurabilidad() {
        assertEquals(1, 1);
    }

    // Test contra Madera
    @Test
    public void test05SeUsaHachaDeMaderaEnMaterialMaderaYSeReduceDurabilidad() {
        assertEquals(1, 1);
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


    // TODO: Agregar tests idem Madera, pero con Piedra y Metal. Ojo que el enunciado nombra algunos, los otros serian supuestos nuestros

}
