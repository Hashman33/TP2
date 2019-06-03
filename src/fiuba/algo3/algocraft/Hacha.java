package fiuba.algo3.algocraft;

public class Hacha extends Herramienta{

    protected MaterialHerramienta material;

    public Hacha(MaterialHerramienta material){
        this.material = material;
        material.inicializarHacha(this);
    }

    @Override
    public void desgastar(Material material){
        material.desgastarCon(this);
        desgaste.desgastar(this.fuerza,this.factor);

    }
}
