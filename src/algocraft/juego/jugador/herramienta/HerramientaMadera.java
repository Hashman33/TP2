package algocraft.juego.jugador.herramienta;

import algocraft.juego.jugador.desgaste.*;
import algocraft.juego.material.Madera;
import algocraft.juego.material.Material;

public class HerramientaMadera implements MaterialHerramienta {

    Madera material = new Madera();

    public void inicializarHacha(Hacha hacha) {
        hacha.texturaUrl = "/recursos/texturas/hachamadera.png";
        hacha.desgaste = new DesgastePorValor(100);
        hacha.factor = 1;
        hacha.fuerza = 2;
    }

    public void inicializarPico(Pico pico) {
        pico.texturaUrl = "/recursos/texturas/picomadera.png";
        pico.desgaste = new DesgastePorValor(100);
        pico.factor = 1;
        pico.fuerza = 2;
    }

    public boolean esPiedra() { return false; }

    public boolean esMetal() { return false; }

    public Material getMaterial() {
        return this.material;
    }
}
