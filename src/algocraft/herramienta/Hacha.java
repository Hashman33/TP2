package algocraft.herramienta;

import algocraft.desgaste.DurabilidadCeroException;
import algocraft.material.*;

public class Hacha extends Herramienta{

    protected MaterialHerramienta material;

    public Hacha(MaterialHerramienta material){
        this.material = material;
        material.inicializarHacha(this);
    }

    @Override
    public void desgastar(Material material){

        try {
            desgaste.desgastarHerramienta(this);
        } catch (DurabilidadCeroException e) {
            throw new HerramientaEstaRotaException();
        }
        material.desgastarCon(this);
    }

    public MaterialHerramienta getMaterial(){ return this.material; }
}
