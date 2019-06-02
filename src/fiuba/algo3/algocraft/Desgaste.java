package fiuba.algo3.algocraft;

public abstract class Desgaste {

    protected int durabilidad;

    public int durabilidad() {
        return this.durabilidad;
    }

    public abstract void desgastar(int valor, int factor);
}
