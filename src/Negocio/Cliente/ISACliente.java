/**
 * 
 */
package Negocio.Cliente;

import java.util.Set;

public interface ISACliente {

	public Integer altaCliente(TCliente cliente);

	public Integer bajaCliente(Integer IDcliente);

	public Integer modificarCliente(TCliente cliente);

	public TCliente mostrarClienteID(Integer IDcliente);

	public Set<TCliente> mostrarClientes();
}