package Integracion.Producto;

import Negocio.Empleado.TEmpleado;
import Negocio.Producto.TProducto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class DAOProducto implements IDAOProducto {

	Connection con;
	
	public DAOProducto() {
		System.out.println("Intentando Conexión - DAOProducto");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheam", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Conexión Realizada - DAOProducto");
	}
	
	public Integer create(TProducto producto) {
		System.out.println("Intentando create - DAOProducto");
		try {
			Statement stmt = con.createStatement();
			PreparedStatement ps;
			String sql = "INSERT INTO productos (nombre, fechalanzamiento, precio, genero, PEGI, terminado, activo, stock) VALUES (?,?,?,?,?,?,?,?);";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, producto.getNombre());
			ps.setInt(2, producto.getFechalanzamiento());
			ps.setDouble(3, producto.getPrecio());
			ps.setString(4, producto.getGenero());
			ps.setInt(5, producto.getPEGI());
			ps.setBoolean(6, producto.getTerminado()); //
			ps.setBoolean(7, true); //activo
			ps.setInt(8, producto.getStock());

			ps.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Create Realizado - DAOProducto");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;

		
		
		
	}

	public Integer delete(Integer idproducto) {
		System.out.println("Intentando Delete - DAOProducto");
		try {
			Statement stmt = con.createStatement();
			PreparedStatement ps;
			String sql = "UPDATE productos set activo = false where id_producto = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idproducto);
			ps.executeUpdate();
			
			ps.close();
			stmt.close();
			con.close();
			System.out.println("Delete Realizado - DAOProducto");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public Integer modify(TProducto producto) {
		System.out.println("Intentando modify - DAOProducto");
		try {
			Statement stmt = con.createStatement();
			PreparedStatement ps;
			String sql = "UPDATE productos set nombre = ?,  fechalanzamiento = ?, precio = ?, genero = ?, PEGI = ?, terminado = ?, activo = ?, stock = ? where id_empleado = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, producto.getNombre());
			ps.setInt(2, producto.getFechalanzamiento());
			ps.setDouble(3, producto.getPrecio());
			ps.setString(4, producto.getGenero());
			ps.setInt(5, producto.getPEGI());
			ps.setBoolean(6, producto.getTerminado()); //
			ps.setBoolean(7, true); //activo
			ps.setInt(8, producto.getStock());

			ps.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Modify Realizado - DAOProducto");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public Set<TProducto> readAll() {
		System.out.println("Intentando readAll - DAOProducto");
		Set<TProducto> result = new HashSet<TProducto>();
		TProducto aux;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM productos WHERE activo");
			ResultSet rs = ps.executeQuery();
			
			if (!rs.next()) {
				return result;
			} else {
				aux = new TProducto();
				aux.setFechalanzamiento(rs.getInt("fechalanzamiento"));
				aux.setGenero(rs.getString("genero"));
				aux.setIdproyecto(rs.getInt("id_proyecto"));
				aux.setNombre(rs.getString("nombre"));
				aux.setPEGI(rs.getInt("PEGI"));
				aux.setPrecio(rs.getDouble("precio"));
				aux.setStock(rs.getInt("stock"));
				aux.setTerminado(rs.getBoolean("terminado"));
				result.add(aux);
				while (rs.next()) {
					aux = new TProducto();
					aux.setFechalanzamiento(rs.getInt("fechalanzamiento"));
					aux.setGenero(rs.getString("genero"));
					aux.setIdproyecto(rs.getInt("id_proyecto"));
					aux.setNombre(rs.getString("nombre"));
					aux.setPEGI(rs.getInt("PEGI"));
					aux.setPrecio(rs.getDouble("precio"));
					aux.setStock(rs.getInt("stock"));
					aux.setTerminado(rs.getBoolean("terminado"));
					result.add(aux);
				}
				rs.close();
				ps.close();
				con.close();
				System.out.println("Readall realizado - DAOProducto");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public TProducto readById(Integer idproducto) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer cerrarProducto(Integer idproducto) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}