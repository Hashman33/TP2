package fiuba.algo3.algocraft;

public abstract class Material {

    protected Desgaste desgaste;

    public  boolean desgastarcon(Herramienta herramienta){
        return this.desgastarcon(herramienta);

    }

    public abstract boolean desgastarcon(HachaMadera hachaMadera);

    public abstract boolean desgastarcon(HachaPiedra hachaPiedra);

    public abstract boolean desgastarcon(HachaMetal hachaMetal);

    public abstract boolean desgastarcon(PicoMadera picoMadera);

    public abstract boolean desgastarcon(PicoPiedra picoPiedra);

    public abstract boolean desgastarcon(PicoMetal picoMetal);

    public abstract boolean desgastarcon(PicoFino picoFino);



    public double durabildadactual(){
        return this.desgaste.durabilidad();
    }



}
