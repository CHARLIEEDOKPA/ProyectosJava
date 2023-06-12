package embarcaciones;

/**
 * Acorazado
 */
public class Acorazado extends Barco {

    private static int contador;
    private int canyones;

    static{
        contador = 1;
    }

    public Acorazado(int longitud, int canyones) {
        super("Ac-" + (contador++), longitud);
        this.canyones = canyones >= 0 ? canyones:0;
    }

    public int getCanyones() {
        return canyones;
    }

    public void setCanyones(int canyones) {
        this.canyones = canyones >= 0 ? canyones:0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || this.getCodigo().equals(((Barco)obj).getCodigo());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.getCodigo() + " - Longitud: " + this.getLongitud() + " - Nº de cañones: " + canyones;
    }

    

    
}