package algocraft.vista;

import algocraft.evento.TecladoAccionado;
import algocraft.juego.Juego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    // Poner la resolucion que quieran. Yo la setee en HD
    public static final int ANCHO = 1280;
    public static final int ALTO = 720;

    //pablosuarez@gmail.com
    // Matriz en utilidades

    @Override
    public void start(Stage stage) {

        stage.setTitle("AlgoCraft - Grupo 13");

        //BorderPane contenedorJuego = new BorderPane();
        Juego juego = new Juego();

        ContenedorJuego contenedorJuego = new ContenedorJuego(stage, juego);
        Scene escenaJuego = new Scene(contenedorJuego, ANCHO, ALTO);

        TecladoAccionado tecladoAccionado = new TecladoAccionado(contenedorJuego,juego);
        escenaJuego.setOnKeyPressed(tecladoAccionado);

        ContenedorMenuPrincipal contenedorMenuPrincipal = new ContenedorMenuPrincipal(stage, escenaJuego);
        Scene scene = new Scene(contenedorMenuPrincipal, ANCHO, ALTO);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
