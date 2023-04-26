package Integracion.Equipo;

import Negocio.Equipo.TEquipo;

import java.util.Set;

import com.mysql.jdbc.ResultSet;

public class DAOEquipo implements IDAOEquipo {
	
	@Override
	public Integer create(TEquipo equipo) {
		
		System.out.println("Intentando create - DAOEmpleado");
		try {
			Statement stmt = con.createStatement();
			PreparedStatement ps;
			String sql = "INSERT INTO equipos (nombre, activo) VALUES (?,?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, equipo.getNombre());
			ps.setString(2, true);
			
			ps.executeUpdate();
			ps.close();
			
			sql = "select id_equipo from equipo where nombre = ?";
			ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			equipo.setIdEquipo(rs.getInt(id_equipo));
			
			if(equipo instanceof TEquipoDesarrollo){
				
			}
			else
			

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