package algocraft.crafteo;

import algocraft.herramienta.*;
import algocraft.jugador.Jugador;
import algocraft.jugador.MesaDeTrabajo;
import algocraft.material.Madera;
import algocraft.material.Metal;
import algocraft.material.Piedra;
import algocraft.matriz.Celda;
import algocraft.matriz.Matriz;
import algocraft.utilidades.VectorPosicion2I;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrafteoTests {

    @Test
    public void test00PonerLosMaterialesEnCualquierLugarNoGeneraHerramienta(){

        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(0,0));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,0));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(0,1));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,1));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,2));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(2,2));

        assert(mesaDeTrabajo.obtenerCrafteoActual() == null);

        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(0,2));

        assert(mesaDeTrabajo.obtenerCrafteoActual() == null);

    }

    @Test
    public void test01CrafteoHachaDeMaderaYObtengoUnHachaDeMadera(){

        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(0,0));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,0));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(0,1));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,1));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,2));

        assert(mesaDeTrabajo.obtenerCrafteoActual() != null);
        assert(mesaDeTrabajo.obtenerCrafteoActual() instanceof Hacha);
        assert(((Hacha) mesaDeTrabajo.obtenerCrafteoActual()).getMaterial() instanceof HerramientaMadera);

    }

    @Test
    public void test02CrafteoHachaDePiedraYObtengoUnHachaDePiedra(){

        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

        mesaDeTrabajo.agregarMaterial(new Piedra(), new VectorPosicion2I(0,0));
        mesaDeTrabajo.agregarMaterial(new Piedra(), new VectorPosicion2I(1,0));
        mesaDeTrabajo.agregarMaterial(new Piedra(), new VectorPosicion2I(0,1));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,1));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,2));

        assert(mesaDeTrabajo.obtenerCrafteoActual() != null);
        assert(mesaDeTrabajo.obtenerCrafteoActual() instanceof Hacha);
        assert(((Hacha) mesaDeTrabajo.obtenerCrafteoActual()).getMaterial() instanceof HerramientaPiedra);

    }

    @Test
    public void test03CrafteoHachaDeMetalYObtengoUnHachaDeMetal(){

        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

        mesaDeTrabajo.agregarMaterial(new Metal(), new VectorPosicion2I(0,0));
        mesaDeTrabajo.agregarMaterial(new Metal(), new VectorPosicion2I(1,0));
        mesaDeTrabajo.agregarMaterial(new Metal(), new VectorPosicion2I(0,1));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,1));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,2));

        assert(mesaDeTrabajo.obtenerCrafteoActual() != null);
        assert(mesaDeTrabajo.obtenerCrafteoActual() instanceof Hacha);
        assert(((Hacha) mesaDeTrabajo.obtenerCrafteoActual()).getMaterial() instanceof HerramientaMetal);

    }

    @Test
    public void test04CrafteoPicoDeMaderaYObtengoUnPicoDeMadera(){

        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(0,0));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,0));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(2,0));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,1));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,2));

        assert(mesaDeTrabajo.obtenerCrafteoActual() != null);
        assert(mesaDeTrabajo.obtenerCrafteoActual() instanceof Pico);
        assert(((Pico) mesaDeTrabajo.obtenerCrafteoActual()).getMaterial() instanceof HerramientaMadera);

    }

    @Test
    public void test05CrafteoPicoDePiedraYObtengoUnPicoDePiedra(){

        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

        mesaDeTrabajo.agregarMaterial(new Piedra(), new VectorPosicion2I(0,0));
        mesaDeTrabajo.agregarMaterial(new Piedra(), new VectorPosicion2I(1,0));
        mesaDeTrabajo.agregarMaterial(new Piedra(), new VectorPosicion2I(2,0));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,1));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,2));

        assert(mesaDeTrabajo.obtenerCrafteoActual() != null);
        assert(mesaDeTrabajo.obtenerCrafteoActual() instanceof Pico);
        assert(((Pico) mesaDeTrabajo.obtenerCrafteoActual()).getMaterial() instanceof HerramientaPiedra);

    }

    @Test
    public void test06CrafteoPicoDeMetalYObtengoUnPicoDeMetal(){

        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

        mesaDeTrabajo.agregarMaterial(new Metal(), new VectorPosicion2I(0,0));
        mesaDeTrabajo.agregarMaterial(new Metal(), new VectorPosicion2I(1,0));
        mesaDeTrabajo.agregarMaterial(new Metal(), new VectorPosicion2I(2,0));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,1));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,2));

        assert(mesaDeTrabajo.obtenerCrafteoActual() != null);
        assert(mesaDeTrabajo.obtenerCrafteoActual() instanceof Pico);
        assert(((Pico) mesaDeTrabajo.obtenerCrafteoActual()).getMaterial() instanceof HerramientaMetal);

    }

    @Test
    public void test07CrafteoPicoFinoYObtengoUnPicoFino(){

        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

        mesaDeTrabajo.agregarMaterial(new Metal(), new VectorPosicion2I(0,0));
        mesaDeTrabajo.agregarMaterial(new Metal(), new VectorPosicion2I(1,0));
        mesaDeTrabajo.agregarMaterial(new Metal(), new VectorPosicion2I(2,0));
        mesaDeTrabajo.agregarMaterial(new Piedra(), new VectorPosicion2I(0,1));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,1));
        mesaDeTrabajo.agregarMaterial(new Madera(), new VectorPosicion2I(1,2));

        assert(mesaDeTrabajo.obtenerCrafteoActual() != null);
        assert(mesaDeTrabajo.obtenerCrafteoActual() instanceof PicoFino);

    }


}
