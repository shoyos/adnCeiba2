package adn.ceiba.consignataria.dominio.repositorio;

import java.util.List;

import adn.ceiba.consignataria.aplicacion.comando.ComandoPublicacion;
import adn.ceiba.consignataria.dominio.model.Publicacion;

public interface RepositorioPublicacion {
	
	void crear(Publicacion publicacion);
	
	void actualizar(Publicacion publicacion);

	void eliminar(int  idPublicacion);
	
	Publicacion obtenerPublicacionById (int  idPublicacion);
	
	Publicacion obtenerPublicacionByIdAutomovil (String idPlaca);
	
	List<ComandoPublicacion> obtenerTodos ();



}
