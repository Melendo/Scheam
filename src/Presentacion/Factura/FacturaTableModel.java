package Presentacion.Factura;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Negocio.Empleado.TEmpleado;
import Negocio.Factura.TFactura;
import Negocio.Factura.TLineaFactura;

public class FacturaTableModel extends AbstractTableModel {
	
	String[] header = {"ID", "ID_Cliente", "Fecha", "Importe"};
	List<TFactura> facturas;
	
	public FacturaTableModel () {
		facturas = new ArrayList<TFactura>();
	}
	
	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	@Override
	public int getRowCount() {
		return facturas.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return facturas.get(rowIndex).getIdFactura();
		case 1:
			return facturas.get(rowIndex).getIDCliente();
		case 2:
			return facturas.get(rowIndex).getFecha();
		case 3:
			return facturas.get(rowIndex).getImporte();
		default:
			return null;
		}
	}
	
	public void setLista(Set<TFactura> lista) {
		if (lista != null) 
			facturas.addAll(lista);
	}

}
