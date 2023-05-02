package Presentacion.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import Negocio.Cliente.TDistribuidor;

public class DistribuidorTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	String[] header = {"ID", "Nombre", "Email", "CIF", "Direccion"};
	List<TDistribuidor> distribuidores;
	
	public DistribuidorTableModel() {
		distribuidores = new ArrayList<TDistribuidor>();
	}
	
	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	@Override
	public int getRowCount() {
		return distribuidores.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return distribuidores.get(rowIndex).getID();
		case 1:
			return distribuidores.get(rowIndex).getNombre();
		case 2:
			return distribuidores.get(rowIndex).getEmail();
		case 3:
			return distribuidores.get(rowIndex).getCIF();
		case 4:
			return distribuidores.get(rowIndex).getDireccion();
		default:
			return null;
		}
	}

	public void setLista(Set<TDistribuidor> lista) {
		if (lista != null) 
			distribuidores.addAll(lista);
	}	
}
