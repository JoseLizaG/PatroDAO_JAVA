package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDBConexion {
	public static Connection getConexion() {
		Connection cn = null;
		try {
			 String myDriver = "com.mysql.jdbc.Driver";
			 Class.forName(myDriver);
			System.out.println("Driver loaded!");

			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cybercultura?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
			System.out.println("Conexion OK");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error de tipo ClassNotFoundException: " + e.toString());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error del tipo SQLException: " + e.toString());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error del tipo Exception: " + e.toString());
			e.printStackTrace();
		}

	return cn;
	}
}
