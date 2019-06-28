package algocraft.evento;

import algocraft.juego.Juego;
import algocraft.juego.material.Material;
import algocraft.utilidades.VectorPosicion2I;
import algocraft.vista.ContenedorJuego;
import algocraft.vista.VistaLateral;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;

public class ClickEnMesaEventHandler implements EventHandler<MouseEvent> {

    Juego juego;
    ContenedorJuego contenedor;
    VectorPosicion2I posicion;
    VistaLateral vistaLateral;
    AudioClip sonido;

    public ClickEnMesaEventHandler(ContenedorJuego contenedor, Juego juego, VistaLateral vistaLateral, VectorPosicion2I pos) {
        this.juego = juego;
        this.contenedor = contenedor;
        this.vistaLateral = vistaLateral;
        this.posicion = pos;
        this.sonido = new AudioClip((this.getClass().getResource("/recursos/sonidos/item2.mp3").toExternalForm()));

    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (vistaLateral.getMaterialAUbicarEnMesa() != null) {
            juego.agregarMaterialAMesaDeTrabajo(vistaLateral.getMaterialAUbicarEnMesa(), posicion);
            vistaLateral.setMaterialAUbicarEnMesa(null);
            contenedor.actualizarMesaDeTrabajo();
            contenedor.actualizarInventario();
            sonido.play();
        }
    }
}

