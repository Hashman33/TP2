package algocraft.herramienta;

import algocraft.material.Material;

public interface MaterialHerramienta {

    void inicializarHacha(Hacha hacha);

    void inicializarPico(Pico pico);

    boolean esPiedra();

    boolean esMetal();

    Material getMaterial();

}
