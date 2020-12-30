package adn.ceiba.consignataria.aplicacion.manejadores;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.servicio.ServicioObtenerAutomoviles;

@Component
public class ManejadorObtenerAutomoviles {
	
	private final ServicioObtenerAutomoviles servicioObtenerAutomoviles;
	
	public ManejadorObtenerAutomoviles( ServicioObtenerAutomoviles servicioObtenerAutomoviles ) {
		// TODO Auto-generated constructor stub
		this.servicioObtenerAutomoviles = servicioObtenerAutomoviles;
	}

	@Transactional
	public List<Automovil> ejecutar() {
		return this.servicioObtenerAutomoviles.ejecutar();
	}

}
