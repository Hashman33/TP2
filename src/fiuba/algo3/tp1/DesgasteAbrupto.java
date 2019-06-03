package fiuba.algo3.tp1;

public class DesgasteAbrupto extends Desgaste {

    private int usos;

    public DesgasteAbrupto(int durabilidad, int usos) {
        this.durabilidad = durabilidad;
        this.usos = usos;
    }

    @Override
    public void usar() {
        this.usos--;
        if (usos <= 0) durabilidad = 0;
    }
}
