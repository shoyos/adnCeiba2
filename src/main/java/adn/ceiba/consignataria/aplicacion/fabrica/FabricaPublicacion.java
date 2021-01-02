package adn.ceiba.consignataria.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.aplicacion.comando.ComandoPublicacion;
import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.model.Publicacion;

@Component
public class FabricaPublicacion {
	
	public Publicacion crear(ComandoPublicacion comandoPublicacion) {
		return new Publicacion(comandoPublicacion.getId(), comandoPublicacion.getIdTipoPublicacion(), comandoPublicacion.getPlaca(), comandoPublicacion.getFechaInicio(), 
				comandoPublicacion.getFechaFinal(), comandoPublicacion.getPrecioPublicacion() );
						
	}


}
