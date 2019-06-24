package algocraft.vista;

import algocraft.evento.TeclaMovimientoEventHandler;
import algocraft.juego.Juego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // Poner la resolucion que quieran. Yo la setee en HD
    public static final int ANCHO = 1140;
    public static final int ALTO = 640;

    //pablosuarez@gmail.com
    // Matriz en utilidades

    @Override
    public void start(Stage stage) {

        stage.setTitle("AlgoCraft - Grupo 13");

        //BorderPane contenedorJuego = new BorderPane();
        Juego juego = new Juego();

        ContenedorJuego contenedorJuego = new ContenedorJuego(stage, juego);
        Scene escenaJuego = new Scene(contenedorJuego, ANCHO, ALTO);

        TeclaMovimientoEventHandler teclaMovimientoEventHandler = new TeclaMovimientoEventHandler(contenedorJuego,juego);
        escenaJuego.setOnKeyPressed(teclaMovimientoEventHandler);

        ContenedorMenuPrincipal contenedorMenuPrincipal = new ContenedorMenuPrincipal(stage, escenaJuego);
        Scene scene = new Scene(contenedorMenuPrincipal, ANCHO, ALTO);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
