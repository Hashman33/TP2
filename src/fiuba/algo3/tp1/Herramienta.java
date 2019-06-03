package fiuba.algo3.tp1;

public abstract class Herramienta {

    protected Desgaste desgaste;

    public Herramienta() {
        this.inicializarDesgaste();
    }

    public int durabilidad() {
        return desgaste.durabilidad();
    }

    public void usar() {
        desgaste.usar();
    }

    public void reparar() {
        this.inicializarDesgaste();
    }

    protected abstract void inicializarDesgaste();

    public abstract Herramienta templar();
}
