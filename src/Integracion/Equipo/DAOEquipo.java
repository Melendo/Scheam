package Integracion.Equipo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Negocio.TVinculacion;
import Negocio.Cliente.TCliente;
import Negocio.Cliente.TDistribuidor;
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
		System.out.println("Intentando readAll - DAOEquipo");
		Set<TEquipo> result = new HashSet<TEquipo>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM equipo WHERE activo");
			PreparedStatement psdes = con.prepareStatement("SELECT * FROM equipodesarrollo");
			PreparedStatement psdis = con.prepareStatement("SELECT * FROM equipodisenyo");
			ResultSet rs = ps.executeQuery();
			ResultSet rsdes = psdes.executeQuery();
			ResultSet rsdis = psdis.executeQuery();
			List<Integer> iddes = new ArrayList<Integer>();
			List<TEquipoDesarrollo> eDes = new ArrayList<TEquipoDesarrollo>();
			List<Integer> iddis = new ArrayList<Integer>();
			List<TEquipoDisenio> eDis = new ArrayList<TEquipoDisenio>();

			while (rsdes.next()) { //getting all ids in EquipoDesarrollo table
				iddes.add(rsdes.getInt("ID"));
				TEquipoDesarrollo eDesAux = new TEquipoDesarrollo();
				eDesAux.setIdEquipo(rsdes.getInt("ID_EQUIPO"));
				eDesAux.setTecnologia(rsdes.getString("TECNOLOGIA"));
				eDes.add(eDesAux);
			}
			
			while (rsdis.next()) { //getting all ids in EquipoDisenio table
				iddis.add(rsdis.getInt("ID"));
				TEquipoDisenio eDisAux = new TEquipoDisenio();
				eDisAux.setIdEquipo(rsdis.getInt("ID_EQUIPO"));
				eDisAux.setCampoDisenio(rsdes.getString("CAMPO_DISENYO"));
				eDis.add(eDisAux);
			}
			
			if (!rs.next()) {
				return result;
			} else {
				if (iddes.contains(rs.getInt("ID_EQUIPO"))) {
					TEquipoDesarrollo auxEDes = new TEquipoDesarrollo();
					auxEDes.setIdEquipo(rs.getInt("ID_EQUIPO"));
					auxEDes.setNombre(rs.getString("NOMBRE"));
					auxEDes.setTecnologia(rs.getString("TECNOLOGIA"));
					result.add(auxEDes);
				} else if (iddis.contains(rs.getInt("id_cliente"))) {
					TEquipoDisenio auxEDis = new TEquipoDisenio();
					auxEDis.setIdEquipo(rs.getInt("ID_EQUIPO"));
					auxEDis.setNombre(rs.getString("nombre"));
					auxEDis.setCampoDisenio(rs.getString("TECNOLOGIA"));
					result.add(auxEDis);
				}
				
				while (rs.next()) {
					if (iddes.contains(rs.getInt("id_cliente"))) {
						TEquipoDesarrollo auxEDes = new TEquipoDesarrollo();
						auxEDes.setIdEquipo(rs.getInt("ID_EQUIPO"));
						auxEDes.setNombre(rs.getString("NOMBRE"));
						auxEDes.setTecnologia(rs.getString("TECNOLOGIA"));
						result.add(auxEDes);
					} else if (iddis.contains(rs.getInt("id_cliente"))) {
						TEquipoDisenio auxEDis = new TEquipoDisenio();
						auxEDis.setIdEquipo(rs.getInt("ID_EQUIPO"));
						auxEDis.setNombre(rs.getString("nombre"));
						auxEDis.setCampoDisenio(rs.getString("TECNOLOGIA"));
						result.add(auxEDis);
					}
				}
				rs.close();
				ps.close();
				con.close();
			}
			System.out.println("Readall realizado - DAOEquipo");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
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

	public Integer anyadirIntegrante(TVinculacion pert) {
		
		System.out.println("Intentando añadirIntegrante - DAOEquipo");
		if(pert.isActivo()){
			try {
				PreparedStatement ps;
							
				String sql = "INSERT INTO pertenece (ID_equipo, ID_empleado, activo) VALUES (?,?,?);";
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, pert.getId_1());
				ps.setInt(2, pert.getId_2());
				ps.setBoolean(3, pert.isActivo());
	
				ps.executeUpdate();
				
				ps.close();
				con.close();
				
				System.out.println("añadirIntegrante Realizado - DAOEquipo");
	
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}
		}else{
			try {
				PreparedStatement ps;
							
				String sql = "UPDATE pertenece SET activo = true where ID_equipo = ? and ID_empleado = ?;";
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, pert.getId_1());
				ps.setInt(2, pert.getId_2());
	
				ps.executeUpdate();
				
				ps.close();
				con.close();
				
				System.out.println("añadirIntegrante Realizado - DAOEquipo");
	
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}
		}
		return 1;
	}

	public Integer bajaIntegrante(TVinculacion pert) {
		System.out.println("Intentando bajaIntegrante - DAOEquipo");
		try {
			PreparedStatement ps;
						
			String sql = "UPDATE pertenece set activo = false where ID_equipo = ? and ID_empleado = ?;";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, pert.getId_1());
			ps.setInt(2, pert.getId_2());

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
	
	public TVinculacion pertenece(Integer idempleado, Integer idequipo) {
				
		System.out.println("Intentando pertenece - DAOEquipo");
		TVinculacion tvin = new TVinculacion();

		try {
			
			PreparedStatement ps;						
			String sql = "select * from pertenece where ID_equipo = ? and ID_empleado = ?;";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, idequipo);
			ps.setInt(2, idempleado);

			ResultSet rs = 	ps.executeQuery();
			
			if(!rs.next()){ 			
				tvin.setId_1(-1);
			}
			else{
				tvin.setId_1(rs.getInt("id_equipo"));
				tvin.setId_2(rs.getInt("id_empleado"));
				tvin.setActivo(rs.getBoolean("activo"));
			}
			ps.close();
			con.close();
			
			System.out.println("pertenece Realizado - DAOEquipo");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tvin;
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