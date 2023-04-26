package Integracion.Producto;

import Negocio.Producto.TProducto;
import java.util.Set;

public interface IDAOProducto {

	public Integer create(TProducto producto);
	public Integer delete(Integer idproducto);
	public Integer modify(TProducto producto);
	public Set<TProducto> readAll();
	public TProducto readById(Integer idproducto);
	public Integer cerrarProducto(Integer idproducto);
}