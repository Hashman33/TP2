package algocraft.test.desgaste;

import fiuba.algo3.algocraft.DesgastePorValor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DesgasteTest {

    @Test
    public void test01DesgastePorValorSeCreaConLaDurabilidadInicialCorrecta() {
        DesgastePorValor desgaste = new DesgastePorValor(10);

        assertEquals(desgaste.durabilidad(), 10);
    }

    @Test
    public void test02DesgastePorValorSeDesgastaCorrectamente01() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        int durabilidad = desgaste.durabilidad();
        desgaste.desgastar(1,1);

        assertEquals(desgaste.durabilidad(), durabilidad - 1);
    }
    @Test
    public void test03DesgastePorValorSeDesgastaCorrectamente02() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        int durabilidad = desgaste.durabilidad();
        desgaste.desgastar(1,1);
        desgaste.desgastar(1,1);
        desgaste.desgastar(1,1);

        assertEquals(desgaste.durabilidad(), durabilidad - 3);
    }
    @Test
    public void test04DesgastePorValorSeDesgastaCorrectamente03() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        int durabilidad = desgaste.durabilidad();
        desgaste.desgastar(3,2);


        assertEquals(desgaste.durabilidad(), durabilidad - 6);
    }
    @Test
    public void test05DesgastePorValorSeDesgastaCorrectamente04() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        int durabilidad = desgaste.durabilidad();
        desgaste.desgastar(3,2);
        desgaste.desgastar(2,1);


        assertEquals(desgaste.durabilidad(), durabilidad - 8);
    }
    @Test
    public void test06DesgastePorValorSeDesgastaHastaAgotarDurabilidadYDaCero01() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        desgaste.desgastar(10,1);

        assertEquals(desgaste.durabilidad(), 0);
    }
    @Test
    public void test07DesgastePorValorSeDesgastaHastaAgotarDurabilidadYDaCero02() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        desgaste.desgastar(15,1);

        assertEquals(desgaste.durabilidad(), 0);
    }
    /*
    @Test
    public void test08DesgastePorValorConDurabilidadCeroLanzaDurabilidadCeroExceptionAlDesgastar() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        desgaste.desgastar(15,1);

        assertThrows(DurabilidadCeroException.class,
                ()->{ desgaste.desgastar(1,1);});
    }

    // DesgasteAbruptoTests...
*/
}