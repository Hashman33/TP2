package algocraft.vista;

import algocraft.controlador.BotonJugar;
import algocraft.evento.BotonJugarEventHandler;
import algocraft.juego.Juego;
import algocraft.juego.jugador.Jugador;
import algocraft.juego.mapa.Mapa;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.InputStream;

public class ContenedorJuego extends BorderPane {

    Stage stage;
    Juego juego;
    VistaMapa vistaMapa;

    public ContenedorJuego(Stage stage, Juego juego) {

        this.stage = stage;

        // Supongo que despues se va a usar el Juego

        this.vistaMapa = new VistaMapa(juego.getMapa(), this);
        vistaMapa.dibujar();
    }


    public void actualizarMapa(){

        vistaMapa.dibujar();

    }



}
