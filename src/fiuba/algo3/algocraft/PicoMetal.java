package fiuba.algo3.algocraft;

public class PicoMetal extends Herramienta {

    public PicoMetal(){
        this.desgaste = new DesgasteAbrupto(400,10);
        this.factor = 1;
        this.fuerza = 12;
    }
    @Override
    public void desgastar(Material material){
        material.desgastarcon(this);
        desgaste.desgastar(this.fuerza,this.factor);

    }
}
