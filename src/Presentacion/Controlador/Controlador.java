
package Presentacion.Controlador;

public abstract class Controlador {

	private static Controlador instance;

	public static Controlador getInstance() {
		if (instance == null) instance = new ControladorImp();
		return instance;
	}

	public void update(int event, Object objeto) {}
}