package algocraft.jugador;

import algocraft.herramienta.*;
import algocraft.mapa.*;
import algocraft.material.*;
import algocraft.utilidades.VectorPosicion2I;

public class Jugador {

    private VectorPosicion2I mirada;
    private VectorPosicion2I posicion;
    protected Inventario inventario;

    public Jugador() {
        inicializar(new VectorPosicion2I());
    }

    public Jugador(VectorPosicion2I posicionInicial) {
        inicializar(posicionInicial);
    }

    private void inicializar(VectorPosicion2I posicionInicial) {

        Hacha hachaMadera = new Hacha(new HerramientaMadera());

        this.inventario = new Inventario();
        this.inventario.agregar(hachaMadera);
        this.inventario.equipar(hachaMadera);

        this.posicion = posicionInicial;
        this.mirada = new VectorPosicion2I(0,-1);
    }

    public Herramienta herramientaEquipada() {
        return this.inventario.herramientaEquipada;
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
                this.inventario.agregar(material);

            } catch (HerramientaEstaRotaException e) {
                this.inventario.equipar(new Mano());
            }
        }
    }

    public VectorPosicion2I getPosicion() { return this.posicion; }

    public VectorPosicion2I getMirada() { return this.mirada; }

}
