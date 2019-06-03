package fiuba.algo3.tp1;

public abstract class Desgaste {

    protected int durabilidad;

    public int durabilidad() {
        return this.durabilidad;
    }

    public abstract void usar();
}
