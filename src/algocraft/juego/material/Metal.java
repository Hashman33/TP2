package algocraft.juego.material;

import algocraft.juego.jugador.desgaste.*;
import algocraft.juego.jugador.herramienta.*;
import javafx.scene.image.Image;

public class Metal extends Material {


    public Metal(){
        this.desgaste = new DesgastePorValor(50);
        this.texturaUrl = "/recursos/texturas/metal.jpeg";
        this.texturaInvUrl = "/recursos/texturas/umetal.png";
    }

    @Override
    public void desgastarCon(Hacha hacha) {}


    @Override
    public void desgastarCon(Pico pico){
        if (pico.getMaterial().esPiedra() || pico.getMaterial().esMetal()) {
            this.desgaste.desgastarMaterial(pico);
            if (desgaste.durabilidad() == 0) throw new MaterialDestruidoException();
        }
    }


    @Override
    public void desgastarCon(PicoFino picoFino){
        this.desgaste.desgastarMaterial(picoFino);
        if (desgaste.durabilidad() == 0) throw new MaterialDestruidoException();
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
