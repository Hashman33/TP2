package fiuba.algo3.algocraft;

public class HerramientaMetal implements MaterialHerramienta {

    public void inicializarHacha(Hacha hacha) {
        hacha.desgaste = new DesgastePorValor(400);
        hacha.factor = 0.5;
        hacha.fuerza = 10;
    }

    public void inicializarPico(Pico pico) {
        pico.desgaste = new DesgasteAbrupto(400, 10);
        pico.factor = 1;
        pico.fuerza = 12;
    }

    public void inicializarPicoFino(PicoFino picoFino) {
        picoFino.desgaste = new DesgastePorValor(1000);
        picoFino.factor = 0.1;
        picoFino.fuerza = 20;
    }

    public boolean esPiedra() { return false; }
}
