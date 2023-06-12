package embarcaciones;

public class Submarino extends Barco {

    private static int contador;

    static {
        contador = 1;
    }

    public Submarino(int longitud) {
        super("Sub-" + (contador++), longitud);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || this.getCodigo().equals(((Barco) obj).getCodigo());
    }

    public int getPeriscopio() {
        return getLongitud() / 10;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.getCodigo() + " - Longitud: " + this.getLongitud() + " - Periscopio: " + getPeriscopio();
    }

    

}
