package adn.ceiba.consignataria.aplicacion.manejadores;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.aplicacion.comando.ComandoPublicacion;
import adn.ceiba.consignataria.aplicacion.fabrica.FabricaAutomovil;
import adn.ceiba.consignataria.aplicacion.fabrica.FabricaPublicacion;
import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.model.Publicacion;
import adn.ceiba.consignataria.dominio.servicio.ServicioCrearAutomovil;
import adn.ceiba.consignataria.dominio.servicio.ServicioCrearPublicacion;

@Component
public class ManejadorCrearPublicacion {
	
	private final ServicioCrearPublicacion servicioCrearPublicacion;
	private final FabricaPublicacion fabricaPublicacion;
	private final ManejadorCrearAutomovil manejadorCrearAutomovil;
	
	public ManejadorCrearPublicacion(FabricaPublicacion fabricaPublicacion, ServicioCrearPublicacion servicioCrearPublicacion,
			 ManejadorCrearAutomovil manejadorCrearAutomovil ) {
		
		this.fabricaPublicacion = fabricaPublicacion;
		this.servicioCrearPublicacion = servicioCrearPublicacion;
		this.manejadorCrearAutomovil = manejadorCrearAutomovil;
	}

	@Transactional
	public void ejecutar(ComandoPublicacion comandoPublicacion) {
		System.out.println("Paso ejecutar comandoPublicacion");
		this.manejadorCrearAutomovil.ejecutar(comandoPublicacion);
		Publicacion publicacion = this.fabricaPublicacion.crear(comandoPublicacion);		
	    this.servicioCrearPublicacion.ejecutar(publicacion);
	}
}
