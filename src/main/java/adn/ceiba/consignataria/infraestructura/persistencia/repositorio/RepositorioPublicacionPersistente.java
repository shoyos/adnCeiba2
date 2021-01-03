package adn.ceiba.consignataria.infraestructura.persistencia.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import adn.ceiba.consignataria.aplicacion.comando.ComandoPublicacion;
import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.model.Publicacion;
import adn.ceiba.consignataria.dominio.repositorio.RepositorioPublicacion;
import adn.ceiba.consignataria.infraestructura.persistencia.builder.PublicacionBuilder;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.PublicacionEntity;

@Repository
public class RepositorioPublicacionPersistente implements RepositorioPublicacion {
	
	private EntityManager entityManager;
	private static final String PUBLICACION_FINDALL = "Publicacion.findAll";
	private static final String PUBLICACION_FINDBYID = "Publicacion.findById";
	private RepositorioAutomovilPersistente repositorioAutomovil;

	public RepositorioPublicacionPersistente (EntityManager entityManager, RepositorioAutomovilPersistente repositorioAutomovil) {
		this.entityManager = entityManager;
		this.repositorioAutomovil = repositorioAutomovil;
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
	
	private PublicacionEntity obtenerPublicacionEntityByIdAutomovil(String idPlaca) {		
		Query query = entityManager.createNamedQuery(PUBLICACION_FINDBYID);
		query.setParameter("idPlaca", idPlaca);
		return (PublicacionEntity) query.getResultList().stream().findFirst().orElse(null);
	}

	
	@Override
	public Publicacion obtenerPublicacionByIdAutomovil(String idPlaca) {
		PublicacionEntity publicacionEntity = obtenerPublicacionEntityByIdAutomovil(idPlaca);
		return PublicacionBuilder.convertirADominio(publicacionEntity);
		//return PublicacionBuilder.convertirADominio( entityManager.find(PublicacionEntity.class, idPlaca));
	}
	
	@Override
	public Publicacion obtenerPublicacionById(int idPublicacion) {
		return PublicacionBuilder.convertirADominio( entityManager.find(PublicacionEntity.class, idPublicacion));
	}

	@Override
	public void actualizar(Publicacion publicacion) {
		// TODO Auto-generated method stub
		System.out.println("Entro repositorio actualizar publicacion");
		PublicacionEntity publicacionEntity = PublicacionBuilder.convertirAEntity(publicacion);
		entityManager.merge(publicacionEntity);
	}

	@Override
	public List<ComandoPublicacion> obtenerTodos() {
		List<ComandoPublicacion> resultado = new ArrayList<ComandoPublicacion>();
		Query query = entityManager.createNamedQuery(PUBLICACION_FINDALL);
		List<PublicacionEntity> listaPublicaciones = (List<PublicacionEntity>) query.getResultList();
		for (PublicacionEntity publicacion : listaPublicaciones) {
			
			Automovil automovilRelacionado = repositorioAutomovil.obtenerAutomovilById(publicacion.getIdAutomovil());
			ComandoPublicacion comando = new ComandoPublicacion();
			comando.setPlaca(automovilRelacionado.getPlaca());
			comando.setNumeroMotor(automovilRelacionado.getNumeroMotor());
			comando.setKilometraje(automovilRelacionado.getKilometraje());
			comando.setCilindraje(automovilRelacionado.getCilindraje());
			comando.setFechaVencimientoSoat(automovilRelacionado.getFechaVencimientoSoat());
			comando.setModelo(automovilRelacionado.getModelo());
			comando.setValorVenta(automovilRelacionado.getValorVenta());
			comando.setValorVentaCalculado(automovilRelacionado.getValorVentaCalculado());
			comando.setId(publicacion.getId());
			comando.setIdTipoPublicacion(publicacion.getIdTipoPublicacion());
			comando.setFechaInicio(publicacion.getFechaInicio());
			comando.setFechaFinal(publicacion.getFechafinal());
			comando.setPrecioPublicacion(publicacion.getPrecioPublicacion());
			
			resultado.add(comando);
			
		}

		return resultado;
	}

}
