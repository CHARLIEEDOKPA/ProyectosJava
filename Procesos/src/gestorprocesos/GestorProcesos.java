package gestorprocesos;

import procesos.Proceso;
import tad.ColasSinRepetidos;

public class GestorProcesos {
    
    private ColasSinRepetidos<Proceso> gestor;

    public GestorProcesos() {
        gestor = new ColasSinRepetidos<>();
    }

    public boolean insertarProceso(Proceso p) {
        return gestor.insertar(p);
    }

    public Proceso sacarProceso() {
        return gestor.sacar();
    }

    public boolean estaVacia() {
        return gestor.estaVacia();
    }

    public int numeroProcesos() {
        return gestor.tamanoCola();
    }


    

}
