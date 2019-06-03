package fiuba.algo3.algocraft;

public abstract class Desgaste {

    protected double durabilidad;

    public double durabilidad() {
        return this.durabilidad;
    }

    public abstract void desgastar(double valor, double factor);
}
