package adn.ceiba.consignataria.infraestructura.persistencia.repositorio;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.model.Publicacion;
import adn.ceiba.consignataria.dominio.repositorio.RepositorioPublicacion;
import adn.ceiba.consignataria.infraestructura.persistencia.builder.AutomovilBuilder;
import adn.ceiba.consignataria.infraestructura.persistencia.builder.PublicacionBuilder;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.AutomovilEntity;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.PublicacionEntity;

@Repository
public class RepositorioPublicacionPersistente implements RepositorioPublicacion {
	
	private EntityManager entityManager;
	private static final String PUBLICACION_FINDALL = "Publicacion.findAll";


	public RepositorioPublicacionPersistente (EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public void crear(Publicacion publicacion) {
		System.out.println("Entro repositorio");
		PublicacionEntity publicacionEntity = PublicacionBuilder.convertirAEntity(publicacion);
		entityManager.persist(publicacionEntity);
		
	}
	
	@Override
	public void eliminar(int idPublicacion) {
		PublicacionEntity publicacionEntity= this.obtenerPublicacionEntityPorId(idPublicacion);
		//publicacionEntity.setAutomovil(null);
		entityManager.remove(publicacionEntity);
	}
	
	private PublicacionEntity obtenerPublicacionEntityPorId(int id) {
		return entityManager.find(PublicacionEntity.class, id);
	}

	
	@Override
	public Publicacion obtenerPublicacionById(int idPublicacion) {
		return PublicacionBuilder.convertirADominio( entityManager.find(PublicacionEntity.class, idPublicacion));
	}

}
