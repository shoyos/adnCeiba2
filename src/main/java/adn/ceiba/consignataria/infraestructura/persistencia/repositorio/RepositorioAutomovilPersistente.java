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
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.PublicacionEntity;

@Repository
public class RepositorioAutomovilPersistente implements RepositorioAutomovil {
	
	private EntityManager entityManager;
	private static final String PUBLICACION_FINDALL = "Publicacion.findAll";


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
	public void eliminar (String idPlaca) {
		System.out.println("Entro eliminar automovl");
		AutomovilEntity autoEntity = this.obtenerAutomovilEntityPorId(idPlaca);
		entityManager.remove(autoEntity);
		//AutomovilEntity autoEntity= AutomovilBuilder.convertirAEntity(obtenerAutomovilById(idPlaca));
		//entityManager.remove(autoEntity);
	}
	
	@Override
	public Automovil obtenerAutomovilById(String idPlaca) {
		return AutomovilBuilder.convertirADominio( entityManager.find(AutomovilEntity.class, idPlaca));
	}
	
	private AutomovilEntity obtenerAutomovilEntityPorId(String id) {
		return entityManager.find(AutomovilEntity.class, id);
	}


	/*
	@Override
	@SuppressWarnings("unchecked")
	public List<Automovil> obtenerAutomoviles() {
		
		Query query = entityManager.createNamedQuery(PUBLICACION_FINDALL);
		List<PublicacionEntity> listaPublicacionesEntity=  (List<PublicacionEntity>) query.getResultList();
		List<Automovil> listaAutomovilesDominio  = new ArrayList<Automovil>();
		for (AutomovilEntity automovilEntity : listaAutomovilesEntity) {
			listaAutomovilesDominio.add(AutomovilBuilder.convertirADominio(automovilEntity));
		}
		
		return listaAutomovilesDominio;
		
	}*/

	@Override
	public void actualizar(Automovil automovil) {
		System.out.println("Entro repositorio actualizar");
		AutomovilEntity creditoEntity = AutomovilBuilder.convertirAEntity(automovil);
		entityManager.merge(creditoEntity);
	}

	@Override
	public List<Automovil> obtenerAutomoviles() {
		// TODO Auto-generated method stub
		return null;
	}

}
