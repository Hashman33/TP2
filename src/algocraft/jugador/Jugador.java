package algocraft.jugador;

import algocraft.herramienta.*;
import algocraft.jugador.Inventario;

public class Jugador {

    public Inventario inventario;

    public Jugador() {

        Hacha hachaMadera = new Hacha(new HerramientaMadera());

        this.inventario = new Inventario();
        this.inventario.agregar(hachaMadera);
        this.inventario.equipar(hachaMadera);
    }

    public Herramienta herramientaEquipada() {
        return this.inventario.herramientaEquipada;
    }

}
