package adn.ceiba.consignataria.aplicacion.comando;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ComandoAutomovil {
	private String placa;
	private String numeroMotor;
	private int kilometraje;
	private int cilindraje;
	private LocalDate fechaVencimientoSoat;
	private int idTipoPublicacion;
	private int modelo;
	private int valorVenta;
	private LocalDate fechaInicio;
	
	
}

