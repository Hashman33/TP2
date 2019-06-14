package algocraft.material;

import algocraft.desgaste.*;
import algocraft.herramienta.*;

public class Diamante extends Material {


    public Diamante(){
        this.desgaste = new DesgastePorValor(100);

    }
    @Override
    public boolean desgastarCon(Hacha hacha){
        return false;
    }


    @Override
    public boolean desgastarCon(Pico pico){
        return false;
    }


    @Override
    public boolean desgastarCon(PicoFino picoFino){
        this.desgaste.desgastarMaterial(picoFino);
        return true;
    }

    @Override
    public boolean desgastarCon(Mano mano) {
        return false;
    }

    public String toString(){ return "dia ";}
}
