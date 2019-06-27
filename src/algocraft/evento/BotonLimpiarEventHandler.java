package algocraft.evento;

import algocraft.vista.ContenedorJuego;
import algocraft.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class BotonLimpiarEventHandler implements EventHandler<ActionEvent> {

    ContenedorJuego contenedor;
    Juego juego;

    public BotonLimpiarEventHandler(ContenedorJuego contenedor, Juego juego) {
        this.contenedor = contenedor;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.juego.limpiarMesaDeTrabajo();
        this.contenedor.actualizarMesaDeTrabajo();
        this.contenedor.actualizarInventarioM();
    }

}