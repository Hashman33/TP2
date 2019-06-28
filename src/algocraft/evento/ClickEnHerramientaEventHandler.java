package algocraft.evento;

import algocraft.juego.Juego;
import algocraft.juego.jugador.herramienta.Herramienta;
import algocraft.vista.ContenedorJuego;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickEnHerramientaEventHandler implements EventHandler<MouseEvent> {

    Juego juego;
    ContenedorJuego contenedorJuego;
    Herramienta herramienta;

    public ClickEnHerramientaEventHandler(Herramienta herramienta, ContenedorJuego contenedor, Juego juego) {
            this.juego = juego;
            this.contenedorJuego = contenedor;
            this.herramienta = herramienta;
        }

        @Override
        public void handle(MouseEvent mouseEvent) {
            juego.equipar(herramienta);
            contenedorJuego.actualizarHerramientaEquipada();
        }

    }

