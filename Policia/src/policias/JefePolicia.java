package policias;

public class JefePolicia extends Policia {

    private static final int SUELDO_INCREMENTADO = 1000;

    public JefePolicia(String nombre) {
        super("J-" + (contador++), nombre, SUELDO_BASE + SUELDO_INCREMENTADO);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + codigo + " - Nombre: " + nombre + " - Sueldo: " + sueldo;
    }
    
    

}
