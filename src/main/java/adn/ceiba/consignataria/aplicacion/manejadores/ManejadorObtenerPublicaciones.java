package adn.ceiba.consignataria.aplicacion.manejadores;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.aplicacion.comando.ComandoPublicacion;
import adn.ceiba.consignataria.dominio.repositorio.RepositorioPublicacion;

@Component
public class ManejadorObtenerPublicaciones {
	
	private final RepositorioPublicacion repositorioPublicacion;

	
	public ManejadorObtenerPublicaciones(  RepositorioPublicacion repositorioPublicacion) {
		this.repositorioPublicacion = repositorioPublicacion;
	}
	
	@Transactional
	public List<ComandoPublicacion> ejecutar() {
		
		return this.repositorioPublicacion.obtenerTodos();
	}

}
