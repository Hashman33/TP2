package algocraft.material;

import algocraft.desgaste.*;
import algocraft.herramienta.*;

public class Metal extends Material {


    public Metal(){
        this.desgaste = new DesgastePorValor(50);
    }

    @Override
    public boolean desgastarCon(Hacha hacha){
        return false;
    }


    @Override
    public boolean desgastarCon(Pico pico){
        if (pico.getMaterial().esPiedra() || pico.getMaterial().esMetal()) {
            this.desgaste.desgastarMaterial(pico);
            return true;
        }
        return false;
    }


    public boolean desgastarCon(PicoFino picoFino){
        this.desgaste.desgastarMaterial(picoFino);
        return false;
    }

}
