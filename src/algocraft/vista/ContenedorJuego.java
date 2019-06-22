package algocraft.vista;

import algocraft.controlador.BotonJugar;
import algocraft.evento.BotonJugarEventHandler;
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
    Mapa mapa;

    public ContenedorJuego(Stage stage) {

        this.stage = stage;
        this.mapa = Mapa.obtenerInstancia();

        VistaMapa vistaMapa = new VistaMapa(mapa, this);

        vistaMapa.dibujar();

    }

}
