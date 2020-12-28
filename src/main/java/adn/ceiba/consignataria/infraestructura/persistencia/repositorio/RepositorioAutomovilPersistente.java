package adn.ceiba.consignataria.infraestructura.persistencia.repositorio;

import javax.persistence.EntityManager;


import adn.ceiba.consignataria.dominio.Repositorio.IRepositorioAutomovil;
import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.infraestructura.persistencia.builder.AutomovilBuilder;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.AutomovilEntity;

public class RepositorioAutomovilPersistente implements IRepositorioAutomovil {
	
	private EntityManager entityManager;

	public RepositorioAutomovilPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void crear(Automovil automovil) {
		// TODO Auto-generated method stub
		AutomovilEntity creditoEntity = AutomovilBuilder.convertirAEntity(automovil);
		entityManager.persist(creditoEntity);
		
	}

}
