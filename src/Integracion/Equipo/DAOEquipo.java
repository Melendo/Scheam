package Integracion.Equipo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import Negocio.Equipo.TEquipo;
import Negocio.Equipo.TEquipoDesarrollo;
import Negocio.Equipo.TEquipoDisenio;


public class DAOEquipo implements IDAOEquipo {	
	
	Connection con;

	public DAOEquipo() {
		System.out.println("Intentando Conexión - DAOEmpleado");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheam", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Conexión Realizada - DAOEmpleado");
	}

	@Override
	public Integer create(TEquipo equipo) {
		
		System.out.println("Intentando create - DAOEquipo");
		try {
			PreparedStatement ps;
			String sql = "INSERT INTO equipos (nombre, activo) VALUES (?,?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, equipo.getNombre());
			ps.setBoolean(2, true);
			
			ps.executeUpdate();
			
			sql = "select id_equipo from equipo where nombre = ?";
			ps = (PreparedStatement) con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			equipo.setIdEquipo(rs.getInt(1));

			rs.close();
						
			if(equipo instanceof TEquipoDesarrollo){
				sql = "INSERT INTO equipodesarrollo (id_equipo, nombre, tecnologia) VALUES (?,?,?);";
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, equipo.getIdEquipo());
				ps.setString(2, equipo.getNombre());
				ps.setString(3, ((TEquipoDesarrollo) equipo).getTecnologia());
				
				ps.executeUpdate();
			} else if (equipo instanceof TEquipoDisenio) {
				sql = "INSERT INTO equipodiseño (id_equipo, nombre, campo_disenio) VALUES (?,?,?);";
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, equipo.getIdEquipo());
				ps.setString(2, equipo.getNombre());				
				ps.setString(3, ((TEquipoDisenio) equipo).getCampoDisenio());
				
				ps.executeUpdate();
			}
			ps.close();
			con.close();	

		}catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}			
			System.out.println("Create Realizado - DAOEquipo");
		
		return 1;
	}

	public Integer delete(Integer idequipo) {
		System.out.println("Intentando Delete - DAOEquipo");
		try {
			Statement stmt = con.createStatement();
			PreparedStatement ps;
			String sql = "UPDATE equipos set activo = false where id_equipo = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idequipo);
			ps.executeUpdate();
			
			ps.close();
			stmt.close();
			con.close();
			System.out.println("Delete Realizado - DAOEquipo");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public Integer modify(TEquipo equipo) {
		System.out.println("Intentando Modify - DAOEquipo");
		try {
			PreparedStatement ps;
						
			String sql = "UPDATE equipo set nombre = ?,  apellidos = ?, dni = ?, email = ?, telefono = ?, sueldo = ?, activo = ? where id_empleado = ?";
			ps = con.prepareStatement(sql);
			
			if (equipo instanceof TEquipoDesarrollo) {
				sql = "UPDATE equipo set nombre = ?, tecnologia = ?, activo = ? WHERE id_equipo = ?";
			}
			
			/*ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellidos());
			ps.setString(3, empleado.getDNI());
			ps.setString(4, empleado.getE_mail());
			ps.setInt(5, empleado.getTlfn());
			ps.setDouble(6, empleado.getSueldo());
			ps.setBoolean(7, empleado.getActivo());
			ps.setInt(8, empleado.getIdEmpleado());*/
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

	public Set<TEquipo> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public TEquipo readByID(Integer idequipo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer anyadirIntegrante(Integer idempleado, Integer idequipo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer bajaIntegrante(Integer idempleado, Integer idequipo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<TEquipo> listarEquiposEmpleadoId(Integer idempleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TEquipo readByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
		
}