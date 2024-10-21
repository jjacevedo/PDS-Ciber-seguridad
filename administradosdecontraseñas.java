import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private HashMap<String, String> almacenamientoContraseñas;
    private Scanner scanner;

    public Main() {
        almacenamientoContraseñas = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = -1;

        while (opcion != 5) {
            System.out.println("Eliga la opcion que desea realizar:");
            System.out.println("1. Nueva contraseña");
            System.out.println("2. Buscar contraseña");
            System.out.println("3. Editar contraseña");
            System.out.println("4. Eliminar contraseña");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarContraseña();
                    break;
                case 2:
                    buscarContraseña();
                    break;
                case 3:
                    editarContraseña();
                    break;
                case 4:
                    eliminarContraseña();
                    break;
                case 5:
                    System.out.println("Saliendo del administrador...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }

    private void agregarContraseña() {
        System.out.print("Ingrese el nombre del servicio: ");
        String servicio = scanner.nextLine();
        System.out.print("Ingrese la contraseña para el servicio: ");
        String contraseña = scanner.nextLine();
        almacenamientoContraseñas.put(servicio, contraseña);
        System.out.println("Contraseña añadida exitosamente.");
    }

    private void buscarContraseña() {
        System.out.print("Ingrese el nombre del servicio a buscar: ");
        String servicio = scanner.nextLine();
        if (almacenamientoContraseñas.containsKey(servicio)) {
            System.out.println("Contraseña para " + servicio + ": " + almacenamientoContraseñas.get(servicio));
        } else {
            System.out.println("Servicio no encontrado.");
        }
    }

    private void editarContraseña() {
        System.out.print("Ingrese el nombre del servicio a editar: ");
        String servicio = scanner.nextLine();
        if (almacenamientoContraseñas.containsKey(servicio)) {
            System.out.print("Ingrese la nueva contraseña para el servicio: ");
            String nuevaContraseña = scanner.nextLine();
            almacenamientoContraseñas.put(servicio, nuevaContraseña);
            System.out.println("Contraseña actualizada exitosamente.");
        } else {
            System.out.println("Servicio no encontrado.");
        }
    }

    private void eliminarContraseña() {
        System.out.print("Ingrese el nombre del servicio a eliminar: ");
        String servicio = scanner.nextLine();
        if (almacenamientoContraseñas.containsKey(servicio)) {
            almacenamientoContraseñas.remove(servicio);
            System.out.println("Contraseña eliminada exitosamente.");
        } else {
            System.out.println("Servicio no encontrado.");
        }
    }

    public static void main(String[] args) {
        Main administrador = new Main();
        administrador.mostrarMenu();
    }
}
