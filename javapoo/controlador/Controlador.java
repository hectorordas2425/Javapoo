// ======================
// Controlador.java
// ======================
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Articulo;
import modelo.Cliente;
import modelo.Venta;
import vista.Vista;

public class Controlador {
    public static void main(String[] args) {
        int opcion;

        do {
            opcion = Vista.mostrarMenu();

			switch (opcion) {
                case 1:
                    MenuClientes.mostrar();
                    break;
          
                case 2:
                	MenuProveedores.mostrar();
                    break;
                case 3:
                	MenuArticulos.mostrar();
                    break;
                case 4:
                	MenuFacturas.mostrar();
                    break;
                case 5:
                	MenuVentas.mostrar();
                    break;
                case 6:
                    informeVentasPorCliente();
                    break;
                case 0:
                    Vista.mostrarMensaje(" Saliendo del programa...");
                    break;
                default:
                    Vista.mostrarMensaje(" Opción no válida.");
            }

        } while (opcion != 0);
    }
    public static void informeVentasPorCliente() {
        System.out.println("\n--- INFORME DE VENTAS POR CLIENTE ---");

        try {
            Connection conn = conexion.Conexion.conectar();

            String sql = """
                SELECT c.nombre AS nombre_cliente, a.nombre AS nombre_articulo,
                       v.cantidad, v.fecha_venta,
                       (v.cantidad * a.precio_unitario) AS subtotal
                FROM Venta v
                JOIN Clientes c ON v.id_cliente = c.id_cliente
                JOIN Articulos a ON v.id_articulo = a.id_articulo
                ORDER BY c.id_cliente, v.fecha_venta
            """;

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            String clienteActual = "";
            double total = 0;

            while (rs.next()) {
                String cliente = rs.getString("nombre_cliente");

                if (!cliente.equals(clienteActual)) {
                    if (!clienteActual.equals("")) {
                        System.out.println("TOTAL GASTADO: "+ total);
                        System.out.println();
                    }
                    clienteActual = cliente;
                    total = 0;
                    System.out.println("Cliente: " + clienteActual);
                }

                String articulo = rs.getString("nombre_articulo");
                int cantidad = rs.getInt("cantidad");
                String fecha = rs.getString("fecha_venta");
                double subtotal = rs.getDouble("subtotal");
                total += subtotal;

                System.out.println("  - Artículo: Cantidad: Fecha: Subtotal:  €\n"+ articulo +cantidad + fecha + subtotal);
            }

            if (!clienteActual.equals("")) {
                System.out.println("TOTAL GASTADO: \n"+ total);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(" Error al generar el informe: " + e.getMessage());
        }
    }
}