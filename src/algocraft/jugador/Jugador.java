package algocraft.jugador;

import algocraft.herramienta.*;
import algocraft.mapa.*;
import algocraft.utilidades.VectorPosicion2I;

public class Jugador {

    private int coordenadaX;
    private int coordenadaY;
    private VectorPosicion2I posicion;
    public Inventario inventario;

    public Jugador() {
        inicializar(new VectorPosicion2I());
    }

    public Jugador(VectorPosicion2I posicionInicial) {
        inicializar(posicionInicial);
    }

    private void inicializar(VectorPosicion2I posicionInicial) {

        Hacha hachaMadera = new Hacha(new HerramientaMadera());

        this.inventario = new Inventario();
        this.inventario.agregar(hachaMadera);
        this.inventario.equipar(hachaMadera);

        this.posicion = posicionInicial;
    }


    public Herramienta herramientaEquipada() {
        return this.inventario.herramientaEquipada;
    }

    public void setCoordenadas(int y, int x) {
        coordenadaX = x;
        coordenadaY = y;
    }

    public void setCoordenadas(VectorPosicion2I posicion) {
        this.posicion = posicion;
    }

    public void mover(Mapa mapa, VectorPosicion2I nuevaPosicion) {
        if (mapa.moverJugador(this, nuevaPosicion)) this.posicion = this.posicion.sumar(nuevaPosicion);
    }

    public int getCoordenadaX() { return coordenadaX; }

    public int getCoordenadaY() { return coordenadaY; }

    public void moverArriba(Mapa mapa) { if (mapa.moverJugadorArriba(this)) coordenadaY --; }

    public void moverAbajo(Mapa mapa) {
        if (mapa.moverJugadorAbajo(this)) coordenadaY ++;
    }

    public void moverIzquierda(Mapa mapa) {
        if (mapa.moverJugadorIzquierda(this)) coordenadaX --;
    }

    public void moverDerecha(Mapa mapa) {
        if (mapa.moverJugadorDerecha(this)) coordenadaX ++;
    }

    public VectorPosicion2I getPosicion() {
        return this.posicion;
    }

}
