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
public class ManejadorCrearAutomovil {
	
	private final ServicioCrearAutomovil servicioCrearAutomovil;
	private final ServicioCrearPublicacion servicioCrearPublicacion;
	private final FabricaAutomovil fabricaAutomovil;
	private final FabricaPublicacion fabricaPublicacion;

	
	public ManejadorCrearAutomovil( ServicioCrearAutomovil servicioCrearAutomovil, FabricaAutomovil fabricaAutomovil,  
			FabricaPublicacion fabricaPublicacion, ServicioCrearPublicacion servicioCrearPublicacion  ) {
		
		this.servicioCrearAutomovil = servicioCrearAutomovil;
		this.fabricaAutomovil = fabricaAutomovil;
		this.fabricaPublicacion = fabricaPublicacion;
		this.servicioCrearPublicacion = servicioCrearPublicacion;
	}

	@Transactional
	public void ejecutar(ComandoPublicacion comandoPublicacion) {
		System.out.println("Paso ejecutar comandoAutomovil");
		Automovil automovil = this.fabricaAutomovil.crear(comandoPublicacion);
	    this.servicioCrearAutomovil.ejecutar(automovil);
	}

}

