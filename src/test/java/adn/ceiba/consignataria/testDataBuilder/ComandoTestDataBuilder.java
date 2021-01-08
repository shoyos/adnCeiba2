package adn.ceiba.consignataria.testDataBuilder;

import java.time.LocalDate;

import adn.ceiba.consignataria.aplicacion.comando.ComandoPublicacion;

public class ComandoTestDataBuilder {
	private String placa;
	private String numeroMotor;
	private int kilometraje;
	private int cilindraje;
	private LocalDate fechaVencimientoSoat;
	private int modelo;
	private int valorVenta;
	private int valorVentaCalculado;
	// Propiedades de publicacion
	private int id;
	private int  idTipoPublicacion;
	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	private int precioPublicacion;
	
	public ComandoTestDataBuilder() {
		// TODO Auto-generated constructor stub
		this.placa = "AA123";
		this.numeroMotor = "12345";
		this.kilometraje = 20000;
		this.cilindraje = 1500;
		this.fechaVencimientoSoat = LocalDate.of(2020, 10, 21);
		this.modelo = 2019;
		this.valorVenta = 56000;
		this.id = 0;
		this.idTipoPublicacion = 1;
		this.fechaInicio = LocalDate.of(2020, 12, 29);
		this.fechaFinal = LocalDate.of(2020, 12, 29);
		this.precioPublicacion = 0;
	}
	
    public ComandoPublicacion build() {
        return new ComandoPublicacion(placa,numeroMotor, kilometraje,cilindraje, fechaVencimientoSoat,
        		modelo, valorVenta, idTipoPublicacion, id,  fechaInicio, fechaFinal, precioPublicacion);
    }

}
