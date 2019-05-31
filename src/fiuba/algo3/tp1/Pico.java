package fiuba.algo3.tp1;

public class Pico extends Herramienta {

    @Override
    protected void inicializarDesgaste() {
        this.desgaste = new DesgasteAbrupto(10, 5);
    }

    @Override
    public Herramienta templar() {
        this.desgaste = new DesgasteAbrupto(10, 8);
        return this;
    }
}
