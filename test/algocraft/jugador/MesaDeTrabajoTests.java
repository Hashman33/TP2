package algocraft.jugador;

import algocraft.herramienta.Hacha;
import algocraft.herramienta.HerramientaMadera;
import algocraft.mapa.Mapa;
import algocraft.material.Piedra;
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

        mesaDeTrabajo.agregarMaterial(0,0, new Piedra());

        assert(!mesaDeTrabajo.estaVacia());
    }
}