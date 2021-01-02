package adn.ceiba.consignataria.dominio.repositorio;

import adn.ceiba.consignataria.dominio.model.Publicacion;

public interface RepositorioPublicacion {
	
	void crear(Publicacion publicacion);

	void eliminar(int  idPublicacion);
	
	Publicacion obtenerPublicacionById (int idPublicacion);

}
