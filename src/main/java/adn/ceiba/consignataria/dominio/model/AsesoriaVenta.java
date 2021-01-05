package adn.ceiba.consignataria.dominio.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AsesoriaVenta {
	
	private String idDocumentoAsesor;
	private LocalDate fecha;
	private String franjaHoraria;
	private String nombreCleinte;
	private String telefonoCliente;

}
