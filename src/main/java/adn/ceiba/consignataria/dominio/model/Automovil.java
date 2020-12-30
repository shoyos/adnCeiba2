package adn.ceiba.consignataria.dominio.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
public class Automovil {
	
	@NonNull private String placa;
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
	
	
	public Automovil(String placa, String numeroMotor, int kilometraje, int cilindraje, 
			LocalDate fechaVencimientoSoat, int idTipoPublicacion, int modelo, int valorVenta, int valorVentaCalculado,
			LocalDate fechaInicio, LocalDate fechaFinal, int precioPublicacion) {
		this.placa = placa;
		this.numeroMotor = numeroMotor;
		this.kilometraje = kilometraje;
		this.cilindraje = cilindraje;
		this.fechaVencimientoSoat = fechaVencimientoSoat;
		this.idTipoPublicacion = idTipoPublicacion;
		this.modelo = modelo;
		this.valorVenta = valorVenta;
		this.valorVentaCalculado = valorVentaCalculado;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.precioPublicacion = precioPublicacion;
	}
	
	
}