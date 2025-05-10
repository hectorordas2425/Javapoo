package controlador;

import modelo.Factura;
import java.sql.Date;
import java.util.Scanner;

public class MenuFacturas {
    static Scanner sc = new Scanner(System.in);

    public static void mostrar() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE FACTURAS ---");
            System.out.println("1. Crear factura");
            System.out.println("2. Listar facturas");
            System.out.println("3. Modificar factura");
            System.out.println("4. Eliminar factura");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID del proveedor: ");
                    int idProveedor = sc.nextInt(); sc.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    String fechaStr = sc.nextLine();
                    System.out.print("Total: ");
                    double total = sc.nextDouble(); sc.nextLine();
                    Date fecha = Date.valueOf(fechaStr);
                    Factura nueva = new Factura(idProveedor, idProveedor, fecha, total);
                    nueva.guardar();
                    break;
                case 2:
                    for (Factura f : Factura.obtenerTodos()) {
                        System.out.println(f.getID() + " - Proveedor: " + f.getIdProveedor() +
                                           " - Fecha: " + f.getFecha() +
                                           " - Total: " + f.getTotal());
                    }
                    break;
                case 3:
                    System.out.print("ID de la factura a modificar: ");
                    int idMod = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo ID proveedor: ");
                    int nuevoProv = sc.nextInt(); sc.nextLine();
                    System.out.print("Nueva fecha (YYYY-MM-DD): ");
                    String nuevaFechaStr = sc.nextLine();
                    System.out.print("Nuevo total: ");
                    double nuevoTotal = sc.nextDouble(); sc.nextLine();
                    Date nuevaFecha = Date.valueOf(nuevaFechaStr);
                    Factura modificada = new Factura(idMod, nuevoProv, nuevaFecha, nuevoTotal);
                    modificada.actualizar();
                    break;
                case 4:
                    System.out.print("ID de la factura a eliminar: ");
                    int idElim = sc.nextInt(); sc.nextLine();
                    Factura.eliminar(idElim);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }
}
