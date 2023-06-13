package procesos;

public class ProcesoMemoria extends Proceso {

    private int prioridad;

    public ProcesoMemoria(String nombre, int tiempo, int prioridad) {
        super(nombre, tiempo);
        this.prioridad = prioridad >= 1 ? prioridad : 0;
        //TODO Auto-generated constructor stub
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + " - Nº Prioridad: " + prioridad;
    }

    
    
}
