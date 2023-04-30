package Presentacion.Cliente;

import javax.swing.table.AbstractTableModel;

import Negocio.Cliente.TCliente;
import Negocio.Cliente.TDistribuidor;
import Negocio.Cliente.TParticular;
import Negocio.Producto.TProducto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;



public class ClientesTableModel extends AbstractTableModel {

	String[] header = {"ID", "Nombre", "Email", "DNI", "telefono", "CIF", "Direccion"};
	List<TCliente> clientes;
	
	public ClientesTableModel() {
		clientes = new ArrayList<>();
	}	
	
	@Override
	public String getColumnName(int column) {
		return header[column];
	}
	
	@Override
	public int getRowCount() {
		return clientes.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0://"ID", "Nombre", "Email", "DNI", "telefono", "CIF", "Direccion"
			return clientes.get(rowIndex).getID();
		case 1:
			return clientes.get(rowIndex).getNombre();
		case 2:
			return clientes.get(rowIndex).getEmail();
		case 3:
			if(clientes instanceof TDistribuidor)
				return null;
			else if(clientes instanceof TParticular)
				return ((TParticular) clientes).getDNI();
		case 4:
			if(clientes instanceof TDistribuidor)
				return null;
			else if(clientes instanceof TParticular)
				return ((TParticular) clientes).getTelefono();
		case 5:
			if(clientes instanceof TDistribuidor)
				return ((TDistribuidor) clientes).getCIF();
			else if(clientes instanceof TParticular)
				return null;
		case 6:
			if(clientes instanceof TDistribuidor)
				return ((TDistribuidor) clientes).getDireccion();
			else if(clientes instanceof TParticular)
				return null;
		default:
			return null;
		}
	}
	
	public void setLista(Set<TCliente> lista) {
		if (lista != null) 
			clientes.addAll(lista);
	}
	
}
