/**
 * 
 */
package Integracion.Factura;

import java.sql.Connection;
import java.sql.Date;

import Negocio.Factura.TFactura;
import Negocio.Factura.TLineaFactura;

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
			String sql = "INSERT INTO factura (fecha, importe, activo) VALUES (?,?,?);";
			ps = con.prepareStatement(sql);
			ps.setDate(1, factura.getFecha());
			ps.setDouble(2, factura.getImporte());
			ps.setBoolean(3, true);

			ps.executeUpdate();
			ps.close();
			
			Set<TLineaFactura> set = factura.getLineas();
			
			PreparedStatement ps1;
			sql= "INSERT INTO contiene (idproducto, idfactura, cantidad, preciopp) VALUES (?,?,?,?);";
			ps1 = con.prepareStatement(sql);
			TFactura fct = getLastCreated();
			for (TLineaFactura s : set) {
				ps1.setInt(1, fct.getIdFactura());
				ps1.setInt(2, factura.getIDCliente());
				ps1.setInt(3, s.getCantidad());
				ps1.setDouble(4, s.getPrecio());
				ps1.executeUpdate();
			    }
			ps.close();
			    
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
			ps.setDate(2, factura.getFecha());
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
				aux.setFecha( rs.getDate("fecha"));
				aux.setImporte(rs.getDouble("importe"));
				result.add(aux);
				while (rs.next()) {
					aux = new TFactura();
					aux.setIdFactura(rs.getInt("idfactura"));
					aux.setIDCliente(rs.getInt("idcliente"));
					aux.setFecha( rs.getDate("fecha"));
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
				result.setFecha(rs.getDate("fecha"));
				result.setImporte(rs.getDouble("importe"));
				result.setActivo(rs.getBoolean("activo"));
			}
			
			rs.close();
			ps.close();
			
			PreparedStatement ps1 = con.prepareStatement("select * from contiene where idfactura = ?");
			ps1.setInt(1, idfactura);

			ResultSet rs1 = ps1.executeQuery();
			TLineaFactura aux;

			if (!rs1.next()) {
				return result;
			} else {
				aux = new TLineaFactura();
				aux.setIdFactura(rs1.getInt("idfactura"));
				aux.setIdProducto(rs1.getInt("idproducto"));
				aux.setCantidad(rs1.getInt("cantidad"));
				aux.setPrecio(rs1.getDouble("preciopp"));
				result.addElement(aux);
				while (rs.next()) {
					aux = new TLineaFactura();
					aux.setIdFactura(rs1.getInt("idfactura"));
					aux.setIdProducto(rs1.getInt("idproducto"));
					aux.setCantidad(rs1.getInt("cantidad"));
					aux.setPrecio(rs1.getDouble("preciopp"));
					result.addElement(aux);
				}
			}
			rs1.close();
			ps1.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ReadybyId realizado - DAOFactura");
		return result;
	}

	public Set<TFactura> listarFacturasIDCliente(Integer idcliente) {
		
		System.out.println("Intentando listarFacturasIDCliente - DAOFactura");
		Set<TFactura> result = new HashSet<TFactura>();
		int ids[] = new int[100];
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM factura WHERE idcliente = ?");
			ps.setInt(1, idcliente);
			ResultSet rs = ps.executeQuery();
			
			if (!rs.next()) {
				return result;
			} else {
				int j = 0;
				if(rs.getBoolean("activo")) {
					ids[j] = rs.getInt("idfactura");
					j++;
				}
				while(rs.next()) {
					if(rs.getBoolean("activo")) {
						ids[j] = rs.getInt("idfactura");
						j++;					}	
				}
				
				if(j != 0) {
					
					for(int i = 0; i < j; i++) {
						
						PreparedStatement ps1 = con.prepareStatement("SELECT * FROM factura WHERE idfactura = ?");
						
						ps1.setInt(1, ids[i]);
						ResultSet rs1 =  ps1.executeQuery();
						
						if(!rs1.next()) {
							//return result;
							System.out.println("Intentando listarFacturasIDCliente - DAOFactura");
						} else {
							TFactura aux = new TFactura();
							
							aux.setActivo(rs1.getBoolean("activo"));
							if(aux.isActivo()) {
								aux.setIdFactura(rs1.getInt("idfactura"));
								aux.setIDCliente(rs1.getInt("idcliente"));
								aux.setFecha(rs1.getDate("fecha"));
								aux.setImporte(rs1.getDouble("importe"));
								
								result.add(aux);
							}
						}
						rs1.close();
					}										
				}							
				rs.close();
				ps.close();
				con.close();
				System.out.println("listarFacturasIDCliente realizado - DAOFactura");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public TFactura getLastCreated(){
		
		System.out.println("Intentando getLastCreated - DAOFactura");
		TFactura result = new TFactura();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM facturas ORDER BY fecha DESC LIMIT 1 ");
			
			ResultSet rs = ps.executeQuery();

			if (!rs.next())
				result.setIdFactura(-1);
			else {
				result.setIdFactura(rs.getInt("idfactura"));
				result.setIDCliente(rs.getInt("idcliente"));
				result.setFecha(rs.getDate("fecha"));
				result.setImporte(rs.getDouble("importe"));
				result.setActivo(rs.getBoolean("activo"));
			}
			
			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("getLastCreated realizado - DAOFactura");
		return result;
	}
}