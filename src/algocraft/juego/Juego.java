package algocraft.juego;

import algocraft.juego.jugador.Jugador;
import algocraft.juego.mapa.Mapa;

public class Juego {

    private Mapa mapa = Mapa.obtenerInstancia();
    private Jugador jugador = new Jugador();

    public Juego() {

        mapa.maparandom();
        mapa.insertarJugador(jugador);
    }

    public Mapa getMapa() { return this.mapa; }
    public Jugador getJugador() { return this.jugador; }
}
