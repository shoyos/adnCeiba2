package adn.ceiba.consignataria.infraestructura.persistencia.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.repositorio.RepositorioAutomovil;
import adn.ceiba.consignataria.infraestructura.persistencia.builder.AutomovilBuilder;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.AutomovilEntity;

@Repository
public class RepositorioAutomovilPersistente implements RepositorioAutomovil {
	
	private EntityManager entityManager;
	private static final String AUTOMOVIL_FINDALL = "Automovil.findAll";


	public RepositorioAutomovilPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void crear(Automovil automovil) {
		System.out.println("Entro repositorio");
		AutomovilEntity creditoEntity = AutomovilBuilder.convertirAEntity(automovil);
		entityManager.persist(creditoEntity);
		
	}

	@Override
	public void eliminar(String idPlaca) {
		AutomovilEntity autoEntity= obtenerAutomovilById(idPlaca);
		entityManager.remove(autoEntity);
		
	}
	
	public AutomovilEntity obtenerAutomovilById(String idPlaca) {
		return entityManager.find(AutomovilEntity.class, idPlaca);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Automovil> obtenerAutomoviles() {
		Query query = entityManager.createNamedQuery(AUTOMOVIL_FINDALL);
		List<AutomovilEntity> listaAutomovilesEntity=  (List<AutomovilEntity>) query.getResultList();
		List<Automovil> listaAutomovilesDominio  = new ArrayList<Automovil>();
		for (AutomovilEntity automovilEntity : listaAutomovilesEntity) {
			listaAutomovilesDominio.add(AutomovilBuilder.convertirADominio(automovilEntity));
		}
		
		return listaAutomovilesDominio;
	}

	@Override
	public void actualizar(Automovil automovil) {
		System.out.println("Entro repositorio actualizar");
		AutomovilEntity creditoEntity = AutomovilBuilder.convertirAEntity(automovil);
		entityManager.merge(creditoEntity);
	}

}
