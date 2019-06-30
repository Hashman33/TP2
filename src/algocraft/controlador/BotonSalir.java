package algocraft.controlador;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.io.InputStream;

public class BotonSalir extends Button {

    public BotonSalir() {

        super();

        InputStream i = getClass().getResourceAsStream("/recursos/fuentes/Minecraft.ttf");
        Font fuenteRegular = Font.loadFont(i, 12);

        this.setFont(fuenteRegular);
        this.setText("Salir");
    }
}
