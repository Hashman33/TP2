package fiuba.algo3.tp1;

public class Hacha extends Herramienta {

    @Override
    protected void inicializarDesgaste() {
        this.desgaste = new DesgasteLineal(10);
    }

    @Override
    public Herramienta templar() {
        this.desgaste = new DesgasteAbrupto(desgaste.durabilidad(), 5);
        return this;
    }
}
