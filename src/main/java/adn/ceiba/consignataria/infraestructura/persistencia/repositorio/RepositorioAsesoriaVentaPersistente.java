package adn.ceiba.consignataria.infraestructura.persistencia.repositorio;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import adn.ceiba.consignataria.dominio.model.AsesoriaVenta;
import adn.ceiba.consignataria.dominio.repositorio.RepositorioAsesoriaVenta;
import adn.ceiba.consignataria.infraestructura.persistencia.builder.AsesoriaBuilder;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.AsesoriaVentasEntity;

@Repository
public class RepositorioAsesoriaVentaPersistente implements RepositorioAsesoriaVenta {
	
	private EntityManager entityManager;
	
	public RepositorioAsesoriaVentaPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public void crear(AsesoriaVenta asesoria) {
		System.out.println("Entro repositorio");
		AsesoriaVentasEntity asesoriaVentasEntity = AsesoriaBuilder.convertirAEntity(asesoria);
		entityManager.persist(asesoriaVentasEntity);
		
	}


}
