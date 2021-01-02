package adn.ceiba.consignataria.dominio.servicio;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.dominio.model.Publicacion;
import adn.ceiba.consignataria.dominio.repositorio.RepositorioPublicacion;

@Component
public class ServicioCrearPublicacion {
	
	private final RepositorioPublicacion repositorioPublicacion;
    private final static int PRECIOPUBLICACION = 15000;
    private final static int COSTOEXTRA = 15000; 

	public ServicioCrearPublicacion(RepositorioPublicacion repositorioPublicacion) {
		this.repositorioPublicacion = repositorioPublicacion;
	}
	
    private boolean esPublicacionEstandar = false;
	
	public void ejecutar(Publicacion publicacion) {
		System.out.println("Entro ejecutar publicacion");
		publicacion.setFechaFinal(calcularFechaFinPublicacion(publicacion.getFechaInicio(), publicacion.getIdTipoPublicacion() ));
		if(this.esPublicacionEstandar) {
			publicacion.setPrecioPublicacion(PRECIOPUBLICACION );
		} else publicacion.setPrecioPublicacion(PRECIOPUBLICACION + COSTOEXTRA );
		
		repositorioPublicacion.crear(publicacion);
				
	}
	
	public LocalDate calcularFechaFinPublicacion(LocalDate fechaInicio, int idTipoPublicacion) {
		LocalDate fechaFinPublicacion = fechaInicio;
		if (idTipoPublicacion == 1) {
			this.esPublicacionEstandar = true;
			 fechaFinPublicacion = fechaInicio.plusDays(15);
		} else if (idTipoPublicacion == 2) {
			fechaFinPublicacion = fechaInicio.plusDays(30);
		}
		
		return fechaFinPublicacion;
	}
	

		
}
