package algocraft.utilidades.matriz;

import algocraft.juego.jugador.Jugador;
import algocraft.juego.material.Material;
import algocraft.utilidades.VectorPosicion2I;

import java.util.ArrayList;
import java.util.List;

public class Matriz {

    private int ANCHO;
    private int LARGO;
    private List<Fila> filas;


    public Matriz(int largoY, int anchoX) {

        ANCHO = anchoX;
        LARGO = largoY;
        filas = new ArrayList<Fila>();
        this.inicilizarMatriz();
    }

    public Matriz(VectorPosicion2I tamanio) {

        ANCHO = tamanio.getX();
        LARGO = tamanio.getY();

        filas = new ArrayList<Fila>();

        this.inicilizarMatriz();
    }

    public void inicilizarMatriz() {

        for (int i = 0; i < LARGO; i++) {
            filas.add(new Fila(ANCHO));
        }
    }

    public Celda obtenerCelda(VectorPosicion2I coordenadas) {
        if (!esPosicionValida(coordenadas)) return null;
        Fila fila = filas.get(coordenadas.getY());
        return fila.obtenerCelda(coordenadas.getX());
    }

    public boolean esPosicionValida(VectorPosicion2I posicion) {
        return posicion.getX() >= 0 && posicion.getX() < ANCHO && posicion.getY() >= 0 && posicion.getY() < LARGO;
    }

    // Se sabe comparar con otra matriz por sus clases de Material
    public boolean esIgualA(Matriz matriz) {

        for (int i = 0; i < matriz.filas.size(); i++) {
            for (int j = 0; j < matriz.filas.get(i).getCeldas().size(); j++) {
                // Casos
                if (this.filas.get(i).getCeldas().get(j).material != null) {
                    if (matriz.filas.get(i).getCeldas().get(j).material == null) return false;
                    if (this.filas.get(i).getCeldas().get(j).material.getClass() != matriz.filas.get(i).getCeldas().get(j).material.getClass()) return false;
                }

                if (matriz.filas.get(i).getCeldas().get(j).material != null) {
                    if (this.filas.get(i).getCeldas().get(j).material == null) return false;
                    if (this.filas.get(i).getCeldas().get(j).material.getClass() != matriz.filas.get(i).getCeldas().get(j).material.getClass()) return false;
                }

            }
        }

        return true;
    }

    public boolean colocar(Jugador jugador, VectorPosicion2I posicion) {
        if (this.esPosicionValida(posicion)) {
            return this.obtenerCelda(posicion).colocar(jugador);
        }
        return false;
    }

    public boolean colocar(Material material, VectorPosicion2I posicion) {
        if (this.esPosicionValida(posicion)) {
            return this.obtenerCelda(posicion).colocar(material);
        }
        return false;
    }

    public boolean estaVacia() {
        for (Fila fila: this.filas) {
            if (!fila.estaVacia()) return false;
        }
        return  true;
    }

    public Jugador obtenerJugador(VectorPosicion2I posicion) {
        if (this.esPosicionValida(posicion)) {
            return this.obtenerCelda(posicion).obtenerJugador();
        }
        return null;
    }

    public Material obtenerMaterial(VectorPosicion2I posicion) {
        if (this.esPosicionValida(posicion)) {
            return this.obtenerCelda(posicion).obtenerMaterial();
        }
        return null;
    }

    public void limpiar() {
        for (Fila fila: filas) {
            fila.limpiar();
        }
    }

    public void limpiarCelda(VectorPosicion2I posicion) {
        if (esPosicionValida(posicion)) {
            this.filas.get(posicion.getY()).getCeldas().get(posicion.getX()).removerMaterial();
            this.filas.get(posicion.getY()).getCeldas().get(posicion.getX()).removerJugador();
        }
    }

}
