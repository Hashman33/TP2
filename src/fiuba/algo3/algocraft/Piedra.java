package fiuba.algo3.algocraft;

public class Piedra extends Material {


    public Piedra(){
        this.desgaste = new DesgastePorValor(30);

    }
    @Override
    public boolean desgastarCon(Hacha hacha){
        return false;
    }


    @Override
    public boolean desgastarCon(Pico pico){
        this.desgaste.desgastar(pico.getFuerza(),1);
        return true;
    }


    @Override
    public boolean desgastarCon(PicoFino picoFino){
        this.desgaste.desgastar(picoFino.getFuerza(),1);
        return false;
    }

}
