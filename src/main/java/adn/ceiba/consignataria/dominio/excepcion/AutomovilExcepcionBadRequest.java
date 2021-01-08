package adn.ceiba.consignataria.dominio.excepcion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomovilExcepcionBadRequest extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AutomovilExcepcionBadRequest(String message) {
		super(message);
	}

}
