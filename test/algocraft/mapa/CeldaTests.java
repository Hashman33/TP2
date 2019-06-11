package algocraft.mapa;

import algocraft.jugador.Jugador;
import algocraft.material.Madera;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CeldaTests {

    @Test
    public void test01UnaCeldaSeIniciaVacia(){
        Celda celda  = new Celda();
        assert(celda.estaVacia());
    }
    @Test
    public void test02SeLeAgregaUnMaterialYnoEstaVacia(){
        Celda celda = new Celda();
        celda.colocarMaterial(new Madera());
        assert(!celda.estaVacia());
    }

    @Test
    public void test03SeLeAgregaUnMaterialCorrectamenteACelda(){

        Celda celda = new Celda();
        Madera madera = new Madera();
        celda.colocarMaterial(madera);

        assertEquals(madera, celda.obtenerMaterial());

    }
    @Test
    public void test04SeLeAgregaUnJugadorCorrectamenteACelda(){

        Celda celda = new Celda();
        Jugador jugador = new Jugador();
        celda.colocarJugador(jugador);

        assertEquals(jugador, celda.obtenerJugador());

    }
    @Test
    public void test05SeIntentaAgregarUnMaterialEnUnaCeldaOcupadaPorMaterialYnoSeModifica(){
        Celda celda = new Celda();
        Madera madera = new Madera();
        celda.colocarMaterial(madera);
        Madera madera2 = new Madera();

        assertEquals(madera, celda.obtenerMaterial());

    }
    @Test
    public void test06SeIntentaAgregarUnMaterialEnUnaCeldaOcupadaPorJugadorYnoSeModifica(){
        Celda celda = new Celda();
        Jugador jugador = new Jugador();
        celda.colocarJugador(jugador);
        Madera madera = new Madera();
        celda.colocarMaterial(madera);

        assertEquals( jugador, celda.obtenerJugador());

    }

    @Test
    public void test07SeRemueveMaterialCorrectamente(){
        Celda celda = new Celda();
        Madera madera = new Madera();
        celda.colocarMaterial(madera);

        celda.removerMaterial();

        assert(celda.estaVacia());
    }

    @Test
    public void test08SeRemueveJugadorCorrectamente(){

        Celda celda = new Celda();
        Jugador jugador = new Jugador();
        celda.colocarJugador(jugador);

        celda.removerJugador();

        assert(celda.estaVacia());

    }

}
