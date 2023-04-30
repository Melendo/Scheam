package Integracion.Cliente;

import Negocio.Cliente.TCliente;
import Negocio.Cliente.TDistribuidor;
import Negocio.Cliente.TParticular;
import Negocio.Empleado.TEmpleado;
import Negocio.Equipo.TEquipo;
import Negocio.Equipo.TEquipoDesarrollo;
import Negocio.Equipo.TEquipoDisenio;

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
	
	public Integer create(TCliente cliente) {
		System.out.println("Intentando create - DAOCliente");
		try {
			//Statement stmt = con.createStatement();
			PreparedStatement ps;
			String sql = "INSERT INTO clientes (nombre, email, activo) VALUES (?,?,?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getEmail());
			ps.setBoolean(3, true);
			
			ps.executeUpdate();
			
			ps.close();
			
			cliente.setID(mostrarClienteEmail(cliente.getEmail()).getID());
			
			if(cliente instanceof TDistribuidor) {
				PreparedStatement ps1;
				sql = "INSERT INTO distribuidores (ID, CIF, direccion) VALUES (?,?,?);";
				ps1 = con.prepareStatement(sql);
				ps1.setInt(1, cliente.getID());
				ps1.setString(2, ((TDistribuidor) cliente).getCIF());
				ps1.setString(3, ((TDistribuidor) cliente).getDireccion());
				ps1.executeUpdate();
				ps1.close();
			} else if (cliente instanceof TParticular){
				PreparedStatement ps2;
				sql = "INSERT INTO particulares (ID, DNI, telefono) VALUES (?,?,?);";
				ps2 = con.prepareStatement(sql);
				ps2.setInt(1, cliente.getID());
				ps2.setString(2, ((TParticular) cliente).getDNI());
				ps2.setInt(3, ((TParticular) cliente).getTelefono());
				ps2.executeUpdate();
				ps2.close();
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		System.out.println("Create Realizado - DAOCliente");
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
	
	public Integer modify(TCliente cliente) {
		System.out.println("Intentando Modify - DAOCliente");
		try {
			PreparedStatement ps;
			
			String sql = "UPDATE clientes set nombre = ?, email = ?, activo = ? where id_cliente = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getEmail());
			ps.setBoolean(3, cliente.getActivo());
			ps.setInt(4, cliente.getID());
			
			if(cliente instanceof TDistribuidor) {
				sql = "UPDATE distribuidores set direccion = ?, CIF = ? where ID = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, ((TDistribuidor) cliente).getDireccion());
				ps.setString(2, ((TDistribuidor) cliente).getCIF());
				ps.setInt(3, cliente.getID());
				ps.executeUpdate();
				
			} else if(cliente instanceof TParticular){
				sql = "UPDATE particulares set DNI = ?, telefono = ? where ID = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, ((TParticular) cliente).getDNI());
				ps.setInt(2, ((TParticular) cliente).getTelefono());
				ps.setInt(3, cliente.getID());
				ps.executeUpdate();
			}			
			ps.close();
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
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM clientes WHERE activo");
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				return result;
			} else {
				/*
				aux = new TCliente();
				if(aux instanceof TDistribuidor) {
					TDistribuidor distribuidor = (TDistribuidor) aux;
					distribuidor = new TDistribuidor();
					distribuidor.setID(rs.getInt("id_cliente"));
					distribuidor.setNombre(rs.getString("nombre"));
					distribuidor.setEmail("email");
					distribuidor.setCIF(rs.getString("CIF"));
					distribuidor.setDireccion(rs.getString("direccion"));;
					result.add(distribuidor);
				} else {
					TParticular particular = (TParticular) aux;
					particular = new TParticular();
					particular.setID(rs.getInt("id_cliente"));
					particular.setNombre(rs.getString("nombre"));
					particular.setEmail("email");
					particular.setDNI(rs.getString("DNI"));
					particular.setTelefono(rs.getInt("telefono"));;
					result.add(particular);
				}
				while (rs.next()) {
					aux = new TCliente();
					if(aux instanceof TDistribuidor) {
						TDistribuidor distribuidor = (TDistribuidor) aux;
						distribuidor = new TDistribuidor();
						distribuidor.setID(rs.getInt("id_cliente"));
						distribuidor.setNombre(rs.getString("nombre"));
						distribuidor.setEmail("email");
						distribuidor.setCIF(rs.getString("CIF"));
						distribuidor.setDireccion(rs.getString("direccion"));;
						result.add(distribuidor);
					} else {
						TParticular particular = (TParticular) aux;
						particular = new TParticular();
						particular.setID(rs.getInt("id_cliente"));
						particular.setNombre(rs.getString("nombre"));
						particular.setEmail("email");
						particular.setDNI(rs.getString("DNI"));
						particular.setTelefono(rs.getInt("telefono"));;
						result.add(particular);
					}
				}
				rs.close();
				ps.close();
				con.close();*/
			}
			
			System.out.println("Readall realizado - DAOCliente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public TCliente mostrarClienteID(Integer idcliente) {
		System.out.println("Intentando readByID - DAOCliente");
		TCliente result = new TCliente();
		try {
			PreparedStatement ps = con.prepareStatement("select * from clientes where id_cliente = ?");
			ps.setInt(1, idcliente);

			ResultSet rs = ps.executeQuery();

			if (!rs.next())
				result.setID(-1);
			else {
				
				result.setID(rs.getInt("id_cliente"));
				result.setNombre(rs.getString("nombre"));
				result.setEmail(rs.getString("email"));
				result.setActivo(rs.getBoolean("activo"));
		
				try {
					ps = con.prepareStatement("select * from distribuidores where ID = ?");
					ps.setInt(1, idcliente);
					
					rs = ps.executeQuery();
					
					if(!rs.next()) {
						try {
							ps = con.prepareStatement("select * from particulares where ID = ?");
							ps.setInt(1, idcliente);
							
							rs = ps.executeQuery();
							TParticular part = new TParticular(); 
							
							part.setID(result.getID());
							part.setNombre(result.getNombre());
							part.setActivo(result.getActivo());
							part.setTelefono(rs.getInt("telefono"));
							part.setDNI(rs.getString("DNI"));
							
							result = part;
						}catch(SQLException e) {
							e.printStackTrace();
						}
					}else {
						TDistribuidor dist = new TDistribuidor(); 
						
						dist.setID(result.getID());
						dist.setNombre(result.getNombre());
						dist.setActivo(result.getActivo());
						dist.setCIF(rs.getString("CIF"));
						dist.setDireccion(rs.getString("direccion"));
						
						result = dist;
					}
					
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ReadybyID realizado - DAOCliente");
		return result;
	}

	public TCliente mostrarClienteEmail(String email) {
		System.out.println("Intentando readByEmail - DAOEquipo");
		TCliente result = new TCliente();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from clientes where email = ?");
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if (!rs.next()) {
				//result.setEmail("-1");
				result.setID(-1);
			} else {
				result.setID(rs.getInt("id_cliente"));
				result.setNombre(rs.getString("nombre"));
				result.setEmail(rs.getString("email"));
				result.setActivo(rs.getBoolean("activo"));
			}
		}catch(SQLException e) {
				e.printStackTrace();
				
		}
		return result;
	}

	public TCliente mostrarClienteCIF(String cifDistribuidor) {
		System.out.println("Intentando readByCIF - DAOCliente");
		TCliente result = new TCliente();
		try {
			PreparedStatement ps = con.prepareStatement("select * from distribuidores where cif = ?");
			ps.setString(1, cifDistribuidor);

			ResultSet rs = ps.executeQuery();

			if (!rs.next())
			result.setID(-1);
			else {
			
				result.setID(rs.getInt("ID"));
				((TDistribuidor) result).setDireccion(rs.getString("direccion"));
				((TDistribuidor) result).setEmail(rs.getString("cif"));
			
				ps = con.prepareStatement("select * from clientes where id_cliente = ?");
				ps.setInt(1, result.getID());
			
				rs = ps.executeQuery();
			
				TDistribuidor dist = new TDistribuidor();
			
				dist.setID(result.getID());
				dist.setNombre(result.getNombre());
				dist.setActivo(true);
				dist.setCIF(rs.getString("CIF"));
				dist.setDireccion(rs.getString("direccion"));
			}
		
			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ReadybyCIF realizado - DAOCliente");
		return result;
	}
}
