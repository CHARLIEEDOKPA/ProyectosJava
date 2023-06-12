package policias;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Multa {
    
    private static int contador;
    private String codigo;
    private double importe;
    private static Map<String,Set<Multa>> almacenMultas;

    static {
        contador = 100;
        almacenMultas = new HashMap<>();
    }

    public Multa(double importe) {
        this.codigo = "M-" + (contador++);
        this.importe = importe;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double sueldo) {
        this.importe = sueldo;
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
        if (getClass() != obj.getClass())
            return false;
        Multa other = (Multa) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + codigo + " - Importe: " + importe;
    }

    public static boolean introducirMulta(String codigo, Multa m) {
        if (!almacenMultas.containsKey(codigo)) {
            almacenMultas.put(codigo, new HashSet<>());
        }
        return almacenMultas.get(codigo).add(m);
    }

    public static boolean eliminarTodasMultas(String codigo) {
        return almacenMultas.remove(codigo) != null;
    }

    public static int numeroMultasTotal() {
        Iterator<Set<Multa>> it = almacenMultas.values().iterator();
        int numMultas = 0;
        while(it.hasNext()) {
            numMultas += it.next().size();
        }
        return numMultas;
    }

    public static Set<String> policiasConMultas() {
        return almacenMultas.keySet();
    }

    public static Iterator<Multa> multasPolicia(String codigo) {
        if(almacenMultas.containsKey(codigo)){
            return almacenMultas.get(codigo).iterator();
        }
        return null;
    } 
    

    

}
