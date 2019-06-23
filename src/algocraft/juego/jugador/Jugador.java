package algocraft.juego.jugador;

import algocraft.juego.jugador.herramienta.*;
import algocraft.juego.mapa.*;
import algocraft.juego.material.*;
import algocraft.utilidades.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class Jugador {

    private Direccion direccion;
    private VectorPosicion2I mirada;
    private VectorPosicion2I posicion;
    protected Inventario inventario;
    protected MesaDeTrabajo mesaDeTrabajo;
    protected String texturaUrl = "";
    protected final int ANCHO = 32;
    protected final int ALTO = 32;



    public Jugador() {
        inicializar(new VectorPosicion2I());
    }

    public Jugador(VectorPosicion2I posicionInicial) {
        inicializar(posicionInicial);
    }

    public ImageView getTextura() {
        ImageView imageView = new ImageView(new Image(this.texturaUrl, ANCHO, ALTO, false,true));

        if (mirada.esIgualA(direccion.izquierda())) imageView.setRotate(90);
        if (mirada.esIgualA(direccion.arriba())) imageView.setRotate(180);
        if (mirada.esIgualA(direccion.derecha())) imageView.setRotate(270);
        if (mirada.esIgualA(direccion.abajo())) imageView.setRotate(360);

        return imageView;
    }

    private void inicializar(VectorPosicion2I posicionInicial) {

        Hacha hachaMadera = new Hacha(new HerramientaMadera());
        this.texturaUrl = "/recursos/texturas/Jugador.png";
        this.mesaDeTrabajo = new MesaDeTrabajo();
        this.direccion = new Direccion();
        this.inventario = new Inventario();
        this.inventario.agregar(hachaMadera);
        this.inventario.equipar(hachaMadera);

        this.posicion = posicionInicial;
        this.mirada = direccion.arriba();
    }

    public void setCoordenadas(VectorPosicion2I posicion) {
        this.posicion = posicion;
    }


    public void mover(Mapa mapa, VectorPosicion2I vectorDesplazamiento) {

        this.mirada = vectorDesplazamiento;
        if (mapa.moverJugador(this, vectorDesplazamiento)) {
            this.posicion = this.posicion.sumar(vectorDesplazamiento);
        }
    }

    public void usarHerramienta(Mapa mapa) {

        Herramienta herramienta = this.inventario.herramientaEquipada;
        VectorPosicion2I posicionMaterial = this.posicion.sumar(mirada);
        Material material = mapa.obtenerMaterial(posicionMaterial);

        if (material != null) {
            try {
                herramienta.desgastar(material);

            } catch (MaterialDestruidoException e) {
                this.agregarEnInventario(material);
                mapa.removerMaterial(posicionMaterial);

            } catch (HerramientaEstaRotaException e) {
                this.equipar(new Mano());
                this.quitarDeInventario(herramienta);
            }
        }
    }

    public void agregarAMesaDeTrabajo(Material material, VectorPosicion2I posicion) {

        if (mesaDeTrabajo.agregarMaterial(material, posicion)) this.quitarDeInventario(material);
        if (mesaDeTrabajo.obtenerCrafteoActual() != null) {
            this.agregarEnInventario(mesaDeTrabajo.obtenerCrafteoActual());
        }
    }

    public void limpiarMesaDeTrabajo() {
        List<Material> materiales = this.mesaDeTrabajo.limpiar();
        for (Material material: materiales) this.agregarEnInventario(material);
    }

    public void equipar(Herramienta herramienta) { this.inventario.equipar(herramienta); }

    public void agregarEnInventario(Material material) { this.inventario.agregar(material); }

    public void agregarEnInventario(Herramienta herramienta) { this.inventario.agregar(herramienta); }

    public void quitarDeInventario(Material material) { this.inventario.quitar(material); }

    public void quitarDeInventario(Herramienta herramienta) { this.inventario.quitar(herramienta); }

    public Herramienta herramientaEquipada() { return this.inventario.herramientaEquipada; }

    public VectorPosicion2I getPosicion() { return this.posicion; }

    public VectorPosicion2I getMirada() { return this.mirada; }

    public List<Material> getInventarioMateriales() { return this.inventario.materiales; }

    public List<Herramienta> getInventarioHerramientas() { return this.inventario.herramientas; }

}
