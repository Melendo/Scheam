package Integracion.Equipo;

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

public class DAOEquipo implements IDAOEquipo {
	
	Connection con;
	
	public DAOEquipo() {
		System.out.println("Intentando Conexión - DAOEquipo");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheam", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Conexión Realizada - DAOEquipo");
	}
	
	@Override
	public Integer create(TEquipo equipo) {
		
		System.out.println("Intentando create - DAOEquipo");
		try {
			PreparedStatement ps;
			String sql;
			
			if(equipo instanceof TEquipoDesarrollo){
				sql = "INSERT INTO equipos (nombre, tecnologia, activo) VALUES (?,?,?);";
				ps = con.prepareStatement(sql);
				ps.setString(1, equipo.getNombre());
				ps.setString(2, ((TEquipoDesarrollo) equipo).getTecnologia());
				ps.setBoolean(3, true);
				ps.executeUpdate();
				ps.close();
			} else if (equipo instanceof TEquipoDisenio) {
				sql = "INSERT INTO equipos (nombre, campo_disenio, activo) VALUES (?,?,?);";
				ps = con.prepareStatement(sql);
				ps.setString(1, equipo.getNombre());
				ps.setString(2, ((TEquipoDisenio) equipo).getCampoDisenio());
				ps.setBoolean(3, true);
				ps.executeUpdate();
				ps.close();
			}
			con.close();
			System.out.println("Create Realizado - DAOEquipo");
		} catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
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