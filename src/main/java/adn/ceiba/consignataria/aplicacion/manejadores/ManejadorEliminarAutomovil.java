package adn.ceiba.consignataria.aplicacion.manejadores;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.aplicacion.comando.ComandoPublicacion;
import adn.ceiba.consignataria.aplicacion.fabrica.FabricaAutomovil;
import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.repositorio.RepositorioAutomovil;
import adn.ceiba.consignataria.dominio.servicio.ServicioCrearAutomovil;
import adn.ceiba.consignataria.dominio.servicio.ServicioEliminarAutomovil;

@Component
public class ManejadorEliminarAutomovil {
	
	//private final ServicioEliminarAutomovil servicioEliminarAutomovil;
	//private final FabricaAutomovil fabricaAutomovil;
	
	private final RepositorioAutomovil repositorioAutomovil;
	/*
	public ManejadorEliminarAutomovil( ServicioEliminarAutomovil servicioEliminarAutomovil, FabricaAutomovil fabricaAutomovil ) {
		// TODO Auto-generated constructor stub
		this.servicioEliminarAutomovil = servicioEliminarAutomovil;
		this.fabricaAutomovil = fabricaAutomovil;
	}*/
	public ManejadorEliminarAutomovil(RepositorioAutomovil repositorioAutomovil) {
		
		this.repositorioAutomovil = repositorioAutomovil;
	}

	/*
	@Transactional
	public void ejecutar(int idPublicacion ) {
		this.repositorioAutomovil.eliminar(idPublicacion);
	}*/

}
