package algocraft.vista;

import algocraft.controlador.BotonJugar;
import algocraft.evento.BotonJugarEventHandler;
import algocraft.juego.Juego;
import algocraft.juego.jugador.Jugador;
import algocraft.juego.mapa.Mapa;
import algocraft.utilidades.VectorPosicion2I;
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
    VistaLateral vistaLateral;



    public static final int ANCHO = 480;
    public static final int ALTO = 260;

    public ContenedorJuego(Stage stage, Juego juego) {

        this.stage = stage;

        this.juego = juego;
        // Supongo que despues se va a usar el Juego

        this.vistaMapa = new VistaMapa(juego.getMapa(), this);
        vistaMapa.dibujar();

        this.vistaLateral = new VistaLateral(juego,this);
        vistaLateral.dibujar();

        BackgroundImage fondo = new BackgroundImage(new Image("/recursos/fondos/fondo2.jpg", ANCHO, ALTO, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        this.setBackground(new Background(fondo));
    }

    public void actualizarCeldaMapa(VectorPosicion2I posicion){

        vistaMapa.dibujarPosicion(posicion.getX(), posicion.getY());

    }

    public void actualizarInventarioM() {

        vistaLateral.dibujarInventarioM();
    }

    public void actualizarInventario(){

        vistaLateral.dibujarInventarioH();
        vistaLateral.dibujarInventarioM();
    }

    public void actualizarMesaDeTrabajo() {

        vistaLateral.dibujarMesaDeTrabajo();
    }

    public void actualizarHerramientaEquipada(){

        vistaLateral.actualizarHerramientaEquipada();
    }



}
