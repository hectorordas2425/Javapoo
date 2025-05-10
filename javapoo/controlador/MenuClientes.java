package controlador;

import modelo.*;
import java.util.Scanner;

public class MenuClientes {
 static Scanner sc = new Scanner(System.in);

 public static void mostrar() {
     int opcion;
     do {
         System.out.println("\n--- GESTIÓN DE CLIENTES ---");
         System.out.println("1. Crear cliente");
         System.out.println("2. Listar clientes");
         System.out.println("3. Modificar cliente");
         System.out.println("4. Eliminar cliente");
         System.out.println("0. Volver");
         System.out.print("Opción: ");
         opcion = sc.nextInt(); sc.nextLine();

         switch (opcion) {
             case 1:
                 System.out.print("Nombre: ");
                 String nombre = sc.nextLine();
                 System.out.print("Email: ");
                 String email = sc.nextLine();
                 System.out.print("Teléfono: ");
                 String telefono = sc.nextLine();
                 Cliente nuevo = new Cliente(opcion, nombre, email, telefono);
                 nuevo.guardar();
                 break;
             case 2:
                 for (Cliente c : Cliente.obtenerTodos()) {
                     System.out.println(c.getID() + " - " + c.getNombre() + " - " + c.getEmail());
                 }
                 break;
             case 3:
                 System.out.print("ID del cliente a modificar: ");
                 int idMod = sc.nextInt(); sc.nextLine();
                 System.out.print("Nuevo nombre: ");
                 String nuevoNombre = sc.nextLine();
                 System.out.print("Nuevo email: ");
                 String nuevoEmail = sc.nextLine();
                 System.out.print("Nuevo teléfono: ");
                 String nuevoTelefono = sc.nextLine();
                 Cliente modificado = new Cliente(idMod, nuevoNombre, nuevoEmail, nuevoTelefono);
                 modificado.actualizar();
                 break;
             case 4:
                 System.out.print("ID del cliente a eliminar: ");
                 int idElim = sc.nextInt(); sc.nextLine();
                 Cliente.eliminar(idElim);
                 break;
             case 0:
                 break;
             default:
                 System.out.println("Opción no válida.");
         }

     } while (opcion != 0);
 }
}

