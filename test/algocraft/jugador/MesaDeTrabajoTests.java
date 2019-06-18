package algocraft.jugador;

import algocraft.herramienta.Hacha;
import algocraft.herramienta.HerramientaMadera;
import algocraft.mapa.Mapa;
import algocraft.material.Piedra;
import algocraft.utilidades.VectorPosicion2I;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MesaDeTrabajoTests {

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