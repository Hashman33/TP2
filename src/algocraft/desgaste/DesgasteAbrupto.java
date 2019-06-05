package algocraft.desgaste;

import algocraft.herramienta.Herramienta;
import algocraft.herramienta.PicoFino;

public class DesgasteAbrupto extends Desgaste {

    private int usos;

    public DesgasteAbrupto(double durabilidad, int usos) {
        this.durabilidad = durabilidad;
        this.durabilidadInicial = durabilidad;
        this.usos = usos;
    }


    @Override
    public void desgastarHerramienta(Herramienta Herramienta) {
        if (durabilidad == 0) throw new DurabilidadCeroException();
        this.usos--;
        if (usos <= 0) durabilidad = 0;
    }
    @Override
    public void desgastar(Herramienta herramienta){
        if (durabilidad == 0) throw new DurabilidadCeroException();
        this.usos--;
        if (usos <= 0) durabilidad = 0;
    }
    @Override
    public void desgastarPicoFino(PicoFino picoFino){
        if (durabilidad == 0) throw new DurabilidadCeroException();
        this.usos--;
        if (usos <= 0) durabilidad = 0;
    }

}
