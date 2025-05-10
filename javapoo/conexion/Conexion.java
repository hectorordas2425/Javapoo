package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String URL = "jdbc:mysql://localhost:3306/javapoo";
    private static final String USUARIO = "root";    
    private static final String PASSWORD = "";        

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            return conexion;
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar: " + e.getMessage());
            return null;
        }
    }
}
