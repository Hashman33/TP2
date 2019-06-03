package fiuba.algo3.algocraft;

public class DesgasteAbrupto extends Desgaste {

    private int usos;

    public DesgasteAbrupto(double durabilidad, int usos) {
        this.durabilidad = durabilidad;
        this.usos = usos;
    }

    @Override
    public void desgastar(double valor, double factor) {
        if (durabilidad == 0) throw new DurabilidadCeroException();
        this.usos--;
        if (usos <= 0) durabilidad = 0;
    }
}
