import java.util.Iterator;

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

    private static Articulo crearArticulo() {
        String nombre;
        do {
            nombre = EntradaTeclado.pedirCadena("Dime el nombre de ese articulo: ");
        } while (nombre.length() == 0);
        double precio;
        do {
            precio = EntradaTeclado.pedirDoble("Dime el precio: ");
        } while (precio < 1);
        int stock = EntradaTeclado.pedirEntero("Dime el stock: ");
        return new Articulo(nombre, precio, stock);
    }

    public static void main(String[] args) throws Exception {
        final int TAMANYO = EntradaTeclado.pedirEntero("Dime el numero maximo del articulos: ");
        Gestion gestion = new Gestion(TAMANYO);
        int menu;
        do {
            menu = menu();
            switch (menu) {
                case 1 -> {
                    Iterator<Articulo> it = gestion.devolverIterador();
                    System.out.println();
                    while (it.hasNext()) {
                        System.out.println(it.next() + "\n");
                    }
                }
                case 2 -> {
                    if (gestion.anyadirArticulo(crearArticulo())) {
                        System.out.println("\nSe ha añadido\n");
                    } else {
                        System.out.println("\nNo se ha añadido\n");
                    }
                }
                case 3 -> {
                    String codigo = EntradaTeclado.pedirCadena("Dime el codigo: ");
                    Articulo a = gestion.encontrarPorCodigo(codigo);
                    if (gestion.eliminarArticulo(a)) {
                        System.out.println("\nSe ha eliminado\n");
                    } else {
                        System.out.println("\nNo se ha eliminado\n");
                    }
                }
                case 4 -> {
                    String codigo = EntradaTeclado.pedirCadena("Dime el codigo: ");
                    Articulo a = gestion.encontrarPorCodigo(codigo);
                    if (a != null) {
                        int opcion;
                        do {
                            opcion = EntradaTeclado.pedirEntero("1). Descripcion\n2). Precio\n3). Los dos\nEscribe: ");
                        } while (opcion > 3 || opcion < 1);
                        switch (opcion) {
                            case 1 -> {
                                String nuevaDescripcion;
                                do {
                                    nuevaDescripcion = EntradaTeclado.pedirCadena("Dime la nueva descripcion: ");
                                } while (nuevaDescripcion.length() == 0);
                                a.setDescripcion(nuevaDescripcion);
                            }
                            case 2 -> {
                                double nuevoPrecio;
                                do {
                                    nuevoPrecio = EntradaTeclado.pedirDoble("Dime el nuevo precio: ");
                                } while (nuevoPrecio < 1);
                                a.setPrecio(nuevoPrecio);
                            }
                            default -> {
                                String nuevaDescripcion;
                                double nuevoPrecio;
                                do {
                                    nuevaDescripcion = EntradaTeclado.pedirCadena("Dime la nueva descripcion: ");
                                } while (nuevaDescripcion.length() == 0);
                                do {
                                    nuevoPrecio = EntradaTeclado.pedirDoble("Dime el nuevo precio: ");
                                } while (nuevoPrecio > 1);
                                a.setDescripcion(nuevaDescripcion);
                                a.setPrecio(nuevoPrecio);
                            }
                        }
                        System.out.println("\nSe ha modificado\n");
                    } else {
                        System.out.println("\nEl codigo que pusiste no existe\n");
                    }
                }
                case 5 -> {
                    String codigo = EntradaTeclado.pedirCadena("Dime el codigo: ");
                    Articulo a = gestion.encontrarPorCodigo(codigo);
                    if (a != null) {
                        int stockExtra = EntradaTeclado.pedirEntero("Dime la cantidad que van a llegar: ");
                        a.setStock(a.getStock() + stockExtra);
                        System.out.println("\nEl stock del articulo " + a.getCodigo() + " se ha incrementado\n");
                    } else {
                        System.out.println("\nEl codigo que pusiste no existe\n");
                    }
                }
                case 6 -> {
                    String codigo = EntradaTeclado.pedirCadena("Dime el codigo: ");
                    Articulo a = gestion.encontrarPorCodigo(codigo);
                    if (a != null) {
                        int stockResta = EntradaTeclado.pedirEntero("Dime la cantidad que quieres restar: ");
                        int stock = a.getStock();
                        if (stock - stockResta >= 0) {
                            a.setStock(a.getStock() - stockResta);
                            System.out.println("\nEl stock articulo " + a.getCodigo() + " se ha decrementado\n");
                        }

                    } else {
                        System.out.println("\nEl codigo que pusiste no existe\n");
                    }
                }
            }
        } while (menu != 0);
    }
}
