package algocraft.mapa;

// Utilizamos patron Singleton
public class Mapa {

    private static final Mapa instancia = new Mapa();

    // Medidas en casilleros
    private static final int LARGO = 10;
    private static final int ANCHO = 10;

    public static Mapa obtenerInstancia() {
        return instancia;
    }

    private Mapa() {

    }

}
