package algocraft.test.herramienta;

import fiuba.algo3.tp1.Hacha;
import fiuba.algo3.tp1.Herramienta;
import fiuba.algo3.tp1.Herrero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HerramientaTests {

    @Test
    public void test01HerreroUsaHachaReduceSuDurabilidadLinealmente() {
        Herrero herrero = new Herrero();
        Herramienta hacha = herrero.construirHacha();
        int durabilidadHacha = hacha.durabilidad();

        assertEquals(durabilidadHacha, hacha.durabilidad());

        herrero.usar(hacha);
        assertEquals(durabilidadHacha -1, hacha.durabilidad());

        herrero.usar(hacha);
        assertEquals(durabilidadHacha -2, hacha.durabilidad());
    }

    @Test
    public void test02HerreroUsaPicoSinDesgasteYSeRompeLaQuinta() {
        Herrero herrero = new Herrero();
        Herramienta pico = herrero.construirPico();

        int durabilidadPico = pico.durabilidad();

        herrero.usar(pico);
        assertEquals(durabilidadPico, pico.durabilidad());

        herrero.usar(pico);
        assertEquals(durabilidadPico, pico.durabilidad());

        herrero.usar(pico);
        assertEquals(durabilidadPico, pico.durabilidad());

        herrero.usar(pico);
        assertEquals(durabilidadPico, pico.durabilidad());

        herrero.usar(pico);
        assertEquals(0, pico.durabilidad());
    }

    @Test
    public void test03HerreroUsaAzadaSeReduceDurabilidadConFibonacci() {
        Herrero herrero = new Herrero();
        Herramienta azada = herrero.construirAzada();

        int durabilidadAzada = azada.durabilidad();

        // Ver secuencia de Fibonacci
        herrero.usar(azada);
        assertEquals(durabilidadAzada, azada.durabilidad());

        herrero.usar(azada);
        assertEquals(durabilidadAzada -1, azada.durabilidad());

        herrero.usar(azada);
        assertEquals(durabilidadAzada -1, azada.durabilidad());

        herrero.usar(azada);
        assertEquals(durabilidadAzada -2, azada.durabilidad());

        herrero.usar(azada);
        assertEquals(durabilidadAzada -3, azada.durabilidad());

        herrero.usar(azada);
        assertEquals(durabilidadAzada -5, azada.durabilidad());
    }

    @Test
    public void test04HerreroReparaHachaGastadaParaRestaurarDurabilidad() {
        Herrero herrero = new Herrero();
        Herramienta hacha = herrero.construirHacha();
        int durabilidadHacha = hacha.durabilidad();

        herrero.usar(hacha);
        assertEquals(durabilidadHacha - 1, hacha.durabilidad());

        herrero.reparar(hacha);
        assertEquals(durabilidadHacha, hacha.durabilidad());
    }

    @Test
    public void test05HerreroUsaPicoTempladoConMasDuracion() {
        Herrero herrero = new Herrero();
        Herramienta pico = herrero.construirPico();
        int durabilidadPico = pico.durabilidad();

        pico = herrero.templar(pico);

        herrero.usar(pico);
        herrero.usar(pico);
        herrero.usar(pico);
        herrero.usar(pico);
        herrero.usar(pico);
        herrero.usar(pico);
        herrero.usar(pico);

        assertEquals(durabilidadPico, pico.durabilidad());

        herrero.usar(pico);
        assertEquals(0, pico.durabilidad());
    }

    @Test
    public void test06HerreroUsaHachaTempladoYSeRompeALaQuinta() {
        Herrero herrero = new Herrero();
        Herramienta hacha = herrero.construirHacha();
        int durabilidadHacha = hacha.durabilidad();

        // Usa el hacha y se desgasta linealmente
        herrero.usar(hacha);
        assertEquals(durabilidadHacha - 1, hacha.durabilidad());

        // templa el hacha y no tiene desgaste pero se rompe a la quinta, como el pico
        hacha = herrero.templar(hacha);

        herrero.usar(hacha);
        assertEquals(durabilidadHacha - 1, hacha.durabilidad());

        herrero.usar(hacha);
        assertEquals(durabilidadHacha - 1, hacha.durabilidad());

        herrero.usar(hacha);
        assertEquals(durabilidadHacha - 1, hacha.durabilidad());

        herrero.usar(hacha);
        assertEquals(durabilidadHacha - 1, hacha.durabilidad());

        herrero.usar(hacha);
        assertEquals(0, hacha.durabilidad());
    }

    @Test
    public void test07HerreroUsaAzadaTempladaSeReduceDurabilidadLineal() {
        Herrero herrero = new Herrero();
        Herramienta azada = herrero.construirAzada();
        int durabilidadAzada = azada.durabilidad();

        // sin templar, disminuye con secuencia fibonacci
        herrero.usar(azada);
        assertEquals(durabilidadAzada, azada.durabilidad());

        herrero.usar(azada);
        assertEquals(durabilidadAzada - 1, azada.durabilidad());

        herrero.usar(azada);
        assertEquals(durabilidadAzada - 1, azada.durabilidad());

        herrero.usar(azada);
        assertEquals(durabilidadAzada - 2, azada.durabilidad());

        // templa la azada y disminuye linealmente, como el acha
        herrero.templar(azada);
        assertEquals(durabilidadAzada - 2, azada.durabilidad());

        herrero.usar(azada);
        assertEquals(durabilidadAzada - 3, azada.durabilidad());

        herrero.usar(azada);
        assertEquals(durabilidadAzada - 4, azada.durabilidad());
    }

    @Test
    public void test08HerreroReparaPicoYRecuperaCincoUsos() {
        Herrero herrero = new Herrero();
        Herramienta pico = herrero.construirPico();
        int durabilidadPico = pico.durabilidad();

        // usa el pico varias veces
        herrero.usar(pico);
        assertEquals(durabilidadPico, pico.durabilidad());

        herrero.usar(pico);
        assertEquals(durabilidadPico, pico.durabilidad());

        // repara el pico
        herrero.reparar(pico);

        // recupera la posibilidad de usarlo 4 veces sin desgaste y luego se rompe a la quinta
        herrero.usar(pico);
        assertEquals(durabilidadPico, pico.durabilidad());

        herrero.usar(pico);
        assertEquals(durabilidadPico, pico.durabilidad());

        herrero.usar(pico);
        assertEquals(durabilidadPico, pico.durabilidad());

        herrero.usar(pico);
        assertEquals(durabilidadPico, pico.durabilidad());

        herrero.usar(pico);
        assertEquals(0, pico.durabilidad());
    }
    @Test
    public void test09HachaFuncionaCorrectamente(){
        Hacha hacha = new Hacha();
        int durabilidadHacha = hacha.durabilidad();

        hacha.usar();
        assertEquals(durabilidadHacha -1 , hacha.durabilidad());

        for(int i = 0; i<4; i++ ){
            hacha.usar();
            }

        assertEquals(durabilidadHacha -5, hacha.durabilidad());


    }
}
