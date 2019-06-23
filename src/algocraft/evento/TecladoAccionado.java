package algocraft.evento;

import algocraft.juego.Juego;
import algocraft.juego.jugador.Jugador;
import algocraft.juego.mapa.Mapa;
import algocraft.utilidades.VectorPosicion2I;
import algocraft.vista.ContenedorJuego;
import algocraft.vista.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class TecladoAccionado implements EventHandler<KeyEvent> {

    private Juego juego;

    private ContenedorJuego contenedorJuego;


    public TecladoAccionado(ContenedorJuego contenedorJuego, Juego juego) {

        this.juego = juego;
        this.contenedorJuego = contenedorJuego;

    }

    @Override
    public void handle(KeyEvent event) {

        if(event.getCode() == KeyCode.W){

            juego.getMapa().moverJugador(juego.getJugador(), new VectorPosicion2I(juego.getJugador().getPosicion().getX()  , juego.getJugador().getPosicion().getY() + 1 ));

            contenedorJuego.actualizarmapa();

        }

        if(event.getCode() == KeyCode.A){

            juego.getMapa().moverJugador(juego.getJugador(), new VectorPosicion2I(juego.getJugador().getPosicion().getX() - 1  , juego.getJugador().getPosicion().getY() ));

            contenedorJuego.actualizarmapa();

        }

        if(event.getCode() == KeyCode.D){

            juego.getMapa().moverJugador(juego.getJugador(), new VectorPosicion2I(juego.getJugador().getPosicion().getX() + 1 , juego.getJugador().getPosicion().getY() ));

            contenedorJuego.actualizarmapa();

        }

        if(event.getCode() == KeyCode.S){

            juego.getMapa().moverJugador(juego.getJugador(), new VectorPosicion2I(juego.getJugador().getPosicion().getX()  , juego.getJugador().getPosicion().getY() - 1 ));

            contenedorJuego.actualizarmapa();

        }



    }
}





