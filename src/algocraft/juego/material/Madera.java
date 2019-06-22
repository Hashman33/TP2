package algocraft.juego.material;

import algocraft.juego.jugador.desgaste.*;
import algocraft.juego.jugador.herramienta.*;
import javafx.scene.image.Image;

public class Madera extends Material {


    public Madera() {

        this.desgaste = new DesgastePorValor(10);
        this.texturaUrl = "/recursos/texturas/madera.png";
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
