package Presentacion.Equipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import Negocio.Equipo.TEquipoDesarrollo;

public class EquipoDesarrolloTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	String[] header = {"ID", "Nombre", "Tecnologia"};
	List<TEquipoDesarrollo> equiposDes;
	
	public EquipoDesarrolloTableModel () {
		equiposDes = new ArrayList<TEquipoDesarrollo>();
	}
	
	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	@Override
	public int getRowCount() {
		return equiposDes.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return equiposDes.get(rowIndex).getIdEquipo();
		case 1:
			return equiposDes.get(rowIndex).getNombre();
		case 2:
			return equiposDes.get(rowIndex).getTecnologia();
		default:
			return null;
		}
	}
	
	public void setLista(Set<TEquipoDesarrollo> lista) {
		if (lista != null) 
			equiposDes.addAll(lista);
	}
}
