package fiuba.algo3.algocraft;

public class HachaMetal extends Herramienta {


    public HachaMetal(){
        this.desgaste = new DesgastePorValor(400);
        this.fuerza = 10;
        this.factor = 0.5;

    }

    @Override
    public void desgastar(Material material){
        material.desgastarcon(this);
        desgaste.desgastar(this.fuerza,this.factor);

    }
}
