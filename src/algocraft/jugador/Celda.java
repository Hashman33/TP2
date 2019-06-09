package algocraft.jugador;

import algocraft.material.Material;

public class Celda {

    private Material material = null;

    public Celda(Material material) {
        this.material = material;
    }

    public boolean estaVacia() {
        return (material == null);
    }

    public Material obtenerMaterial() {
        return this.material;
    }
}
