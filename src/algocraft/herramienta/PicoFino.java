package algocraft.herramienta;

import algocraft.desgaste.*;
import algocraft.material.*;

public class PicoFino extends Herramienta {

    public PicoFino(){
        this.desgaste = new DesgastePorValor(1000);
        this.factor = 0.1;
        this.fuerza = 20;
    }
    @Override
    public void desgastar(Material material){
        if (material.desgastarCon(this)) {
            desgaste.desgastar(this.getDurabilidadActual(),this.factor);
        }
    }
}
