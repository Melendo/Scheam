package Presentacion.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import Negocio.Cliente.TParticular;

public class ParticularModel extends AbstractTableModel{

	String[] header = {"ID", "Nombre", "Email", "DNI", "telefono"};
	List<TParticular> particulares;
	
	public ParticularModel() {
		particulares = new ArrayList<TParticular>();
	}
	
	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	@Override
	public int getRowCount() {
		return particulares.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return particulares.get(rowIndex).getID();
		case 1:
			return particulares.get(rowIndex).getNombre();
		case 2:
			return particulares.get(rowIndex).getEmail();
		case 3:
			return particulares.get(rowIndex).getDNI();
		case 4:
			return particulares.get(rowIndex).getTelefono();
		default:
			return null;
		}
	}

	public void setLista(Set<TParticular> lista) {
		if (lista != null) 
			particulares.addAll(lista);
	}

}
