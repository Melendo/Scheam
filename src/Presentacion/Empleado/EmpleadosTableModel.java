package Presentacion.Empleado;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Negocio.Empleado.TEmpleado;

public class EmpleadosTableModel extends AbstractTableModel {
	
	String[] header = {"ID", "Nombre", "Apellidos", "DNI", "Email", "Telefono", "Sueldo"};
	List<TEmpleado> empleados;
	
	public EmpleadosTableModel (List <TEmpleado> emp) {
		empleados = emp;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}

}
