/**
 * 
 */
package Integracion.Factura;

import java.sql.Connection;
import java.sql.Date;

import Negocio.Empleado.TEmpleado;
import Negocio.Factura.TFactura;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
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
		System.out.println("Intentando Delete - DAOFactura");
		try {
			PreparedStatement ps;
			String sql = "UPDATE factura set activo = false where idfactura = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idfactura);
			ps.executeUpdate();
			
			ps.close();
			con.close();
			System.out.println("Delete Realizado - DAOFactura");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public Integer modify(TFactura factura) {
		System.out.println("Intentando Modify - DAOFactura");
		try {
			PreparedStatement ps;
						
			String sql = "UPDATE factura set idcliente = ?,  fecha = ?, importe = ?, activo = ? where idfactura = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, factura.getIDCliente());
			ps.setDate(2, (Date) factura.getFecha());
			ps.setDouble(3, factura.getImporte());
			ps.setBoolean(4, factura.isActivo());
			ps.setInt(5, factura.getIdFactura());
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
			System.out.println("Modify Realizado - DAOFactura");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public Set<TFactura> readAll() {

		System.out.println("Intentando readAll - DAOFactura");
		Set<TFactura> result = new HashSet<TFactura>();
		TFactura aux;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM factura WHERE activo");
			ResultSet rs = ps.executeQuery();
			
			if (!rs.next()) {
				return result;
			} else {
				aux = new TFactura();
				aux.setIdFactura(rs.getInt("idfactura"));
				aux.setIDCliente(rs.getInt("idcliente"));
				aux.setFecha((Date) rs.getDate("fecha"));
				aux.setImporte(rs.getDouble("importe"));
				result.add(aux);
				while (rs.next()) {
					aux = new TFactura();
					aux.setIdFactura(rs.getInt("idfactura"));
					aux.setIDCliente(rs.getInt("idcliente"));
					aux.setFecha((Date) rs.getDate("fecha"));
					aux.setImporte(rs.getDouble("importe"));
					result.add(aux);
				}
				rs.close();
				ps.close();
				con.close();
				System.out.println("Readall realizado - DAOFactura");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public TFactura readById(Integer idfactura) {
		System.out.println("Intentando readByID - DAOFactura");
		TFactura result = new TFactura();
		try {
			PreparedStatement ps = con.prepareStatement("select * from factura where idfactura = ?");
			ps.setInt(1, idfactura);

			ResultSet rs = ps.executeQuery();

			if (!rs.next())
				result.setIdFactura(-1);
			else {
				result.setIdFactura(rs.getInt("idfactura"));
				result.setIDCliente(rs.getInt("idcliente"));
				result.setFecha((Date) rs.getDate("fecha"));
				result.setImporte(rs.getDouble("importe"));
				result.setActivo(rs.getBoolean("activo"));
			}
			
			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ReadybyId realizado - DAOFactura");
		return result;
	}

	public Set<TFactura> listarFacturasIDCliente(Integer idcliente) {
		
		return null;
	}
}