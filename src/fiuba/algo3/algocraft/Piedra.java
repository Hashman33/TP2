package fiuba.algo3.algocraft;

public class Piedra extends Material{


    public Piedra(){
        this.desgaste = new DesgastePorValor(30);

    }
    @Override
    public boolean desgastarcon( HachaMadera hachaMadera){
        return true;
    }


    @Override
    public boolean desgastarcon(HachaMetal hachaMetal){
        return true;
    }


    @Override
    public boolean desgastarcon(HachaPiedra hachaPiedra){
        return true;
    }


    @Override
    public boolean desgastarcon(PicoMadera picoMadera){
        this.desgaste.desgastar(picoMadera.getFuerza(),1);
        return true;
    }


    @Override
    public boolean desgastarcon(PicoPiedra picoPiedra){
        this.desgaste.desgastar(picoPiedra.getFuerza(), 1);
        return true;
    }


    @Override
    public boolean desgastarcon(PicoMetal picoMetal){
        this.desgaste.desgastar(picoMetal.getFuerza(),1);
        return true;
    }


    @Override
    public boolean desgastarcon(PicoFino picoFino){
        this.desgaste.desgastar(picoFino.getFuerza(),1);
        return false;
    }

}
