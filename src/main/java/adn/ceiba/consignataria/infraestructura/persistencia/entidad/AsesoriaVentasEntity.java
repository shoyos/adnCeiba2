package adn.ceiba.consignataria.infraestructura.persistencia.entidad;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "asesoriaventas")
public class AsesoriaVentasEntity {

   @Id 
   @GeneratedValue( strategy=GenerationType.AUTO )
   private int id;
   
	@Column(name = "documento_asesor")
	private String idDocumentoAsesor;
	
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column(name = "franja_horaria")
	private String franjaHoraria;
	
	@Column(name = "nombre_cliente")
	private String nombreCliente;
	
	@Column(name = "telefono_cliente")
	private String telefonoCliente;
	
	
}
