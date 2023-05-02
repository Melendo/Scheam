package Presentacion.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import Negocio.Factura.TLineaFactura;

public class LineaFacturaTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] header = {"Producto", "Cantidad", "Precio"};
	List<TLineaFactura> lineas;
	
	public LineaFacturaTableModel () {
		lineas = new ArrayList<TLineaFactura>();
	}
	
	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	@Override
	public int getRowCount() {
		return lineas.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return lineas.get(rowIndex).getIdProducto();
		case 1:
			return lineas.get(rowIndex).getCantidad();
		case 2:
			return lineas.get(rowIndex).getPrecio();
		default:
			return null;
		}
	}
	
	public void setLista(Set<TLineaFactura> lista) {
		if (lista != null) 
			lineas.addAll(lista);
	}

}
