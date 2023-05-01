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
		System.out.println("Intentando Conexion - DAOEquipo");
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
			String sql = "INSERT INTO equipo (nombre, activo) VALUES (?,?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, equipo.getNombre());
			ps.setBoolean(2, true);
			
			ps.executeUpdate();
			
			ps.close();
						
			equipo.setIdEquipo(readByNombre(equipo.getNombre()).getIdEquipo());
						
			if(equipo instanceof TEquipoDesarrollo){
				PreparedStatement ps1;

				sql = "INSERT INTO equipodesarrollo (ID_EQUIPO, TECNOLOGIA) VALUES (?,?);";
				ps1 = con.prepareStatement(sql);
				
				ps1.setInt(1, equipo.getIdEquipo());
				ps1.setString(2, ((TEquipoDesarrollo) equipo).getTecnologia());
				
				ps1.executeUpdate();
				
				ps1.close();
				
			} else if (equipo instanceof TEquipoDisenio) {
				
				PreparedStatement ps2;
				sql = "INSERT INTO equipodisenyo (ID_EQUIPO, CAMPO_DISEnyO) VALUES (?,?);";
				ps2 = con.prepareStatement(sql);
				
				ps2.setInt(1, equipo.getIdEquipo());
				ps2.setString(2, ((TEquipoDisenio) equipo).getCampoDisenio());
				
				ps2.executeUpdate();
				
				ps2.close();
			}
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
			String sql = "UPDATE equipo set activo = false where id_equipo = ?";
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
						
			String sql = "UPDATE equipo set nombre = ?, activo = ? where id_equipo = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, equipo.getNombre());
			ps.setBoolean(2, equipo.getActivo());
			ps.setInt(3, equipo.getIdEquipo());
			
			ps.executeUpdate();

			
			if (equipo instanceof TEquipoDesarrollo) {
				sql = "UPDATE equipodesarrollo set TECNOLOGIA = ? WHERE id_equipo = ?";
				ps = con.prepareStatement(sql);
				
				ps.setString(1, ((TEquipoDesarrollo) equipo).getTecnologia());
				ps.setInt(2, equipo.getIdEquipo());
				ps.executeUpdate();

				ps.close();
			}else {
				sql = "UPDATE equipodisenyo set CAMPO = ? WHERE id_equipo = ?";
				PreparedStatement ps1 = con.prepareStatement(sql);
				
				ps1.setString(1, ((TEquipoDisenio) equipo).getCampoDisenio());
				ps1.setInt(2, equipo.getIdEquipo());
				ps1.executeUpdate();
				
				ps1.close();
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
		
		return null;
	}

	public TEquipo readByID(Integer idequipo) {
		System.out.println("Intentando readByID - DAOEquipo");
		TEquipo result = new TEquipoDesarrollo();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from equipo where id_equipo = ?");
			ps.setInt(1, idequipo);
			
			ResultSet rs = ps.executeQuery();
			
			if (!rs.next()) {
				result.setIdEquipo(-1);
			}else {
				result.setIdEquipo(rs.getInt("id_equipo"));
				result.setNombre(rs.getString("nombre"));
				result.setActivo(rs.getBoolean("activo"));
				
				rs.close();
				ps.close();
				
				ps = con.prepareStatement("select tecnologia from equipodesarrollo where ID_EQUIPO = ?");
				ps.setInt(1, idequipo);				
				ResultSet rs1 = ps.executeQuery();
				
				if(!rs1.next()) {
					rs1.close();
					ps.close();
					
					ps = con.prepareStatement("select campo from equipodisenyo where ID_EQUIPO = ?");
					ps.setInt(1, idequipo);
					
					ResultSet rs2 = ps.executeQuery();
					if(!rs2.next()) {
						result.setIdEquipo(-1);
					}else {
					TEquipoDisenio eqdi = new TEquipoDisenio(); 
					
					eqdi.setIdEquipo(result.getIdEquipo());
					eqdi.setNombre(result.getNombre());
					eqdi.setActivo(result.getActivo());
					eqdi.setCampoDisenio(rs2.getString("CAMPO"));
					
					rs2.close();
					ps.close();
					con.close();
					
					return eqdi;
					}
				}else {
					TEquipoDesarrollo eqde = new TEquipoDesarrollo(); 
					
					eqde.setIdEquipo(result.getIdEquipo());
					eqde.setNombre(result.getNombre());
					eqde.setActivo(result.getActivo());
					eqde.setTecnologia(rs1.getString("TECNOLOGIA"));
					
					rs1.close();
					rs.close();
					ps.close();
					con.close();
										
					return eqde;
				}				
			}		
			rs.close();
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ReadybyID realizado (error) - DAOEquipo");
		return result;
	}

	public Integer anyadirIntegrante(Integer idempleado, Integer idequipo) {
		
		System.out.println("Intentando añadirIntegrante - DAOEquipo");
		try {
			PreparedStatement ps;
						
			String sql = "INSERT INTO pertenece (ID_equipo, ID_empleado, activo) VALUES (?,?,?);";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, idequipo);
			ps.setInt(2, idempleado);
			ps.setBoolean(3, true);

			ps.executeUpdate();
			
			ps.close();
			con.close();
			
			System.out.println("añadirIntegrante Realizado - DAOEquipo");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public Integer bajaIntegrante(Integer idempleado, Integer idequipo) {
		System.out.println("Intentando bajaIntegrante - DAOEquipo");
		try {
			PreparedStatement ps;
						
			String sql = "UPDATE pertenece set activo = false where ID_equipo = ? and ID_empleado = ?;";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, idequipo);
			ps.setInt(2, idempleado);

			ps.executeUpdate();
			
			ps.close();
			con.close();
			
			System.out.println("bajaIntegrante Realizado - DAOEquipo");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
	
	public boolean pertenece(Integer idempleado, Integer idequipo) {
		
		System.out.println("Intentando pertenece - DAOEquipo");
		boolean found;
		try {
			
			PreparedStatement ps;						
			String sql = "select * from equipo where ID_equipo = ? and ID_empleado = ?;";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, idequipo);
			ps.setInt(2, idempleado);

			ResultSet rs = 	ps.executeQuery();
			
			if(rs.next()) found = true;			
			else found = false;
		
			ps.close();
			con.close();
			
			System.out.println("pertenece Realizado - DAOEquipo");

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return found;
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
				result.setNombre("-1");
			else {
				result.setIdEquipo(rs.getInt("id_equipo"));
				result.setNombre(rs.getString("nombre"));
				result.setActivo(rs.getBoolean("activo"));
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
		return result;
	}
		
}