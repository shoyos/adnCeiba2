package adn.ceiba.consignataria.dominio.servicio;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.repositorio.RepositorioAutomovil;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.AutomovilEntity;

@Component
public class ServicioEliminarAutomovil {
	
	private final RepositorioAutomovil repositorioAutomovil;

    public ServicioEliminarAutomovil(RepositorioAutomovil repositorioAutomovil ) {
    	this.repositorioAutomovil = repositorioAutomovil;
	}
    /*
	public void ejecutar(int idPublicacion) {
		
		this.repositorioAutomovil.ob(idPlaca);
	}*/

}
