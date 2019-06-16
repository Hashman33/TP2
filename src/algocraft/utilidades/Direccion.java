package algocraft.utilidades;

public class Direccion {

    public VectorPosicion2I arriba() { return new VectorPosicion2I(0,-1); }

    public VectorPosicion2I abajo() { return new VectorPosicion2I(0,1); }

    public VectorPosicion2I derecha() { return new VectorPosicion2I(1,0); }

    public VectorPosicion2I izquierda() { return new VectorPosicion2I(-1,0); }
}
