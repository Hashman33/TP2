package fiuba.algo3.algocraft;

public class PicoFino extends Herramienta {

    public PicoFino(){
        this.desgaste = new DesgastePorValor(1000);
        this.factor = 0.1;
        this.fuerza = 20;
    }
    @Override
    public void desgastar(Material material){
        if (material.desgastarcon(this)) {
            desgaste.desgastar(this.getDurabilidadActual(),this.factor);
        }
    }
}
