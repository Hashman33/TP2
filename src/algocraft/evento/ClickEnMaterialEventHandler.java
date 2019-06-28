
package algocraft.evento;

import algocraft.juego.material.Material;
import algocraft.vista.VistaLateral;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;


public class ClickEnMaterialEventHandler implements  EventHandler<MouseEvent> {

    Material materialSeleccionado;
    VistaLateral vistaLateral;
    AudioClip sonido;

    public ClickEnMaterialEventHandler(Material materialSeleccionado, VistaLateral vistaLateral) {
        this.materialSeleccionado = materialSeleccionado;
        this.vistaLateral = vistaLateral;
        this.sonido = new AudioClip(this.getClass().getResource("/recursos/sonidos/item1.mp3").toExternalForm());

    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.vistaLateral.setMaterialAUbicarEnMesa(materialSeleccionado);
        sonido.play();
    }
}

