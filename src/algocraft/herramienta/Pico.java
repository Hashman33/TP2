package algocraft.herramienta;

import algocraft.material.*;

public class Pico extends Herramienta{

    protected MaterialHerramienta material;

    public Pico(MaterialHerramienta material){
        this.material = material;
        material.inicializarPico(this);
    }

    @Override
    public void desgastar(Material material){
        material.desgastarCon(this);
        desgaste.desgastarHerramienta(this);

    }

    public MaterialHerramienta getMaterial(){ return this.material; }
}
