package algocraft.juego.jugador;

import algocraft.juego.jugador.herramienta.*;
import algocraft.juego.material.*;
import java.util.ArrayList;
import java.util.List;

public class Inventario {

    public Inventario() {
        this.herramientaEquipada = null;
        this.herramientas = new ArrayList<Herramienta>();
        this.materiales = new ArrayList<Material>();
    }

    protected List<Herramienta> herramientas;

    protected List<Material> materiales;

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
        if (!pertenece(herramienta)) throw new ElementoNoEstaEnInventarioException();
        if (herramienta == this.herramientaEquipada) this.equipar(new Mano());
        herramientas.remove(herramienta);
    }

    public void quitar(Material material) {
        if (!pertenece(material)) throw new ElementoNoEstaEnInventarioException();;
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

    public int cantidadDeElementos() { return this.materiales.size() + this.herramientas.size(); }

}
