package algocraft.desgaste;

import algocraft.herramienta.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DesgasteAbruptoTests {

    @Test
    public void test01desgasteAbruptoSeInicilizaCorrectamente() {
        DesgasteAbrupto desgaste = new DesgasteAbrupto(10, 5);

        assertEquals(desgaste.durabilidad(), 10);
        assertEquals(desgaste.getUsos(), 5);
    }

    // DESGASTAR MATERIAL
    @Test
    public void test02DesgasteAbruptoDesgastaMaterialSinAgotarUsosYSuDUrabilidadNoSeModifica01() {
        DesgasteAbrupto desgaste = new DesgasteAbrupto(10, 8);
        Pico pico = new Pico (new HerramientaPiedra());
        desgaste.desgastarMaterial(pico);
        desgaste.desgastarMaterial(pico);

        assertEquals(desgaste.durabilidad(), desgaste.getDurabilidadInicial() );
    }

    @Test
    public void test03DesgasteAbruptoDesgastaMaterialSinAgotarUsosYSuDurabilidadNoSeModifica02() {
        DesgasteAbrupto desgaste = new DesgasteAbrupto(10, 8);
        Pico pico = new Pico (new HerramientaPiedra());
        desgaste.desgastarMaterial(pico);
        desgaste.desgastarMaterial(pico);
        desgaste.desgastarMaterial(pico);
        desgaste.desgastarMaterial(pico);

        assertEquals(desgaste.durabilidad(), desgaste.getDurabilidadInicial() );
    }

    @Test
    public void test03DesgasteAbruptoDesgastaMaterialHastaAgotarUsosYSuDurabilidadEsCero() {
        DesgasteAbrupto desgaste = new DesgasteAbrupto(10, 8);
        Pico pico = new Pico (new HerramientaPiedra());
        for (int i = 0; i < 8; i++){
            desgaste.desgastarMaterial(pico);
        }

        assertEquals(desgaste.durabilidad(), 0);
    }

    @Test
    public void test04DesgasteAbruptoDesgastaMaterialConDurabilidadCeroYLanzaDurabilidadCeroException() {
        DesgasteAbrupto desgaste = new DesgasteAbrupto(10, 8);
        Pico pico = new Pico (new HerramientaPiedra());
        for (int i = 0; i < 8; i++){
            desgaste.desgastarMaterial(pico);
        }

        assertThrows(DurabilidadCeroException.class,
                ()->{ desgaste.desgastarMaterial(pico);;});
    }

    @Test
    public void test05DesgasteAbruptoDesgastaHerramientaSinAgotarUsosYSuDUrabilidadNoSeModifica01() {
        DesgasteAbrupto desgaste = new DesgasteAbrupto(10, 5);
        Hacha hacha = new Hacha (new HerramientaMadera());
        desgaste.desgastarHerramienta(hacha);
        desgaste.desgastarHerramienta(hacha);

        assertEquals(desgaste.durabilidad(), desgaste.getDurabilidadInicial() );
    }

    @Test
    public void test06DesgasteAbruptoDesgastaHerramientaSinAgotarUsosYSuDurabilidadNoSeModifica02() {
        DesgasteAbrupto desgaste = new DesgasteAbrupto(10, 5);
        Hacha hacha = new Hacha (new HerramientaMadera());
        desgaste.desgastarHerramienta(hacha);
        desgaste.desgastarHerramienta(hacha);
        desgaste.desgastarHerramienta(hacha);
        desgaste.desgastarHerramienta(hacha);

        assertEquals(desgaste.durabilidad(), desgaste.getDurabilidadInicial() );
    }

    @Test
    public void test07DesgasteAbruptoDesgastaHerramientaHastaAgotarUsosYSuDurabilidadEsCero() {
        DesgasteAbrupto desgaste = new DesgasteAbrupto(10, 5);
        Hacha hacha = new Hacha (new HerramientaMadera());
        for (int i = 0; i < 5; i++){
            desgaste.desgastarHerramienta(hacha);
        }

        assertEquals(desgaste.durabilidad(), 0);
    }

    @Test
    public void test08DesgasteAbruptoDesgastaHerramientaConDurabilidadCeroYLanzaDurabilidadCeroException() {
        DesgasteAbrupto desgaste = new DesgasteAbrupto(10, 5);
        Hacha hacha = new Hacha (new HerramientaMadera());
        for (int i = 0; i < 5; i++){
            desgaste.desgastarHerramienta(hacha);
        }

        assertThrows(DurabilidadCeroException.class,
                ()->{ desgaste.desgastarHerramienta(hacha);});
    }
}
