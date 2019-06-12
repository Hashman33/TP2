package algocraft.utilidades;

public class VectorPosicion2I {

    public int x;
    public int y;

    public VectorPosicion2I(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public VectorPosicion2I() {
        this.x = 0;
        this.y = 0;
    }

    public VectorPosicion2I sumar(VectorPosicion2I vector) {
        VectorPosicion2I vectorSuma = new VectorPosicion2I(this.x + vector.x, this.y + vector.y);
        return vectorSuma;
    }

    public VectorPosicion2I escalar(int alfa) {
        VectorPosicion2I vectorEscalado = new VectorPosicion2I(this.x * alfa, this.y *alfa);
        return vectorEscalado;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
