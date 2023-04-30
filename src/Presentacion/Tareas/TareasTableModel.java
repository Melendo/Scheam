package Presentacion.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import Negocio.Producto.TProducto;
import Negocio.Tareas.TTarea;
public class TareasTableModel extends AbstractTableModel{

	String[] header = {"ID", "Nombre", "Equipo", "Producto", "Terminada"};
	List<TTarea> tareas;
	
	public TareasTableModel() {
		tareas = new ArrayList<>();
	}
	
	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	
	@Override
	public int getRowCount() {
		return tareas.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0://"ID", "Nombre", "Equipo", "Producto", "Terminado
			return tareas.get(rowIndex).getIdTarea();
		case 1:
			return tareas.get(rowIndex).getNombre();
		case 2:
			return tareas.get(rowIndex).getEquipo();
		case 3:
			return tareas.get(rowIndex).getProducto();
		case 4:
			return tareas.get(rowIndex).getTerminada();
		default:
			return null;
		}
	}
	
	public void setLista(Set<TTarea> lista) {
		if (lista != null) 
			tareas.addAll(lista);
	}
	

}

