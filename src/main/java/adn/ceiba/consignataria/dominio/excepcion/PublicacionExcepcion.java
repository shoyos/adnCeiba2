package adn.ceiba.consignataria.dominio.excepcion;

public class PublicacionExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PublicacionExcepcion(String message) {
		super(message);
	}

}
