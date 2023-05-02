package Integracion.Cliente;

import java.util.Set;

import Negocio.Cliente.TCliente;

public interface IDAOCliente {

	public Integer create(TCliente cliente);

	public Integer delete(Integer idcliente);

	public Integer modify(TCliente cliente);

	public Set<TCliente> readAll();

	public TCliente readByID(Integer idcliente);
}