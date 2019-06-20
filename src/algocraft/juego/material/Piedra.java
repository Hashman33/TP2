package algocraft.juego.material;

import algocraft.juego.jugador.desgaste.*;
import algocraft.juego.jugador.herramienta.*;

public class Piedra extends Material {


    public Piedra(){
        this.desgaste = new DesgastePorValor(30);

    }
    @Override
    public void desgastarCon(Hacha hacha){
    }


    @Override
    public void desgastarCon(Pico pico){
        this.desgaste.desgastarMaterial(pico);
        if (desgaste.durabilidad() == 0) throw new MaterialDestruidoException();
    }


    @Override
    public void desgastarCon(PicoFino picoFino){
        this.desgaste.desgastarMaterial(picoFino);
        if (desgaste.durabilidad() == 0) throw new MaterialDestruidoException();
    }

    @Override
    public void desgastarCon(Mano mano) { }

    @Override
    public boolean esDiamante() {
        return false;
    }

    public String toString(){ return "pie ";}

}
