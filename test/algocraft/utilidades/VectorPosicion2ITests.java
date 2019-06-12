package algocraft.utilidades;

import algocraft.jugador.Jugador;
import algocraft.material.Madera;
import algocraft.matriz.Celda;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VectorPosicion2ITests {

    @Test
    public void test01VectorPosicion2ISeIniciaEnElOrigen(){
        VectorPosicion2I vector = new VectorPosicion2I();

        assert(vector.getX() == 0 && vector.getY() == 0);
    }

    @Test
    public void test02VectorPosicion2ISeIniciaConUnaPosicionInicial(){
        VectorPosicion2I vector = new VectorPosicion2I(3, 3);

        assert(vector.getX() == 3 && vector.getY() == 3);
    }

    @Test
    public void test03VectorPosicion2ISeSumaConOtro() {
        VectorPosicion2I vector = new VectorPosicion2I(2, 2);
        VectorPosicion2I vector2 = new VectorPosicion2I(3,1);
        VectorPosicion2I vectorSuma = vector.sumar(vector2);

        assert(vectorSuma.getX() == 5 && vectorSuma.getY() == 3);
    }

    @Test
    public void test04VectorPosicion2ISeEscala() {
        VectorPosicion2I vector = new VectorPosicion2I(2, 2);
        VectorPosicion2I vectorEscalado = vector.escalar(10);

        assert(vectorEscalado.getX() == 20 && vectorEscalado.getY() == 20);
    }


}
