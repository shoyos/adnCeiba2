package adn.ceiba.testDataBuilder;

import java.time.LocalDate;

import adn.ceiba.consignataria.dominio.model.Automovil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomovilTestDataBuilder {
	
	private static final String PLACA = "ABC123";
	private static final String NUMMOTOR = "1111";
	private static final int KILOMETRAJE = 20000;
	private static final int CILINDRAJE = 1200;
	//private static final int IDTIPOPUBLICACION = 1;
	private static final int MODELO = 2019;
	private static final LocalDate FECHAVENCIMIENTOSOAT = LocalDate.of(2021, 02, 05);
	//private static final LocalDate FECHAINICIO = LocalDate.of(2020, 12, 29);
	//private static final LocalDate FECHAFINAL = LocalDate.of(2020, 12, 29);
	private static final int VALORVENTA = 20000;
	private static final int VALORVENTACALCULADO = 0;
	
	private String placa;
	private String numeroMotor;
	private int kilometraje;
	private int cilindraje;
	private LocalDate fechaVencimientoSoat;
	//private int idTipoPublicacion;
	private int modelo;
	private int valorVenta;
	private int valorVentaCalculado;
	//private LocalDate fechaInicio;
	//private LocalDate fechaFinal;
	//private int precioPublicacion;
	
	public AutomovilTestDataBuilder() {
		this.placa = PLACA;
		this.numeroMotor = NUMMOTOR;
		this.kilometraje = KILOMETRAJE;
		this.cilindraje = CILINDRAJE;
		//this.idTipoPublicacion = IDTIPOPUBLICACION;
		this.modelo = MODELO;
		this.fechaVencimientoSoat = FECHAVENCIMIENTOSOAT;
		//this.fechaInicio = FECHAINICIO;
		//this.fechaFinal = FECHAINICIO;
		this.valorVenta = VALORVENTA;
		this.valorVentaCalculado = VALORVENTACALCULADO;
	}
	
	public AutomovilTestDataBuilder conPlaca(String placa) {
		this.placa= placa;
		return this;
	}
	
	public Automovil build() {
		return new Automovil(this.placa, this.numeroMotor, this.kilometraje, this.cilindraje, this.fechaVencimientoSoat,
			this.modelo, this.valorVenta, this.valorVentaCalculado );
	}
	
	
}
