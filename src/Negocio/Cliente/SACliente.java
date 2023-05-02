/**
 * 
 */
package Negocio.Cliente;

import java.util.Set;

import Integracion.Factorias.FactoriaDAOImp;

public class SACliente implements ISACliente {

	public Integer altaCliente(TCliente cliente) {
		System.out.println("Intentando altaEmpleado - SACliente");

		TCliente cli = FactoriaDAOImp.getInstance().getDaoCliente().readByEmail(cliente.getEmail());

		if (cli.getID() == -1) { // cli.getID().equals(-1)
			System.out.println("altaCliente Realizado (creado) - SACliente");
			return FactoriaDAOImp.getInstance().getDaoCliente().create(cliente);
		} else {
			if (cli.getActivo()) {
				System.out.println("altaCliente No Realizado (existe y activo) - SACliente");
				return -1;
			} else {
				cliente.setActivo(true);
				cliente.setID(cli.getID());
				System.out.println("altaCliente Realizado (reactivado) - SACliente");
				FactoriaDAOImp.getInstance().getDaoCliente().modify(cliente);
				return 2;
			}
		}
	}

	public Integer bajaCliente(Integer IDcliente) {
		System.out.println("Intentando bajaCliente - SACliente");
		TCliente cli = FactoriaDAOImp.getInstance().getDaoCliente().readByID(IDcliente);

		if (cli.getID() == -1) {
			System.out.println("bajaCliente No Realizado (no exite) - SACliente");
			return -1;
		}

		if (cli.getActivo()) {
			System.out.println("bajaCliente Realizado - SACliente");
			return FactoriaDAOImp.getInstance().getDaoCliente().delete(IDcliente);
		} else {
			System.out.println("bajaCliente No Realizado (ya dado de baja) - SACliente");
			return -2;
		}
	}

	public Integer modificarCliente(TCliente cliente) {
		TCliente cli = FactoriaDAOImp.getInstance().getDaoCliente().readByID(cliente.getID());
		if (cli.getID() == -1 || !cli.getActivo()) {
			System.out.println("modificarCliente no realizado (cliente no existe o esta inactivo)- SACliente");
			return -1;
		} else {
			if (cliente.getID() != null
					&& FactoriaDAOImp.getInstance().getDaoCliente().readByEmail(cliente.getEmail()).getID() != -1) { // mostrarClienteEmail(cliente.getID()).getID()
																														// !=
																														// -
				System.out
						.println("modificarCliente no realizado (cliente tiene un ID o Email coincidente)- SACliente");
				return -2;
			} else {
				if (cliente.getEmail() == null)
					cliente.setEmail(cli.getEmail());
				;
				if (cliente.getNombre() == null)
					cliente.setNombre(cli.getNombre());
				if (cliente.getActivo() == null)
					cliente.setActivo(cli.getActivo());

				if (cliente instanceof TDistribuidor) {
					if (((TDistribuidor) cliente).getDireccion() == null)
						((TDistribuidor) cliente).setDireccion(((TDistribuidor) cli).getDireccion());
					if (((TDistribuidor) cliente).getEmail() == null)
						((TDistribuidor) cliente).setEmail(((TDistribuidor) cli).getEmail());
				} else {
					if (((TParticular) cliente).getTelefono() == null)
						((TParticular) cliente).setTelefono(((TParticular) cli).getTelefono());
					if (((TParticular) cliente).getDNI() == null)
						((TParticular) cliente).setDNI(((TParticular) cli).getDNI());
				}
				System.out.println("modificarCliente Realizado - SACliente");
				return FactoriaDAOImp.getInstance().getDaoCliente().modify(cliente);
			}
		}
	}

	public TCliente mostrarClienteID(Integer IDcliente) {
		TCliente cli = FactoriaDAOImp.getInstance().getDaoCliente().readByID(IDcliente);
		if (cli.getID() != -1 && cli.getActivo()) {
			System.out.println("mostrarCliente Realizado - SACliente");
			return cli;
		} else {
			cli.setID(-1);
			System.out.println("mostrarCliente no Realizado - SACliente");
			return cli;
		}
	}

	public Set<TCliente> mostrarClientes() {
		Set<TCliente> lista = FactoriaDAOImp.getInstance().getDaoCliente().readAll();
		System.out.println("mostrarClientes Realizado - SACliente");
		return lista;
	}
}