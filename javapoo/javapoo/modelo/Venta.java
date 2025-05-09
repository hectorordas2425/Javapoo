package modelo;

import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;


public class Venta {
	private int id;
    private int idCliente;
    private int idArticulo;
    private int cantidad;
    private Date fechaVenta;
	
    public Venta(int id, int idCliente, int idArticulo, int cantidad, Date fechaVenta) {
        this.id = id;
        this.idCliente = idCliente;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
        this.fechaVenta = fechaVenta;
    }
	public int getID() {
		return id;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public int getIdArticulo() {
		return idArticulo;
	}
	public int getcantidad() {
		return cantidad;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
public void guardar() {
	String sql = "Insert into Factura (nombre, precio_unitario, stock) Values (?,?,?)";
	try (Connection conn = Conexion.conectar();
		PreparedStatement stmt= conn.prepareStatement(sql)) {
		stmt.setInt(1, idCliente);
        stmt.setInt(2, idArticulo);
        stmt.setInt(3, cantidad);
        stmt.setDate(4, fechaVenta);
        stmt.executeUpdate();
			System.out.println("Venta guardadoa");
		} catch (SQLException e) {
            System.out.println(" Error al guardar venta: " + e.getMessage());
        }
    }
public static ArrayList<Venta> obtenerTodos() {
    ArrayList<Venta> lista = new ArrayList<>();
    String sql = "Select * from Factura";
    try (Connection conn = Conexion.conectar();
    	 Statement stmt = conn.createStatement();
    	 ResultSet rs = stmt.executeQuery(sql)) {
    	while (rs.next()) {
            Venta v = new Venta(
            		rs.getInt("id_venta"),
                    rs.getInt("id_cliente"),
                    rs.getInt("id_articulo"),
                    rs.getInt("cantidad"),
                    rs.getDate("fecha_venta"));
                lista.add(v);
        }	
    } catch (SQLException e) {
        System.out.println(" Error al obtener facturas: " + e.getMessage());
    }
    return lista;
}
public void actualizar() {
	String sql = "UPDATE Facturas SET id_proveedor=?, fecha=?, total=? WHERE id_factura=?";
	try (Connection conn = Conexion.conectar();
			PreparedStatement stmt= conn.prepareStatement(sql)) {
		stmt.setInt(1, idCliente);
        stmt.setInt(2, idArticulo);
        stmt.setInt(3, cantidad);
        stmt.setDate(4, fechaVenta);
        stmt.setInt(5, id);
        stmt.executeUpdate();
        System.out.println(" Venta actualizada.");
	} catch (SQLException e) {
        System.out.println(" Error al actualizar venta: " + e.getMessage());
    }
}
public static void eliminar(int id) {
	String sql = "DELETE FROM Ventas WHERE id_venta=?";
	try ( Connection conn = Conexion.conectar();
			PreparedStatement stmt= conn.prepareStatement(sql)) {
		stmt.setInt(1,  id);
		stmt.executeUpdate();
		System.out.println(" Venta eliminada.");
	} catch (SQLException e) {
        System.out.println(" Error al eliminar venta: " + e.getMessage());
    }
}
}

			

