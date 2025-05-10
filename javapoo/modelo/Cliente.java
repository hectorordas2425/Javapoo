package modelo;

import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;

public class Cliente {
	private int id;
	private String nombre;
	private String email;
	private String telefono;
	
	public Cliente(int id, String nombre, String email, String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}
	public int getID() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void guardar() {
    	String sql = "INSERT INTO Clientes (nombre, email, telefono) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, email);
            stmt.setString(3, telefono);
            stmt.executeUpdate();
            System.out.println(" Cliente guardado.");
        } catch (SQLException e) {
            System.out.println(" Error al guardar cliente: " + e.getMessage());
        }
    }
    public static ArrayList<Cliente> obtenerTodos() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";
        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getString("telefono"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println(" Error al obtener clientes: " + e.getMessage());
        }
        return lista;
    }
    public void actualizar() {
        String sql = "UPDATE Clientes SET nombre=?, email=?, telefono=? WHERE id_cliente=?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, email);
            stmt.setString(3, telefono);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Cliente actualizado.");
        } catch (SQLException e) {
            System.out.println(" Error al actualizar cliente: " + e.getMessage());
        }
    }

    public static void eliminar(int id) {
        String sql = "DELETE FROM Clientes WHERE id_cliente=?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println(" Cliente eliminado.");
        } catch (SQLException e) {
            System.out.println(" Error al eliminar cliente: " + e.getMessage());
        }
    }
	}




