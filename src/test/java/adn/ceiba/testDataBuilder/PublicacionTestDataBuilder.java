package adn.ceiba.testDataBuilder;

import java.time.LocalDate;

import adn.ceiba.consignataria.dominio.model.Publicacion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicacionTestDataBuilder {

	private static final int ID = 0;
	private static final int IDTIPOPUBLICACION = 1;
	private static final String ID_AUTOMOVIL = "AA1";
	private static final LocalDate FECHAINICIO = LocalDate.of(2020, 12, 29);
	private static final LocalDate FECHAFINAL = LocalDate.of(2020, 12, 29);
	private static final int PRECIO_PUBLICACION = 15000;

	private int id;
	private int idTipoPublicacion;
	private String idAutomovil;
	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	private int precioPublicacion;
	
	public PublicacionTestDataBuilder() {
		
		this.id = ID;
		this.idTipoPublicacion = IDTIPOPUBLICACION;
		this.idAutomovil = ID_AUTOMOVIL;
		this.fechaInicio = FECHAINICIO;
		this.fechaFinal = FECHAFINAL;
		this.precioPublicacion = PRECIO_PUBLICACION;

	}
	
	public PublicacionTestDataBuilder conId(int id ) {
		this.id= id;
		return this;
	}
	
	public PublicacionTestDataBuilder conIdTipoPublicacion(int idTipoPublicacion ) {
		this.idTipoPublicacion= idTipoPublicacion;
		return this;
	}
	
	public PublicacionTestDataBuilder conFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio= fechaInicio;
		return this;
	}
	
	public PublicacionTestDataBuilder conFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal= fechaFinal;
		return this;
	}
	
	public PublicacionTestDataBuilder conPrecioPublicacion(int precioPublicacion ) {
		this.precioPublicacion= precioPublicacion;
		return this;
	}
	
	public Publicacion build() {
		return new Publicacion(this.id, this.idTipoPublicacion, this.idAutomovil, 
				this.fechaInicio, this.fechaFinal, this.precioPublicacion);
	}
}
