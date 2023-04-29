package Integracion.Equipo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import Negocio.Empleado.TEmpleado;
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
						
			String sql = "UPDATE equipo set nombre = ? where id_empleado = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, equipo.getNombre());
			ps.setInt(8, equipo.getIdEquipo());
			
			ps.executeUpdate();

			
			if (equipo instanceof TEquipoDesarrollo) {
				sql = "UPDATE equipodesarrollo set tecnologia = ? WHERE id_equipo = ?";
				ps = con.prepareStatement(sql);
				
				ps.setString(1, ((TEquipoDesarrollo) equipo).getTecnologia());
				ps.setInt(2, equipo.getIdEquipo());
				ps.executeUpdate();

			}else if(equipo instanceof TEquipoDisenio) {
				sql = "UPDATE equipodisenño set campo_diseño = ? WHERE id_equipo = ?";
				ps = con.prepareStatement(sql);
				
				ps.setString(1, ((TEquipoDisenio) equipo).getCampoDisenio());
				ps.setInt(2, equipo.getIdEquipo());
				ps.executeUpdate();

			}

			
			ps.close();
			con.close();
			
			System.out.println("Modify Realizado - DAOEquipo");

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
		System.out.println("Intentando readByID - DAOEquipo");
		TEquipo result = new TEquipo();


		
		try {
			PreparedStatement ps = con.prepareStatement("select * from equipo where id_empleado = ?");
			ps.setInt(1, idequipo);
			
			ResultSet rs = ps.executeQuery();
			
			if (!rs.next())
				result.setIdEquipo(-1);
			else {
				
				result.setIdEquipo(rs.getInt("id_equipo"));
				result.setNombre(rs.getString("nombre"));
				
				ps = con.prepareStatement("select * from equipodesarrollo where id_empleado = ?");
				ps.setInt(1, idequipo);
				
				rs = ps.executeQuery();
				if(!rs.next()) {
					ps = con.prepareStatement("select * from equipodiseño where id_empleado = ?");
					ps.setInt(1, idequipo);
					
					rs = ps.executeQuery();
					TEquipoDisenio eqdi = new TEquipoDisenio(); 

					
					eqdi.setIdEquipo(result.getIdEquipo());
					eqdi.setNombre(result.getNombre());
					eqdi.setActivo(true);
					eqdi.setCampoDisenio(rs.getString("campo_diseño"));
					
					rs.close();
					ps.close();
					con.close();
					
					System.out.println("ReadybyID realizado - DAOEquipo");
					return eqdi;
				}else {
					TEquipoDesarrollo eqde = new TEquipoDesarrollo(); 

					eqde.setIdEquipo(result.getIdEquipo());
					eqde.setNombre(result.getNombre());
					eqde.setActivo(true);
					eqde.setTecnologia(rs.getString("tecnologia"));
					
					rs.close();
					ps.close();
					con.close();
					
					System.out.println("ReadybyID realizado - DAOEquipo");
					return eqde;
				}
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ReadybyID realizado - DAOEquipo");
		return result;
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
		System.out.println("Intentando readByID - DAOEquipo");
		TEquipo result = new TEquipo();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from equipo where nombre = ?");
			ps.setString(1, nombre);
			
			ResultSet rs = ps.executeQuery();
			
			if (!rs.next())
				result.setIdEquipo(-1);
			else {
				result.setIdEquipo(rs.getInt("id_quipo"));
				result.setNombre(rs.getString("nombre"));
				result.setActivo(rs.getBoolean("activo"));
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
		return result;
	}
	
	@Override
	public Integer empleadoEstaEnEquipo(Integer idempleado, Integer idequipo) {
		
		return null;
	}
		
}