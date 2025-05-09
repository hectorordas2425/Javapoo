package modelo;

import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;


public class Factura {
	private int id;
	private int idProveedor;
	private Date fecha;
	private double total;
	
	public Factura(int id, int idProveedor, Date fecha, double total) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.fecha = fecha;
        this.total = total;
    }
	public int getID() {
		return id;
	}
	public int getIdProveedor() {
		return idProveedor;
	}
	public Date getFecha() {
		return fecha;
	}
	public double getTotal() {
		return total;
	}
public void guardar() {
	String sql = "Insert into Factura (nombre, precio_unitario, stock) Values (?,?,?)";
	try (Connection conn = Conexion.conectar();
		PreparedStatement stmt= conn.prepareStatement(sql)) {
			stmt.setInt(1, idProveedor);
			stmt.setDate(2,fecha);
			stmt.setDouble(3, total);
			stmt.executeUpdate();
			System.out.println("Factura guardado.");
		} catch (SQLException e) {
            System.out.println(" Error al guardar factura: " + e.getMessage());
        }
    }
public static ArrayList<Factura> obtenerTodos() {
    ArrayList<Factura> lista = new ArrayList<>();
    String sql = "Select * from Factura";
    try (Connection conn = Conexion.conectar();
    	 Statement stmt = conn.createStatement();
    	 ResultSet rs = stmt.executeQuery(sql)) {
    	while (rs.next()) {
            Factura f = new Factura(
                rs.getInt("id_factura"),
                rs.getInt("id_proveedor"),
                rs.getDate("fecha"),
                rs.getDouble("total"));
            lista.add(f);
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
		stmt.setInt(1, idProveedor);
        stmt.setDate(2, fecha);
        stmt.setDouble(3, total);
        stmt.setInt(4, id);
        stmt.executeUpdate();
		System.out.println("Factura actualizado.");
	} catch (SQLException e) {
        System.out.println(" Error al actualizar factura: " + e.getMessage());
    }
}
public static void eliminar(int id) {
	String sql = "DELETE FROM Facturas WHERE id_factura=?";
	try ( Connection conn = Conexion.conectar();
			PreparedStatement stmt= conn.prepareStatement(sql)) {
		stmt.setInt(1,  id);
		stmt.executeUpdate();
		System.out.println(" Factura eliminada.");
	} catch (SQLException e) {
        System.out.println(" Error al eliminar factura: " + e.getMessage());
    }
}
}

			

