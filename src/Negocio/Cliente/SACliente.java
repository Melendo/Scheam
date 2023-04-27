/**
 * 
 */
package Negocio.Cliente;

import java.util.Set;

import Integracion.Factorias.FactoriaDAOImp;
import Negocio.Cliente.TCliente;

public class SACliente implements ISACliente {
	
	public Integer altaCliente(TCliente cliente) {
		System.out.println("Intentando altaEmpleado - SACliente");
		TCliente cli = FactoriaDAOImp.getInstance().getDaoCliente().mostrarClienteID(cliente.getID());

		if (cli.getID().equals("-1")) {
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
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer modificarCliente(TCliente cliente) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public TCliente mostrarClienteID(Integer IDcliente) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Set mostrarClientes() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}