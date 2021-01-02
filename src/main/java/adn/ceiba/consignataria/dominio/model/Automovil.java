package adn.ceiba.consignataria.dominio.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


public class Automovil {
	
	@NonNull @Getter private String placa;
	private @Getter @Setter  String numeroMotor;
	private @Getter @Setter int kilometraje;
	private  @Getter@Setter int cilindraje;
	private @Getter @Setter LocalDate fechaVencimientoSoat;
	//private int idTipoPublicacion;
	private @Getter @Setter int modelo;
	private @Getter @Setter int valorVenta;
	private @Getter @Setter int valorVentaCalculado;
	//private LocalDate fechaInicio;
	//private LocalDate fechaFinal;
	//private int precioPublicacion;
	
	
	public Automovil(String placa, String numeroMotor, int kilometraje, int cilindraje, 
			LocalDate fechaVencimientoSoat,int modelo, int valorVenta, int valorVentaCalculado) {
		this.placa = placa;
		this.numeroMotor = numeroMotor;
		this.kilometraje = kilometraje;
		this.cilindraje = cilindraje;
		this.fechaVencimientoSoat = fechaVencimientoSoat;
		//this.idTipoPublicacion = idTipoPublicacion;
		this.modelo = modelo;
		this.valorVenta = valorVenta;
		this.valorVentaCalculado = valorVentaCalculado;
		/*
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.precioPublicacion = precioPublicacion;
		*/
	}
	
	
}