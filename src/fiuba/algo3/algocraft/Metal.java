package fiuba.algo3.algocraft;

public class Metal extends Material {


    public Metal(){
        this.desgaste = new DesgastePorValor(50);
    }

    @Override
    public boolean desgastarCon(Hacha hacha){
        return true;
    }


    @Override
    public boolean desgastarCon(Pico pico){
        if (pico.material.esPiedra() || pico.material.esMetal()) {
            this.desgaste.desgastar(pico.getFuerza(), 1);
        }
        return true;
    }


    public boolean desgastarCon(PicoFino picoFino){
        this.desgaste.desgastar(picoFino.getFuerza(),1);
        return false;
    }

}
