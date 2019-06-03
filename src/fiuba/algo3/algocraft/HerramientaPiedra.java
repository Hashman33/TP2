package fiuba.algo3.algocraft;

public class HerramientaPiedra implements MaterialHerramienta{

    public void inicializarHacha(Hacha hacha) {
        hacha.desgaste = new DesgastePorValor(200);
        hacha.factor = 1;
        hacha.fuerza = 5;
    }

    public void inicializarPico(Pico pico) {
        pico.desgaste = new DesgastePorValor(200);
        pico.factor = 1 / (1.5);
        pico.fuerza = 4;
    }

    public boolean esPiedra() { return true; }
}
