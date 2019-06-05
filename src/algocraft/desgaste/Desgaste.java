package algocraft.desgaste;

import algocraft.herramienta.Herramienta;
import algocraft.herramienta.PicoFino;

public abstract class Desgaste {

    protected double durabilidad;
    protected double durabilidadInicial;

    public double durabilidad() {
        return this.durabilidad;
    }

    public double getDurabilidadInicial() {
        return this.durabilidadInicial;
    }

    public abstract void desgastar(Herramienta herramienta);

    public abstract void desgastarHerramienta(Herramienta herramienta);

    public abstract  void desgastarPicoFino(PicoFino picoFino);
}
