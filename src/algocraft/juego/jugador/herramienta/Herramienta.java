package algocraft.juego.jugador.herramienta;

import algocraft.juego.jugador.desgaste.*;
import algocraft.juego.material.*;
import algocraft.utilidades.matriz.Matriz;

public abstract class Herramienta {

    protected Desgaste desgaste;
    protected double factor;
    protected int fuerza;
    protected Matriz matrizCrafteo;

    public abstract void desgastar(Material material);

    public double getFactor() {
        return factor;
    }

    public int getFuerza() {
        return fuerza;
    }

    public double getDurabilidadActual(){ return this.desgaste.durabilidad(); }

    public Matriz getMatrizCrafteo(){ return this.matrizCrafteo; }

}