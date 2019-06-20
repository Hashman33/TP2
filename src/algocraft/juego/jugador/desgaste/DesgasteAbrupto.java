package algocraft.juego.jugador.desgaste;

import algocraft.juego.jugador.herramienta.Herramienta;
import algocraft.juego.jugador.herramienta.PicoFino;

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
    public void desgastarMaterial(Herramienta herramienta){
        this.desgastarHerramienta(herramienta);
    }
    @Override
    public void desgastarPicoFino(PicoFino picoFino){
        this.desgastarHerramienta(picoFino);;
    }

    public int getUsos() {
        return this.usos;
    }
}
