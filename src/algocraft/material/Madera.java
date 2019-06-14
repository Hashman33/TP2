package algocraft.material;

import algocraft.desgaste.*;
import algocraft.herramienta.*;

public class Madera extends Material {


    public Madera() {

        this.desgaste = new DesgastePorValor(10);
    }

    @Override
    public void desgastarCon(Hacha hacha){
        this.desgaste.desgastarMaterial(hacha);
        if (desgaste.durabilidad() == 0) throw new MaterialDestruidoException();
    }

    @Override
    public void desgastarCon(Pico pico) {}


    @Override
    public void desgastarCon(PicoFino picoFino){}

    @Override
    public void desgastarCon(Mano mano) {}

    @Override
    public boolean esDiamante() {
        return false;
    }

    public String toString(){ return "Mad ";}

}
