public class App {

    private static boolean esNarcisista(int numero) {
        int exponente = getExponente(numero);
        int suma = 0;
        int num = numero;
        do {
            int cifra = num % 10;
            suma += getPotencia(cifra, exponente);
            num = num / 10;
        } while (num != 0);
        return suma == numero;
    }

    private static int getPotencia(int base, int exponente)  {
        int num = 1;
        for (int i = 0; i < exponente; i++) {
            num *= base;
        }
        return num;
    }

    private static int getExponente(int num) {
        int contador = 0;
        int numero  = num;
        while(numero != 0) {
            numero = numero / 10;
            contador++;
        }
        return contador;
    }
    public static void main(String[] args) throws Exception {
        int contador = 0;
        int contadorNarcisista = 0;
        do {
            if (esNarcisista(contador)) {
                System.out.println(contador);
                contadorNarcisista++;
            }
            contador++;
        } while (contadorNarcisista < 30);
    }
}
