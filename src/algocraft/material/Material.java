package algocraft.material;

import algocraft.desgaste.*;
import algocraft.herramienta.*;

public abstract class Material {

    protected Desgaste desgaste;

    public  boolean desgastarCon(Herramienta herramienta){
        return this.desgastarCon(herramienta);

    }

    public abstract void desgastarCon(Hacha hacha);

    public abstract void desgastarCon(Pico pico);

    public abstract void desgastarCon(PicoFino picoFino);

    public abstract void desgastarCon(Mano mano);

    public abstract  boolean esDiamante();

    public double getDurabilidadActual(){
        return this.desgaste.durabilidad();
    }

    public double getDurabilidadInicial(){
        return this.desgaste.getDurabilidadInicial();
    }



}
