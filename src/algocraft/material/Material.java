package algocraft.material;

import algocraft.desgaste.*;
import algocraft.herramienta.*;

public abstract class Material {

    protected Desgaste desgaste;

    public  boolean desgastarCon(Herramienta herramienta){
        return this.desgastarCon(herramienta);

    }

    public abstract boolean desgastarCon(Hacha hacha);

    public abstract boolean desgastarCon(Pico pico);

    public abstract boolean desgastarCon(PicoFino picoFino);


    public double getDurabilidadActual(){
        return this.desgaste.durabilidad();
    }

    public double getDurabilidadInicial(){
        return this.desgaste.getDurabilidadInicial();
    }



}
