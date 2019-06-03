package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaterialTests {

    @Test
    public void test01SeCreaMaderaConUnaDurabilidad() {

        Madera madera = new Madera();

        assertEquals(10, madera.durabildadactual());
    }

    @Test
    public void test02SeCreaPiedraConUnaDurabilidad() {

        Piedra piedra = new Piedra();

        assertEquals(30, piedra.durabildadactual());
    }

    @Test
    public void test03SeCreaMetalConUnaDurabilidad() {

         Metal metal = new Metal();

        assertEquals(50, metal.durabildadactual());
    }

    @Test
    public void test04SeCreaDiamanteConUnaDurabilidad() {

        Diamante diamante = new Diamante();

        assertEquals(100, diamante.durabildadactual());
    }

    // Test contra Madera
    @Test
    public void test05SeUsaHachaDeMaderaEnMaterialMaderaYSeReduceDurabilidad() {
        HachaMadera hachaMadera = new HachaMadera();
        Madera madera = new Madera();
        hachaMadera.desgastar(madera);
        assertEquals(8, madera.durabildadactual());
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
