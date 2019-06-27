package algocraft.controlador;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.io.InputStream;

public class BotonLimpiarMesa extends Button {

    public BotonLimpiarMesa() {

        super();

        InputStream i = getClass().getResourceAsStream("/recursos/fuentes/Minecraft.ttf");
        Font fuenteRegular = Font.loadFont(i, 10);

        this.setFont(fuenteRegular);
        this.setText("Limpiar");
    }
}