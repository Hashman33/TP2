package fiuba.algo3.algocraft;

public abstract class Desgaste {

    protected double durabilidad;
    protected double durabilidadInicial;

    public double durabilidad() {
        return this.durabilidad;
    }

    public double getDurabilidadInicial() {
        return this.durabilidadInicial;
    }

    public abstract void desgastar(double valor, double factor);
}
