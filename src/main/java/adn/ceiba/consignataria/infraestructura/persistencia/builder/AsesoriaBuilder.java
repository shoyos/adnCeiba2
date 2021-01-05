package adn.ceiba.consignataria.infraestructura.persistencia.builder;

import adn.ceiba.consignataria.dominio.model.AsesoriaVenta;
import adn.ceiba.consignataria.dominio.model.Publicacion;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.AsesoriaVentasEntity;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.PublicacionEntity;

public final class AsesoriaBuilder {
	
	
	public static AsesoriaVentasEntity convertirAEntity(AsesoriaVenta asesoria) {
		AsesoriaVentasEntity asesoriaEntity = new AsesoriaVentasEntity();
		asesoriaEntity.setIdDocumentoAsesor(asesoria.getIdDocumentoAsesor());
		asesoriaEntity.setFecha(asesoria.getFecha());
		asesoriaEntity.setFranjaHoraria(asesoria.getFranjaHoraria());
		asesoriaEntity.setNombreCliente(asesoria.getNombreCleinte());
		asesoriaEntity.setTelefonoCliente(asesoria.getTelefonoCliente());
		return asesoriaEntity;
		
	}

}
