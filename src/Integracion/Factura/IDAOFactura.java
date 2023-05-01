/**
 * 
 */
package Integracion.Factura;

import Negocio.Factura.TFactura;
import java.util.Set;
import Negocio.Cliente.TCliente;


public interface IDAOFactura {

	public Integer create(TFactura factura);

	public Integer delete(Integer idfactura);

	public Integer modify(TFactura factura);

	public Set<TFactura> readAll();

	public TFactura readById(Integer idfactura);

	public Set<TFactura> listarFacturasIDCliente(Integer idcliente);
}