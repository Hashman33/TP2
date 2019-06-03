package fiuba.algo3.algocraft;

public class Metal extends Material {


    public Metal(){
        this.desgaste = new DesgastePorValor(50);
    }

    @Override
    public boolean desgastarcon( HachaMadera hachamadera){
        return false;
    }


    @Override
    public boolean desgastarcon(HachaMetal hachaMetal){
        this.desgaste.desgastar(hachaMetal.GetValorDesgaste(), 1);
        return true;
    }


    @Override
    public boolean desgastarcon(HachaPiedra hachaPiedra){
        this.desgaste.desgastar(hachaPiedra.GetValorDesgaste(), 1);
        return true;
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



    public boolean desgastarcon(PicoFino picoFino){
        this.desgaste.desgastar(picoFino.GetValorDesgaste(),1);
        return true;
    }

}
