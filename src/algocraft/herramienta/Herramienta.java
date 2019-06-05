package algocraft.herramienta;

import algocraft.desgaste.*;
import algocraft.material.*;

public abstract class Herramienta {

    protected Desgaste desgaste;
    protected double factor;
    protected int fuerza;

    public void desgastar(Material material){
        material.desgastarCon(this);
        desgaste.desgastar(this);

    }

    public double getFactor() {
        return factor;
    }

    public int getFuerza() {
        return fuerza;
    }
    public double getDurabilidadActual(){ return this.desgaste.durabilidad(); }

}
