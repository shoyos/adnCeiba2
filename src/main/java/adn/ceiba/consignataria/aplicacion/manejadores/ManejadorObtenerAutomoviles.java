package adn.ceiba.consignataria.aplicacion.manejadores;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.repositorio.RepositorioAutomovil;
import adn.ceiba.consignataria.dominio.servicio.ServicioObtenerAutomoviles;

@Component
public class ManejadorObtenerAutomoviles {
	
	private final ServicioObtenerAutomoviles servicioObtenerAutomoviles;
	private final RepositorioAutomovil repositorioAutomovil;

	
	public ManejadorObtenerAutomoviles( ServicioObtenerAutomoviles servicioObtenerAutomoviles, RepositorioAutomovil repositorioAutomovil) {
		// TODO Auto-generated constructor stub
		this.servicioObtenerAutomoviles = servicioObtenerAutomoviles;
		this.repositorioAutomovil = repositorioAutomovil;
	}
	/*
	@Transactional
	public List<Automovil> ejecutar() {
		List<Publicacion> listPublicaciones = repositorioAutomovil.obtenerAutomoviles();
		
		return this.servicioObtenerAutomoviles.ejecutar();
	}*/

}
