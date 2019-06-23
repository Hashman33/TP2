package algocraft.evento;

import algocraft.juego.Juego;
import algocraft.juego.jugador.Jugador;
import algocraft.juego.mapa.Mapa;
import algocraft.utilidades.*;
import algocraft.vista.ContenedorJuego;
import algocraft.vista.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class TeclaMovimientoEventHandler implements EventHandler<KeyEvent> {

    private Juego juego;
    private Direccion direccion;
    private ContenedorJuego contenedorJuego;


    public TeclaMovimientoEventHandler(ContenedorJuego contenedorJuego, Juego juego) {

        this.juego = juego;
        this.direccion = new Direccion();
        this.contenedorJuego = contenedorJuego;

    }

    @Override
    public void handle(KeyEvent event) {

        VectorPosicion2I posAnterior = juego.getJugador().getPosicion();

        if(event.getCode() == KeyCode.W){
            juego.moverJugador(direccion.arriba());
        }
        if(event.getCode() == KeyCode.A){
            juego.moverJugador(direccion.izquierda());
        }
        if(event.getCode() == KeyCode.D){
            juego.moverJugador(direccion.derecha());
        }
        if(event.getCode() == KeyCode.S){
            juego.moverJugador(direccion.abajo());
        }

        contenedorJuego.actualizarMapa(posAnterior);
    }
}





