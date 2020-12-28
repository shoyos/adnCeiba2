package adn.ceiba.consignataria.aplicacion.manejadores;

import adn.ceiba.consignataria.aplicacion.comando.ComandoAutomovil;
import adn.ceiba.consignataria.aplicacion.fabrica.FabricaAutomovil;
import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.servicio.ServicioCrearAutomovil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ManejadorCrearAutomovil {
	
	private final ServicioCrearAutomovil servicioCrearAutomovil;
	private final FabricaAutomovil fabricaAutomovil;


	public void ejecutar(ComandoAutomovil comandoAutomovil) {
		Automovil automovil = this.fabricaAutomovil.crear(comandoAutomovil);
		this.servicioCrearAutomovil.crear(automovil);
	}

}

