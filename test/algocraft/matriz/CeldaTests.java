package algocraft.matriz;

import algocraft.jugador.Jugador;
import algocraft.material.Madera;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CeldaTests {

    @Test
    public void test01CeldaSeIniciaVacia(){
        Celda celda  = new Celda();
        assert(celda.estaVacia());
    }


    @Test
    public void test02CeldaSeLeAgregaUnMaterialYnoEstaVacia(){
        Celda celda = new Celda();
        celda.colocarMaterial(new Madera());
        assert(!celda.estaVacia());
    }

    @Test
    public void test03CeldaSeLeAgregaUnMaterialCorrectamenteACelda(){

        Celda celda = new Celda();
        Madera madera = new Madera();
        celda.colocarMaterial(madera);

        assertEquals(madera, celda.obtenerMaterial());
    }

    @Test
    public void test04CeldaSeLeAgregaUnJugadorCorrectamenteACelda(){

        Celda celda = new Celda();
        Jugador jugador = new Jugador();
        celda.colocarJugador(jugador);

        assertEquals(jugador, celda.obtenerJugador());
    }

    @Test
    public void test05CeldaSeIntentaAgregarUnMaterialEnUnaCeldaOcupadaPorMaterialYnoSeModifica(){
        Celda celda = new Celda();
        Madera madera = new Madera();
        celda.colocarMaterial(madera);
        Madera madera2 = new Madera();
        celda.colocarMaterial(madera2);

        assertEquals(madera, celda.obtenerMaterial());
    }

    @Test
    public void test06CeldaSeIntentaAgregarUnMaterialEnUnaCeldaOcupadaPorJugadorYnoSeModifica(){
        Celda celda = new Celda();
        Jugador jugador = new Jugador();
        celda.colocarJugador(jugador);
        Madera madera = new Madera();
        celda.colocarMaterial(madera);

        assertEquals( jugador, celda.obtenerJugador());
    }

    @Test
    public void test07CeldaSeRemueveMaterialCorrectamente(){
        Celda celda = new Celda();
        Madera madera = new Madera();
        celda.colocarMaterial(madera);

        celda.removerMaterial();

        assert(celda.estaVacia());
    }

    @Test
    public void test08CeldaSeRemueveJugadorCorrectamente(){

        Celda celda = new Celda();
        Jugador jugador = new Jugador();
        celda.colocarJugador(jugador);

        celda.removerJugador();

        assert(celda.estaVacia());
    }
}
