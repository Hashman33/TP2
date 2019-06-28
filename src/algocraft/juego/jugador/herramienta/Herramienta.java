package algocraft.juego.jugador.herramienta;

import algocraft.juego.jugador.desgaste.*;
import algocraft.juego.material.*;
import algocraft.utilidades.matriz.Matriz;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Herramienta {

    protected Desgaste desgaste;
    protected double factor;
    protected int fuerza;
    protected Matriz matrizCrafteo;
    protected String texturaUrl = "";
    protected final int ANCHO = 32;
    protected final int ALTO = 32;
    protected final int ANCHOGRANDE = 96;
    protected final int ALTOGRANDE = 96;

    public abstract void desgastar(Material material);

    public double getFactor() {
        return factor;
    }

    public int getFuerza() {
        return fuerza;
    }

    public double getDurabilidadActual(){ return this.desgaste.durabilidad(); }

    public Matriz getMatrizCrafteo(){ return this.matrizCrafteo; }

    public ImageView getTextura() {
        return new ImageView(new Image(this.texturaUrl, ANCHO, ALTO, false,true));
    }

    public ImageView getTexturaGrande() {
        return new ImageView(new Image(this.texturaUrl, ANCHOGRANDE, ALTOGRANDE, false,true));
    }


}
