package fiuba.algo3.algocraft;

public class Madera extends Material{
    public Madera() {

        this.desgaste = new DesgastePorValor(10);
    }
    @Override
    public boolean desgastarcon( HachaMadera hachaMadera){
        this.desgaste.desgastar(hachaMadera.GetValorDesgaste(), 1 );
        return true;
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
    public boolean desgastarcon(PicoMetal picoMetal){ return false; }


    @Override
    public boolean desgastarcon(PicoFino picoFino){
        return false;
    }


}
