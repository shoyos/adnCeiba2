package adn.ceiba.consignataria.aplicacion.manejadores;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.aplicacion.comando.ComandoAutomovil;
import adn.ceiba.consignataria.aplicacion.fabrica.FabricaAutomovil;
import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.servicio.ServicioCrearAutomovil;


@Component
public class ManejadorCrearAutomovil {
	
	private final ServicioCrearAutomovil servicioCrearAutomovil;
	private final FabricaAutomovil fabricaAutomovil;
	
	public ManejadorCrearAutomovil( ServicioCrearAutomovil servicioCrearAutomovil, FabricaAutomovil fabricaAutomovil ) {
		// TODO Auto-generated constructor stub
		this.servicioCrearAutomovil = servicioCrearAutomovil;
		this.fabricaAutomovil = fabricaAutomovil;
	}

	@Transactional
	public void ejecutar(ComandoAutomovil comandoAutomovil) {
		Automovil automovil = this.fabricaAutomovil.crear(comandoAutomovil);
		System.out.println("Paso ejecutar comandoAutomovil");
		this.servicioCrearAutomovil.ejecutar(automovil);
	}

}

