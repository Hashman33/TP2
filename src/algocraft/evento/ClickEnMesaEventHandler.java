package algocraft.evento;

import algocraft.juego.Juego;
import algocraft.juego.material.Material;
import algocraft.utilidades.VectorPosicion2I;
import algocraft.vista.ContenedorJuego;
import algocraft.vista.VistaLateral;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickEnMesaEventHandler implements EventHandler<MouseEvent> {

    Juego juego;
    ContenedorJuego contenedor;
    VectorPosicion2I posicion;
    VistaLateral vistaLateral;

    public ClickEnMesaEventHandler(ContenedorJuego contenedor, Juego juego, VistaLateral vistaLateral, VectorPosicion2I pos) {
        this.juego = juego;
        this.contenedor = contenedor;
        this.vistaLateral = vistaLateral;
        this.posicion = pos;

    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (vistaLateral.getMaterialAUbicarEnMesa() != null) {
            juego.agregarMaterialAMesaDeTrabajo(vistaLateral.getMaterialAUbicarEnMesa(), posicion);
            vistaLateral.setMaterialAUbicarEnMesa(null);
            contenedor.actualizarMesaDeTrabajo();
            contenedor.actualizarInventario();
        }
    }
}

