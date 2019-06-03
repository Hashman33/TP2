package fiuba.algo3.algocraft;

public class Diamante extends Material {


    public Diamante(){
        this.desgaste = new DesgastePorValor(100);

    }
    @Override
    public boolean desgastarcon( HachaMadera hachamadera){
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
        return false;
    }


    @Override
    public boolean desgastarcon(PicoPiedra picoPiedra){
        return false;
    }


    @Override
    public boolean desgastarcon(PicoMetal picoMetal){
        return false;
    }


    @Override
    public boolean desgastarcon(PicoFino picoFino){
        this.desgaste.desgastar(picoFino.GetValorDesgaste(), 1);
        return true;
    }
}
