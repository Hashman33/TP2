package algocraft.juego.jugador.herramienta;

import algocraft.juego.jugador.desgaste.*;
import algocraft.juego.material.Material;
import algocraft.juego.material.Piedra;

public class HerramientaPiedra implements MaterialHerramienta{

    Piedra piedra = new Piedra();

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

    public boolean esMetal() { return false; }

    public Material getMaterial() {
        return piedra;
    }
}
