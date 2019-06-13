package algocraft.utilidades;

public class VectorPosicion2I {

    public int x;
    public int y;

    public VectorPosicion2I(int x, int y) {
        setCoordenadas(x, y);
    }

    public VectorPosicion2I() {
        setCoordenadas(0, 0);
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

    public void setCoordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void imprimir() {
        System.out.println("(" + this.getX() + " " + this.getY() + ")\n");
    }

    public boolean esIgualA(VectorPosicion2I vector) {
        return vector.x == this.x && vector.y == this.y;
    }
}
