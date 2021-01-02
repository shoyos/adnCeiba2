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
	
	//private @Setter Automovil automovil;
	private @Setter String idAutomovil;
	
	private @Setter LocalDate fechaInicio;
	
	private @Setter LocalDate fechaFinal;
	
	private @Setter int precioPublicacion;
	
	/*
	public Publicacion(int id, int idTipoPublicacion, Automovil automovil, LocalDate fechaInicio, LocalDate fechafinal, int precioPublicacion ) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.idTipoPublicacion = idTipoPublicacion;
		this.automovil = automovil;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechafinal;
		this.precioPublicacion = precioPublicacion;
		
	}*/

}
