package algocraft.vista;

import algocraft.juego.jugador.Inventario;
import algocraft.juego.jugador.MesaDeTrabajo;
import algocraft.juego.mapa.Mapa;
import algocraft.utilidades.VectorPosicion2I;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

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
    private Inventario inventario;
    private MesaDeTrabajo mesaDeTrabajo;

    public VistaLateral(Inventario inventario, MesaDeTrabajo mesaDeTrabajo,BorderPane borderPane) {

        this.borderPane = borderPane;
        this.contenedor = new VBox();
        this.slot = new Image("/recursos/texturas/slot.png", 34, 34, false, true);
        this.mesaCarfteo = new GridPane();
        this.inventarioMateriales = new GridPane();
        this.inventarioHerramientas = new GridPane();
        inventarioHerramientas.setBackground(new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        this.inventario = inventario;
        this.mesaDeTrabajo = mesaDeTrabajo;
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
        BorderPane.setMargin(contenedor, new Insets(32,32,32,32));

    }

    public void dibujarInventarioH(){

        for (int i = 0; i < ANCHOINVENTARIO; i++) {
            for (int j = 0; j < LARGOINVENTARIOH; j++) {
                dibujarCeldaInventarioH(i, j);
            }
        }

    }
    public void dibujarInventarioM(){

        for (int i = 0; i < ANCHOINVENTARIO; i++) {
            for (int j = 0; j < LARGOINVENTARIOM; j++) {
                dibujarCeldaInventarioM(i, j);
            }
        }

    }

    public void dibujarCeldaMesa(int i, int j) {
        ImageView fondo = new ImageView(slot);
        this.mesaCarfteo.add(fondo, i, j);
    }

    public void dibujarCeldaInventarioM(int i, int j) {
        ImageView fondo = new ImageView(slot);
        this.inventarioMateriales.add(fondo, i, j);

        int posicionArray = LARGOINVENTARIOM * i + j;

        if ( posicionArray < inventario.getMateriales().size() ){
            this.inventarioMateriales.add(inventario.getMateriales().get(posicionArray).getTexturaU(),i,j);
            return;
        }

    }

    public void dibujarCeldaInventarioH(int i, int j) {
        ImageView fondo = new ImageView(slot);
        this.inventarioHerramientas.add(fondo, i, j);

        if( i < inventario.cantidadDeHerramientas()){
            this.inventarioHerramientas.add(inventario.getHerramientas().get(i).getTextura(),i,j);
            return;
        }

    }



}
