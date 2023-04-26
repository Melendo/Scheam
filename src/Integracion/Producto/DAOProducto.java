package Integracion.Producto;

import Negocio.Producto.TProducto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class DAOProducto implements IDAOProducto {

	Connection con;
	
	public DAOProducto() {
		System.out.println("Intentando Conexión - DAOProducto");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheam", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Conexión Realizada - DAOProducto");
	}
	
	public Integer create(TProducto producto) {
		System.out.println("Intentando create - DAOProducto");
		try {
			Statement stmt = con.createStatement();
			PreparedStatement ps;
			String sql = "INSERT INTO productos (nombre, fechalanzamiento, precio, genero, PEGI, terminado, activo, stock) VALUES (?,?,?,?,?,?,?,?);";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, producto.getNombre());
			ps.setInt(2, producto.getFechalanzamiento());
			ps.setDouble(3, producto.getPrecio());
			ps.setString(4, producto.getGenero());
			ps.setInt(5, producto.getPEGI());
			ps.setBoolean(6, producto.getTerminado()); //
			ps.setBoolean(7, true); //activo
			ps.setInt(8, producto.getStock());

			ps.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Create Realizado - DAOEmpleado");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;

		
		
		
	}

	public Integer delete(Integer idproducto) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer modify(TProducto producto) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Set readAll() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public TProducto readById(Integer idproducto) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer cerrarProducto(Integer idproducto) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}