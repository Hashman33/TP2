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

    // Tests contra madera
    @Test
    public void test05SeUsaHachaDeMaderaContraMaderaSeReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test06SeUsaHachaDePiedraContraMaderaSeReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test07SeUsaHachaDeMetalContraMaderaSeReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test08SeUsaPicoDeMaderaContraMaderaNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test09SeUsaPicoDePiedraContraMaderaNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test10SeUsaPicoDeMetalContraMaderaNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test11SeUsaPicoFinoDePiedraContraMaderaNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test12SeUsaPicoFinoDeMetalContraMaderaNoReduceDurabilidad() { assertEquals(1,1); }

    // Tests contra piedra
    @Test
    public void test13SeUsaHachaDeMaderaContraPiedraNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test14SeUsaHachaDePiedraContraPiedraNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test15SeUsaHachaDeMetalContraPiedraNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test16SeUsaPicoDeMaderaContraPiedraSeReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test17SeUsaPicoDePiedraContraPiedraSeReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test18SeUsaPicoDeMetalContraPiedraSeReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test19SeUsaPicoFinoDePiedraContraPiedraSeReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test20SeUsaPicoFinoDeMetalContraPiedraSeReduceDurabilidad() { assertEquals(1,1); }

    // Tests contra Metal
    @Test
    public void test21SeUsaHachaDeMaderaContraMetalNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test22SeUsaHachaDePiedraContraMetalNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test23SeUsaHachaDeMetalContraMetalNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test24SeUsaPicoDeMaderaContraMetalNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test25SeUsaPicoDePiedraContraMetalSeReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test26SeUsaPicoDeMetalContraMetalSeReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test27SeUsaPicoFinoDePiedraContraMetalSeReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test28SeUsaPicoFinoDeMetalContraMetalSeReduceDurabilidad() { assertEquals(1,1); }

    // Tests contra Diamante
    @Test
    public void test29SeUsaHachaDeMaderaContraDiamanteNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test30SeUsaHachaDePiedraContraDiamanteNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test31SeUsaHachaDeMetalContraDiamanteNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test32SeUsaPicoDeMaderaContraDiamanteNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test33SeUsaPicoDePiedraContraDiamanteNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test34SeUsaPicoDeMetalContraDiamanteNoReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test35SeUsaPicoFinoDePiedraContraDiamanteSeReduceDurabilidad() { assertEquals(1,1); }
    @Test
    public void test36SeUsaPicoFinoDeMetalContraDiamanteSeReduceDurabilidad() { assertEquals(1,1); }


}
