package algocraft.jugador;

import algocraft.herramienta.*;
import algocraft.material.Madera;
import algocraft.material.Material;
import algocraft.matriz.Matriz;
import algocraft.utilidades.VectorPosicion2I;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class MesaDeTrabajo {

    private final VectorPosicion2I TAMANIO = new VectorPosicion2I(3,3);

    public Matriz matriz;

    private Herramienta crafteoActual = null;

    public MesaDeTrabajo() {
        this.matriz = new Matriz(TAMANIO);
    }

    private void evaluar() {

        // Comparo con cada herramienta posible

        // Hachas
        Hacha hachaMadera = new Hacha(new HerramientaMadera());
        if (hachaMadera.getMatrizCrafteo().esIgualA(this.matriz)) {
            this.crafteoActual = hachaMadera;
            return;
        }

        Hacha hachaPiedra = new Hacha(new HerramientaPiedra());
        if (hachaPiedra.getMatrizCrafteo().esIgualA(this.matriz)) {
            this.crafteoActual = hachaPiedra;
            return;
        }

        Hacha hachaMetal = new Hacha(new HerramientaMetal());
        if (hachaMetal.getMatrizCrafteo().esIgualA(this.matriz)) {
            this.crafteoActual = hachaMetal;
            return;
        }

        // Picos
        Pico picoMadera = new Pico(new HerramientaMadera());
        if (picoMadera.getMatrizCrafteo().esIgualA(this.matriz)) {
            this.crafteoActual = picoMadera;
            return;
        }

        Pico picoPiedra = new Pico(new HerramientaPiedra());
        if (picoPiedra.getMatrizCrafteo().esIgualA(this.matriz)) {
            this.crafteoActual = picoPiedra;
            return;
        }

        Pico picoMetal = new Pico(new HerramientaMetal());
        if (picoMetal.getMatrizCrafteo().esIgualA(this.matriz)) {
            this.crafteoActual = picoMetal;
            return;
        }

        // PicoFino
        PicoFino picoFino = new PicoFino();
        if (picoFino.getMatrizCrafteo().esIgualA(this.matriz)) {
            this.crafteoActual = picoFino;
            return;
        }

        this.crafteoActual = null;

    }

    public boolean agregarMaterial(Material material, VectorPosicion2I posicion) {

        boolean seAgrega = this.matriz.colocar(material, posicion);
        this.evaluar();
        if (this.crafteoActual != null) this.limpiar();
        return seAgrega;
    }

    public Material removerMaterial(VectorPosicion2I posicion) {
        Material material = this.matriz.obtenerMaterial(posicion);
        this.matriz.limpiarCelda(posicion);
        return material;
    }

    public List<Material> limpiar() {

        List<Material> materiales = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                materiales.add(removerMaterial(new VectorPosicion2I(i, j)));
            }
        }
        return materiales;
    }

    public Herramienta obtenerCrafteoActual() {
        return this.crafteoActual;
    }

    public boolean estaVacia() {
        return this.matriz.estaVacia();
    }

}
