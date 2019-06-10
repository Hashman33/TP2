package algocraft.desgaste;

import algocraft.herramienta.Hacha;
import algocraft.herramienta.HerramientaMadera;
import algocraft.herramienta.HerramientaPiedra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DesgasteTests {

    @Test
    public void test01DesgastePorValorSeCreaConLaDurabilidadInicialCorrecta() {
        DesgastePorValor desgaste = new DesgastePorValor(10);

        assertEquals(desgaste.durabilidad(), 10);
    }

    @Test
    public void test02DesgastePorValorSeDesgastaCorrectamente01() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        double durabilidad = desgaste.durabilidad();
        Hacha hacha = new Hacha ( new HerramientaMadera());
        desgaste.desgastarMaterial(hacha);

        assertEquals(desgaste.durabilidad(), durabilidad - 2);
    }
    @Test
    public void test03DesgastePorValorSeDesgastaCorrectamente02() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        double durabilidad = desgaste.durabilidad();
        Hacha hacha = new Hacha ( new HerramientaMadera());
        desgaste.desgastarMaterial(hacha);
        desgaste.desgastarMaterial(hacha);
        desgaste.desgastarMaterial(hacha);

        assertEquals(desgaste.durabilidad(), durabilidad - 6);
    }
    @Test
    public void test04DesgasteHerramientaDesgastaCorrectamenteLaHerramienta03() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        double durabilidad = desgaste.durabilidad();
        Hacha hacha = new Hacha ( new HerramientaMadera());
        desgaste.desgastarHerramienta(hacha);

        assertEquals(desgaste.durabilidad(), durabilidad - 2);
    }
    @Test
    public void test05DesgasteHerramientaDesgastaCorrectamenteLaHerramienta04() {
        DesgastePorValor desgaste = new DesgastePorValor(20);
        double durabilidad = desgaste.durabilidad();
        Hacha hacha = new Hacha ( new HerramientaPiedra());

        desgaste.desgastarMaterial(hacha);
        desgaste.desgastarMaterial(hacha);


        assertEquals(desgaste.durabilidad(), durabilidad - 10);
    }
    @Test
    public void test06DesgastePorValorSeDesgastaHastaAgotarDurabilidadYDaCero01() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        Hacha hacha = new Hacha ( new HerramientaMadera());
        for (int i = 0; i < 5; i++){
            desgaste.desgastarMaterial(hacha);
        }

        assertEquals(desgaste.durabilidad(), 0);
    }
    @Test
    public void test07DesgastePorValorSeDesgastaHastaAgotarDurabilidadYDaCero02() {
        DesgastePorValor desgaste = new DesgastePorValor(16);

        Hacha hacha = new Hacha ( new HerramientaMadera());
        for (int i = 0; i < 8; i++){
            desgaste.desgastarMaterial(hacha);
        }

        assertEquals(desgaste.durabilidad(), 0);
    }

    @Test
    public void test08DesgastePorValorConDurabilidadCeroLanzaDurabilidadCeroExceptionAlDesgastar() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        Hacha hacha = new Hacha ( new HerramientaMadera());
        for (int i = 0; i < 5; i++){
            desgaste.desgastarMaterial(hacha);
        }

        assertThrows(DurabilidadCeroException.class,
                ()->{ desgaste.desgastarMaterial(hacha);});
    }

    // desgaste abrupto tests
}