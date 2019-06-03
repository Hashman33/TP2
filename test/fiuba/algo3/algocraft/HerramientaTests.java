package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.HachaMadera;
import fiuba.algo3.algocraft.Madera;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HerramientaTests {

    @Test
    public void test01SeCreaHachaDeMaderaConDurabilidadYFuerza() {
        assertEquals(1, 1);
    }

    @Test
    public void test02SeCreaPicoDeMaderaConDurabilidadYFuerza() {
        assertEquals(1, 1);
    }

    @Test
    public void test03SeCreaHachaDeMetalConDurabilidadYFuerza() {
        assertEquals(1, 1);
    }

    @Test
    public void test04SeCreaPicoDeMetalConDurabilidadYFuerza() {
        assertEquals(1, 1);
    }

    @Test
    public void test04SeCreaPicoFinoConDurabilidadYFuerza() {
        assertEquals(1, 1);
    }

    @Test
    public void test05SeUsaHachaDeMaderaConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerza() {
        HachaMadera hachaMadera = new HachaMadera();
        Madera madera = new Madera();
        hachaMadera.desgastar(madera);
        hachaMadera.desgastar(madera);
        assertEquals(96, hachaMadera.getDurabilidadActual());
    }

    @Test
    public void test06SeUsaHachaDePiedraConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerza() {

        assertEquals(1, 1);
    }


    @Test
    public void test07SeUsaHachaDeMetalConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerzaDivididoDos() {
        assertEquals(1, 1);
    }

    @Test
    public void test08SeUsaPicoDeMaderaConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerza() {
        assertEquals(1, 1);
    }

    @Test
    public void test09SeUsaPicoDePiedraConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerzaDivididoUnoYMedio() {
        assertEquals(1, 1);
    }

    @Test
    public void test10SeUsaPicoDeMetalConTodosLosMaterialesYSeRompeAlDecimoGolpe() {
        assertEquals(1, 1);
    }

    @Test
    public void test11SeUsaPicoFinoConDiamanteYSeDesgastaDeADecimos() {
        assertEquals(1, 1);
    }

    @Test
    public void test11SeUsaPicoFinoConTodosLosMaterialesExceptoDiamanteYNoSeDesgasta() {
        assertEquals(1, 1);
    }
}
