package adn.ceiba.consignataria.infraestructura.persistencia.entidad;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "containerdb_1")
public class ClienteEntityMongo  {
	@Id
	public String id;

	public String nombre;
	
	public String apellido;


}
