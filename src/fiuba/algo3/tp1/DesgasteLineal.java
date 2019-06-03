package fiuba.algo3.tp1;

public class DesgasteLineal extends Desgaste {

    public DesgasteLineal(int durabilidadInicial) {
        this.durabilidad = durabilidadInicial;
    }

    @Override
    public void usar() {
        if (durabilidad == 0) throw new HerramientaNoSePuedeUsarSinDurabilidadException();
        durabilidad--;
    }
}
