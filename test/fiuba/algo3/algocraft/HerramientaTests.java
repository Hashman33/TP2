package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.HachaMadera;
import fiuba.algo3.algocraft.Madera;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HerramientaTests {

    @Test
    public void test01SeCreaHachaDeMaderaConDurabilidadYFuerza() {
        HachaMadera hachaMadera = new HachaMadera();
        assertEquals(100, hachaMadera.getDurabilidadActual());
        assertEquals(2, hachaMadera.getFuerza());
    }

    @Test
    public void test02SeCreaPicoDeMaderaConDurabilidadYFuerza() {
        PicoMadera picoMadera = new PicoMadera();
        assertEquals(100, picoMadera.getDurabilidadActual());
        assertEquals(2, picoMadera.getFuerza());
    }

    @Test
    public void test03SeCreaHachaDePiedraConDurabilidadYFuerza() {
        HachaPiedra hachaPiedra = new HachaPiedra();
        assertEquals(200, hachaPiedra.getDurabilidadActual());
        assertEquals(5, hachaPiedra.getFuerza());
    }

    @Test
    public void test04SeCreaPicoDePiedraConDurabilidadYFuerza() {
        PicoPiedra picoPiedra = new PicoPiedra();
        assertEquals(200, picoPiedra.getDurabilidadActual());
        assertEquals(4, picoPiedra.getFuerza());
    }

    @Test
    public void test05SeCreaHachaDeMetalConDurabilidadYFuerza() {
        HachaMetal hachaMetal = new HachaMetal();
        assertEquals(400, hachaMetal.getDurabilidadActual());
        assertEquals(10, hachaMetal.getFuerza());
    }

    @Test
    public void test06SeCreaPicoDeMetalConDurabilidadYFuerza() {
        PicoMetal picoMetal = new PicoMetal();
        assertEquals(400, picoMetal.getDurabilidadActual());
        assertEquals(12, picoMetal.getFuerza());
    }

    @Test
    public void test07SeCreaPicoFinoConDurabilidadYFuerza() {
        PicoFino PicoFino = new PicoFino();
        assertEquals(1000, PicoFino.getDurabilidadActual());
        assertEquals(20, PicoFino.getFuerza());
    }

    @Test
    public void test08SeUsaHachaDeMaderaConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerza() {
        HachaMadera hachaMadera = new HachaMadera();    // FUERZA = 2
        int durabilidadInicial = hachaMadera.getDurabilidadActual();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Diamante diamante = new Diamante();

        hachaMadera.desgastar(madera);
        hachaMadera.desgastar(piedra);
        hachaMadera.desgastar(metal);
        hachaMadera.desgastar(diamante);
        assertEquals(durabilidadInicial - 8, hachaMadera.getDurabilidadActual());
    }

    @Test
    public void test09SeUsaHachaDePiedraConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerza() {
        HachaPiedra hachaPiedra = new HachaPiedra();    // FUERZA = 5
        int durabilidadInicial = hachaPiedra.getDurabilidadActual();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Diamante diamante = new Diamante();

        hachaPiedra.desgastar(madera);
        hachaPiedra.desgastar(piedra);
        hachaPiedra.desgastar(metal);
        hachaPiedra.desgastar(diamante);
        assertEquals(durabilidadInicial - 20, hachaPiedra.getDurabilidadActual());
    }


    @Test
    public void test10SeUsaHachaDeMetalConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerzaDivididoDos() {
        HachaMetal hachaMetal = new HachaMetal();   // FUERZA = 10
        int durabilidadInicial = hachaMetal.getDurabilidadActual();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Diamante diamante = new Diamante();

        hachaMetal.desgastar(madera);
        hachaMetal.desgastar(piedra);
        hachaMetal.desgastar(metal);
        hachaMetal.desgastar(diamante);
        assertEquals(durabilidadInicial - 20, hachaMetal.getDurabilidadActual());
    }

    @Test
    public void test11SeUsaPicoDeMaderaConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerza() {
        PicoMadera picoMadera = new PicoMadera();    // FUERZA = 2
        int durabilidadInicial = picoMadera.getDurabilidadActual();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Diamante diamante = new Diamante();

        picoMadera.desgastar(madera);
        picoMadera.desgastar(piedra);
        picoMadera.desgastar(metal);
        picoMadera.desgastar(diamante);
        assertEquals(durabilidadInicial - 8, picoMadera.getDurabilidadActual());
    }

    @Test
    public void test12SeUsaPicoDePiedraConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerzaDivididoUnoYMedio() {
        PicoPiedra picoPiedra = new PicoPiedra();    // FUERZA = 4
        int durabilidadInicial = picoPiedra.getDurabilidadActual();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Diamante diamante = new Diamante();

        picoPiedra.desgastar(madera);
        picoPiedra.desgastar(piedra);
        picoPiedra.desgastar(metal);
        picoPiedra.desgastar(diamante);
        assertEquals(durabilidadInicial - 24, picoPiedra.getDurabilidadActual());
    }

    @Test
    public void test13SeUsaPicoDeMetalConTodosLosMaterialesYNoSeModificaSuDurabilidad() {
        PicoMetal picoMetal = new PicoMetal();   // FUERZA = 12
        int durabilidadInicial = picoMetal.getDurabilidadActual();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Diamante diamante = new Diamante();

        picoMetal.desgastar(madera);
        picoMetal.desgastar(piedra);
        picoMetal.desgastar(metal);
        picoMetal.desgastar(diamante);
        assertEquals(durabilidadInicial, picoMetal.getDurabilidadActual());
    }

    @Test
    public void test14SeUsaPicoFinoConDiamanteYSeDesgastaDeADecimos() {
        PicoFino picoFino = new PicoFino();   // FUERZA = 20
        int durabilidadInicial = picoFino.getDurabilidadActual();
        Diamante diamante = new Diamante();

        picoFino.desgastar(diamante);
        picoFino.desgastar(diamante);
        picoFino.desgastar(diamante);
        assertEquals(durabilidadInicial - (durabilidadInicial * 0.271), picoFino.getDurabilidadActual());
    }

    @Test
    public void test15SeUsaPicoFinoConTodosLosMaterialesExceptoDiamanteYNoSeDesgasta() {
        PicoFino picoFino = new PicoFino();   // FUERZA = 20
        int durabilidadInicial = picoFino.getDurabilidadActual();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();

        picoFino.desgastar(madera);
        picoFino.desgastar(piedra);
        picoFino.desgastar(metal);
        assertEquals(durabilidadInicial, picoFino.getDurabilidadActual());
    }
}
