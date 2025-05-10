package controlador;

import modelo.Venta;
import java.sql.Date;
import java.util.Scanner;

public class MenuVentas {
    static Scanner sc = new Scanner(System.in);

    public static void mostrar() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE VENTAS ---");
            System.out.println("1. Crear venta");
            System.out.println("2. Listar ventas");
            System.out.println("3. Modificar venta");
            System.out.println("4. Eliminar venta");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID cliente: ");
                    int idCliente = sc.nextInt(); sc.nextLine();
                    System.out.print("ID artículo: ");
                    int idArticulo = sc.nextInt(); sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt(); sc.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    String fechaStr = sc.nextLine();
                    Date fecha = Date.valueOf(fechaStr);
                    Venta nueva = new Venta(idCliente, idArticulo, cantidad, idCliente, fecha);
                    nueva.guardar();
                    break;
                case 2:
                    for (Venta v : Venta.obtenerTodos()) {
                        System.out.println(v.getID() + " - Cliente: " + v.getIdCliente() +
                                           " - Artículo: " + v.getIdArticulo() +
                                           " - Cantidad: " + v.getCantidad() +
                                           " - Fecha: " + v.getFechaVenta());
                    }
                    break;
                case 3:
                    System.out.print("ID de la venta a modificar: ");
                    int idMod = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo ID cliente: ");
                    int nuevoCliente = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo ID artículo: ");
                    int nuevoArticulo = sc.nextInt(); sc.nextLine();
                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = sc.nextInt(); sc.nextLine();
                    System.out.print("Nueva fecha (YYYY-MM-DD): ");
                    String nuevaFechaStr = sc.nextLine();
                    Date nuevaFecha = Date.valueOf(nuevaFechaStr);
                    Venta modificada = new Venta(idMod, nuevoCliente, nuevoArticulo, nuevaCantidad, nuevaFecha);
                    modificada.actualizar();
                    break;
                case 4:
                    System.out.print("ID de la venta a eliminar: ");
                    int idElim = sc.nextInt(); sc.nextLine();
                    Venta.eliminar(idElim);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }
}
