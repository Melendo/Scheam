package Negocio.Producto;

import java.util.Set;

public interface ISAProducto {

	public Integer altaProducto(TProducto producto);

	public Integer bajaProducto(Integer IDProducto);

	public Integer modificarProducto(TProducto producto);

	public Set<TProducto> listarProductos();

	public TProducto mostrarProductoID(Integer IDProducto);

	public Integer cerrarProducto(Integer IDProducto);
}