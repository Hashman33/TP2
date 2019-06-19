package algocraft.jugador;

import algocraft.herramienta.*;
import algocraft.material.Madera;
import algocraft.material.Metal;
import algocraft.material.Piedra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InventarioTests {

    @Test
    public void test01InventarioIniciaVacio() {

        Inventario inventario = new Inventario();

        assertEquals(0, inventario.cantidadDeElementos());

    }

    @Test
    public void test02AgregoItemsAlInventarioYAumentaSuCantidad() {

        Inventario inventario = new Inventario();

        inventario.agregar(new Hacha(new HerramientaMadera()));
        assertEquals(1, inventario.cantidadDeElementos());

        inventario.agregar(new Pico(new HerramientaMadera()));
        assertEquals(2, inventario.cantidadDeElementos());

        inventario.agregar(new PicoFino());
        assertEquals(3, inventario.cantidadDeElementos());

        inventario.agregar(new Piedra());
        assertEquals(4, inventario.cantidadDeElementos());

        inventario.agregar(new Madera());
        assertEquals(5, inventario.cantidadDeElementos());

        inventario.agregar(new Metal());
        assertEquals(6, inventario.cantidadDeElementos());
    }

    @Test
    public void test03AgregoUnElementoYPerteneceAlInventario() {

        Inventario inventario = new Inventario();

        Hacha hacha = new Hacha(new HerramientaMadera());

        inventario.agregar(hacha);
        assert(inventario.pertenece(hacha));

        Piedra piedra = new Piedra();

        inventario.agregar(piedra);
        assert(inventario.pertenece(piedra));

    }

    @Test
    public void test04AgregoUnElementoYaExistenteYNoAmuentaLaCantidad() {

        Inventario inventario = new Inventario();

        Hacha hacha = new Hacha(new HerramientaMadera());

        inventario.agregar(hacha);
        assertEquals(1, inventario.cantidadDeElementos());

        inventario.agregar(hacha);
        assertEquals(1, inventario.cantidadDeElementos());

    }

    @Test
    public void test05QuitoUnElementoYYaNoPerteneceAlInventario() {

        Inventario inventario = new Inventario();

        Hacha hacha = new Hacha(new HerramientaMadera());

        inventario.agregar(hacha);
        inventario.quitar(hacha);

        assert(!inventario.pertenece(hacha));

    }

    // Por la dinamica del juego, esto no podria pasar, ya que no habria elementos que
    // no pertenezcan al inventario para quitarDeInventario. Para el modelo, es un caso de excepcion.
    @Test
    public void test06QuitoUnaHerramientaQueNoEstaYLanzaExcepcion() {

        Inventario inventario = new Inventario();

        Hacha hacha = new Hacha(new HerramientaMadera());

        assertThrows(ElementoNoEstaEnInventarioException.class, ()-> { inventario.quitar(hacha); });

    }

    @Test
    public void test07QuitoUnMaterialQueNoEstaYLanzaExcepcion() {

        Inventario inventario = new Inventario();

        Piedra piedra = new Piedra();

        assertThrows(ElementoNoEstaEnInventarioException.class, ()-> { inventario.quitar(piedra); });

    }

    @Test
    public void test08QuitoHerramientaQueEstabaEquipadaYSeEquipaLaMano() {

        Inventario inventario = new Inventario();
        Hacha hachaMadera = new Hacha(new HerramientaMadera());

        inventario.agregar(hachaMadera);
        inventario.equipar(hachaMadera);
        inventario.quitar(hachaMadera);

        assert(!inventario.pertenece(hachaMadera));
        assert(inventario.herramientaEquipada instanceof Mano);

    }
}
