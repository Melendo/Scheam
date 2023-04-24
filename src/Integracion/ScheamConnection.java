package Integracion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ScheamConnection {
	public Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("localhost:3306/scheam", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
