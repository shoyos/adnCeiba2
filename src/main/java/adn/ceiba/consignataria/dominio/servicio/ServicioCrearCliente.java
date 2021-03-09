package adn.ceiba.consignataria.dominio.servicio;


import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.dominio.repositorio.RepositorioMongoCliente;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.ClienteEntityMongo;

@Component
public class ServicioCrearCliente {
	
	private RepositorioMongoCliente repositorioCliente;
	
	public ServicioCrearCliente(RepositorioMongoCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}


	public void ejecutar(ClienteEntityMongo cliente) {
		repositorioCliente.save(cliente);
		
	}


}
