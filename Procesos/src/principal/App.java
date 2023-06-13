package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gestorprocesos.GestorProcesos;
import procesos.*;

public class App {

    private final static String PATH_NAME = "numEjecuciones.dat";

    private static int menu() {
        System.out.println("1. Introducir un proceso");
        System.out.println("2. Simular el gestor de procesos con la política FCFS (First Come First Serve)");
        System.out.println("3. Simular el gestor de procesos sólo con los procesos de memoria ordenados por prioridad");
        System.out.println("4. Simular el gestor de procesos con el algoritmo SJF (Shortest Job First)");
        System.out.println("0. Salir");
        int menu = EntradaTeclado.pedirEntero("Escribe: ");
        return menu;
    }

    private static Proceso crearProceso() {
        int opcion;
        do {
            opcion = EntradaTeclado.pedirEntero("\n1). Proceso Disco\n2). Proceso Memoria\nEscribe: ");
        } while (opcion > 2 || opcion < 1);
        String nombre = EntradaTeclado.pedirCadena("Dime el nombre del proceso: ");
        int tiempo = EntradaTeclado.pedirEntero("Dime el tiempo (En segundos): ");
        if (opcion == 1) {
            return new ProcesoDisco(nombre, tiempo);
        }
        int prioridad = EntradaTeclado.pedirEntero("Dime la prioridad: ");
        return new ProcesoMemoria(nombre, tiempo, prioridad);

    }

    private static void simulacion(List<? extends Proceso> simulacion) {
        System.out.println();
        for (int i = 0; i < simulacion.size(); i++) {
            System.out.println(simulacion.get(i) + "\n");
            try {
                java.lang.Thread.sleep((long) simulacion.get(i).getTiempo() * 1000);
            } catch (Exception ex) {
            }
        }
    }

    private static void sacarProcesos(GestorProcesos gestor, List<Proceso> simulacion) {
        while (!gestor.estaVacia()) {
            simulacion.add(gestor.sacarProceso());
        }
    }

    private static void mensaje() {
        System.out.println("\nNo hay procesos en el gestor, añade un proceso para poder simularlo\n");
    }

    public static void main(String[] args) throws IOException {
        GestorProcesos gestor = new GestorProcesos();
        int numEjecuciones;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PATH_NAME))) {
            numEjecuciones = in.readInt();
        } catch (Exception e) {
            File file = new File("numEjecuciones.dat");
            file.createNewFile();
            numEjecuciones = 0;
        }
        int menu;
        do {
            menu = menu();
            switch (menu) {
                case 1 -> {
                    if (gestor.insertarProceso(crearProceso())) {
                        System.out.println("\nSe ha insertado ese proceso\n");
                    } else {
                        System.out.println(
                                "\nNo se ha insertado porque puede que este lleno o que has puesto el mismo nombre\n");
                    }
                }
                case 2 -> {
                    if (!gestor.estaVacia()) {
                        List<Proceso> simulacion = new ArrayList<>();
                        sacarProcesos(gestor, simulacion);
                        numEjecuciones += simulacion.size();
                        simulacion(simulacion);
                    } else {
                        mensaje();
                    }
                }
                case 3 -> {
                    if (!gestor.estaVacia()) {
                        List<ProcesoMemoria> simulacion = new ArrayList<>();
                        int numProcesos = gestor.numeroProcesos();
                        for (int i = 0; i < numProcesos; i++) {
                            Proceso p = gestor.sacarProceso();
                            if (p instanceof ProcesoMemoria) {
                                simulacion.add((ProcesoMemoria) p);
                            } else {
                                gestor.insertarProceso(p);
                            }
                        }
                        Collections.sort(simulacion, (o1, o2) -> o2.getPrioridad() - o1.getPrioridad());
                        numEjecuciones += simulacion.size();
                        simulacion(simulacion);
                    } else {
                        mensaje();
                    }

                }
                case 4 -> {
                    if (!gestor.estaVacia()) {
                        List<Proceso> simulacion = new ArrayList<>();
                        sacarProcesos(gestor, simulacion);
                        Collections.sort(simulacion, (o1, o2) -> o1.getTiempo() - o2.getTiempo());
                        numEjecuciones += simulacion.size();
                        simulacion(simulacion);
                    } else {
                        mensaje();
                    }
                }
            }
        } while (menu != 0);
        System.out.println("\nHas ejecutado " + numEjecuciones + " procesos\n");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PATH_NAME))) {
            out.writeInt(numEjecuciones);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
