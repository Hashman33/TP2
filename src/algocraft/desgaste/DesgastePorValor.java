package algocraft.desgaste;

public class DesgastePorValor extends Desgaste{

    public DesgastePorValor(double durabilidadInicial) {

        this.durabilidad = durabilidadInicial;
        this.durabilidadInicial = durabilidadInicial;

    }


    public void desgastar(double valor, double factor) {
        if (durabilidad == 0) throw new DurabilidadCeroException();
        durabilidad -=  valor * factor;
        if (durabilidad <= 0) durabilidad = 0;
    }

}

