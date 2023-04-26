package Integracion.Cliente;

import Negocio.Cliente.TCliente;
import Negocio.Cliente.TDistribuidor;
import Negocio.Cliente.TParticular;

import java.util.Set;

public interface IDAOCliente {

	public Integer create(TCliente cliente);
	
	public Integer delete(Integer idcliente);
	
	public Integer modify(TCliente cliente);
	
	public Set<TCliente> mostrarClientes();

	public TCliente mostrarClienteID(Integer idcliente);
}