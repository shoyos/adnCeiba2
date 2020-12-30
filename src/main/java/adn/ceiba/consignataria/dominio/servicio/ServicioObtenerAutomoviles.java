package adn.ceiba.consignataria.dominio.servicio;

import java.util.List;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.repositorio.RepositorioAutomovil;

@Component
public class ServicioObtenerAutomoviles {
	
	private final RepositorioAutomovil repositorioAutomovil;

    public ServicioObtenerAutomoviles(RepositorioAutomovil repositorioAutomovil ) {
    	this.repositorioAutomovil = repositorioAutomovil;
	}
    
	public List<Automovil> ejecutar() {
		return this.repositorioAutomovil.obtenerAutomoviles();
	}

}
