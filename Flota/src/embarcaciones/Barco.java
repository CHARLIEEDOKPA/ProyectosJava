package embarcaciones;

/**
 * Barco
 */
public abstract class Barco {

    private String codigo;
    private int longitud;

    
    public Barco(String codigo, int longitud) {
        this.codigo = codigo;
        this.longitud = longitud >= 1 ? longitud : 1;
    }


    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public int getLongitud() {
        return longitud;
    }


    public void setLongitud(int longitud) {
        this.longitud = longitud >= 1 ? longitud : 1;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + codigo + " - Longitud: " + longitud;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + longitud;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Barco other = (Barco) obj;
        if (longitud != other.longitud)
            return false;
        return true;
    }

    

    
    
}