package algocraft.juego.jugador.herramienta;

import algocraft.juego.jugador.desgaste.DurabilidadCeroException;
import algocraft.juego.material.*;
import algocraft.utilidades.matriz.Matriz;
import algocraft.utilidades.VectorPosicion2I;

public class Pico extends Herramienta{

    protected MaterialHerramienta material;

    public Pico(MaterialHerramienta material){
        this.sonidoUrl = "/recursos/sonidos/pico.mp3";
        this.material = material;
        material.inicializarPico(this);
        crearMatrizCrafteo(material.getMaterial());
    }

    @Override
    public void desgastar(Material material){

        try {
            desgaste.desgastarHerramienta(this);
        } catch (DurabilidadCeroException e) {
            throw new HerramientaEstaRotaException();
        }
        material.desgastarCon(this);
    }

    public MaterialHerramienta getMaterial(){ return this.material; }

    private void crearMatrizCrafteo(Material material) {
        matrizCrafteo = new Matriz(new VectorPosicion2I(3, 3));

        matrizCrafteo.colocar(material, new VectorPosicion2I(0,0));
        matrizCrafteo.colocar(material, new VectorPosicion2I(1,0));
        matrizCrafteo.colocar(material, new VectorPosicion2I(2,0));
        matrizCrafteo.colocar(new Madera(), new VectorPosicion2I(1,1));
        matrizCrafteo.colocar(new Madera(), new VectorPosicion2I(1,2));
    }
}
