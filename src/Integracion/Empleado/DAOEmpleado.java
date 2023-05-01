package Integracion.Empleado;

import Negocio.Empleado.TEmpleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.HashSet;

public class DAOEmpleado implements IDAOEmpleado {

	Connection con;

	public DAOEmpleado() {
		System.out.println("Intentando Conexión - DAOEmpleado");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheam", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Conexion Realizada - DAOEmpleado");
	}

	public Integer create(TEmpleado empleado) {
		System.out.println("Intentando create - DAOEmpleado");
		try {
			PreparedStatement ps;
			String sql = "INSERT INTO empleados (nombre, apellidos, dni, email, telefono,sueldo, activo) VALUES (?,?,?,?,?,?,?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellidos());
			ps.setString(3, empleado.getDNI());
			ps.setString(4, empleado.getE_mail());
			ps.setInt(5, empleado.getTlfn());
			ps.setDouble(6, empleado.getSueldo());
			ps.setBoolean(7, true);

			ps.executeUpdate();
			con.close();
			System.out.println("Create Realizado - DAOEmpleado");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;

	}

	public Integer delete(Integer idempleado) {
		System.out.println("Intentando Delete - DAOEmpleado");
		try {
			PreparedStatement ps;
			String sql = "UPDATE empleados set activo = false where id_empleado = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idempleado);
			ps.executeUpdate();
			
			ps.close();
			con.close();
			System.out.println("Delete Realizado - DAOEmpleado");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public Integer modify(TEmpleado empleado) {
		System.out.println("Intentando Modify - DAOEmpleado");
		try {
			PreparedStatement ps;
						
			String sql = "UPDATE empleados set nombre = ?,  apellidos = ?, dni = ?, email = ?, telefono = ?, sueldo = ?, activo = ? where id_empleado = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellidos());
			ps.setString(3, empleado.getDNI());
			ps.setString(4, empleado.getE_mail());
			ps.setInt(5, empleado.getTlfn());
			ps.setDouble(6, empleado.getSueldo());
			ps.setBoolean(7, empleado.getActivo());
			ps.setInt(8, empleado.getIdEmpleado());
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
			System.out.println("Modify Realizado - DAOEmpleado");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public Set<TEmpleado> readAll() {
		System.out.println("Intentando readAll - DAOEmpleado");
		Set<TEmpleado> result = new HashSet<TEmpleado>();
		TEmpleado aux;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM empleados WHERE activo");
			ResultSet rs = ps.executeQuery();
			
			if (!rs.next()) {
				return result;
			} else {
				aux = new TEmpleado();
				aux.setIdEmpleado(rs.getInt("id_empleado"));
				aux.setNombre(rs.getString("nombre"));
				aux.setApellidos(rs.getString("apellidos"));
				aux.setDNI(rs.getString("DNI"));
				aux.setE_mail(rs.getString("email"));
				aux.setTlfn(rs.getInt("telefono"));
				aux.setSueldo(rs.getDouble("sueldo"));
				result.add(aux);
				while (rs.next()) {
					aux = new TEmpleado();
					aux.setIdEmpleado(rs.getInt("id_empleado"));
					aux.setNombre(rs.getString("nombre"));
					aux.setApellidos(rs.getString("apellidos"));
					aux.setDNI(rs.getString("DNI"));
					aux.setE_mail(rs.getString("email"));
					aux.setTlfn(rs.getInt("telefono"));
					aux.setSueldo(rs.getDouble("sueldo"));
					result.add(aux);
				}
				rs.close();
				ps.close();
				con.close();
				System.out.println("Readall realizado - DAOEmpleado");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public TEmpleado readByDNI(String dni) {
		System.out.println("Intentando readByDNI - DAOEmpleado");
		TEmpleado result = new TEmpleado();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM empleados WHERE DNI = ?");
			ps.setString(1, dni);

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) 
				result.setDNI("-1");
			else  {
				result.setIdEmpleado(rs.getInt("id_empleado"));
				result.setNombre(rs.getString("nombre"));
				result.setApellidos(rs.getString("apellidos"));
				result.setDNI(rs.getString("DNI"));
				result.setE_mail(rs.getString("email"));
				result.setTlfn(rs.getInt("telefono"));
				result.setSueldo(rs.getDouble("sueldo"));
				result.setActivo(rs.getBoolean("activo"));
			}
			
			rs.close();
			ps.close();
			con.close();
			
			if (result.getDNI().equals("-1"))
				System.out.println("ReadByDNI realizado (no encontró DNI) - DAOEmpleado");
			else
				System.out.println("ReadByDNI realizado (encontró DNI) - DAOEmpleado");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public TEmpleado readById(Integer idempleado) {
		System.out.println("Intentando readByID - DAOEmpleado");
		TEmpleado result = new TEmpleado();
		try {
			PreparedStatement ps = con.prepareStatement("select * from empleados where id_empleado = ?");
			ps.setInt(1, idempleado);

			ResultSet rs = ps.executeQuery();

			if (!rs.next())
				result.setIdEmpleado(-1);
			else {
				result.setIdEmpleado(rs.getInt("id_empleado"));
				result.setNombre(rs.getString("nombre"));
				result.setApellidos(rs.getString("apellidos"));
				result.setDNI(rs.getString("DNI"));
				result.setE_mail(rs.getString("email"));
				result.setTlfn(rs.getInt("telefono"));
				result.setSueldo(rs.getDouble("sueldo"));
				result.setActivo(rs.getBoolean("activo"));
			}
			
			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ReadybyId realizado - DAOEmpleado");
		return result;
	}

	public Set<TEmpleado> listarIdEquipo(Integer idequipo) {
		System.out.println("Intentando listarIdEquipo - DAOEmpleado");
		Set<TEmpleado> result = new HashSet<TEmpleado>();
		int ids[] = new int[100];
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM pertenece WHERE id_equipo = ?");
			ps.setInt(1, idequipo);
			ResultSet rs = ps.executeQuery();
			
			if (!rs.next()) {
				return result;
			} else {
				int j = 0;
				if(rs.getBoolean("activo")) {
					ids[j] = rs.getInt("id_empleado");
					j++;
				}
				while(rs.next()) {
					if(rs.getBoolean("activo")) {
						ids[j] = rs.getInt("id_empleado");
						j++;					}	
				}
				
				if(j != 0) {
					
					for(int i = 0; i < j; i++) {
						
						PreparedStatement ps1 = con.prepareStatement("SELECT * FROM empleados WHERE id_empleado = ?");
						
						ps1.setInt(1, ids[i]);
						ResultSet rs1 =  ps1.executeQuery();
						
						if(!rs1.next()) {
							//return result;
							System.out.println("Intentando listarIdEquipo - DAOEmpleado");
						} else {
							TEmpleado aux = new TEmpleado();
							
							aux.setActivo(rs1.getBoolean("activo"));
							if(aux.getActivo()) {
								aux.setIdEmpleado(rs1.getInt("id_empleado"));
								aux.setNombre(rs1.getString("nombre"));
								aux.setApellidos(rs1.getString("apellidos"));
								aux.setDNI(rs1.getString("DNI"));
								aux.setE_mail(rs1.getString("email"));
								aux.setTlfn(rs1.getInt("telefono"));
								aux.setSueldo(rs1.getDouble("sueldo"));
								
								result.add(aux);
							}
						}
					}										
				}							
				rs.close();
				ps.close();
				con.close();
				System.out.println("listarIdEquipo realizado - DAOEmpleado");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean pertenece(int id_empleado){
		System.out.println("Intentando pertenece - DAOEmpleado");
		boolean found = false;
		try {
			PreparedStatement ps;
			String sql = "select * from pertenece where id_empleado = ? and activo = true;";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, id_empleado);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				found = true;
			}else{
				found = false;
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Terminado pertenece - DAOEmpleado");
		return found;
	}
}











