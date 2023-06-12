/**
 * Personaje
 */
public abstract class Personaje {

    private String codigo;
    private int nivelVida;
    private static int contador;

    static {
        contador = 1;
    }

    public Personaje(String codigo, int nivelVida) {
        this.codigo = codigo;
        this.nivelVida = nivelVida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }

    public static int getContador() {
        return contador++;
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " " + this.codigo + " - Vida: " + this.nivelVida;
    }

    
}