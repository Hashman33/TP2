package algocraft.material;

import algocraft.desgaste.*;
import algocraft.herramienta.*;

public class Piedra extends Material {


    public Piedra(){
        this.desgaste = new DesgastePorValor(30);

    }
    @Override
    public boolean desgastarCon(Hacha hacha){
        return false;
    }


    @Override
    public boolean desgastarCon(Pico pico){
        this.desgaste.desgastar(pico);
        return true;
    }


    @Override
    public boolean desgastarCon(PicoFino picoFino){
        this.desgaste.desgastar(picoFino);
        return false;
    }

}
