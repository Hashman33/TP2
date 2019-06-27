package algocraft.vista;

import algocraft.controlador.BotonLimpiarMesa;
import algocraft.evento.*;
import algocraft.juego.Juego;
import algocraft.juego.jugador.Inventario;
import algocraft.juego.jugador.MesaDeTrabajo;
import algocraft.juego.material.Material;
import algocraft.utilidades.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class VistaLateral implements Dibujable {

    private static int LARGOMESA = 3;
    private static int ANCHOMESA = 3;
    private static int ANCHOINVENTARIO = 6;
    private static int LARGOINVENTARIOH = 1;
    private static int LARGOINVENTARIOM = 4;

    private ContenedorJuego contenedorJuego;
    private VBox contenedor;
    private Image slot;
    private GridPane gridMesaCarfteo;
    private GridPane inventarioMateriales;
    private GridPane inventarioHerramientas;
    private Juego juego;
    private Inventario inventario;
    private MesaDeTrabajo mesaDeTrabajo;
    private Material materialAUbicarEnMesa;


    public VistaLateral(Juego juego,ContenedorJuego contenedorJuego) {

        this.contenedorJuego = contenedorJuego;
        this.contenedor = new VBox();
        this.slot = new Image("/recursos/texturas/slot.png", 34, 34, false, true);
        this.gridMesaCarfteo = new GridPane();
        this.inventarioMateriales = new GridPane();
        this.inventarioHerramientas = new GridPane();
        inventarioHerramientas.setBackground(new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        this.inventario = juego.getJugador().getInventario();
        this.mesaDeTrabajo = juego.getJugador().getMesaDeTrabajo();
        this.materialAUbicarEnMesa = null;
        this.juego = juego;
    }

    @Override
    public void dibujar() {

        this.dibujarMesaDeTrabajo();
        this.dibujarInventarioH();
        this.dibujarInventarioM();

        HBox mesaTrabajo = new HBox();
        BotonLimpiarMesa botonLimpiar = new BotonLimpiarMesa();
        mesaTrabajo.getChildren().addAll(gridMesaCarfteo, botonLimpiar);
        mesaTrabajo.setSpacing(20);

        BotonLimpiarEventHandler botonLimpiarHandler = new BotonLimpiarEventHandler(contenedorJuego, juego);
        botonLimpiar.setOnAction(botonLimpiarHandler);

        this.contenedor.getChildren().addAll(mesaTrabajo, inventarioMateriales, inventarioHerramientas);
        this.contenedor.setSpacing(40);
        this.contenedorJuego.setRight(contenedor);
        BorderPane.setMargin(contenedor, new Insets(32,32,32,32));
    }

    public void dibujarMesaDeTrabajo() {

        for (int i = 0; i < ANCHOMESA; i++) {
            for (int j = 0; j < LARGOMESA; j++) {
                dibujarCeldaMesa(i, j);
            }
        }
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
        ClickEnMesaEventHandler clickMesaHandler = new ClickEnMesaEventHandler(contenedorJuego, juego, this, new VectorPosicion2I(i,j) );
        fondo.setOnMouseClicked(clickMesaHandler);
        this.gridMesaCarfteo.add(fondo, i, j);

        Material material = this.mesaDeTrabajo.obtenerMaterial(new VectorPosicion2I(i, j));
        if (material != null) {
            this.gridMesaCarfteo.add(material.getTexturaU(), i, j);
        }
    }

    public void dibujarCeldaInventarioM(int i, int j) {

        ImageView fondo = new ImageView(slot);
        this.inventarioMateriales.add(fondo, i, j);

        int posicionArray = LARGOINVENTARIOM * i + j;

        if ( posicionArray < inventario.getMateriales().size() ){

            ImageView material = inventario.getMateriales().get(posicionArray).getTexturaU();
            ClickEnMaterialEventHandler clickMaterialHandler = new ClickEnMaterialEventHandler(inventario.getMateriales().get(posicionArray), this);
            material.setOnMouseClicked(clickMaterialHandler);
            fondo.setOnMouseClicked(clickMaterialHandler);
            this.inventarioMateriales.add(material,i,j);
        }

    }

    public void dibujarCeldaInventarioH(int i, int j) {

        ImageView fondo = new ImageView(slot);
        this.inventarioHerramientas.add(fondo, i, j);

        if (i < inventario.cantidadDeHerramientas()) {

            ImageView herramienta = inventario.getHerramientas().get(i).getTextura();
            ClickEnHerramientaEventHandler clickMaterialHandler = new ClickEnHerramientaEventHandler(inventario.getHerramientas().get(i), contenedorJuego, juego);
            herramienta.setOnMouseClicked(clickMaterialHandler);
            fondo.setOnMouseClicked(clickMaterialHandler);
            this.inventarioHerramientas.add(herramienta, i, j);
        }
    }

    public void setMaterialAUbicarEnMesa(Material material) { this.materialAUbicarEnMesa = material; }

    public Material getMaterialAUbicarEnMesa() { return this.materialAUbicarEnMesa; }


}
