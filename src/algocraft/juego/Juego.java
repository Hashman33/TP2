package algocraft.juego;

import algocraft.juego.jugador.Jugador;
import algocraft.juego.jugador.herramienta.Herramienta;
import algocraft.juego.mapa.Mapa;
import algocraft.juego.material.Material;
import algocraft.utilidades.VectorPosicion2I;

public class Juego {

    private Mapa mapa = Mapa.obtenerInstancia();
    private Jugador jugador = new Jugador();

    public Juego() {

        mapa.iniciarRandom();
        mapa.insertarJugador(jugador);
    }

    public void moverJugador(VectorPosicion2I movimiento) { jugador.mover(mapa, movimiento); }

    public void usarHerramienta() { jugador.usarHerramienta(mapa); }

    public void agregarMaterialAMesaDeTrabajo(Material material, VectorPosicion2I pos) {
        jugador.agregarAMesaDeTrabajo(material, pos);
    }

    public void equipar(Herramienta herramienta) { this.jugador.equipar(herramienta); }

    public void limpiarMesaDeTrabajo() { this.jugador.limpiarMesaDeTrabajo(); }


    public Mapa getMapa() { return this.mapa; }
    public Jugador getJugador() { return this.jugador; }
}
