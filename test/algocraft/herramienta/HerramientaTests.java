package algocraft.herramienta;

import algocraft.material.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HerramientaTests {

    @Test
    public void test01SeCreaHachaDeMaderaConDurabilidadYFuerza() {
        HerramientaMadera madera = new HerramientaMadera();
        Hacha hachaMadera = new Hacha(madera);
        assertEquals(100, hachaMadera.getDurabilidadActual());
        assertEquals(2, hachaMadera.getFuerza());
    }

    @Test
    public void test02SeCreaPicoDeMaderaConDurabilidadYFuerza() {
        HerramientaMadera madera = new HerramientaMadera();
        Pico picoMadera = new Pico(madera);
        assertEquals(100, picoMadera.getDurabilidadActual());
        assertEquals(2, picoMadera.getFuerza());
    }

    @Test
    public void test03SeCreaHachaDePiedraConDurabilidadYFuerza() {
        HerramientaPiedra piedra = new HerramientaPiedra();
        Hacha hachaPiedra = new Hacha(piedra);
        assertEquals(200, hachaPiedra.getDurabilidadActual());
        assertEquals(5, hachaPiedra.getFuerza());
    }

    @Test
    public void test04SeCreaPicoDePiedraConDurabilidadYFuerza() {
        HerramientaPiedra piedra = new HerramientaPiedra();
        Pico picoPiedra = new Pico(piedra);
        assertEquals(200, picoPiedra.getDurabilidadActual());
        assertEquals(4, picoPiedra.getFuerza());
    }

    @Test
    public void test05SeCreaHachaDeMetalConDurabilidadYFuerza() {
        HerramientaMetal metal = new HerramientaMetal();
        Hacha hachaMetal = new Hacha(metal);
        assertEquals(400, hachaMetal.getDurabilidadActual());
        assertEquals(10, hachaMetal.getFuerza());
    }

    @Test
    public void test06SeCreaPicoDeMetalConDurabilidadYFuerza() {
        HerramientaMetal metal = new HerramientaMetal();
        Pico picoMetal = new Pico(metal);
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
        HerramientaMadera madera = new HerramientaMadera();
        Hacha hachaMadera = new Hacha(madera);                  // FUERZA = 2
        double durabilidadInicial = hachaMadera.getDurabilidadActual();

        Madera bloqueMadera = new Madera();
        Piedra bloquePiedra = new Piedra();
        Metal bloqueMetal = new Metal();
        Diamante diamante = new Diamante();

        hachaMadera.desgastar(bloqueMadera);
        hachaMadera.desgastar(bloquePiedra);
        hachaMadera.desgastar(bloqueMetal);
        hachaMadera.desgastar(diamante);

        assertEquals(durabilidadInicial - (4 * 2), hachaMadera.getDurabilidadActual());
    }

    @Test
    public void test09SeUsaHachaDePiedraConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerza() {
        HerramientaPiedra piedra = new HerramientaPiedra();
        Hacha hachaPiedra = new Hacha(piedra);                  // FUERZA = 5
        double durabilidadInicial = hachaPiedra.getDurabilidadActual();

        Madera bloqueMadera = new Madera();
        Piedra bloquePiedra = new Piedra();
        Metal bloqueMetal = new Metal();
        Diamante diamante = new Diamante();

        hachaPiedra.desgastar(bloqueMadera);
        hachaPiedra.desgastar(bloquePiedra);
        hachaPiedra.desgastar(bloqueMetal);
        hachaPiedra.desgastar(diamante);

        assertEquals(durabilidadInicial - (4 * 5), hachaPiedra.getDurabilidadActual());
    }

    @Test
    public void test10SeUsaHachaDeMetalConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerzaDivididoDos() {
        HerramientaMetal metal = new HerramientaMetal();
        Hacha hachaMetal = new Hacha(metal);                  // FUERZA = 10
        double durabilidadInicial = hachaMetal.getDurabilidadActual();

        Madera bloqueMadera = new Madera();
        Piedra bloquePiedra = new Piedra();
        Metal bloqueMetal = new Metal();
        Diamante diamante = new Diamante();

        hachaMetal.desgastar(bloqueMadera);
        hachaMetal.desgastar(bloquePiedra);
        hachaMetal.desgastar(bloqueMetal);
        hachaMetal.desgastar(diamante);

        assertEquals(durabilidadInicial - (4 * (10 / 2)), hachaMetal.getDurabilidadActual());
    }

    @Test
    public void test11SeUsaPicoDeMaderaConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerza() {
        HerramientaMadera madera = new HerramientaMadera();
        Pico picoMadera = new Pico(madera);                  // FUERZA = 2
        double durabilidadInicial = picoMadera.getDurabilidadActual();

        Madera bloqueMadera = new Madera();
        Piedra bloquePiedra = new Piedra();
        Metal bloqueMetal = new Metal();
        Diamante diamante = new Diamante();

        picoMadera.desgastar(bloqueMadera);
        picoMadera.desgastar(bloquePiedra);
        picoMadera.desgastar(bloqueMetal);
        picoMadera.desgastar(diamante);

        assertEquals(durabilidadInicial - (2 * 4), picoMadera.getDurabilidadActual());
    }

    @Test
    public void test12SeUsaPicoDePiedraConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerzaDivididoUnoYMedio() {
        HerramientaPiedra piedra = new HerramientaPiedra();
        Pico picoPiedra = new Pico(piedra);                  // FUERZA = 4
        double durabilidadInicial = picoPiedra.getDurabilidadActual();

        Madera bloqueMadera = new Madera();
        Piedra bloquePiedra = new Piedra();
        Metal bloqueMetal = new Metal();
        Diamante diamante = new Diamante();

        picoPiedra.desgastar(bloqueMadera);
        picoPiedra.desgastar(bloquePiedra);
        picoPiedra.desgastar(bloqueMetal);
        picoPiedra.desgastar(diamante);

        double durabilidad = durabilidadInicial;
        for (int i = 0; i < 4; i++) { durabilidad -= 4 / 1.5; }

        assertEquals(durabilidad, picoPiedra.getDurabilidadActual());
    }

    @Test
    public void test13SeUsaPicoDeMetalConTodosLosMaterialesUnaVezYNoSeModificaSuDurabilidad() {
        HerramientaMetal metal = new HerramientaMetal();
        Pico picoMetal = new Pico(metal);                  // FUERZA = 12
        double durabilidadInicial = picoMetal.getDurabilidadActual();

        Madera bloqueMadera = new Madera();
        Piedra bloquePiedra = new Piedra();
        Metal bloqueMetal = new Metal();
        Diamante diamante = new Diamante();

        picoMetal.desgastar(bloqueMadera);
        picoMetal.desgastar(bloquePiedra);
        picoMetal.desgastar(bloqueMetal);
        picoMetal.desgastar(diamante);

        assertEquals(durabilidadInicial, picoMetal.getDurabilidadActual());
    }

    @Test
    public void test14SeUsaPicoFinoConDiamanteYSeDesgastaDeADecimos() {
        PicoFino picoFino = new PicoFino();   // FUERZA = 20
        double durabilidadInicial = picoFino.getDurabilidadActual();
        Diamante diamante = new Diamante();

        picoFino.desgastar(diamante);
        picoFino.desgastar(diamante);
        picoFino.desgastar(diamante);

        double durabilidad = durabilidadInicial;
        for (int i = 0; i < 3; i++) { durabilidad -= durabilidad * 0.1; }

        assertEquals(durabilidad, picoFino.getDurabilidadActual());
    }

    @Test
    public void test15SeUsaPicoFinoConTodosLosMaterialesExceptoDiamanteYNoSeDesgasta() {
        PicoFino picoFino = new PicoFino();   // FUERZA = 20
        double durabilidadInicial = picoFino.getDurabilidadActual();
        Madera bloqueMadera = new Madera();
        Piedra bloquePiedra = new Piedra();
        Metal bloqueMetal = new Metal();

        picoFino.desgastar(bloqueMadera);
        picoFino.desgastar(bloquePiedra);
        picoFino.desgastar(bloqueMetal);
        assertEquals(durabilidadInicial, picoFino.getDurabilidadActual());
    }

    // ....
}
