package algocraft.jugador;

import algocraft.herramienta.Herramienta;
import algocraft.herramienta.HerramientaMadera;
import algocraft.herramienta.Pico;
import algocraft.material.Madera;
import algocraft.material.Material;


public class MesaDeTrabajo {

    private final int FILAS = 3;
    private final int COLUMNAS = 3;

    private Celda[][] tabla = null;

    private Herramienta crafteoActual = null;

    public MesaDeTrabajo() {
        tabla = new Celda[FILAS][COLUMNAS];
    }

    public void evaluar() {
        /* TODO: La idea es que esta funcion recorra y compare contra los posibles crafteos,
            luego setee la variable crafteoActual en lo que corresponda y que con otra funcion
            puedas obtener la herramienta al apretar un boton por ejemplo (como en el Minecraft)
        */

        // Ejemplo asi nomas de un pico de madera
        // Lo piola seria que cada herramienta sepa su crafteo
        if (tabla[0][0].obtenerMaterial() instanceof Madera &&
            tabla[0][1].obtenerMaterial() instanceof Madera &&
            tabla[0][2].obtenerMaterial() instanceof Madera &&
            tabla[1][1].obtenerMaterial() instanceof Madera &&
            tabla[1][1].obtenerMaterial() instanceof Madera) {

            this.crafteoActual = new Pico(new HerramientaMadera());

        }
        else {
            this.crafteoActual = null;
        }

    }

    public void agregarMaterial(int fila, int columna, Material material) {
        if (tabla[fila][columna].estaVacia()) tabla[fila][columna] = new Celda(material);
    }

    public Herramienta obtenerCrafteoActual() {
        limpiarMesaDeTrabajo();
        return crafteoActual;
    }

    public void limpiarMesaDeTrabajo() {
        for (Celda[] fila : tabla) {
            for (Celda celda: fila) {
                celda = null;
            }
        }
    }

}
