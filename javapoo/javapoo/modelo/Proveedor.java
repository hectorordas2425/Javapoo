package modelo;

import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;

public class Proveedor {
	private int id;
	private String nombre;
	private String cif;
	private String telefono;
	
	public Proveedor(int id, String nombre, String cif, String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.cif = cif;
		this.telefono = telefono;
	}
	public int getID() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCif() {
		return cif;
	}
	public String getTelefono() {
		return telefono;
	}
public void guardar() {
	String sql = "INSERT INTO Clientes (nombre, cif, telefono) VALUES (?, ?, ?)";
    try (Connection conn = Conexion.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nombre);
        stmt.setString(2, cif);
        stmt.setString(3, telefono);
        stmt.executeUpdate();
        System.out.println(" Proveedor guardado.");
    } catch (SQLException e) {
        System.out.println(" Error al guardar proveedor: " + e.getMessage());
    }
}
public static ArrayList<Proveedor> obtenerTodos() {
    ArrayList<Proveedor> lista = new ArrayList<>();
    String sql = "SELECT * FROM Proveedor";
    try (Connection conn = Conexion.conectar();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Proveedor p = new Proveedor(
                rs.getInt("id_cliente"),
                rs.getString("nombre"),
                rs.getString("cif"),
                rs.getString("telefono"));
            lista.add(p);
        }
    } catch (SQLException e) {
        System.out.println(" Error al obtener proveedores: " + e.getMessage());
    }
    return lista;
}
public void actualizar() {
    String sql = "UPDATE Proveedores SET nombre=?, cif=?, telefono=? WHERE id_proveedor=?";
    try (Connection conn = Conexion.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nombre);
        stmt.setString(2, cif);
        stmt.setString(3, telefono);
        stmt.setInt(4, id);
        stmt.executeUpdate();
        System.out.println(" Proveedor actualizado.");
    } catch (SQLException e) {
        System.out.println(" Error al actualizar proveedor: " + e.getMessage());
    }
}

public static void eliminar(int id) {
    String sql = "DELETE FROM Proveedor WHERE id_proveedor=?";
    try (Connection conn = Conexion.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println(" Proveedor eliminado.");
    } catch (SQLException e) {
        System.out.println(" Error al eliminar proveedor: " + e.getMessage());
    }
  }
}

