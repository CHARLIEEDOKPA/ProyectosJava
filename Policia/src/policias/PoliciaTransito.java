package policias;

import java.util.Iterator;

public class PoliciaTransito extends Policia{

    public PoliciaTransito(String nombre) {
        super("T-" + (contador++), nombre, SUELDO_BASE);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + codigo + " - Nombre: " + nombre + " - Sueldo: " + sueldo;
    }

    public void actualizarSueldo() {

        double sueldoExtra = 0;
        Iterator<Multa> it = Multa.multasPolicia(this.codigo);
        while (it != null && it.hasNext()) {
            sueldoExtra += it.next().getImporte();
        }
        sueldo = SUELDO_BASE + (sueldoExtra * 0.1);

    }

    
    
}
