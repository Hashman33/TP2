package fiuba.algo3.algocraft;

public class Madera extends Material{
    public Madera() {

        this.desgaste = new DesgastePorValor(10);
    }
    @Override
    public boolean desgastarcon( HachaMadera hachaMadera){
        this.desgaste.desgastar(hachaMadera.getFuerza(), 1 );
        return true;
    }


    @Override
    public boolean desgastarcon(HachaMetal hachaMetal){
        this.desgaste.desgastar(hachaMetal.getFuerza(), 1);
        return true;
    }


    @Override
    public boolean desgastarcon(HachaPiedra hachaPiedra){
        this.desgaste.desgastar(hachaPiedra.getFuerza(), 1);
        return true;
    }


    @Override
    public boolean desgastarcon(PicoMadera picoMadera) { return true; }


    @Override
    public boolean desgastarcon(PicoPiedra picoPiedra) { return true; }

    @Override
    public boolean desgastarcon(PicoMetal picoMetal) { return true; }


    @Override
    public boolean desgastarcon(PicoFino picoFino){
        this.desgaste.desgastar(picoFino.getFuerza(),1);
        return false;
    }


}
