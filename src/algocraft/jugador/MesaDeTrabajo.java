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
        inicializarMesaDeTrabajo();
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
        if (this.crafteoActual == null) return null;

        limpiarMesaDeTrabajo();
        return this.crafteoActual;
    }

    private void limpiarMesaDeTrabajo() {
        for (Celda[] fila : tabla) {
            for (Celda celda: fila) {
                celda.vaciar();
            }
        }
    }

    private void inicializarMesaDeTrabajo() {
        for(int i = 0; i < FILAS; i++) {
            for(int j = 0; j < COLUMNAS; j++) {
                this.tabla[i][j] = new Celda(null);
            }
        }
    }

    public boolean estaVacia() {

        boolean vacia = true;

        for (Celda[] fila : this.tabla) {
            for (Celda celda: fila) {
                if (!celda.estaVacia()) return celda.estaVacia();
            }
        }

        return vacia;
    }

}
