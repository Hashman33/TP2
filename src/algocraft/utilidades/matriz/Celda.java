package algocraft.utilidades.matriz;

import algocraft.juego.jugador.Jugador;
import algocraft.juego.material.Material;

public class Celda {

    protected Material material;

    protected Jugador jugador ;

    public Celda() {

        material = null;
        jugador = null;

    }

    public boolean estaVacia(){
        return material == null && jugador == null;
    }

    public Jugador obtenerJugador(){
        return jugador;
    }

    public Material obtenerMaterial(){
        return material;
    }

    public void removerMaterial() { material = null; }

    public void removerJugador() { jugador = null; }


    public boolean colocar(Jugador jugadorAColocar){
        if (!estaVacia()) return false;
        this.jugador = jugadorAColocar;
        return true;
    }

    public boolean colocar(Material materialAColocar){
        if (!estaVacia()) return false;
        this.material = materialAColocar;
        return true;
    }

    public void limpiar() {
        this.removerJugador();
        this.removerMaterial();
    }

}
