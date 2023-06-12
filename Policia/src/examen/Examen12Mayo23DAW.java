package examen;

import policias.*;

public class Examen12Mayo23DAW {
    
    private static int menu() {
        System.out.println("1. Introducir policía en la comisaria.");
        System.out.println("2. Eliminar policía de la comisaria.");
        System.out.println("3. Introducir una multa de un policía de la comisaria.");
        System.out.println("4. Indicar el total de multas.");
        System.out.println("5. Mostar información (sin multas) de los policias de la comisaria ordenados por nombre.");
        System.out.println("6. Mostrar información (con multas) de todos los policias de la comisaria ordenados por código.");
        System.out.println("7. Actualizar el sueldo de un policía de tránsito.");
        System.out.println("0. Salir.");
        int menu = EntradaTeclado.pedirEntero("Escribe: ");
        return menu;
    }

    private static Policia crearPolicia(){
        int opcion;
        do {
            opcion = EntradaTeclado.pedirEntero("1). Policia Jefe\n2). Policia Transito\nEscribe: ");
        } while (opcion > 2 || opcion < 1);
        String nombre = EntradaTeclado.pedirCadena("Dime el nombre: ");
        switch (opcion) {
            case 1 -> {
                return new JefePolicia(nombre);
            }
            default -> {
                return new PoliciaTransito(nombre);
            }
        }
    }

    public static void main(String[] args) {
        
        ComisariaPolicia comisaria = new ComisariaPolicia();
        int menu;
        do {
            menu = menu();
            switch (menu) {
                case 1 -> {
                    if (comisaria.insertarPolicia(crearPolicia())) {
                        System.out.println("\nSe ha insertado\n");
                    } else {
                        System.out.println("\nNo se ha insertado\n");
                    }
                }
                case 2 -> {
                    String codigo = EntradaTeclado.pedirCadena("Dime el codigo: ");
                    Policia p = comisaria.encontrarPorCodigo(codigo);
                    boolean eliminado = comisaria.eliminarPolicia(p);
                    if (eliminado) {
                        System.out.println("\nSe ha eliminado\n");
                    } else {
                        System.out.println("\nNo se ha eliminado\n");
                    }
                    if (eliminado && p instanceof PoliciaTransito) {
                        Multa.eliminarTodasMultas(codigo);
                    }
                }
                case 3 -> {
                    String codigo = EntradaTeclado.pedirCadena("Dime el codigo: ");
                    double importe = EntradaTeclado.pedirDoble("Dime el importe: ");
                    if (comisaria.insertarMultaPolicia(codigo, new Multa(importe))) {
                        System.out.println("\nSe ha insertado la multa\n");
                    } else {
                        System.out.println("\nNo se insertado la multa\n");
                    }
                } 
                case 4 -> {
                    int numMultas = Multa.numeroMultasTotal();
                    if (numMultas != 0) {
                        System.out.println("\nEn total hay " + numMultas + " multas\n");
                    } else {
                        System.out.println("\nDe momento no hay multas\n");
                    }
                }
                case 5 ->  {
                    System.out.println("\n" + comisaria.toStringPoliciasOrdenadosPorNombre());
                }
                case 6 -> {
                    System.out.println("\n" + comisaria.toStringPoliciasYMultasOrdenadoPorCodigo());
                }
                case 7 -> {
                    String codigo = EntradaTeclado.pedirCadena("Dime el codigo: ");
                    Policia p = comisaria.encontrarPorCodigo(codigo);
                    if (p != null && p instanceof PoliciaTransito) {
                        double oldSueldo = p.getSueldo();
                        ((PoliciaTransito)p).actualizarSueldo();
                        double newSueldo = p.getSueldo();
                        if (oldSueldo != newSueldo) {
                            System.out.println("\nViejo sueldo: " + oldSueldo + "\nNuevo sueldo: " + newSueldo + "\n");
                        } else {
                            System.out.println("\nNo hay cambios\n");
                        }
                    } else {
                        System.out.println("\nEl codigo que escribiste puede que no exista ese policia o que ese policia no es de transtio\n");
                    }
                }
            }
        } while (menu != 0);

    }

}
