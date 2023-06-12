public class Articulo {
    
    private String codigo;
    private String descripcion;
    private double precio;
    private int stock;
    private static int contador;

    static {
        contador = 1;
    }

    public Articulo(String nombre, double precio, int stock) {
        this.codigo = "A-"+(contador++);
        this.descripcion = nombre;
        this.precio = precio;
        this.stock = stock >= 1 ? stock : 1;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String nombre) {
        this.descripcion = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }


    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Articulo other = (Articulo) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getClass(). getSimpleName() + " " + codigo + " - Nombre: " + descripcion + " - Stock: " + stock ;
    }

    

    

}
