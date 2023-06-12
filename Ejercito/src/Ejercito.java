import java.util.ArrayList;
import java.util.List;

public class Ejercito {

    private List<Personaje> ejercito;
    private static final int MINIMO = 3;
    private static final int MAXIMO = 6;
    private static final int ATAQUE_MINIMO = 0;
    private static final int ATAQUE_MAXIMO = 10;

    public Ejercito() {
        ejercito = new ArrayList<>();
        int tamanyo = (int) (Math.random() * (MAXIMO - MINIMO) + MINIMO) + 1;
        for (int i = 0; i < tamanyo - 1; i++) {
            ejercito.add(new Guerrero());
        }
        ejercito.add(new Jefe());
    }

    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < ejercito.size(); i++) {
            cadena += ejercito.get(i).toString() + "\n";
        }
        return cadena;
    }

    public boolean guerreroVivo() {
        boolean vivo = false;
        for (int i = 0; i < ejercito.size() - 1 && !vivo; i++) {
            if (ejercito.get(i).getNivelVida() > 0) {
                vivo = true;
            }
        }
        return vivo;
    }

    public boolean esDerrotado() {
        return ejercito.get(ejercito.size() - 1).getNivelVida() <= 0
                && ((Jefe) ejercito.get(ejercito.size() - 1)).getVidaExtra() <= 0;
    }

    public void recibeAtaque() {
        int danyo = (int) (Math.random() * (ATAQUE_MAXIMO - ATAQUE_MINIMO) + ATAQUE_MINIMO) + 1 ;
        if (guerreroVivo()) {
            final int POSICION = (int) (Math.random() * (ejercito.size() - 1));
            int vida = ejercito.get(POSICION).getNivelVida();
            ejercito.get(POSICION).setNivelVida(vida - danyo);
        } else {
            final int POSICION = ejercito.size() - 1;
            int vidaJefe = ejercito.get(POSICION).getNivelVida();
            int vidaExtraJefe = ((Jefe) ejercito.get(POSICION)).getVidaExtra();
            if (vidaJefe > 0) {
                ejercito.get(POSICION).setNivelVida(vidaJefe - danyo);
            } else {
                ((Jefe) ejercito.get(POSICION)).setVidaExtra(vidaExtraJefe - danyo);
            }
        }

    }

}
