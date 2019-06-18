package algocraft.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonJugar extends BotonMenu {

    public BotonJugar() {
        super();

        this.setText("Jugar");

        this.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

            }

        });
    }

}
