package algocraft.herramienta;

import algocraft.material.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HachaTests {

    @Test
    public void test01SeCreaHachaDeMaderaConDurabilidadYFuerza() {
        Hacha hachaMadera = new Hacha(new HerramientaMadera());
        assertEquals(100, hachaMadera.getDurabilidadActual());
        assertEquals(2, hachaMadera.getFuerza());
    }

    @Test
    public void test02SeCreaHachaDePiedraConDurabilidadYFuerza() {
        Hacha hachaPiedra = new Hacha(new HerramientaPiedra());
        assertEquals(200, hachaPiedra.getDurabilidadActual());
        assertEquals(5, hachaPiedra.getFuerza());
    }

    @Test
    public void test03SeCreaHachaDeMetalConDurabilidadYFuerza() {
        Hacha hachaMetal = new Hacha(new HerramientaMetal());
        assertEquals(400, hachaMetal.getDurabilidadActual());
        assertEquals(10, hachaMetal.getFuerza());
    }

    @Test
    public void test04SeUsaHachaDeMaderaConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerza() {
        Hacha hachaMadera = new Hacha(new HerramientaMadera());                  // FUERZA = 2
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
    public void test05SeUsaHachaDePiedraConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerza() {
        Hacha hachaPiedra = new Hacha(new HerramientaPiedra());                  // FUERZA = 5
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
    public void test06SeUsaHachaDeMetalConTodosLosMaterialesYSeDesgastaEnFuncionDeLaFuerzaDivididoDos() {
        Hacha hachaMetal = new Hacha(new HerramientaMetal());                  // FUERZA = 10
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

}
