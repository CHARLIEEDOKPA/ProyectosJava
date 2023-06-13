package tad;

import java.util.ArrayList;
import java.util.List;

public class ColasSinRepetidos<T>{
    
    private List<T> cola;
    private final int TAMANYO_COLA = 10;

    public ColasSinRepetidos() {
        cola = new ArrayList<>();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }
    
    public boolean estaLlena() {
        return cola.size() == TAMANYO_COLA;
    }

    public int tamanoCola() {
        return cola.size();
    }

    public boolean insertar(T elemento) {
        if (!estaLlena() && !cola.contains(elemento)) {
            cola.add(elemento);
            return true;
        }
        return false;
    }

    public <E> T sacar() {
        if (!estaVacia()) {
            T value = cola.get(0);
            cola.remove(value);
            return value;
        }
        return null;
    }

    

}
