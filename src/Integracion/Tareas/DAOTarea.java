package Integracion.Tareas;

import Negocio.Tareas.TTarea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;
import Negocio.Producto.TProducto;

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
			ps.setBoolean(4, tarea.getTerminada());
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
			String sql = "UPDATE tareas set activo = false where id_tarea = ?";
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

	/** 
	* (non-Javadoc)
	* @see IDAOTarea#modify(TTarea tarea)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer modify(TTarea tarea) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see IDAOTarea#readAll()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set readAll() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see IDAOTarea#readById(Integer idtarea)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TTarea readById(Integer idtarea) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see IDAOTarea#listarIdEquipo(Integer idtarea)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set listarIdEquipo(Integer idtarea) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see IDAOTarea#listarIdProducto(Integer idtarea)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TProducto listarIdProducto(Integer idtarea) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see IDAOTarea#closeTask(Integer idtarea)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer closeTask(Integer idtarea) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}