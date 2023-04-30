package Presentacion.Equipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import Negocio.Equipo.TEquipoDisenio;

public class EquipoDisenyoTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	
	String[] header = {"ID", "Nombre", "Campo"};
	List<TEquipoDisenio> equiposDis;
	
	public EquipoDisenyoTableModel () {
		equiposDis = new ArrayList<TEquipoDisenio>();
	}
	
	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	@Override
	public int getRowCount() {
		return equiposDis.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return equiposDis.get(rowIndex).getIdEquipo();
		case 1:
			return equiposDis.get(rowIndex).getNombre();
		case 2:
			return equiposDis.get(rowIndex).getCampoDisenio();
		default:
			return null;
		}
	}
	
	public void setLista(Set<TEquipoDisenio> lista) {
		if (lista != null) 
			equiposDis.addAll(lista);
	}
}
