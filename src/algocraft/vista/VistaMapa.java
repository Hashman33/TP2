package algocraft.vista;

import algocraft.juego.mapa.Mapa;
import algocraft.utilidades.VectorPosicion2I;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class VistaMapa implements Dibujable {

    private Mapa mapa;
    private BorderPane borderPane;

    public VistaMapa(Mapa mapa, BorderPane borderPane) {
        this.borderPane = borderPane;
        this.mapa = mapa;
    }

    @Override
    public void dibujar() {

        GridPane gridPane = new GridPane();

        Image pasto = new Image("/recursos/texturas/pasto.jpg", 32, 32, false,true);

        for (int i = 0; i < this.mapa.getLargo(); i++) {
            for (int j = 0; j < this.mapa.getAncho(); j++) {
                VectorPosicion2I posicion = new VectorPosicion2I(i, j);
                Image imagen = this.mapa.obtenerMaterial(posicion) != null ? this.mapa.obtenerMaterial(posicion).getTextura() : null;
                ImageView imageView = null;

                if (imagen != null) {
                    imageView = new ImageView(imagen);
                }
                else {
                    imageView = new ImageView(pasto);
                }
                gridPane.add(imageView, i, j);
            }
        }

        this.borderPane.setCenter(gridPane);

    }
}
