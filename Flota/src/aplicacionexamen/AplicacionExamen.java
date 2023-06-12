package aplicacionexamen;

import java.util.Collections;
import java.util.List;
import embarcaciones.Acorazado;
import embarcaciones.Barco;
import embarcaciones.Submarino;
import flota.Flota;

public class AplicacionExamen {

    private static int menu() {
        System.out.println("1. Insertar barco: ");
        System.out.println("2. Eliminar barco: ");
        System.out.println("3. Mostrar número de barcos");
        System.out.println("4. Mostrar barcos por orden de inserción en la flota");
        System.out.println("5. Mostrar barco por longitud de menor a mayor.");
        System.out.println("6. Mostrar los metros de longitud de todos los periscopios de la flota. ");
        System.out.println("7. Recibe la flota un ataque");
        System.out.println("0. Salir del programa.");
        int menu = EntradaTeclado.pedirEntero("Escribe: ");
        return menu;
    }

    private static Barco crearBarco() {
        int opcion;
        do {
            opcion = EntradaTeclado.pedirEntero("1). Acorazado\n2). Submarino\nEscribe: ");
        } while (opcion > 2 || opcion < 1);
        int longitud = EntradaTeclado.pedirEntero("Dime la longitud: ");
        switch (opcion) {
            case 1 -> {
                int canyones = EntradaTeclado.pedirEntero("Dime el numero de cañones: ");
                return new Acorazado(longitud, canyones);
            }
            default -> {
                return new Submarino(longitud);
            }
        }

    }

    public static void main(String[] args) {
        final int TAMANYO = EntradaTeclado.pedirEntero("Dime la longitud de la flota: ");
        Flota flota = new Flota(TAMANYO);
        int menu;
        do {
            menu = menu();
            switch (menu) {
                case 1 -> {
                    if (flota.insertarBarco(crearBarco())) {
                        System.out.println("\nSe ha insertado\n");
                    } else {
                        System.out.println("\nNo se ha insertado\n");
                    }
                }
                case 2 -> {
                    int longitud = EntradaTeclado.pedirEntero("Dime la longitud de ese barco para eliminar: ");
                    if (flota.eliminarBarco(new Submarino(longitud))) {
                        System.out.println("\nSe ha eliminado\n");
                    } else {
                        System.out.println("\nNo se ha eliminado\n");
                    }
                }
                case 3 -> {
                    int numBarcos = flota.numeroBarcos();
                    if (numBarcos != 0) {
                        System.out.println("\nEn total hay " + numBarcos + " barcos\n");
                    } else {
                        System.out.println("\nNo hay barcos\n");
                    }
                }
                case 4 -> {
                    List<Barco> listaBarcos = flota.listadoBarcos();
                    System.out.println();
                    for (int i = 0; i < listaBarcos.size(); i++) {
                        System.out.println(listaBarcos.get(i) + "\n");
                    }
                }
                case 5 -> {
                    List<Barco> listaBarcos = flota.listadoBarcos();
                    Collections.sort(listaBarcos, (o1, o2) -> {
                        return ((Barco) o1).getLongitud() - ((Barco) o2).getLongitud();
                    });
                    System.out.println();
                    for (int i = 0; i < listaBarcos.size(); i++) {
                        System.out.println(listaBarcos.get(i) + "\n");
                    }
                }
                case 6 -> {
                    int totalPeriscopio = flota.longitudPeriscopioFlota();
                    if (totalPeriscopio != 0) {
                        System.out.println("\nEl total de periscopio es " + totalPeriscopio + "\n");
                    } else {
                        System.out.println("\nDe momento es " + totalPeriscopio + "\n");
                    }
                }
                case 7 -> {
                    if (flota.recibeAtaque()) {
                        System.out.println("\nHas derribado un barco\n");
                    } else {
                        System.out.println("\nNo hay barcos\n");
                    }
                }
            }
        } while (menu != 0);
    }

}
