package algocraft.vista;

import algocraft.juego.mapa.Mapa;
import algocraft.utilidades.VectorPosicion2I;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class VistaLateral implements Dibujable {

    private BorderPane borderPane;
    private VBox contenedor;
    private Image slot;
    private GridPane mesaCarfteo;
    private GridPane inventarioMateriales;
    private GridPane inventarioHerramientas;
    private static int LARGOMESA = 3;
    private static int ANCHOMESA = 3;
    private static int ANCHOINVENTARIO = 6;
    private static int LARGOINVENTARIOH = 1;
    private static int LARGOINVENTARIOM = 4;

    public VistaLateral(BorderPane borderPane) {

        this.borderPane = borderPane;
        this.contenedor = new VBox();
        this.slot = new Image("/recursos/texturas/slot.png", 40, 40, false, true);
        this.mesaCarfteo = new GridPane();
        this.inventarioMateriales = new GridPane();
        this.inventarioHerramientas = new GridPane();
    }

    @Override
    public void dibujar() {

        for (int i = 0; i < ANCHOMESA; i++) {
            for (int j = 0; j < LARGOMESA; j++) {
                dibujarCeldaMesa(i, j);
            }
        }
        for (int i = 0; i < ANCHOINVENTARIO; i++) {
            for (int j = 0; j < LARGOINVENTARIOH; j++) {
                dibujarCeldaInventarioH(i, j);
            }
        }
        for (int i = 0; i < ANCHOINVENTARIO; i++) {
            for (int j = 0; j < LARGOINVENTARIOM; j++) {
                dibujarCeldaInventarioM(i, j);
            }
        }
        this.contenedor.getChildren().addAll(mesaCarfteo, inventarioMateriales, inventarioHerramientas);
        this.contenedor.setSpacing(40);
        this.borderPane.setRight(contenedor);

    }

    public void dibujarCeldaMesa(int i, int j) {

        // Tal vez cada nodo del grid deberia ser un vbox con un fondo y una imagen
        ImageView fondo = new ImageView(slot);
        this.mesaCarfteo.add(fondo, i, j);
    }

    public void dibujarCeldaInventarioM(int i, int j) {

        ImageView fondo = new ImageView(slot);
        this.inventarioMateriales.add(fondo, i, j);
    }

    public void dibujarCeldaInventarioH(int i, int j) {

        ImageView fondo = new ImageView(slot);
        this.inventarioHerramientas.add(fondo, i, j);
    }

}
