package algocraft.material;

import algocraft.desgaste.*;
import algocraft.herramienta.*;

public class Madera extends Material {


    public Madera() {

        this.desgaste = new DesgastePorValor(10);
    }

    @Override
    public boolean desgastarCon(Hacha hacha){
        this.desgaste.desgastarMaterial(hacha);
        return true;
    }


    @Override
    public boolean desgastarCon(Pico pico) { return false; }


    @Override
    public boolean desgastarCon(PicoFino picoFino){ return false; }
}
