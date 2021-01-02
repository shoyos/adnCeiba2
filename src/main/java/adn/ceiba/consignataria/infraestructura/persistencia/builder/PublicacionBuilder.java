package adn.ceiba.consignataria.infraestructura.persistencia.builder;

import adn.ceiba.consignataria.dominio.model.Publicacion;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.PublicacionEntity;

public final class PublicacionBuilder {
	
	public static Publicacion convertirADominio(PublicacionEntity publicacionEntity) {

		Publicacion publicacion = null;

		if (publicacionEntity != null) {
			publicacion = new Publicacion ( publicacionEntity.getId(), publicacionEntity.getIdTipoPublicacion(), 
					publicacionEntity.getIdAutomovil(),
					publicacionEntity.getFechaInicio(), 
					publicacionEntity.getFechafinal(), 
					publicacionEntity.getPrecioPublicacion() );
		}

		return publicacion;
	}

	
	public static PublicacionEntity convertirAEntity(Publicacion publicacion) {
		PublicacionEntity publicacionEntity = new PublicacionEntity();
		publicacionEntity.setId(publicacion.getId());
		publicacionEntity.setIdTipoPublicacion(publicacion.getIdTipoPublicacion());
		//publicacionEntity.setAutomovil(AutomovilBuilder.convertirAEntity(publicacion.getAutomovil()));
		publicacionEntity.setIdAutomovil(publicacion.getIdAutomovil());
		publicacionEntity.setFechaInicio(publicacion.getFechaInicio());
		publicacionEntity.setFechafinal(publicacion.getFechaFinal());
		publicacionEntity.setPrecioPublicacion(publicacion.getPrecioPublicacion());

		return publicacionEntity;
	}

}
