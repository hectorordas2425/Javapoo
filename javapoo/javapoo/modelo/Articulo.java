package modelo;

import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;

public class Articulo {
	private int id;
	private String nombre;
	private double precio;
	private int stock;
	
	public Articulo(int id, String nombre, double precio, int stock) {
		this.id = id;
		this.nombre =nombre;
		this.precio = precio;
		this.stock = stock;
	}
	public int getID() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public int getStock() {
		return stock;
	}
public void guardar() {
	String sql = "Insert into Articulos (nombre, precio_unitario, stock) Values (?,?,?)";
	try (Connection conn = Conexion.conectar();
		PreparedStatement stmt= conn.prepareStatement(sql)) {
			stmt.setString(1, nombre);
			stmt.setDouble(2, precio);
			stmt.setInt(3, stock);
			stmt.executeUpdate();
			System.out.println("Articulo guardado.");
		} catch (SQLException e) {
            System.out.println(" Error al guardar artículo: " + e.getMessage());
        }
    }
public static ArrayList<Articulo> obtenerTodos() {
    ArrayList<Articulo> lista = new ArrayList<>();
    String sql = "Select * from Articulos";
    try (Connection conn = Conexion.conectar();
    	 Statement stmt = conn.createStatement();
    	 ResultSet rs = stmt.executeQuery(sql)) {
    	 while (rs.next()) {
    		 Articulo a = new Articulo(
    				rs.getInt("id_articulo"),	 
    		 		rs.getString("nombre"),
    		 		rs.getDouble("precio_unitario"),
    		 		rs.getInt("stock"));
    		 		lista.add(a);
    	 }	
    } catch (SQLException e) {
        System.out.println(" Error al obtener artículos: " + e.getMessage());
    }
    return lista;
}
public void actualizar() {
	String sql = "UPDATE Articulos SET nombre=?, precio_unitario=?, stock=? WHERE id_articulo=?";
	try ( Connection conn = Conexion.conectar();
			PreparedStatement stmt= conn.prepareStatement(sql)) {
		stmt.setString(1, nombre);
		stmt.setDouble(2, precio);
		stmt.setInt(3, stock);
		stmt.setInt(4, id);
		stmt.executeUpdate();
		System.out.println("Articulo actualizado.");
	} catch (SQLException e) {
        System.out.println(" Error al actualizar artículo: " + e.getMessage());
    }
}
public static void eliminar(int id) {
	String sql = "DELETE FROM Articulos WHERE id_articulo=?";
	try ( Connection conn = Conexion.conectar();
			PreparedStatement stmt= conn.prepareStatement(sql)) {
		stmt.setInt(1,  id);
		stmt.executeUpdate();
		System.out.println(" Artículo eliminado.");
	} catch (SQLException e) {
        System.out.println(" Error al eliminar artículo: " + e.getMessage());
    }
}
}

			
