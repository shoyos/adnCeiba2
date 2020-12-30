package adn.ceiba.consignataria.dominio.repositorio;

import java.util.List;

import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.AutomovilEntity;

public interface RepositorioAutomovil {
	
	void crear(Automovil automovil);
	
	void eliminar(String idPlaca);
	
	List<Automovil> obtenerAutomoviles();
	
	void actualizar(Automovil automovil);
	
	AutomovilEntity obtenerAutomovilById(String idPlaca);


	

}