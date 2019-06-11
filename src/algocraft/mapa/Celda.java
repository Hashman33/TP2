package algocraft.mapa;

import algocraft.jugador.Jugador;
import algocraft.material.Material;

public class Celda {

    protected Material material;

    protected Jugador jugador ;

    public Celda() {

        material = null;
        jugador = null;

    }

    public boolean colocarMaterial(Material materialAserColocado){

        if (estaVacia()){
            material = materialAserColocado;
            return true;
        }

        return false;
    }

    public boolean colocarJugador(Jugador jugadorAserColocado){

        if (estaVacia()){
            jugador = jugadorAserColocado;
            return true;
        }

        return false;
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

    public void removerMaterial(){

        material = null;

    }

    public void removerJugador(){

        jugador = null;

    }


}
