package Integracion.Cliente;

import Negocio.Cliente.TCliente;
import Negocio.Cliente.TDistribuidor;
import Negocio.Cliente.TParticular;
import Negocio.Empleado.TEmpleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.HashSet;

public class DAOCliente implements IDAOCliente {

	Connection con;
	
	public DAOCliente() {
		System.out.println("Intentando Conexión - DAOCliente");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheam", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Conexión Realizada - DAOCliente");
	}
	
	public Integer create(TParticular particular) {
		System.out.println("Intentando create - DAOCliente");
		try {
			Statement stmt = con.createStatement();
			PreparedStatement ps;
			String sql = "INSERT INTO clientes (nombre, email, activo, DNI, telefono) VALUES (?,?,?,?,?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, particular.getNombre());
			ps.setString(2, particular.getEmail());
			ps.setBoolean(3, true);
			ps.setString(4, particular.getDNI());
			ps.setInt(5, particular.getTelefono());
			

			ps.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Create Realizado - DAOCliente");
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
	
	public Integer create(TDistribuidor distribuidor) {
		System.out.println("Intentando create - DAOCliente");
		try {
			Statement stmt = con.createStatement();
			PreparedStatement ps;
			String sql = "INSERT INTO clientes (nombre, email, activo, direccion, CIF) VALUES (?,?,?,?,?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, distribuidor.getNombre());
			ps.setString(2, distribuidor.getEmail());
			ps.setBoolean(3, true);
			ps.setString(4, distribuidor.getDireccion());
			ps.setString(5, distribuidor.getCIF());
			

			ps.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Create Realizado - DAOCliente");
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public Integer delete(Integer idcliente) {
		System.out.println("Intentando Delete - DAOCliente");
		try {
			Statement stmt = con.createStatement();
			PreparedStatement ps;
			String sql = "UPDATE clientes set activo = false where id_cliente = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idcliente);
			ps.executeUpdate();
			
			ps.close();
			stmt.close();
			con.close();
			System.out.println("Delete Realizado - DAOCliente");
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public Integer modify(TDistribuidor distribuidor) {
		System.out.println("Intentando Modify - DAOCliente");
		try {
			Statement stmt = con.createStatement();
			PreparedStatement ps;
						
			String sql = "UPDATE clientes set nombre = ?,  email = ?, activo = ?, direccion = ?, CIF = ? where id_empleado = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, distribuidor.getNombre());
			ps.setString(2, distribuidor.getEmail());
			ps.setBoolean(3, distribuidor.getActivo());
			ps.setString(4, distribuidor.getDireccion());
			ps.setString(5, distribuidor.getCIF());
			ps.setInt(8, distribuidor.getID());
			ps.executeUpdate();
			
			ps.close();
			stmt.close();
			con.close();
			
			System.out.println("Modify Realizado - DAOCliente");
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public Integer modify(TParticular particular) {
		System.out.println("Intentando Modify - DAOCliente");
		try {
			Statement stmt = con.createStatement();
			PreparedStatement ps;
						
			String sql = "UPDATE clientes set nombre = ?,  email = ?, activo = ?, DNI = ?, telefono = ? where id_empleado = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, particular.getNombre());
			ps.setString(2, particular.getEmail());
			ps.setBoolean(3, particular.getActivo());
			ps.setString(4, particular.getDNI());
			ps.setInt(5, particular.getTelefono());
			ps.setInt(8, particular.getID());
			ps.executeUpdate();
			
			ps.close();
			stmt.close();
			con.close();
			
			System.out.println("Modify Realizado - DAOCliente");
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public Set<TCliente> mostrarClientes() {
		System.out.println("Intentando readAll - DAOCliente");
		Set<TCliente> result = new HashSet<TCliente>();
		TCliente aux;
		TParticular aux1;
		TDistribuidor aux2;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM clientes WHERE activo");
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				return result;
			} else {
				aux1 = new TParticular();
				aux1.setID(rs.getInt("id_cliente"));
				aux1.setNombre(rs.getString("nombre"));
				aux1.setEmail("email");
				aux1.setDNI(rs.getString("DNI"));
				aux1.setTelefono(rs.getInt("telefono"));;
				result.add(aux1);
				while (rs.next()) {
					aux1 = new TParticular();
					aux1.setID(rs.getInt("id_cliente"));
					aux1.setNombre(rs.getString("nombre"));
					aux1.setEmail("email");
					aux1.setDNI(rs.getString("DNI"));
					aux1.setTelefono(rs.getInt("telefono"));;
					result.add(aux1);
				}
				rs.close();
				ps.close();
				con.close();
			}
			if (!rs.next()) {
				return result;
			} else {
				aux2 = new TDistribuidor();
				aux2.setID(rs.getInt("id_cliente"));
				aux2.setNombre(rs.getString("nombre"));
				aux2.setEmail("email");
				aux2.setCIF(rs.getString("CIF"));
				aux2.setDireccion(rs.getString("direccion"));;
				result.add(aux2);
				while (rs.next()) {
					aux2 = new TDistribuidor();
					aux2.setID(rs.getInt("id_cliente"));
					aux2.setNombre(rs.getString("nombre"));
					aux2.setEmail("email");
					aux2.setCIF(rs.getString("CIF"));
					aux2.setDireccion(rs.getString("direccion"));;
					result.add(aux2);
				}
				rs.close();
				ps.close();
				con.close();
			}
			
			System.out.println("Readall realizado - DAOCliente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public TCliente mostrarClienteID(Integer idcliente) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	
}