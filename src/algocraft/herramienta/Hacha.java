package algocraft.herramienta;

import algocraft.material.*;

public class Hacha extends Herramienta{

    protected MaterialHerramienta material;

    public Hacha(MaterialHerramienta material){
        this.material = material;
        material.inicializarHacha(this);
    }

    @Override
    public void desgastar(Material material){
        material.desgastarCon(this);
        desgaste.desgastarHerramienta(this);

    }

    public MaterialHerramienta getMaterial(){ return this.material; }
}
