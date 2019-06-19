package algocraft.jugador;

import algocraft.herramienta.*;
import algocraft.material.*;
import algocraft.utilidades.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorUsaMesaDeTrabajoTests {

    PosicionMesaDeTrabajo posicion = new PosicionMesaDeTrabajo();

    @Test
    public void test01JugadorAgregaMaterialAMesaDeTrabajoYSeQuitaDeSuInventario() {
        Jugador jugador = new Jugador();

        Madera madera = new Madera();
        jugador.agregarEnInventario(madera);

        assertEquals(jugador.inventario.pertenece(madera), true);
        jugador.agregarAMesaDeTrabajo(madera, posicion.uno());
        assertEquals(jugador.inventario.pertenece(madera), false);
    }

    @Test
    public void test02JugadorAgregaMaterialAMesaDeTrabajoEnUnaPosicionOcupadaYNoLoQuitaDelInventario() {
        Jugador jugador = new Jugador();

        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        jugador.agregarEnInventario(madera);
        jugador.agregarEnInventario(piedra);

        assertEquals(jugador.inventario.pertenece(madera), true);
        assertEquals(jugador.inventario.pertenece(piedra), true);
        jugador.agregarAMesaDeTrabajo(madera, posicion.uno());
        jugador.agregarAMesaDeTrabajo(piedra, posicion.uno());
        assertEquals(jugador.inventario.pertenece(madera), false);
        assertEquals(jugador.inventario.pertenece(piedra), true);
    }

    @Test
    public void test03JugadorAgregaMaterialAMesaDeTrabajoYLuegoLimpiaLaMesaDevolviendoElMaterial() {
        Jugador jugador = new Jugador();

        Madera madera = new Madera();
        jugador.agregarEnInventario(madera);

        assertEquals(jugador.inventario.pertenece(madera), true);
        jugador.agregarAMesaDeTrabajo(madera, posicion.uno());
        assertEquals(jugador.inventario.pertenece(madera), false);
        jugador.limpiarMesaDeTrabajo();
        assertEquals(jugador.inventario.pertenece(madera), true);
    }

    @Test
    public void test04JugadorAgregaVariosMaterialesAMesaDeTrabajoYLuegoLimpiaLaMesaDevolviendoLosMateriales() {
        Jugador jugador = new Jugador();

        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        jugador.agregarEnInventario(madera);
        jugador.agregarEnInventario(piedra);
        jugador.agregarEnInventario(metal);


        assertEquals(jugador.inventario.pertenece(madera), true);
        assertEquals(jugador.inventario.pertenece(piedra), true);
        assertEquals(jugador.inventario.pertenece(metal), true);
        jugador.agregarAMesaDeTrabajo(madera, posicion.uno());
        jugador.agregarAMesaDeTrabajo(piedra, posicion.dos());
        jugador.agregarAMesaDeTrabajo(metal, posicion.tres());

        assertEquals(jugador.inventario.pertenece(madera), false);
        assertEquals(jugador.inventario.pertenece(piedra), false);
        assertEquals(jugador.inventario.pertenece(metal), false);
        jugador.limpiarMesaDeTrabajo();

        assertEquals(jugador.inventario.pertenece(madera), true);
        assertEquals(jugador.inventario.pertenece(piedra), true);
        assertEquals(jugador.inventario.pertenece(metal), true);
    }

    @Test
    public void test05JugadorCreaHachaDeMaderaConMesaDeTrabajoYQuedaVacia() {
        Jugador jugador = new Jugador();

        Madera madera1 = new Madera();
        Madera madera2 = new Madera();
        Madera madera3 = new Madera();
        Madera madera4 = new Madera();
        Madera madera5 = new Madera();

        jugador.agregarEnInventario(madera1);
        jugador.agregarEnInventario(madera2);
        jugador.agregarEnInventario(madera3);
        jugador.agregarEnInventario(madera4);
        jugador.agregarEnInventario(madera5);

        jugador.agregarAMesaDeTrabajo(madera1, posicion.dos());
        jugador.agregarAMesaDeTrabajo(madera2, posicion.cinco());
        jugador.agregarAMesaDeTrabajo(madera3, posicion.ocho());
        jugador.agregarAMesaDeTrabajo(madera4, posicion.uno());
        jugador.agregarAMesaDeTrabajo(madera5, posicion.cuatro());

        //En posicion 0 está el hacha madera inicial
        assert(jugador.inventario.herramientas.get(1) instanceof Hacha);
        assert((((Hacha) jugador.inventario.herramientas.get(1)).getMaterial() instanceof HerramientaMadera));
        assert(jugador.mesaDeTrabajo.estaVacia());
    }

    @Test
    public void test06JugadorCreaHachaDePiedraConMesaDeTrabajoYQuedaVacia() {
        Jugador jugador = new Jugador();

        Madera madera1 = new Madera();
        Madera madera2 = new Madera();
        Piedra piedra1 = new Piedra();
        Piedra piedra2 = new Piedra();
        Piedra piedra3 = new Piedra();

        jugador.agregarEnInventario(madera1);
        jugador.agregarEnInventario(madera2);
        jugador.agregarEnInventario(piedra1);
        jugador.agregarEnInventario(piedra2);
        jugador.agregarEnInventario(piedra3);

        jugador.agregarAMesaDeTrabajo(madera1, posicion.cinco());
        jugador.agregarAMesaDeTrabajo(madera2, posicion.ocho());
        jugador.agregarAMesaDeTrabajo(piedra1, posicion.uno());
        jugador.agregarAMesaDeTrabajo(piedra2, posicion.dos());
        jugador.agregarAMesaDeTrabajo(piedra3, posicion.cuatro());

        assert(jugador.inventario.herramientas.get(1) instanceof Hacha);
        assert((((Hacha) jugador.inventario.herramientas.get(1)).getMaterial() instanceof HerramientaPiedra));
        assert(jugador.mesaDeTrabajo.estaVacia());
    }

    @Test
    public void test07JugadorCreaHachaDeMetalConMesaDeTrabajoYQuedaVacia() {
        Jugador jugador = new Jugador();

        Madera madera1 = new Madera();
        Madera madera2 = new Madera();
        Metal metal1 = new Metal();
        Metal metal2 = new Metal();
        Metal metal3 = new Metal();

        jugador.agregarEnInventario(madera1);
        jugador.agregarEnInventario(madera2);
        jugador.agregarEnInventario(metal1);
        jugador.agregarEnInventario(metal2);
        jugador.agregarEnInventario(metal3);

        jugador.agregarAMesaDeTrabajo(madera1, posicion.cinco());
        jugador.agregarAMesaDeTrabajo(madera2, posicion.ocho());
        jugador.agregarAMesaDeTrabajo(metal1, posicion.uno());
        jugador.agregarAMesaDeTrabajo(metal2, posicion.dos());
        jugador.agregarAMesaDeTrabajo(metal3, posicion.cuatro());

        assert(jugador.inventario.herramientas.get(1) instanceof Hacha);
        assert((((Hacha) jugador.inventario.herramientas.get(1)).getMaterial() instanceof HerramientaMetal));
        assert(jugador.mesaDeTrabajo.estaVacia());
    }

    @Test
    public void test08JugadorCreaPicoDeMaderaConMesaDeTrabajoYQuedaVacia() {
        Jugador jugador = new Jugador();

        Madera madera1 = new Madera();
        Madera madera2 = new Madera();
        Madera madera3 = new Madera();
        Madera madera4 = new Madera();
        Madera madera5 = new Madera();

        jugador.agregarEnInventario(madera1);
        jugador.agregarEnInventario(madera2);
        jugador.agregarEnInventario(madera3);
        jugador.agregarEnInventario(madera4);
        jugador.agregarEnInventario(madera5);

        jugador.agregarAMesaDeTrabajo(madera1, posicion.cinco());
        jugador.agregarAMesaDeTrabajo(madera2, posicion.ocho());
        jugador.agregarAMesaDeTrabajo(madera3, posicion.uno());
        jugador.agregarAMesaDeTrabajo(madera4, posicion.dos());
        jugador.agregarAMesaDeTrabajo(madera5, posicion.tres());

        assert(jugador.inventario.herramientas.get(1) instanceof Pico);
        assert((((Pico) jugador.inventario.herramientas.get(1)).getMaterial() instanceof HerramientaMadera));
        assert(jugador.mesaDeTrabajo.estaVacia());
    }

    @Test
    public void test09JugadorCreaPicoDePiedraConMesaDeTrabajoYQuedaVacia() {
        Jugador jugador = new Jugador();

        Madera madera1 = new Madera();
        Madera madera2 = new Madera();
        Piedra piedra1 = new Piedra();
        Piedra piedra2 = new Piedra();
        Piedra piedra3 = new Piedra();

        jugador.agregarEnInventario(madera1);
        jugador.agregarEnInventario(madera2);
        jugador.agregarEnInventario(piedra1);
        jugador.agregarEnInventario(piedra2);
        jugador.agregarEnInventario(piedra3);

        jugador.agregarAMesaDeTrabajo(madera1, posicion.cinco());
        jugador.agregarAMesaDeTrabajo(madera2, posicion.ocho());
        jugador.agregarAMesaDeTrabajo(piedra1, posicion.uno());
        jugador.agregarAMesaDeTrabajo(piedra2, posicion.dos());
        jugador.agregarAMesaDeTrabajo(piedra3, posicion.tres());

        assert(jugador.inventario.herramientas.get(1) instanceof Pico);
        assert((((Pico) jugador.inventario.herramientas.get(1)).getMaterial() instanceof HerramientaPiedra));
        assert(jugador.mesaDeTrabajo.estaVacia());
    }

    @Test
    public void test10JugadorCreaPicoDeMetalConMesaDeTrabajoYQuedaVacia() {

        Jugador jugador = new Jugador();

        Madera madera1 = new Madera();
        Madera madera2 = new Madera();
        Metal metal1 = new Metal();
        Metal metal2 = new Metal();
        Metal metal3 = new Metal();

        jugador.agregarEnInventario(madera1);
        jugador.agregarEnInventario(madera2);
        jugador.agregarEnInventario(metal1);
        jugador.agregarEnInventario(metal2);
        jugador.agregarEnInventario(metal3);

        jugador.agregarAMesaDeTrabajo(madera1, posicion.cinco());
        jugador.agregarAMesaDeTrabajo(madera2, posicion.ocho());
        jugador.agregarAMesaDeTrabajo(metal1, posicion.uno());
        jugador.agregarAMesaDeTrabajo(metal2, posicion.dos());
        jugador.agregarAMesaDeTrabajo(metal3, posicion.tres());

        assert(jugador.inventario.herramientas.get(1) instanceof Pico);
        assert((((Pico) jugador.inventario.herramientas.get(1)).getMaterial() instanceof HerramientaMetal));
        assert(jugador.mesaDeTrabajo.estaVacia());
    }

    @Test
    public void test11JugadorCreaPicoFinoConMesaDeTrabajoYQuedaVacia() {

        Jugador jugador = new Jugador();

        Madera madera1 = new Madera();
        Madera madera2 = new Madera();
        Piedra piedra = new Piedra();
        Metal metal1 = new Metal();
        Metal metal2 = new Metal();
        Metal metal3 = new Metal();

        jugador.agregarEnInventario(madera1);
        jugador.agregarEnInventario(madera2);
        jugador.agregarEnInventario(piedra);
        jugador.agregarEnInventario(metal1);
        jugador.agregarEnInventario(metal2);
        jugador.agregarEnInventario(metal3);

        jugador.agregarAMesaDeTrabajo(madera1, posicion.cinco());
        jugador.agregarAMesaDeTrabajo(madera2, posicion.ocho());
        jugador.agregarAMesaDeTrabajo(piedra, posicion.cuatro());
        jugador.agregarAMesaDeTrabajo(metal1, posicion.uno());
        jugador.agregarAMesaDeTrabajo(metal2, posicion.dos());
        jugador.agregarAMesaDeTrabajo(metal3, posicion.tres());

        assert(jugador.inventario.herramientas.get(1) instanceof PicoFino);
        assert(jugador.mesaDeTrabajo.estaVacia());
    }
}
