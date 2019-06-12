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

    public void setCoordenadas(int y, int x) {
        coordenadaX = x;
        coordenadaY = y;
    }

    public int getCoordenadaX() { return coordenadaX; }

    public int getCoordenadaY() { return coordenadaY; }

    public void moverArriba(Mapa mapa) {
        if (mapa.moverJugadorArriba(this)) coordenadaY --;
    }

    public void moverAbajo(Mapa mapa) {
        if (mapa.moverJugadorAbajo(this)) coordenadaY ++;
    }

    public void moverIzquierda(Mapa mapa) {
        if (mapa.moverJugadorIzquierda(this)) coordenadaX --;
    }

    public void moverDerecha(Mapa mapa) {
        if (mapa.moverJugadorDerecha(this)) coordenadaX ++;
    }
}
