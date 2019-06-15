package algocraft.jugador;

import algocraft.herramienta.Hacha;
import algocraft.herramienta.Herramienta;
import algocraft.herramienta.HerramientaMadera;
import algocraft.herramienta.Pico;
import algocraft.material.Madera;
import algocraft.material.Material;
import algocraft.matriz.Matriz;
import algocraft.utilidades.VectorPosicion2I;


public class MesaDeTrabajo {

    private final VectorPosicion2I TAMANIO = new VectorPosicion2I(3,3);

    public Matriz matriz;

    private Herramienta crafteoActual = null;

    public MesaDeTrabajo() {
        this.matriz = new Matriz(TAMANIO);
    }

    private void evaluar() {

        // Comparo con cada herramienta posible
        Hacha hachaMadera = new Hacha(new HerramientaMadera());
        if (hachaMadera.getMatrizCrafteo().esIgualA(this.matriz)) {
            this.crafteoActual = hachaMadera;
        }
    }

    public void agregarMaterial(Material material, VectorPosicion2I posicion) {
        this.matriz.colocar(material, posicion);
        this.evaluar();
    }

    public Herramienta obtenerCrafteoActual() {
        return this.crafteoActual;
    }

    public boolean estaVacia() {
        return this.matriz.estaVacia();
    }

}
