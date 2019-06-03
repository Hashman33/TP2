package fiuba.algo3.algocraft;

public abstract class Herramienta {
    protected Desgaste desgaste;
    protected double factor;
    protected int fuerza;

    public void desgastar(Material material){
        material.desgastarcon(this);
        desgaste.desgastar(this.getFuerza(),this.factor);

    }

    public double getFactor() {
        return factor;
    }

    public int getFuerza() {
        return fuerza;
    }
    public int getDurabilidadActual(){
        return this.desgaste.durabilidad();
    }
}
