package adn.ceiba.consignataria.infraestructura.persistencia.entidad;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Automoviles")
public class AutomovilEntity {
	@Id
	private String placa;
	
	@Column(name = "numeromotor")
	private String numeroMotor;
	
	@Column(name = "kilometraje")
	private int kilometraje;
	
	@Column(name = "cilindraje")
	private int cilindraje;
	
	@Column(name = "fechavencimientosoat")
	private LocalDate fechaVencimientoSoat;
	
	@Column(name = "modelo")
	private int modelo;
	
	@Column(name = "valorventa")
	private int valorVenta;

	@Column(name = "valorventacalculado")
	private int valorVentaCalculado;
	


}
