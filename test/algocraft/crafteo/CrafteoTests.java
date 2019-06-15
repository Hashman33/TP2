package algocraft.crafteo;

import algocraft.herramienta.Hacha;
import algocraft.herramienta.HerramientaMadera;
import algocraft.jugador.Jugador;
import algocraft.jugador.MesaDeTrabajo;
import algocraft.material.Madera;
import algocraft.material.Piedra;
import algocraft.matriz.Celda;
import algocraft.matriz.Matriz;
import algocraft.utilidades.VectorPosicion2I;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrafteoTests {

    @Test
    public void test01CrafteoDeHachaDeMadera(){

        Hacha hachaMadera = new Hacha(new HerramientaMadera());

        Matriz matrizHerramienta = hachaMadera.getMatrizCrafteo();
        Matriz matrizMesaDeTrabajo = new Matriz(new VectorPosicion2I(3,3));

        // Hacha de madera (OK)
        matrizMesaDeTrabajo.colocar(new Madera(), new VectorPosicion2I(0,0));
        matrizMesaDeTrabajo.colocar(new Madera(), new VectorPosicion2I(1,0));
        matrizMesaDeTrabajo.colocar(new Madera(), new VectorPosicion2I(0,1));
        matrizMesaDeTrabajo.colocar(new Madera(), new VectorPosicion2I(1,1));
        matrizMesaDeTrabajo.colocar(new Madera(), new VectorPosicion2I(1,2));

        assert(matrizHerramienta.esIgualA(matrizMesaDeTrabajo));

    }
}
