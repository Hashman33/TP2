package algocraft.juego.jugador.herramienta;

import algocraft.juego.material.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManoTests {

    @Test
    public void test01SeCreaManoConDurabilidadInfinitaYFuerzaCero() {
        Mano mano = new Mano();
        assertEquals(Double.POSITIVE_INFINITY, mano.getDurabilidadActual());
        assertEquals(0, mano.getFuerza());
    }

    @Test
    public void test02SeUsaManoConTodosLosMaterialesYNoSeDesgasta() {
        Mano mano = new Mano();
        double durabilidadInicial = mano.getDurabilidadActual();

        mano.desgastar(new Madera());
        mano.desgastar(new Piedra());
        mano.desgastar(new Metal());
        mano.desgastar(new Diamante());
        assertEquals(durabilidadInicial, mano.getDurabilidadActual());
    }

    @Test
    public void test03SeUsaMano1000VecesConDiferentesMaterialesYNoSeDesgasta() {
        Mano mano = new Mano();
        double durabilidadInicial = mano.getDurabilidadActual();

        for (int i = 0; i < 250; i++) {
            mano.desgastar(new Madera());
            mano.desgastar(new Piedra());
            mano.desgastar(new Metal());
            mano.desgastar(new Diamante());
        }

        assertEquals(durabilidadInicial, mano.getDurabilidadActual());
    }
}
