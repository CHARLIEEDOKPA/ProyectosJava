import java.util.Arrays;

public class App {

    private static int menu() {
        System.out.println("1. Listado");
        System.out.println("2. Alta");
        System.out.println("3. Baja");
        System.out.println("4. Modificación");
        System.out.println("5. Entrada de mercancía");
        System.out.println("6. Salida de mercancía");
        System.out.println("0. Salir");
        int menu = EntradaTeclado.pedirEntero("Escribe: ");
        return menu;
    }

    private static int encontrarArticulo(Articulo[] almacen, String codigo) {
        int indice = -1;
        for (int i = 0; i < almacen.length && indice == -1; i++) {
            if (almacen[i].getCodigo().equals(codigo)) {
                indice = i;
            }
        }
        return indice;
    }

    public static void main(String[] args) throws Exception {
        Articulo[] almacen = new Articulo[0];
        int menu;
        do {
            menu = menu();
            switch (menu) {
                case 1 -> {
                    System.out.println();
                    for (int i = 0; i < almacen.length; i++) {
                        System.out.println(almacen[i] + "\n");
                    }
                }
                case 2 -> {
                    String nombre = EntradaTeclado.pedirCadena("Dime el nombre de ese articulo: ");
                    double precio;
                    do {
                        precio = EntradaTeclado.pedirDoble("Dime el precio: ");
                    } while (precio < 1);
                    int stock = EntradaTeclado.pedirEntero("Dime el stock: ");
                    almacen = Arrays.copyOf(almacen, almacen.length + 1);
                    almacen[almacen.length - 1] = new Articulo(nombre, precio, stock);
                    System.out.println("\nSe ha dado el alta el articulo\n");
                }
                case 3 -> {
                    String codigo = EntradaTeclado.pedirCadena("Dime el codigo: ");
                    int indice = encontrarArticulo(almacen, codigo);
                    if (indice != -1) {
                        while (indice != almacen.length - 1) {
                            Articulo aux = almacen[indice + 1];
                            almacen[indice + 1] = almacen[indice];
                            almacen[indice] = aux;
                        }
                        almacen = Arrays.copyOf(almacen, almacen.length - 1);
                        System.out.println("\nSe ha eliminado\n");
                    } else {
                        System.out.println("\nNo se ha encontrado el articulo\n");
                    }
                }
                case 4 -> {
                    String codigo = EntradaTeclado.pedirCadena("Dime el codigo: ");
                    int indice = encontrarArticulo(almacen, codigo);
                    if (indice != -1) {
                        int opcion;
                        do {
                            opcion = EntradaTeclado.pedirEntero("1). Descripcion\n2).Precio\nEscribe");
                        } while (opcion > 2 || opcion < 1);
                        if (opcion == 1) {
                            String descripcionNueva;
                            do {
                                descripcionNueva = EntradaTeclado.pedirCadena("Dime la nueva descripción: ");
                            } while (descripcionNueva.length() == 0);
                            almacen[indice].setDescripcion(descripcionNueva);
                        } else {
                            double precioNuevo = EntradaTeclado.pedirDoble("Dime el nuevo precio: ");
                            do {
                                precioNuevo = EntradaTeclado.pedirDoble("Dime el nuevo precio: ");
                            } while (precioNuevo > 1);
                            almacen[indice].setPrecio(precioNuevo);
                        }
                        System.out.println("\nSe ha modificado\n");
                    } else {
                        System.out.println("\nEl codigo que pusiste no existe\n");
                    }
                }
                case 5 -> {
                    String codigo = EntradaTeclado.pedirCadena("Dime el codigo: ");
                    int indice = encontrarArticulo(almacen, codigo);
                    if (indice != -1) {
                        int stockExtra;
                        do {
                            stockExtra = EntradaTeclado.pedirEntero("Dime la cantidad de stocks que va a entrar: ");
                        } while (stockExtra < 1);
                        almacen[indice].setStock(almacen[indice].getStock() + stockExtra);
                        System.out.println("\nSe ha incrementado\n");
                    }
                }
                case 6 -> {
                    String codigo = EntradaTeclado.pedirCadena("Dime el codigo: ");
                    int indice = encontrarArticulo(almacen, codigo);
                    if (indice != -1) {
                        int stockResta;
                        int stock = almacen[indice].getStock();
                        do {
                            stockResta = EntradaTeclado.pedirEntero("Dime la cantidad de stocks que va a salir: ");
                        } while (stockResta <= 0);
                        if (stock - stockResta >= 0) {
                            almacen[indice].setStock(almacen[indice].getStock() - stockResta);
                            System.out.println("\nSe ha salido\n");
                        } else {
                            System.out.println("\nNo hay suficiente stock\n");
                        }

                    }
                }

            }
        } while (menu != 0);
    }
}
