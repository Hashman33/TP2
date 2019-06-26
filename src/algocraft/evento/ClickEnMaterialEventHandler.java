package algocraft.evento;

import algocraft.juego.material.Material;
import algocraft.vista.VistaLateral;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickEnMaterialEventHandler implements  EventHandler<MouseEvent> {

    Material materialSeleccionado;
    VistaLateral vistaLateral;

    public ClickEnMaterialEventHandler(Material materialSeleccionado, VistaLateral vistaLateral) {
        this.materialSeleccionado = materialSeleccionado;
        this.vistaLateral = vistaLateral;

    }

    @Override
    public void handle(MouseEvent mouseEvent) { this.vistaLateral.setMaterialAUbicarEnMesa(materialSeleccionado); }
}
