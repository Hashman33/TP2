package algocraft;

import algocraft.herramienta.*;

public class Jugador {

    public Inventario inventario;

    Jugador() {

        Hacha hachaMadera = new Hacha(new HerramientaMadera());

        this.inventario = new Inventario();
        this.inventario.agregar(hachaMadera);
        this.inventario.equipar(hachaMadera);
    }

    public Herramienta herramientaEquipada() {
        return this.inventario.herramientaEquipada;
    }

}
