package fiuba.algo3.algocraft;

public class HerramientaMadera implements MaterialHerramienta {

    public void inicializarHacha(Hacha hacha) {
        hacha.desgaste = new DesgastePorValor(100);
        hacha.factor = 1;
        hacha.fuerza = 2;
    }

    public void inicializarPico(Pico pico) {
        pico.desgaste = new DesgastePorValor(100);
        pico.factor = 1;
        pico.fuerza = 2;
    }

    public boolean esPiedra() { return false; }

    public boolean esMetal() { return false; }
}
