package Integracion.Producto;

import java.util.Set;

import Negocio.Producto.TProducto;

public interface IDAOProducto {

	public Integer create(TProducto producto);

	public Integer delete(Integer idproducto);

	public Integer modify(TProducto producto);

	public Set<TProducto> readAll();

	public TProducto readById(Integer idproducto);

	public TProducto readByNombre(String nombre); // anadida

	public Integer cerrarProducto(Integer idproducto);
}