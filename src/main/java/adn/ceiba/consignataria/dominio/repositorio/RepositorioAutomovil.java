package adn.ceiba.consignataria.dominio.repositorio;

import java.util.List;

import adn.ceiba.consignataria.dominio.model.Automovil;

public interface RepositorioAutomovil {
	
	void crear(Automovil automovil);
	
	public void eliminar(String idPlaca);
	
	List<Automovil> obtenerAutomoviles();
	
	void actualizar(Automovil automovil);
	
	Automovil obtenerAutomovilById(String idPlaca);


	

}