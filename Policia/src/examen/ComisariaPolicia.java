package examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import policias.Multa;
import policias.Policia;
import policias.PoliciaTransito;

public class ComisariaPolicia {
    
    private List<Policia> almacenPolicias;

    public ComisariaPolicia() {
        almacenPolicias = new ArrayList<>();
    }

    public boolean insertarPolicia(Policia p) {
        if (!almacenPolicias.contains(p)) {
            almacenPolicias.add(p);
            return true;
        }
        return false;
    }

    public boolean eliminarPolicia(Policia p) {
        return almacenPolicias.remove(p);
    }

    public boolean insertarMultaPolicia(String codigo, Multa m) {
        return Multa.introducirMulta(codigo, m);
    }

    public Policia encontrarPorCodigo(String codigo) {
        Policia p = null;
        for (int i = 0; i < almacenPolicias.size() && p == null; i++) {
            if (almacenPolicias.get(i).getCodigo().equals(codigo)) {
                p = almacenPolicias.get(i);
            }
        }
        return p;
    }

    public String toStringPoliciasYMultasOrdenadoPorCodigo() {
        String cadena = "";
        for (int i = 0; i < almacenPolicias.size(); i++) {
            Policia p = almacenPolicias.get(i);
            cadena += p.toString();
            if (p instanceof PoliciaTransito) {
                Iterator<Multa> it = Multa.multasPolicia(p.getCodigo());
                cadena += " - Multas: ";
                while (it != null && it.hasNext()) {
                    cadena += it.next().toString() + " |";
                }
            }
            cadena += "\n";
        }
        return cadena;
    }

    public String toStringPoliciasOrdenadosPorNombre() {
        List<Policia> copia = new ArrayList<>(almacenPolicias);
        Collections.sort(copia, ((o1, o2) -> {
            return o1.getNombre().compareTo(o2.getNombre());
        }));
        String cadena = "";
        for (int i = 0; i < copia.size(); i++) {
            cadena += copia.get(i).toString() + "\n";
        }
        return cadena;
    }


}
