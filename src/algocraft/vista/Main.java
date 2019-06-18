package algocraft.vista;

import algocraft.controlador.BotonJugar;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main extends Application {

    // Poner la resolucion que quieran. Yo la setee en HD
    public static final int ANCHO = 1280;
    public static final int ALTO = 720;

    @Override
    public void start(Stage stage) {

        stage.setTitle("AlgoCraft - Grupo 13");

        InputStream i = getClass().getResourceAsStream("/recursos/fuentes/Minecrafter.Alt.ttf");
        Font fuenteAlt = Font.loadFont(i, 54);

        i = getClass().getResourceAsStream("/recursos/fuentes/Minecraft.ttf");
        Font fuenteRegular = Font.loadFont(i, 20);

        Label titulo = new Label("ALGOCRAFT");
        titulo.setFont(fuenteAlt);
        titulo.setTextFill(Color.web("#FFF", 1.0));

//        Button botonInicio = new Button("Jugar");
//        botonInicio.setFont(fuenteRegular);
        BotonJugar botonJugar = new BotonJugar();

        BackgroundImage fondo = new BackgroundImage(new Image("/recursos/fondos/fondo1.jpg", ANCHO, ALTO, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        BorderPane root = new BorderPane();

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

        root.setCenter(vBoxPrincipal);
        root.setBackground(new Background(fondo));

        Scene scene = new Scene(root, ANCHO, ALTO);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
