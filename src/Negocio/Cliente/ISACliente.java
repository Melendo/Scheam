/**
 * 
 */
package Negocio.Cliente;

import java.util.Set;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author 34601
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public interface ISACliente {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param cliente
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer altaCliente(TCliente cliente);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param IDcliente
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer bajaCliente(Integer IDcliente);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param cliente
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer modificarCliente(TCliente cliente);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param IDcliente
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TCliente mostrarClienteID(Integer IDcliente);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set mostrarClientes();
}