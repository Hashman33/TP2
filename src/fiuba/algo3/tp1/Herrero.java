package fiuba.algo3.tp1;

public class Herrero {

    public Herramienta construirHacha() {
        return new Hacha();
    }

    public Herramienta construirPico() {
        return new Pico();
    }

    public Herramienta construirAzada() {
        return new Azada();
    }

    public void usar(Herramienta herramienta) {
        herramienta.usar();
    }

    public void reparar(Herramienta herramienta) {
        herramienta.reparar();
    }

    public Herramienta templar(Herramienta herramienta) {
        return herramienta.templar();
    }
}
