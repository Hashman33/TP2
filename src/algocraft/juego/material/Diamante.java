package algocraft.juego.material;

import algocraft.juego.jugador.desgaste.*;
import algocraft.juego.jugador.herramienta.*;
import javafx.scene.image.Image;

public class Diamante extends Material {


    public Diamante(){
        this.desgaste = new DesgastePorValor(100);
        this.texturaUrl = "/recursos/texturas/diamante.png";
        this.texturaInvUrl = "/recursos/texturas/udiamante.png";
    }
    @Override
    public void desgastarCon(Hacha hacha) { }


    @Override
    public void desgastarCon(Pico pico) { }


    @Override
    public void desgastarCon(PicoFino picoFino){
        this.desgaste.desgastarMaterial(picoFino);
        if (desgaste.durabilidad() == 0) throw new MaterialDestruidoException();
    }

    @Override
    public void desgastarCon(Mano mano) { }

    @Override
    public boolean esDiamante() {
        return true;
    }

    public String toString(){ return "dia ";}
}
