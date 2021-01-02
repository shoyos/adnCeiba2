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
	private final FabricaAutomovil fabricaAutomovil;

	
	public ManejadorCrearPublicacion(FabricaPublicacion fabricaPublicacion, ServicioCrearPublicacion servicioCrearPublicacion,
			 FabricaAutomovil fabricaAutomovil) {
		
		this.fabricaPublicacion = fabricaPublicacion;
		this.servicioCrearPublicacion = servicioCrearPublicacion;
		this.fabricaAutomovil = fabricaAutomovil;
	}

	@Transactional
	public void ejecutar(ComandoPublicacion comandoAutomovil) {
		System.out.println("Paso ejecutar comandoAutomovil");
		//Automovil automovil = this.fabricaAutomovil.crear(comandoAutomovil);
		Publicacion publicacion = this.fabricaPublicacion.crear(comandoAutomovil);		
	    this.servicioCrearPublicacion.ejecutar(publicacion);
	}
}
