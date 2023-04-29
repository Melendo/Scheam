package Presentacion.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import Negocio.Producto.TProducto;



public class ProductosTableModel extends AbstractTableModel{

	String[] header = {"ID", "Nombre", "FechaLanzamiento", "Precio", "Genero", "PEGI", "Terminado", "Stock"};
	List<TProducto> productos;
	
	public ProductosTableModel() {
		productos = new ArrayList<>();
	}
	
	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	
	@Override
	public int getRowCount() {
		return productos.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0://"ID", "Nombre", "FechaLanzamiento", "Precio", "Genero", "PEGI", "Terminado", "Stock"
			return productos.get(rowIndex).getIdproyecto();
		case 1:
			return productos.get(rowIndex).getNombre();
		case 2:
			return productos.get(rowIndex).getFechalanzamiento();
		case 3:
			return productos.get(rowIndex).getPrecio();
		case 4:
			return productos.get(rowIndex).getGenero();
		case 5:
			return productos.get(rowIndex).getPEGI();
		case 6:
			return productos.get(rowIndex).getTerminado();
		case 7:
			return productos.get(rowIndex).getStock();
		default:
			return null;
		}
	}
	
	public void setLista(Set<TProducto> lista) {
		if (lista != null) 
			productos.addAll(lista);
	}
	

}
