package adn.ceiba.consignataria.infraestructura.persistencia.entidad;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Publicaciones")
@NamedQuery(name = "Publicacion.findAll", query = "SELECT publicacion FROM Publicaciones publicacion")
public class PublicacionEntity {
	
   @Id 
   @GeneratedValue( strategy=GenerationType.AUTO )
   private int id;
	
	@Column(name = "idautomovil")
	private String idAutomovil;
	
	@Column(name = "idtipopublicacion")
	private int idTipoPublicacion;
	
	@Column(name = "fechainicio")
	private LocalDate fechaInicio;
	
	@Column(name = "fechafinal")
	private LocalDate fechafinal;
	
	@Column(name = "preciopublicacion")
	private int precioPublicacion;

}
