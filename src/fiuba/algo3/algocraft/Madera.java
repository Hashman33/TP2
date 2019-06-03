package fiuba.algo3.algocraft;

public class Madera extends Material {


    public Madera() {

        this.desgaste = new DesgastePorValor(10);
    }

    @Override
    public boolean desgastarCon(Hacha hacha){
        this.desgaste.desgastar(hacha.getFuerza(), 1 );
        return true;
    }


    @Override
    public boolean desgastarCon(Pico pico) { return false; }


    @Override
    public boolean desgastarCon(PicoFino picoFino){ return false; }
}