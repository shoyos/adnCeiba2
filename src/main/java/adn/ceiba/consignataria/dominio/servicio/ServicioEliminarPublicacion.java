package adn.ceiba.consignataria.dominio.servicio;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.model.Publicacion;
import adn.ceiba.consignataria.dominio.repositorio.RepositorioAutomovil;
import adn.ceiba.consignataria.dominio.repositorio.RepositorioPublicacion;

@Component
public class ServicioEliminarPublicacion {
	
	private final RepositorioPublicacion repositorioPublicacion;
	private final RepositorioAutomovil repositorioAutomovil;


	public ServicioEliminarPublicacion(RepositorioPublicacion repositorioPublicacion, 
			RepositorioAutomovil repositorioAutomovil) {
		
		this.repositorioPublicacion = repositorioPublicacion;
		this.repositorioAutomovil = repositorioAutomovil;
	}
	
	public void ejecutar (int idPublicacion) {
		Publicacion publicacion = repositorioPublicacion.obtenerPublicacionById(idPublicacion);
		//Automovil automovil = repositorioAutomovil.obtenerAutomovilById(publicacion.getIdAutomovil());
		//publicacion.setAutomovil(null);
		repositorioAutomovil.eliminar(publicacion.getIdAutomovil());
		repositorioPublicacion.eliminar(idPublicacion);
		
	}
	
	
	
	

}
