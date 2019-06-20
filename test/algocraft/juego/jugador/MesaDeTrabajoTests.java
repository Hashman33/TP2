package algocraft.juego.jugador;

import algocraft.juego.material.*;
import algocraft.utilidades.*;
import org.junit.jupiter.api.Test;


public class MesaDeTrabajoTests {

    PosicionMesaDeTrabajo posicion = new PosicionMesaDeTrabajo();
    @Test
    public void test01MesaDeTrabajoIniciaVacia() {

        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

        assert(mesaDeTrabajo.estaVacia());
    }

    @Test
    public void test02AgregoUnElementoALaMesaDeTrabajoYNoEstaVacia() {

        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

        mesaDeTrabajo.agregarMaterial(new Piedra(), new VectorPosicion2I(0,0));

        assert(!mesaDeTrabajo.estaVacia());
    }

    @Test
    public void test03AgregoUnElementoALaMesaDeTrabajoYLuegoLoRemuevoYQuedaVacia() {

        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

        mesaDeTrabajo.agregarMaterial(new Piedra(), new VectorPosicion2I(0,0));
        mesaDeTrabajo.removerMaterial(new VectorPosicion2I(0,0));

        assert(mesaDeTrabajo.estaVacia());
    }

}