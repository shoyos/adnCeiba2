package adn.ceiba.consignataria.dominio.repositorio;



import org.springframework.stereotype.Repository;

import adn.ceiba.consignataria.infraestructura.persistencia.entidad.ClienteEntityMongo;

@Repository
public interface RepositorioMongoCliente extends CosmosRepository<ClienteEntityMongo, String> {

}
