public class Guerrero extends Personaje {

    private static final int VALOR_VIDA = 15;

    public Guerrero() {
        super("2" + (Personaje.getContador()), VALOR_VIDA);
    }
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " " + this.getCodigo() + " - Vida: " + this.getNivelVida();
    }
    
}
