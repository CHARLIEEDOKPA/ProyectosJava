public class App {

    private static int menu() {
        System.out.println("1. Mostrar ejércitos");
        System.out.println("2. Atacar al ejercito 1");
        System.out.println("3. Atacar al ejercito 2");
        System.out.println("0. Salir del programa");
        int menu = EntradaTeclado.pedirEntero("Escribe: ");
        return menu;
    }
    public static void main(String[] args) throws Exception {
        Ejercito ej1 = new Ejercito();
        Ejercito ej2 = new Ejercito();
        int menu;
        do {
            menu = menu();
            switch (menu) {
                case 1 -> {
                    System.out.println("EJERCITO 1\n___________\n" + ej1 + "\nEJERCITO 2\n___________\n" + ej2);
                }
                case 2 -> {
                    if (!ej1.esDerrotado()) {
                        ej1.recibeAtaque();
                    } else {
                        System.out.println("\nEl ejercito 1 ha sido derrotado\n");
                    }
                }
                case 3 -> {
                    if (!ej2.esDerrotado()) {
                        ej2.recibeAtaque();
                    } else {
                        System.out.println("\nEl ejercito 2 ha sido derrotado\n");
                    }
                }
            }
        } while (menu != 0);
    }
}
