package Presentacion.Empleado;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Negocio.Empleado.TEmpleado;

public class EmpleadosTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] header = {"ID", "Nombre", "Apellidos", "DNI", "Email", "Telefono", "Sueldo"};
	List<TEmpleado> empleados;
	
	public EmpleadosTableModel () {
		empleados = new ArrayList<TEmpleado>();
	}
	
	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	@Override
	public int getRowCount() {
		return empleados.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return empleados.get(rowIndex).getIdEmpleado();
		case 1:
			return empleados.get(rowIndex).getNombre();
		case 2:
			return empleados.get(rowIndex).getApellidos();
		case 3:
			return empleados.get(rowIndex).getDNI();
		case 4:
			return empleados.get(rowIndex).getE_mail();
		case 5:
			return empleados.get(rowIndex).getTlfn();
		case 6:
			return empleados.get(rowIndex).getSueldo();
		default:
			return null;
		}
	}
	
	public void setLista(Set<TEmpleado> lista) {
		if (lista != null) 
			empleados.addAll(lista);
	}

}
