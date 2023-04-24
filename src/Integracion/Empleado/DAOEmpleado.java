package Integracion.Empleado;

import Negocio.Empleado.TEmpleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

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
		System.out.println("Conexión Realizada - DAOEmpleado");
	}

	public Integer create(TEmpleado empleado) {
		System.out.println("Intentando create - DAOEmpleado");
		try {
			Statement stmt = con.createStatement();
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
			stmt.close();
			con.close();
			System.out.println("Create Realizado - DAOEmpleado");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;

	}

	public Integer delete(Integer idempleado) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer modify(TEmpleado empleado) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Set<TEmpleado> readAll() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
	
	public TEmpleado readByDNI(String dni) {
		System.out.println("Intentando readByDNI - DAOEmpleado");
		TEmpleado result = new TEmpleado();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT DNI, activo FROM EMPLEADOS WHERE DNI = ?");
			ps.setString(1, dni);

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) 
				result.setDNI("-1");
			else  {
				result.setDNI(rs.getString(1));
				result.setActivo(rs.getBoolean(2));
			}
			
			rs.close();
			ps.close();
			System.out.println("ReadByDNI realizado - DAOEmpleado");

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
			else
				result.setIdEmpleado(rs.getInt(1));
			
			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ReadybyDNI realizado - DAOEmpleado");
		return result;
	}

	public Set<TEmpleado> listarIdEquipo(Integer idempleado) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}