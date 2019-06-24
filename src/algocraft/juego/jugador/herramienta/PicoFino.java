package algocraft.juego.jugador.herramienta;

import algocraft.juego.jugador.desgaste.*;
import algocraft.juego.material.*;
import algocraft.utilidades.matriz.Matriz;
import algocraft.utilidades.VectorPosicion2I;

public class PicoFino extends Herramienta {

    public PicoFino() {
        this.texturaUrl = "/recursos/texturas/picofino.png";
        this.desgaste = new DesgastePorValor(1000);
        this.factor = 0.1;
        this.fuerza = 20;
        this.crearMatrizCrafteo();
    }

    @Override
    public void desgastar(Material material) {

        if (material.esDiamante()) {
            try {
                desgaste.desgastarPicoFino(this);
            } catch (DurabilidadCeroException e) {
                throw new HerramientaEstaRotaException();
            }
        }
        material.desgastarCon(this);
    }

    private void crearMatrizCrafteo() {
        matrizCrafteo = new Matriz(new VectorPosicion2I(3, 3));

        matrizCrafteo.colocar(new Metal(), new VectorPosicion2I(0,0));
        matrizCrafteo.colocar(new Metal(), new VectorPosicion2I(1,0));
        matrizCrafteo.colocar(new Metal(), new VectorPosicion2I(2,0));
        matrizCrafteo.colocar(new Piedra(), new VectorPosicion2I(0,1));
        matrizCrafteo.colocar(new Madera(), new VectorPosicion2I(1,1));
        matrizCrafteo.colocar(new Madera(), new VectorPosicion2I(1,2));
    }
}

