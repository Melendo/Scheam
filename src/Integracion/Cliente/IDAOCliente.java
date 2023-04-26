package Integracion.Cliente;

import Negocio.Cliente.TCliente;
import Negocio.Cliente.TDistribuidor;
import Negocio.Cliente.TParticular;

import java.util.Set;

public interface IDAOCliente {

	public Integer create(TDistribuidor distribuidor);
	public Integer create(TParticular particular);
	
	public Integer delete(Integer idcliente);
	
	public Integer modify(TDistribuidor distribuidor);
	public Integer modify(TParticular particular);
	
	public Set<TCliente> mostrarClientes();

	public TCliente mostrarClienteID(Integer idcliente);
}