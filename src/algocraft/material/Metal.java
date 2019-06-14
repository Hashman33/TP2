package algocraft.material;

import algocraft.desgaste.*;
import algocraft.herramienta.*;

public class Metal extends Material {


    public Metal(){
        this.desgaste = new DesgastePorValor(50);
    }

    @Override
    public void desgastarCon(Hacha hacha) {}


    @Override
    public void desgastarCon(Pico pico){
        if (pico.getMaterial().esPiedra() || pico.getMaterial().esMetal()) {
            this.desgaste.desgastarMaterial(pico);
        }
    }


    @Override
    public void desgastarCon(PicoFino picoFino){
        this.desgaste.desgastarMaterial(picoFino);
    }

    @Override
    public void desgastarCon(Mano mano) {
    }

    @Override
    public boolean esDiamante() {
        return false;
    }

    public String toString(){ return "Met ";}

}
