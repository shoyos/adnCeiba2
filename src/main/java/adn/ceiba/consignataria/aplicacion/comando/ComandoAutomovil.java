package adn.ceiba.consignataria.aplicacion.comando;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ComandoAutomovil {
	private String placa;
	private String numeroMotor;
	private int kilometraje;
	private int cilindraje;
	private LocalDate fechaVencimientoSoat;
	private int idTipoPublicacion;
	private int modelo;
	private int valorVenta;
	private int valorVentaCalculado;
	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	private int precioPublicacion;
	
	
	public ComandoAutomovil(String placa, String numeroMotor, int kilometraje, int cilindraje, LocalDate fechaVencimientoSoat,
			int idTipoPublicacion, int modelo, int valorVenta, LocalDate fechaInicio) {
		this.placa = placa;
		this.numeroMotor = numeroMotor;
		this.kilometraje = kilometraje;
		this.cilindraje = cilindraje;
		this.fechaVencimientoSoat = fechaVencimientoSoat;
		this.idTipoPublicacion = idTipoPublicacion;
		this.modelo = modelo;
		this.valorVenta = valorVenta;
		this.fechaInicio = fechaInicio;
	}
	
	
}

