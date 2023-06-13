package procesos;

/**
 * Proceso
 */
public abstract class Proceso {

    private String codigo;
    private String nombre;
    private int tiempo;
    private static int contador;

    static {
        contador = 1;
    }

    public Proceso(String nombre, int tiempo) {
        this.codigo = "P-" + (contador++);
        this.nombre = nombre;
        this.tiempo = tiempo >= 1 ? tiempo : 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Proceso other = (Proceso) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + codigo + " - Nombre: " + nombre + " - Tiempo: " + tiempo + " segundos";
    }

    

    

    
}