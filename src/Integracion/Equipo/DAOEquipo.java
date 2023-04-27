package Integracion.Equipo;

import Negocio.Equipo.TEquipo;
import Negocio.Equipo.TEquipoDesarrollo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;


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
		
		System.out.println("Intentando create - DAOEmpleado");
		try {
 			
			PreparedStatement ps;
			String sql = "INSERT INTO equipos (nombre, activo) VALUES (?,?);";
			ps = con.prepareStatement(sql);
			ps=con.prepareStatement(sql);
			ps.setString(1, equipo.getNombre());
			ps.setBoolean(2, true);
			
			ps.executeUpdate();
			ps.close();
			
			sql = "select id_equipo from equipo where nombre = ?";
			ps = (PreparedStatement) con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			equipo.setIdEquipo(rs.getInt(1));
			
			if(equipo instanceof TEquipoDesarrollo){
				return null;
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}
			
		return null;
	}

	public Integer delete(Integer idequipo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer modify(TEquipo equipo) {
		// TODO Auto-generated method stub
		return null;
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