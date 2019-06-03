package fiuba.algo3.tp1;

public class Azada extends Herramienta {

    @Override
    protected void inicializarDesgaste() {
        this.desgaste = new DesgasteFibonacci(10);
    }

    @Override
    public Herramienta templar() {
        this.desgaste = new DesgasteLineal(desgaste.durabilidad());
        Herramienta azada = this;
        return this;
    }
}
