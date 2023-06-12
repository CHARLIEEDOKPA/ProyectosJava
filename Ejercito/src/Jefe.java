public class Jefe extends Personaje {

    private static final int VALOR_VIDA = 20;
    private int vidaExtra;

    public Jefe() {
        super("1" + (Personaje.getContador()),VALOR_VIDA);
        this.vidaExtra = Integer.parseInt(this.getCodigo()) / 2;
    }

    public int getVidaExtra() {
        return vidaExtra;
    }

    public void setVidaExtra(int vidaExtra) {
        this.vidaExtra = vidaExtra;
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " " + this.getCodigo() + " - Vida: " + this.getNivelVida() + " - Vida extra: " + vidaExtra;
    }
    
}
