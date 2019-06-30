package algocraft.vista;


import algocraft.juego.Juego;
import algocraft.utilidades.VectorPosicion2I;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


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

        this.vistaLateral = new VistaLateral(stage, juego,this);
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
