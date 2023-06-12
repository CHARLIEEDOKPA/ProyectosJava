import java.util.Arrays;

public class App {

    private static boolean esPrimo(int num) {
        boolean esPrimo = true;
        for (int i = 2; i < num && esPrimo; i++) {
            if (num % i == 0) {
                esPrimo = false;
            }
        }
        return esPrimo;
    }

    private static void ordenar(int [] t) {
        for (int i = 0; i < t.length; i++) {
            int indice = i;
            while (indice != 0 && esPrimo(t[indice])) {
                int aux = t[indice - 1];
                t[indice - 1] = t[indice];
                t[indice] = aux;
                indice--;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        int[] numeros = {1,6,4,9,4,11,44,59,12,7,3,93};
        ordenar(numeros);
        System.out.println(Arrays.toString(numeros));
    }
}
