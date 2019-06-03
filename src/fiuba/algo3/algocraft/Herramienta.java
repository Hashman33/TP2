package fiuba.algo3.algocraft;

public abstract class Herramienta {
    protected Desgaste desgaste;
    protected double factor;
    protected int valordesgaste;

    public void desgastar(Material material){
        material.desgastarcon(this);
        desgaste.desgastar(this.GetValorDesgaste(),this.factor);

    }

    public double getFactor() {
        return factor;
    }

    public int GetValorDesgaste() {
        return valordesgaste;
    }
    public int getDurabilidadActual(){
        return this.desgaste.durabilidad();
    }
}
