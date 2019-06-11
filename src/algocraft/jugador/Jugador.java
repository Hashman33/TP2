package algocraft.jugador;

import algocraft.herramienta.*;
import algocraft.mapa.*;

public class Jugador {

    private int coordenadaX;
    private int coordenadaY;
    public Inventario inventario;

    public Jugador() {

        Hacha hachaMadera = new Hacha(new HerramientaMadera());

        this.inventario = new Inventario();
        this.inventario.agregar(hachaMadera);
        this.inventario.equipar(hachaMadera);
    }

    public Herramienta herramientaEquipada() {
        return this.inventario.herramientaEquipada;
    }

    public void setCoordenadas(int x, int y) {
        coordenadaX = x;
        coordenadaY = y;
    }

    public int getCoordenadaX() { return coordenadaX; }

    public int getCoordenadaY() { return coordenadaY; }

    public void moverArriba(Mapa mapa) { mapa.moverJugadorArriba(this); }

    public void moverAbajo(Mapa mapa) { mapa.moverJugadorAbajo(this); }

    public void moverIzquierda(Mapa mapa) { mapa.moverJugadorIzquierda(this); }

    public void moverDerecha(Mapa mapa) { mapa.moverJugadorDerecha(this); }
}
