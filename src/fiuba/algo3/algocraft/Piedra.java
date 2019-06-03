package fiuba.algo3.algocraft;

public class Piedra extends Material{


    public Piedra(){
        this.desgaste = new DesgastePorValor(30);

    }
    @Override
    public boolean desgastarcon( HachaMadera hachaMadera){
        return false;
    }


    @Override
    public boolean desgastarcon(HachaMetal hachaMetal){
        return false;
    }


    @Override
    public boolean desgastarcon(HachaPiedra hachaPiedra){
        return false;
    }


    @Override
    public boolean desgastarcon(PicoMadera picoMadera){
        this.desgaste.desgastar(picoMadera.GetValorDesgaste(),1);
        return true;
    }


    @Override
    public boolean desgastarcon(PicoPiedra picoPiedra){
        this.desgaste.desgastar(picoPiedra.GetValorDesgaste(), 1);
        return true;
    }


    @Override
    public boolean desgastarcon(PicoMetal picoMetal){
        this.desgaste.desgastar(picoMetal.GetValorDesgaste(),1);
        return true;
    }


    @Override
    public boolean desgastarcon(PicoFino picoFino){
        this.desgaste.desgastar(picoFino.GetValorDesgaste(),1);
        return true;
    }

}
