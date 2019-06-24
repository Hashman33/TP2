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

        Jugador jugador = juego.getJugador();
        VectorPosicion2I posAnterior = jugador.getPosicion();
        VectorPosicion2I movimiento = new VectorPosicion2I(0,0);

        if(event.getCode() == KeyCode.W) { movimiento = direccion.arriba(); }

        if(event.getCode() == KeyCode.A) { movimiento = direccion.izquierda(); }

        if(event.getCode() == KeyCode.D) { movimiento = direccion.derecha(); }

        if(event.getCode() == KeyCode.S) { movimiento = direccion.abajo(); }

        if(event.getCode() == KeyCode.F) { juego.usarHerramienta(); }


        if (!movimiento.esIgualA(new VectorPosicion2I(0,0))) {
            juego.moverJugador(movimiento);
        }
        contenedorJuego.actualizarCeldaMapa(posAnterior);
        contenedorJuego.actualizarCeldaMapa(posAnterior.sumar(movimiento));
        contenedorJuego.actualizarCeldaMapa(posAnterior.sumar(jugador.getMirada()));
    }
}





