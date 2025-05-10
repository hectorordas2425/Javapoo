package controlador;

import modelo.Articulo;
import java.util.Scanner;

public class MenuArticulos {
    static Scanner sc = new Scanner(System.in);

    public static void mostrar() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE ARTÍCULOS ---");
            System.out.println("1. Crear artículo");
            System.out.println("2. Listar artículos");
            System.out.println("3. Modificar artículo");
            System.out.println("4. Eliminar artículo");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Precio unitario: ");
                    double precio = sc.nextDouble(); sc.nextLine();
                    System.out.print("Stock: ");
                    int stock = sc.nextInt(); sc.nextLine();
                    Articulo nuevo = new Articulo(stock, nombre, precio, stock);
                    nuevo.guardar();
                    break;
                case 2:
                    for (Articulo a : Articulo.obtenerTodos()) {
                        System.out.println(a.getID() + " - " + a.getNombre() + " - " + a.getPrecio());
                    }
                    break;
                case 3:
                    System.out.print("ID del artículo a modificar: ");
                    int idMod = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = sc.nextDouble(); sc.nextLine();
                    System.out.print("Nuevo stock: ");
                    int nuevoStock = sc.nextInt(); sc.nextLine();
                    Articulo modificado = new Articulo(idMod, nuevoNombre, nuevoPrecio, nuevoStock);
                    modificado.actualizar();
                    break;
                case 4:
                    System.out.print("ID del artículo a eliminar: ");
                    int idElim = sc.nextInt(); sc.nextLine();
                    Articulo.eliminar(idElim);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }
}
