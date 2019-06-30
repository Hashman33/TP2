package algocraft.evento;

import algocraft.juego.Juego;
import algocraft.juego.jugador.Jugador;
import algocraft.utilidades.*;
import algocraft.vista.ContenedorJuego;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;



public class TecladoEventHandler implements EventHandler<KeyEvent> {

    private Juego juego;
    private Direccion direccion;
    private ContenedorJuego contenedorJuego;
    AudioClip sonidoHerramienta;
    AudioClip sonidoCaminar;


    public TecladoEventHandler(ContenedorJuego contenedorJuego, Juego juego) {

        this.juego = juego;
        this.direccion = new Direccion();
        this.contenedorJuego = contenedorJuego;
        this.sonidoCaminar = new AudioClip(this.getClass().getResource("/recursos/sonidos/caminar.mp3").toExternalForm());
    }

    @Override
    public void handle(KeyEvent event) {

        Jugador jugador = juego.getJugador();
        VectorPosicion2I posJugador = jugador.getPosicion();
        VectorPosicion2I movimiento = null;


        // Movimiento
        if (event.getCode() == KeyCode.W) {
            movimiento = direccion.arriba();
        }

        if (event.getCode() == KeyCode.A) {
            movimiento = direccion.izquierda();
        }

        if (event.getCode() == KeyCode.D) {
            movimiento = direccion.derecha();
        }

        if (event.getCode() == KeyCode.S) {
            movimiento = direccion.abajo();
        }

        if (movimiento != null) {
            juego.moverJugador(movimiento);
            contenedorJuego.actualizarCeldaMapa(posJugador.sumar(movimiento));
            contenedorJuego.actualizarCeldaMapa(posJugador);
            if (!posJugador.esIgualA(juego.getJugador().getPosicion())) {
                sonidoCaminar.play();
            }
        }

        // Uso de herramienta
        if (event.getCode() == KeyCode.F) {
            this.sonidoHerramienta = juego.getJugador().herramientaEquipada().getSonido();

            if (juego.getMapa().obtenerMaterial(posJugador.sumar(jugador.getMirada())) != null) {
                sonidoHerramienta.play();
            }
            juego.usarHerramienta();
            contenedorJuego.actualizarCeldaMapa(posJugador.sumar(jugador.getMirada()));
            contenedorJuego.actualizarInventario();
            contenedorJuego.actualizarHerramientaEquipada();

        }
    }
}