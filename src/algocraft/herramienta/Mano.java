package algocraft.herramienta;

import algocraft.desgaste.DesgastePorValor;
import algocraft.material.Material;

public class Mano extends Herramienta {

    public Mano(){
        this.desgaste = new DesgastePorValor(Double.POSITIVE_INFINITY);
        this.factor = 1;
        this.fuerza = 0;
    }
    @Override
    public void desgastar(Material material){
        material.desgastarCon(this);
        desgaste.desgastarHerramienta(this);
    }

}
