package algocraft;

import algocraft.herramienta.*;
import algocraft.material.*;
import java.util.ArrayList;
import java.util.List;

public class Inventario {

    Inventario() {
        this.herramientaEquipada = null;
        this.herramientas = new ArrayList<Herramienta>();
        this.materiales = new ArrayList<Material>();
    }

    private List<Herramienta> herramientas;

    private List<Material> materiales;

    public Herramienta herramientaEquipada;

    public void agregar(Herramienta herramienta) {
        if (pertenece(herramienta)) return;
        herramientas.add(herramienta);
    }

    public void agregar(Material material) {
        if (pertenece(material)) return;
        materiales.add(material);
    }

    public void quitar(Herramienta herramienta) {
        if (!pertenece(herramienta)) return;
        herramientas.remove(herramienta);
    }

    public void quitar(Material material) {
        if (!pertenece(material)) return;
        materiales.remove(material);
    }

    public void equipar(Herramienta herramienta) {
        this.herramientaEquipada = herramienta;
    }

    public boolean pertenece(Herramienta herramienta) {
        return this.herramientas.contains(herramienta);
    }

    public boolean pertenece(Material material) {
        return this.materiales.contains(material);
    }

}
