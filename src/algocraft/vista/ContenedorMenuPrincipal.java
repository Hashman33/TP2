package algocraft.vista;

import algocraft.controlador.BotonJugar;
import algocraft.evento.BotonJugarEventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.InputStream;

public class ContenedorMenuPrincipal extends BorderPane {

    Stage stage;

    public static final int ANCHO = 1140;
    public static final int ALTO = 640;


    public ContenedorMenuPrincipal(Stage stage, Scene proximaEscena) {

        this.stage = stage;

        InputStream i = getClass().getResourceAsStream("/recursos/fuentes/Minecrafter.Alt.ttf");
        Font fuenteAlt = Font.loadFont(i, 54);

        Label titulo = new Label("ALGOCRAFT");
        titulo.setFont(fuenteAlt);
        titulo.setTextFill(Color.web("#FFF", 1.0));

        BotonJugar botonJugar = new BotonJugar();

        BackgroundImage fondo = new BackgroundImage(new Image("/recursos/fondos/fondo1.jpg", ANCHO, ALTO, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        // Creo contenedores
        VBox vBoxPrincipal = new VBox();
        vBoxPrincipal.setAlignment(Pos.CENTER);

        VBox vBoxTitulo = new VBox();
        vBoxTitulo.setAlignment(Pos.TOP_CENTER);

        VBox vBoxBotones = new VBox();
        vBoxBotones.setAlignment(Pos.BASELINE_CENTER);

        // Agrego los controles
        vBoxTitulo.getChildren().addAll(titulo);
        vBoxBotones.getChildren().addAll(botonJugar);
        vBoxPrincipal.getChildren().addAll(vBoxTitulo, vBoxBotones);

        BotonJugarEventHandler botonEntrarHandler = new BotonJugarEventHandler(stage, proximaEscena);
        botonJugar.setOnAction(botonEntrarHandler);

        this.setCenter(vBoxPrincipal);
        this.setBackground(new Background(fondo));

    }

}
