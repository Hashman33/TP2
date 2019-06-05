package algocraft.desgaste;

import algocraft.herramienta.Herramienta;
import algocraft.herramienta.PicoFino;

public class DesgastePorValor extends Desgaste{

    public DesgastePorValor(double durabilidadInicial) {

        this.durabilidad = durabilidadInicial;
        this.durabilidadInicial = durabilidadInicial;

    }


    public void desgastar(Herramienta herramienta) {
        if (durabilidad == 0) throw new DurabilidadCeroException();
        durabilidad -=  herramienta.getFuerza();
        if (durabilidad <= 0) durabilidad = 0;
    }

    public void desgastarHerramienta(Herramienta herramienta){
        if(durabilidad == 0 ) throw new DurabilidadCeroException();
        durabilidad -= herramienta.getFactor() * herramienta.getFuerza();
        if (durabilidad <= 0) durabilidad = 0;

    }

    public void desgastarPicoFino(PicoFino picoFino){
        if(durabilidad == 0 ) throw new DurabilidadCeroException();
        durabilidad -= picoFino.getDurabilidadActual() * 0.1;
        if (durabilidad <= 0) durabilidad = 0;
    }

}

