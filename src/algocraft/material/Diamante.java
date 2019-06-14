package algocraft.material;

import algocraft.desgaste.*;
import algocraft.herramienta.*;

public class Diamante extends Material {


    public Diamante(){
        this.desgaste = new DesgastePorValor(100);

    }
    @Override
    public void desgastarCon(Hacha hacha) { }


    @Override
    public void desgastarCon(Pico pico) { }


    @Override
    public void desgastarCon(PicoFino picoFino){
        this.desgaste.desgastarMaterial(picoFino);
    }

    @Override
    public void desgastarCon(Mano mano) { }

    @Override
    public boolean esDiamante() {
        return true;
    }

    public String toString(){ return "dia ";}
}
