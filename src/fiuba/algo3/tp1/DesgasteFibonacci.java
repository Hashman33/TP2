package fiuba.algo3.tp1;

public class DesgasteFibonacci extends Desgaste {

    private final int durabilidadTotal;
    private int usos;

    public DesgasteFibonacci(int durabilidad) {
        this.usos = 0;
        this.durabilidadTotal = durabilidad;
        this.durabilidad = durabilidad;
    }

    @Override
    public void usar() {
        this.durabilidad = durabilidadTotal - fibonacci(usos);
        this.usos++;
    }

    private int fibonacci(int n) {
        if(n <= 1) {
            return n;
        }
        int fib = 1;
        int prevFib = 1;

        for(int i = 2; i < n; i++) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }
}
