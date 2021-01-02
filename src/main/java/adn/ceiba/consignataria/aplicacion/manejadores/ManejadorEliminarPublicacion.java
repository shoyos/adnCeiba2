package adn.ceiba.consignataria.aplicacion.manejadores;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.dominio.repositorio.RepositorioPublicacion;
import adn.ceiba.consignataria.dominio.servicio.ServicioEliminarPublicacion;

@Component
public class ManejadorEliminarPublicacion {
	
	
	private final ServicioEliminarPublicacion servicioEliminarPublicacion;

	
	public ManejadorEliminarPublicacion(ServicioEliminarPublicacion servicioEliminarPublicacion) {
		this.servicioEliminarPublicacion = servicioEliminarPublicacion;
	}


	@Transactional
	public void ejecutar(int idPublicacion ) {
		this.servicioEliminarPublicacion.ejecutar(idPublicacion);
	}
	
	

}
