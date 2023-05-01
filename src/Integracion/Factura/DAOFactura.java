/**
 * 
 */
package Integracion.Factura;

import java.sql.Connection;
import Negocio.Factura.TFactura;

import java.sql.DriverManager;
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
		
		return null;
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