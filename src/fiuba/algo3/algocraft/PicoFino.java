package fiuba.algo3.algocraft;

public class PicoFino extends Herramienta {

    protected MaterialHerramienta material;

    public PicoFino(MaterialHerramienta material){

        this.material = material;
        material.inicializarPicoFino(this);
    }
    @Override
    public void desgastar(Material material){
        if (material.desgastarCon(this)) {
            desgaste.desgastar(this.getDurabilidadActual(),this.factor);
        }
    }
}
