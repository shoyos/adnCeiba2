package adn.ceiba.consignataria.aplicacion.comando;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComandoAsesoria {
	
	private String idDocumentoAsesor;
	private LocalDate fecha;
	private String franjaHoraria;
	private String nombreCliente;
	private String telefonoCliente;
	
	public ComandoAsesoria(String idDocumentoAsesor, LocalDate fecha, String franjaHoraria, 
			String nombreCliente,
			String telefonoCliente) {
		
		this.idDocumentoAsesor = idDocumentoAsesor;
		this.fecha = fecha;
		this.franjaHoraria = franjaHoraria;
		this.nombreCliente = nombreCliente;
		this.telefonoCliente = telefonoCliente;
	}
	
	


}
