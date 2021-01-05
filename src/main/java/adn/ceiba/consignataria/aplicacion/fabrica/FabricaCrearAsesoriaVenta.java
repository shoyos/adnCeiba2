package adn.ceiba.consignataria.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.aplicacion.comando.ComandoAsesoria;
import adn.ceiba.consignataria.aplicacion.comando.ComandoPublicacion;
import adn.ceiba.consignataria.dominio.model.AsesoriaVenta;
import adn.ceiba.consignataria.dominio.model.Publicacion;

@Component
public class FabricaCrearAsesoriaVenta {
	
	
	public AsesoriaVenta crear (ComandoAsesoria comandoAsesoria) {
		return new AsesoriaVenta(comandoAsesoria.getIdDocumentoAsesor(), comandoAsesoria.getFecha(), comandoAsesoria.getFranjaHoraria(),
				comandoAsesoria.getNombreCliente(), comandoAsesoria.getTelefonoCliente());
	}

}
