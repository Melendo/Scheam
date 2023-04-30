package Presentacion.Cliente;

import javax.swing.table.AbstractTableModel;

import Negocio.Cliente.TCliente;
import Negocio.Cliente.TDistribuidor;
import Negocio.Cliente.TParticular;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;



public class ClientesTableModel extends AbstractTableModel {

	String[] headerDistribuidor = {"ID", "Nombre", "Email", "CIF", "Direccion"};
	String[] headerParticular = {"ID", "Nombre", "Email", "DNI", "telefono"};
	List<TCliente> clientes;
	List<TDistribuidor> distribuidores;
	List<TParticular> particulares;
	
	boolean esDistribuidor;
	
	public ClientesTableModel(boolean distribuidor) {
		clientes = new ArrayList<>();
		esDistribuidor = distribuidor;
	}	
	
	@Override
	public String getColumnName(int column) {
		if(esDistribuidor)
			return headerDistribuidor[column];
		else
			return headerParticular[column];
	}
	
	@Override
	public int getRowCount() {
		if(esDistribuidor)
			return distribuidores.size();
		else
			return particulares.size();
	}

	@Override
	public int getColumnCount() {
		if(esDistribuidor)
			return headerDistribuidor.length;
		else 
			return headerParticular.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0://"ID", "Nombre", "Email", "DNI/CIF", "telefono/Direccion"
			return clientes.get(rowIndex).getID();
		case 1:
			return clientes.get(rowIndex).getNombre();
		case 2:
			return clientes.get(rowIndex).getEmail();
		case 3:
			if(esDistribuidor)
				return ((TDistribuidor) clientes).getCIF();
			else 
				return ((TParticular) clientes).getDNI();
		case 4:
			if(esDistribuidor)
				return ((TDistribuidor) clientes).getDireccion();
			else if(clientes instanceof TParticular)
				return ((TParticular) clientes).getTelefono();
		default:
			return null;
		}
	}
	
	public void setLista(Set<TCliente> lista) {
		if (lista != null) 
			clientes.addAll(lista);
	}
	
}
