package flota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import embarcaciones.Barco;
import embarcaciones.Submarino;

public class Flota {

    private Set<Barco> flota;
    private int numTamanyo;

    public Flota(int numBarcos) {
        flota = new LinkedHashSet<>();
        this.numTamanyo = numBarcos;
    }

    public int getNumTamanyo() {
        return numTamanyo;
    }

    public void setNumTamanyo(int numBarcos) {
        this.numTamanyo = numBarcos;
    }

    public int numeroBarcos() {
        return flota.size();
    }

    public boolean insertarBarco(Barco b) {
        if (numTamanyo != flota.size()) {
            return flota.add(b);
        }
        return false;
    }

    public boolean eliminarBarco(Barco b) {
        return flota.remove(b);
    }

    public int longitudPeriscopioFlota() {
        int total = 0;
        for (Barco barco : flota) {
            if (barco instanceof Submarino) {
                total += ((Submarino) barco).getPeriscopio();
            }
        }
        return total;
    }

    public boolean recibeAtaque() {
        if (numeroBarcos() != 0) {
            Barco b = Collections.min(listadoBarcos(), (o1, o2) -> {
                return ((Barco) o1).getLongitud() - ((Barco) o2).getLongitud();
            });
            flota.remove(b);
            return true;
        }
        return false;
    }
    

    public ArrayList<Barco> listadoBarcos() {
        return new ArrayList<>(flota);
    }

}
