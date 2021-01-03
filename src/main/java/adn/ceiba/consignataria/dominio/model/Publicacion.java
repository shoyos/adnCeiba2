package adn.ceiba.consignataria.dominio.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Publicacion {
	
	private int id;
	
	private @Setter int  idTipoPublicacion;
	
	private @Setter String idAutomovil;
	
	private @Setter LocalDate fechaInicio;
	
	private @Setter LocalDate fechaFinal;
	
	private @Setter int precioPublicacion;
	

}
