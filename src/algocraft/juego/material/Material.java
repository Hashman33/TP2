package algocraft.juego.material;

import algocraft.juego.jugador.desgaste.*;
import algocraft.juego.jugador.herramienta.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Material {

    protected Desgaste desgaste;
    protected String texturaUrl = "";
    protected final int ANCHO = 32;
    protected final int ALTO = 32;

    public abstract void desgastarCon(Hacha hacha);

    public abstract void desgastarCon(Pico pico);

    public abstract void desgastarCon(PicoFino picoFino);

    public abstract void desgastarCon(Mano mano);

    public abstract  boolean esDiamante();

    public double getDurabilidadActual(){
        return this.desgaste.durabilidad();
    }

    public double getDurabilidadInicial(){
        return this.desgaste.getDurabilidadInicial();
    }

    public ImageView getTextura() {
        return new ImageView(new Image(this.texturaUrl, ANCHO, ALTO, false,true));
    }

}
