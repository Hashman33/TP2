package algocraft.juego.jugador.desgaste;

import algocraft.juego.jugador.herramienta.Herramienta;
import algocraft.juego.jugador.herramienta.PicoFino;

public abstract class Desgaste {

    protected double durabilidad;
    protected double durabilidadInicial;

    public double durabilidad() {
        return this.durabilidad;
    }

    public double getDurabilidadInicial() {
        return this.durabilidadInicial;
    }

    public abstract void desgastarMaterial(Herramienta herramienta);

    public abstract void desgastarHerramienta(Herramienta herramienta);

    public abstract  void desgastarPicoFino(PicoFino picoFino);
}
