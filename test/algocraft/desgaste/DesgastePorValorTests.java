package algocraft.desgaste;

import algocraft.herramienta.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DesgastePorValorTests {

    @Test
    public void test01DesgastePorValorSeCreaConLaDurabilidadInicialCorrecta() {
        DesgastePorValor desgaste = new DesgastePorValor(10);

        assertEquals(desgaste.durabilidad(), 10);
    }

    // DESGASTAR MATERIAL
    @Test
    public void test02DesgastePorValorDesgastaCorrectamenteElMaterial01() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        Hacha hacha = new Hacha (new HerramientaMadera());
        desgaste.desgastarMaterial(hacha);

        assertEquals(desgaste.durabilidad(), desgaste.getDurabilidadInicial() - 2);
    }
    @Test
    public void test03DesgastePorValorDesgastaCorrectamenteElMaterial02() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        Hacha hacha = new Hacha (new HerramientaMadera());
        desgaste.desgastarMaterial(hacha);
        desgaste.desgastarMaterial(hacha);
        desgaste.desgastarMaterial(hacha);

        assertEquals(desgaste.durabilidad(), desgaste.getDurabilidadInicial() - 6);
    }

    @Test
    public void test04DesgastePorValorDesgastaMaterialHastaAgotarDurabilidadYDaCero() {
        DesgastePorValor desgaste = new DesgastePorValor(9);
        Hacha hacha = new Hacha (new HerramientaMadera());
        for (int i = 0; i < 5; i++){
            desgaste.desgastarMaterial(hacha);
        }

        assertEquals(desgaste.durabilidad(), 0);
    }

    @Test
    public void test05DesgastePorValorConDurabilidadCeroLanzaDurabilidadCeroExceptionAlDesgastarMaterial() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        Hacha hacha = new Hacha (new HerramientaMadera());
        for (int i = 0; i < 5; i++){
            desgaste.desgastarMaterial(hacha);
        }

        assertThrows(DurabilidadCeroException.class,
                ()->{ desgaste.desgastarMaterial(hacha);});
    }

    // DESGASTAR HERRAMIENTA
    @Test
    public void test06DesgastePorValorDesgastaCorrectamenteLaHerramienta01() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        Hacha hacha = new Hacha (new HerramientaMadera());
        desgaste.desgastarHerramienta(hacha);

        assertEquals(desgaste.durabilidad(), desgaste.getDurabilidadInicial() - 2);
    }

    @Test
    public void test07DesgasteHerramientaDesgastaCorrectamenteLaHerramienta02() {
        DesgastePorValor desgaste = new DesgastePorValor(20);
        Hacha hacha = new Hacha (new HerramientaPiedra());

        desgaste.desgastarMaterial(hacha);
        desgaste.desgastarMaterial(hacha);


        assertEquals(desgaste.durabilidad(), desgaste.getDurabilidadInicial() - 10);
    }

    @Test
    public void test08DesgastePorValorDesgastaHerramientaHastaAgotarDurabilidadYDaCero01() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        Hacha hacha = new Hacha (new HerramientaMadera());
        for (int i = 0; i < 5; i++){
            desgaste.desgastarMaterial(hacha);
        }

        assertEquals(desgaste.durabilidad(), 0);
    }
    @Test
    public void test09DesgastePorValorSeDesgastaHastaAgotarDurabilidadYDaCero02() {
        DesgastePorValor desgaste = new DesgastePorValor(12);

        Hacha hacha = new Hacha (new HerramientaPiedra());
        for (int i = 0; i < 3; i++){
            desgaste.desgastarMaterial(hacha);
        }

        assertEquals(desgaste.durabilidad(), 0);
    }

    @Test
    public void test10DesgastePorValorConDurabilidadCeroLanzaDurabilidadCeroExceptionAlDesgastarHerramienta() {
        DesgastePorValor desgaste = new DesgastePorValor(10);
        Hacha hacha = new Hacha (new HerramientaMadera());
        for (int i = 0; i < 5; i++){
            desgaste.desgastarHerramienta(hacha);
        }

        assertThrows(DurabilidadCeroException.class,
                ()->{ desgaste.desgastarHerramienta(hacha);});
    }

    // DESGASTAR PICO FINO
    @Test
    public void test11DesgastePorValorDesgastaCorrectamentePicoFino01() {
        DesgastePorValor desgaste = new DesgastePorValor(1000);
        PicoFino picoFino = new PicoFino();
        desgaste.desgastarPicoFino(picoFino);

        assertEquals(desgaste.durabilidad(), desgaste.getDurabilidadInicial() - picoFino.getDurabilidadActual() * 0.1);
    }
    @Test
    public void test12DesgastePorValorDesgastaCorrectamentePicoFino02() {
        DesgastePorValor desgaste = new DesgastePorValor(1000);
        double durabilidad = desgaste.getDurabilidadInicial();
        PicoFino picoFino = new PicoFino();
        desgaste.desgastarPicoFino(picoFino);
        desgaste.desgastarPicoFino(picoFino);
        desgaste.desgastarPicoFino(picoFino);

        for (int i = 0; i < 3; i++) { durabilidad -= picoFino.getDurabilidadActual() * 0.1; }
        assertEquals(desgaste.durabilidad(), durabilidad);
    }
}