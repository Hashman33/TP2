package algocraft.controlador;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.io.InputStream;

public class BotonMenu extends Button {

    public BotonMenu() {

        super();

        InputStream i = getClass().getResourceAsStream("/recursos/fuentes/Minecraft.ttf");
        Font fuenteRegular = Font.loadFont(i, 20);

        this.setFont(fuenteRegular);
    }
}
