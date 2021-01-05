package adn.ceiba.testDataBuilder;

import java.time.LocalDate;

import adn.ceiba.consignataria.dominio.model.AsesoriaVenta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AsesoriaTestDataBuilder {
	
	private String idDocumentoAsesor;
	private LocalDate fecha;
	private String franjaHoraria;
	private String nombreCliente;
	private String telefonoCliente;
	
	public AsesoriaTestDataBuilder(){
		this.idDocumentoAsesor = "123";
		this.fecha = LocalDate.of(2021, 02, 05);
		this.franjaHoraria = "1-2";
		this.nombreCliente = "Hoyos";
		this.telefonoCliente = "123";
	}
	
	public AsesoriaTestDataBuilder conFecha(LocalDate fecha) {
		this.fecha = fecha;
		return this;
	}
	
	public AsesoriaVenta build() {
		return new AsesoriaVenta(this.idDocumentoAsesor, this.fecha, this.franjaHoraria, this.nombreCliente, this.telefonoCliente);
	}
	

}
