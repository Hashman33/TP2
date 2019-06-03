package fiuba.algo3.algocraft;

public class HachaPiedra extends Herramienta {


    public HachaPiedra(){
        this.desgaste = new DesgastePorValor(200);
        this.factor = 1;
        this.valordesgaste = 5;

    }
    @Override
    public void desgastar(Material material){
        material.desgastarcon(this);
        desgaste.desgastar(this.GetValorDesgaste(),this.factor);

    }
}
