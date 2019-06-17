package algocraft.vistas;

import javafx.application.Application;
import javafx.scene.Group;
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
        Font fuenteTitulo = Font.loadFont(i, 54);

        Label titulo = new Label("ALGOCRAFT");
        titulo.setFont(fuenteTitulo);
        titulo.setTextFill(Color.web("#FFF", 0.9));

        BackgroundImage fondo = new BackgroundImage(new Image("/recursos/fondos/fondo1.jpg", ANCHO, ALTO, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        StackPane root = new StackPane();

        // Agrego los controles
        root.getChildren().add(titulo);
        root.setBackground(new Background(fondo));

        Scene scene = new Scene(root, ANCHO, ALTO);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
