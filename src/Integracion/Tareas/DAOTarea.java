package Integracion.Tareas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import Negocio.Tareas.TTarea;

public class DAOTarea implements IDAOTarea {

	Connection con;

	public DAOTarea() {

		System.out.println("Intentando Conexión - DAOTarea");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheam", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Conexión Realizada - DAOTarea");

	}

	public Integer create(TTarea tarea) {

		System.out.println("Intentando create - DAOTarea");
		try {
			PreparedStatement ps;
			String sql = "INSERT INTO tarea (nombre, equipo, producto, terminada, activo) VALUES (?,?,?,?,?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, tarea.getNombre());
			ps.setInt(2, tarea.getEquipo());
			ps.setInt(3, tarea.getProducto());
			ps.setBoolean(4, false);
			ps.setBoolean(5, true);

			ps.executeUpdate();
			con.close();
			System.out.println("Create Realizado - DAOTarea");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;

	}

	public Integer delete(Integer idtarea) {
		System.out.println("Intentando Delete - DAOTarea");
		try {
			PreparedStatement ps;
			String sql = "UPDATE tarea set activo = false where id_tarea = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idtarea);
			ps.executeUpdate();

			ps.close();
			con.close();
			System.out.println("Delete Realizado - DAOTarea");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public Integer modify(TTarea tarea) {
		System.out.println("Intentando Modify - DAOTarea");
		try {
			PreparedStatement ps;

			String sql = "UPDATE tarea set nombre = ?,  equipo = ?, producto = ?, terminada = ?, activo = ? where id_tarea = ?";
			ps = con.prepareStatement(sql);

			ps.setString(1, tarea.getNombre());
			ps.setInt(2, tarea.getEquipo());
			ps.setInt(3, tarea.getProducto());
			ps.setBoolean(4, tarea.getTerminada());
			ps.setBoolean(5, tarea.getActivo());
			ps.setInt(6, tarea.getIdTarea());

			ps.executeUpdate();

			ps.close();
			con.close();

			System.out.println("Modify Realizado - DAOTarea");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public Set<TTarea> readAll() {
		System.out.println("Intentando readAll - DAOTarea");
		Set<TTarea> result = new HashSet<TTarea>();
		TTarea aux;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM tarea WHERE activo");
			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				return result;
			} else {
				aux = new TTarea();
				aux.setIdTarea(rs.getInt("id_tarea"));
				aux.setNombre(rs.getString("nombre"));
				aux.setEquipo(rs.getInt("equipo"));
				aux.setProducto(rs.getInt("producto"));
				aux.setTerminada(rs.getBoolean("terminada"));
				result.add(aux);
				while (rs.next()) {
					aux = new TTarea();
					aux.setIdTarea(rs.getInt("id_tarea"));
					aux.setNombre(rs.getString("nombre"));
					aux.setEquipo(rs.getInt("equipo"));
					aux.setProducto(rs.getInt("producto"));
					aux.setTerminada(rs.getBoolean("terminada"));
					result.add(aux);
				}
				rs.close();
				ps.close();
				con.close();
				System.out.println("Readall realizado - DAOTarea");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public TTarea readById(Integer idtarea) {
		System.out.println("Intentando readByDNI - DAOTarea");
		TTarea result = new TTarea();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM tarea WHERE id_tarea = ?");
			ps.setInt(1, idtarea);

			ResultSet rs = ps.executeQuery();

			if (!rs.next())
				result.setIdTarea(idtarea);
			else {
				result.setIdTarea(rs.getInt("id_tarea"));
				result.setNombre(rs.getString("nombre"));
				result.setEquipo(rs.getInt("equipo"));
				result.setProducto(rs.getInt("producto"));
				result.setTerminada(rs.getBoolean("terminada"));
				result.setActivo(rs.getBoolean("activo"));
			}

			rs.close();
			ps.close();
			con.close();
			System.out.println("ReadByDNI realizado - DAOTarea");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Set<TTarea> listarIdEquipo(Integer idEquipo) {
		System.out.println("Intentando listar tareas por equipo - DAOTarea");
		Set<TTarea> result = new HashSet<>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM tarea WHERE equipo = ? and activo = true");
			ps.setInt(1, idEquipo);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TTarea tarea = new TTarea();
				tarea.setIdTarea(rs.getInt("id_tarea"));
				tarea.setNombre(rs.getString("nombre"));
				tarea.setEquipo(rs.getInt("equipo"));
				tarea.setProducto(rs.getInt("producto"));
				tarea.setTerminada(rs.getBoolean("terminada"));
				tarea.setActivo(rs.getBoolean("activo"));
				result.add(tarea);
			}

			rs.close();
			ps.close();
			con.close();
			System.out.println("Listado de tareas por equipo realizado - DAOTarea");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * public TProducto listarIdProducto(Integer idtarea) { // begin-user-code //
	 * TODO Auto-generated method stub return null; // end-user-code }
	 */

	public Set<TTarea> listarIdProducto(Integer idProducto) {
		System.out.println("Intentando listar tareas por ID de producto - DAOTarea");
		Set<TTarea> result = new HashSet<>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM tarea WHERE producto = ? and activo = true");
			ps.setInt(1, idProducto);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TTarea tarea = new TTarea();
				tarea.setIdTarea(rs.getInt("id_tarea"));
				tarea.setNombre(rs.getString("nombre"));
				tarea.setEquipo(rs.getInt("equipo"));
				tarea.setProducto(rs.getInt("producto"));
				tarea.setTerminada(rs.getBoolean("terminada"));
				tarea.setActivo(rs.getBoolean("activo"));
				result.add(tarea);
			}

			rs.close();
			ps.close();
			con.close();
			System.out.println("Listado de tareas por ID de producto realizado - DAOTarea");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Integer closeTask(Integer idtarea) {
		System.out.println("Intentando Cerrar Tarea - DAOTarea");
		try {
			PreparedStatement ps;
			String sql = "UPDATE tareas set terminada = true where id_tarea = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idtarea);
			ps.executeUpdate();

			ps.close();
			con.close();
			System.out.println("Tarea Cerrada - DAOTarea");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public TTarea readByNombre(String nombre) {
		System.out.println("Intentando readByNombre - DAOTarea");
		TTarea result = new TTarea();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM tarea WHERE nombre = ?");
			ps.setString(1, nombre);

			ResultSet rs = ps.executeQuery();

			if (!rs.next())
				result.setIdTarea(-1);
			else {
				result.setIdTarea(rs.getInt("id_tarea"));
				result.setNombre(rs.getString("nombre"));
				result.setEquipo(rs.getInt("equipo"));
				result.setProducto(rs.getInt("producto"));
				result.setTerminada(rs.getBoolean("terminada"));
				result.setActivo(rs.getBoolean("activo"));
			}

			rs.close();
			ps.close();
			con.close();

			if (result.getIdTarea() == -1)
				System.out.println("readByNombre realizado (no encontró nombre) - DAOTarea");
			else
				System.out.println("readByNombre realizado (encontró nombre) - DAOTarea");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}