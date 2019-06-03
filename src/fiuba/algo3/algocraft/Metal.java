package fiuba.algo3.algocraft;

public class Metal extends Material {


    public Metal(){
        this.desgaste = new DesgastePorValor(50);
    }

    @Override
    public boolean desgastarcon( HachaMadera hachaMadera){
        return true;
    }


    @Override
    public boolean desgastarcon(HachaMetal hachaMetal) {
        return true;
    }


    @Override
    public boolean desgastarcon(HachaPiedra hachaPiedra){
        return true;
    }


    @Override
    public boolean desgastarcon(PicoMadera picoMadera) { return true; }


    @Override
    public boolean desgastarcon(PicoPiedra picoPiedra){
        this.desgaste.desgastar(picoPiedra.getFuerza(), 1);
        return true;
    }


    @Override
    public boolean desgastarcon(PicoMetal picoMetal) { return true; }



    public boolean desgastarcon(PicoFino picoFino){
        this.desgaste.desgastar(picoFino.getFuerza(),1);
        return false;
    }

}
