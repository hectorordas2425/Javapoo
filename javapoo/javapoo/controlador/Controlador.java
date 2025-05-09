// ======================
// Controlador.java
// ======================
package controlador;

import modelo.*;
import vista.menu;

public class Controlador {
    public static void main(String[] args) {
        int opcion;

        do {
            opcion = menu.mostrarMenu();

            switch (opcion) {
                case 1:
                    for (Cliente c : Cliente.obtenerTodos()) {
                        menu.mostrarMensaje(c.getID() + " - " + c.getNombre() + " - " + c.getEmail());
                    }
                    break;
                case 2:
                    for (Proveedor p : Proveedor.obtenerTodos()) {
                       menu.mostrarMensaje(p.getID() + " - " + p.getNombre() + " - " + p.getCif());
                    }
                    break;
                case 3:
                    for (Articulo a : Articulo.obtenerTodos()) {
                        menu.mostrarMensaje(a.getID() + " - " + a.getNombre() + " - " + a.getPrecio());
                    }
                    break;
                case 4:
                    for (Factura f : Factura.obtenerTodos()) {
                        menu.mostrarMensaje(f.getID() + " - Proveedor: " + f.getIdProveedor() + " - Total: " + f.getTotal());
                    }
                    break;
                case 5:
                    for (Venta v : Venta.obtenerTodos()) {
                        menu.mostrarMensaje(v.getID() + " - Cliente: " + v.getIdCliente() + " - Artículo: " + v.getIdArticulo());
                    }
                    break;
                case 0:
                    menu.mostrarMensaje(" Saliendo del programa...");
                    break;
                default:
                    menu.mostrarMensaje(" Opción no válida.");
            }

            menu.mostrarSeparador();

        } while (opcion != 0);
    }
}
