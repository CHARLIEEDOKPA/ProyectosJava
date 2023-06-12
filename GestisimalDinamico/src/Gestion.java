import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Gestion {
    
    private List<Articulo> gestion;
    private int numArticulos;

    public Gestion(int numArticulos) {
        gestion = new ArrayList<>();
        this.numArticulos = numArticulos;
    }

    public Articulo encontrarPorCodigo(String codigo) {
        Articulo a = null;
        for (int i = 0; i < gestion.size() && a == null; i++) {
            if (gestion.get(i).getCodigo().equals(codigo)) {
                a = gestion.get(i);
            }
        }
        return a;
    }

    public boolean anyadirArticulo(Articulo a) {
        if (gestion.size() != numArticulos ) {
            gestion.add(a);
            return true;
        }
        return false;
    }

    public boolean eliminarArticulo(Articulo a) {
        return gestion.remove(a);
    }

    public Iterator<Articulo> devolverIterador() {
        return gestion.iterator();
    }



    

}
