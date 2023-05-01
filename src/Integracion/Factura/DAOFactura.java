/**
 * 
 */
package Integracion.Factura;

import java.sql.Connection;
import java.sql.Date;

import Negocio.Factura.TFactura;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class DAOFactura implements IDAOFactura {
	
	Connection con;
	
	public DAOFactura() {
		System.out.println("Intentando Conexión - DAOFactura");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheam", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Conexión Realizada - DAOFactura");
	}

	public Integer create(TFactura factura) {
		System.out.println("Intentando create - DAOFactura");
		try {
			PreparedStatement ps;
			String sql = "INSERT INTO factura (idcliente, fecha, importe, activo) VALUES (?,?,?,?);";
			ps = con.prepareStatement(sql);
			ps.setInt(1, factura.getIDCliente());
			ps.setDate(2, (Date) factura.getFecha());
			ps.setDouble(3, factura.getImporte());
			ps.setBoolean(4, true);

			ps.executeUpdate();
			con.close();
			System.out.println("Create Realizado tabla factura- DAOFactura");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public Integer delete(Integer idfactura) {

		return null;
	}

	public Integer modify(TFactura factura) {

		return null;
	}

	public Set readAll() {

		return null;
	}

	public TFactura readById(Integer idfactura) {

		return null;
	}

	public Set<TFactura> listarIDCliente(Integer idcliente) {
		
		return null;
	}
}