package algocraft.juego;

import algocraft.juego.jugador.Jugador;
import algocraft.juego.jugador.herramienta.*;
import algocraft.juego.mapa.Mapa;
import algocraft.juego.material.*;
import algocraft.utilidades.Direccion;
import algocraft.utilidades.PosicionMesaDeTrabajo;
import algocraft.utilidades.VectorPosicion2I;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JuegoTests {

    Direccion direccion = new Direccion();
    PosicionMesaDeTrabajo posicionMesa = new PosicionMesaDeTrabajo();

    @Test
    public void test01JuegoSeIniciaCorrectamenteConUnJugadorEnElMapa() {
        Juego juego = new Juego();

        Mapa mapa = juego.getMapa();
        Jugador jugador = juego.getJugador();

        assertEquals(jugador, mapa.obtenerJugador(jugador.getPosicion()));

        mapa.resetear();
    }

    @Test
    public void test02DeIntegracionJugadorObtieneTodosLosMaterialesCreaVariasHerramientasYRompeUna() {
        Juego juego = new Juego();
        Mapa mapa = juego.getMapa();
        Jugador jugadorRandom = juego.getJugador();

        // Normalizo el mapa y reemplazo jugador en pos Random por uno en posicion definida
        Jugador jugador = new Jugador();
        mapa.iniciarNormalizado();
        mapa.removerJugador(jugadorRandom.getPosicion());
        mapa.insertarJugador(jugador, new VectorPosicion2I(14,14));
        List<Material> materiales = jugador.getInventarioMateriales();
        List<Herramienta> herramientas = jugador.getInventarioHerramientas();

        // Obtiene 5 maderas
        for (int i = 0; i < 3; i++) jugador.mover(mapa, direccion.izquierda());
        for (int i = 0; i < 5; i++) jugador.usarHerramienta(mapa);
        jugador.mover(mapa, direccion.izquierda());
        for (int i = 0; i < 5; i++) jugador.usarHerramienta(mapa);
        jugador.mover(mapa, direccion.izquierda());
        for (int i = 0; i < 5; i++) jugador.usarHerramienta(mapa);
        jugador.mover(mapa, direccion.izquierda());
        for (int i = 0; i < 5; i++) jugador.usarHerramienta(mapa);
        jugador.mover(mapa, direccion.izquierda());
        for (int i = 0; i < 5; i++) jugador.usarHerramienta(mapa);

        // Craftea los materiales y obtiene el pico de madera
        jugador.agregarAMesaDeTrabajo(materiales.get(0), posicionMesa.uno());
        jugador.agregarAMesaDeTrabajo(materiales.get(0), posicionMesa.dos());
        jugador.agregarAMesaDeTrabajo(materiales.get(0), posicionMesa.tres());
        jugador.agregarAMesaDeTrabajo(materiales.get(0), posicionMesa.cinco());
        jugador.agregarAMesaDeTrabajo(materiales.get(0), posicionMesa.ocho());

        assert(herramientas.get(1) instanceof Pico);
        assert(((Pico) herramientas.get(1)).getMaterial() instanceof HerramientaMadera);


        // Obtiene 4 maderas más para futuras construcciones
        jugador.mover(mapa, direccion.izquierda());
        for (int i = 0; i < 5; i++) jugador.usarHerramienta(mapa);
        jugador.mover(mapa, direccion.izquierda());
        for (int i = 0; i < 5; i++) jugador.usarHerramienta(mapa);
        jugador.mover(mapa, direccion.izquierda());
        for (int i = 0; i < 5; i++) jugador.usarHerramienta(mapa);
        jugador.mover(mapa, direccion.abajo());
        for (int i = 0; i < 5; i++) jugador.usarHerramienta(mapa);

        // Equipa el pico de madera y obtiene 4 piedras
        jugador.equipar(herramientas.get(1));

        jugador.mover(mapa, direccion.arriba());
        jugador.mover(mapa, direccion.arriba());
        for (int i = 0; i < 15; i++) jugador.usarHerramienta(mapa);
        jugador.mover(mapa, direccion.arriba());
        for (int i = 0; i < 15; i++) jugador.usarHerramienta(mapa);
        jugador.mover(mapa, direccion.arriba());
        for (int i = 0; i < 15; i++) jugador.usarHerramienta(mapa);

        // Craftea los materiales y obtiene el pico de piedra
        jugador.agregarAMesaDeTrabajo(materiales.get(4), posicionMesa.uno());
        jugador.agregarAMesaDeTrabajo(materiales.get(4), posicionMesa.dos());
        jugador.agregarAMesaDeTrabajo(materiales.get(4), posicionMesa.tres());
        jugador.agregarAMesaDeTrabajo(materiales.get(0), posicionMesa.cinco());
        jugador.agregarAMesaDeTrabajo(materiales.get(0), posicionMesa.ocho());

        assert(herramientas.get(2) instanceof Pico);
        assert(((Pico) herramientas.get(2)).getMaterial() instanceof HerramientaPiedra);


        // Equipa el pico de piedra y obtiene 1 piedra y 3 metales
        jugador.equipar(herramientas.get(2));

        jugador.mover(mapa, direccion.derecha());
        for (int i = 0; i < 8; i++) jugador.usarHerramienta(mapa);
        for (int i = 0; i < 8; i++) jugador.mover(mapa, direccion.arriba());
        for (int i = 0; i < 2; i++) jugador.mover(mapa, direccion.derecha());
        for (int i = 0; i < 13; i++) jugador.usarHerramienta(mapa);
        jugador.mover(mapa, direccion.derecha());
        for (int i = 0; i < 13; i++) jugador.usarHerramienta(mapa);
        jugador.mover(mapa, direccion.derecha());
        for (int i = 0; i < 13; i++) jugador.usarHerramienta(mapa);

        // Craftea los materiales y obtiene el pico fino
        jugador.agregarAMesaDeTrabajo(materiales.get(3), posicionMesa.uno());
        jugador.agregarAMesaDeTrabajo(materiales.get(3), posicionMesa.dos());
        jugador.agregarAMesaDeTrabajo(materiales.get(3), posicionMesa.tres());
        jugador.agregarAMesaDeTrabajo(materiales.get(2), posicionMesa.cuatro());
        jugador.agregarAMesaDeTrabajo(materiales.get(0), posicionMesa.cinco());
        jugador.agregarAMesaDeTrabajo(materiales.get(0), posicionMesa.ocho());

        assert(herramientas.get(3) instanceof PicoFino);


        // Equipa el pico fino y obtiene 2 diamantes
        jugador.equipar(herramientas.get(3));

        jugador.mover(mapa, direccion.abajo());
        for (int i = 0; i < 8; i++) jugador.mover(mapa, direccion.derecha());
        for (int i = 0; i < 13; i++) jugador.usarHerramienta(mapa);
        jugador.mover(mapa, direccion.derecha());
        for (int i = 0; i < 13; i++) jugador.usarHerramienta(mapa);

        assert(materiales.get(0) instanceof Diamante);
        assert(materiales.get(1) instanceof Diamante);

        // Equipa el pico de madera y lo rompe contra un diamante
        // (tenía 45/50 usos con desgaste + 1 que provoca la rotura)
        jugador.equipar(herramientas.get(1));

        jugador.mover(mapa, direccion.abajo());
        for (int i = 0; i < 6; i++) jugador.usarHerramienta(mapa);

        assert(jugador.herramientaEquipada() instanceof Mano);
        assert(herramientas.size() == 3); // HachaMadera - PicoPiedra - PicoFino

        mapa.resetear();
    }
}