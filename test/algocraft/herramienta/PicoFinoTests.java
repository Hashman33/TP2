package algocraft.herramienta;

import algocraft.material.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PicoFinoTests {

    @Test
    public void test01SeCreaPicoFinoConDurabilidadYFuerza() {
        PicoFino PicoFino = new PicoFino();
        assertEquals(1000, PicoFino.getDurabilidadActual());
        assertEquals(20, PicoFino.getFuerza());
    }

    @Test
    public void test02SeUsaPicoFinoConDiamanteYSeDesgastaDeADecimos() {
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
    public void test03SeUsaPicoFinoConTodosLosMaterialesExceptoDiamanteYNoSeDesgasta() {
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
}
