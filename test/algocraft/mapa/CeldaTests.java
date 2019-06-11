package algocraft.mapa;

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
    public void test02CeldaSeIniciaConMaterialYNoEstaVacia(){
        Celda celda  = new Celda(new Madera());
        assert(!celda.estaVacia());
    }

    @Test
    public void test03UnaCeldaSeIniciaConMaterialYLoDevuelveCorrectamente(){
        Madera madera = new Madera();
        Celda celda  = new Celda(madera);
        assertEquals(madera, celda.obtenerMaterial());
    }

    @Test
    public void test04CeldaSeIniciaConJugadorYNoEstaVacia(){
        Celda celda  = new Celda(new Jugador());
        assert(!celda.estaVacia());
    }

    @Test
    public void test05CeldaSeIniciaConJuagadorYLoDevuelveCorrectamente(){
        Jugador jugador = new Jugador();
        Celda celda  = new Celda(jugador);
        assertEquals(jugador, celda.obtenerJugador());
    }

    @Test
    public void test06CeldaSeLeAgregaUnMaterialYnoEstaVacia(){
        Celda celda = new Celda();
        celda.colocarMaterial(new Madera());
        assert(!celda.estaVacia());
    }

    @Test
    public void test07CeldaSeLeAgregaUnMaterialCorrectamenteACelda(){

        Celda celda = new Celda();
        Madera madera = new Madera();
        celda.colocarMaterial(madera);

        assertEquals(madera, celda.obtenerMaterial());
    }

    @Test
    public void test08CeldaSeLeAgregaUnJugadorCorrectamenteACelda(){

        Celda celda = new Celda();
        Jugador jugador = new Jugador();
        celda.colocarJugador(jugador);

        assertEquals(jugador, celda.obtenerJugador());
    }

    @Test
    public void test09CeldaSeIntentaAgregarUnMaterialEnUnaCeldaOcupadaPorMaterialYnoSeModifica(){
        Celda celda = new Celda();
        Madera madera = new Madera();
        celda.colocarMaterial(madera);
        Madera madera2 = new Madera();
        celda.colocarMaterial(madera2);

        assertEquals(madera, celda.obtenerMaterial());
    }

    @Test
    public void test10CeldaSeIntentaAgregarUnMaterialEnUnaCeldaOcupadaPorJugadorYnoSeModifica(){
        Celda celda = new Celda();
        Jugador jugador = new Jugador();
        celda.colocarJugador(jugador);
        Madera madera = new Madera();
        celda.colocarMaterial(madera);

        assertEquals( jugador, celda.obtenerJugador());
    }

    @Test
    public void test11CeldaSeRemueveMaterialCorrectamente(){
        Celda celda = new Celda();
        Madera madera = new Madera();
        celda.colocarMaterial(madera);

        celda.removerMaterial();

        assert(celda.estaVacia());
    }

    @Test
    public void test12CeldaSeRemueveJugadorCorrectamente(){

        Celda celda = new Celda();
        Jugador jugador = new Jugador();
        celda.colocarJugador(jugador);

        celda.removerJugador();

        assert(celda.estaVacia());
    }
}
