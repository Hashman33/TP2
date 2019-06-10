package algocraft.herramienta;

import algocraft.material.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PicoTests {

    @Test
    public void test01SeCreaPicoDeMaderaConDurabilidadYFuerza() {
        Pico picoMadera = new Pico(new HerramientaMadera());
        assertEquals(100, picoMadera.getDurabilidadActual());
        assertEquals(2, picoMadera.getFuerza());
    }

    @Test
    public void test02SeCreaPicoDePiedraConDurabilidadYFuerza() {
        Pico picoPiedra = new Pico(new HerramientaPiedra());
        assertEquals(200, picoPiedra.getDurabilidadActual());
        assertEquals(4, picoPiedra.getFuerza());
    }

    @Test
    public void test03SeCreaPicoDeMetalConDurabilidadYFuerza() {
        Pico picoMetal = new Pico(new HerramientaMetal());
        assertEquals(400, picoMetal.getDurabilidadActual());
        assertEquals(12, picoMetal.getFuerza());
    }

    @Test
    public void test04SeUsaPicoDeMaderaConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerza() {
        Pico picoMadera = new Pico(new HerramientaMadera());                  // FUERZA = 2
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
    public void test05SeUsaPicoDePiedraConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerzaDivididoUnoYMedio() {
        Pico picoPiedra = new Pico(new HerramientaPiedra());                  // FUERZA = 4
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
        for (int i = 0; i < 4; i++) {
            durabilidad -= 4 / 1.5;
        }

        assertEquals(durabilidad, picoPiedra.getDurabilidadActual());
    }

    @Test
    public void test06SeUsaPicoDeMetalConTodosLosMaterialesUnaVezYNoSeModificaSuDurabilidad() {
        Pico picoMetal = new Pico(new HerramientaMetal());                  // FUERZA = 12
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
}

