package adn.ceiba.consignataria.aplicacion.manejadores;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.aplicacion.comando.ComandoAutomovil;
import adn.ceiba.consignataria.aplicacion.fabrica.FabricaAutomovil;
import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.servicio.ServicioCrearAutomovil;
import adn.ceiba.consignataria.dominio.servicio.ServicioEliminarAutomovil;

@Component
public class ManejadorEliminarAutomovil {
	
	private final ServicioEliminarAutomovil servicioEliminarAutomovil;
	private final FabricaAutomovil fabricaAutomovil;
	
	public ManejadorEliminarAutomovil( ServicioEliminarAutomovil servicioEliminarAutomovil, FabricaAutomovil fabricaAutomovil ) {
		// TODO Auto-generated constructor stub
		this.servicioEliminarAutomovil = servicioEliminarAutomovil;
		this.fabricaAutomovil = fabricaAutomovil;
	}

	@Transactional
	public void ejecutar(String idPlaca ) {
		this.servicioEliminarAutomovil.ejecutar(idPlaca);
	}

}
