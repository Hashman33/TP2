package algocraft.juego.material;

import algocraft.juego.jugador.desgaste.*;
import algocraft.juego.jugador.herramienta.*;

public abstract class Material {

    protected Desgaste desgaste;


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
