package policias;

public abstract class Policia {
    
    protected static final int SUELDO_BASE = 1750;
    protected static int contador;
    protected String codigo;
    protected String nombre;
    protected double sueldo;

    static {
        contador = 1;
    }


    public Policia(String codigo, String nombre, double sueldo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }


    public static int getSueldoBase() {
        return SUELDO_BASE;
    }


    public static int getContador() {
        return contador;
    }


    public static void setContador(int contador) {
        Policia.contador = contador;
    }


    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public double getSueldo() {
        return sueldo;
    }


    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Policia other = (Policia) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + codigo + " - Nombre: " + nombre + " - Sueldo: " + sueldo;
    }

     



}
