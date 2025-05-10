package controlador;

import modelo.Proveedor;
import java.util.Scanner;

public class MenuProveedores {
    static Scanner sc = new Scanner(System.in);

    public static void mostrar() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE PROVEEDORES ---");
            System.out.println("1. Crear proveedor");
            System.out.println("2. Listar proveedores");
            System.out.println("3. Modificar proveedor");
            System.out.println("4. Eliminar proveedor");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("CIF: ");
                    String cif = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    Proveedor nuevo = new Proveedor(opcion, nombre, cif, telefono);
                    nuevo.guardar();
                    break;
                case 2:
                    for (Proveedor p : Proveedor.obtenerTodos()) {
                        System.out.println(p.getCif() + " - " + p.getNombre() + " - " + p.getCif());
                    }
                    break;
                case 3:
                    System.out.print("ID del proveedor a modificar: ");
                    int idMod = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Nuevo CIF: ");
                    String nuevoCif = sc.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTelefono = sc.nextLine();
                    Proveedor modificado = new Proveedor(idMod, nuevoNombre, nuevoCif, nuevoTelefono);
                    modificado.actualizar();
                    break;
                case 4:
                    System.out.print("ID del proveedor a eliminar: ");
                    int idElim = sc.nextInt(); sc.nextLine();
                    Proveedor.eliminar(idElim);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }
}
