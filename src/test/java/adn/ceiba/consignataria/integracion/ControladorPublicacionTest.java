package adn.ceiba.consignataria.integracion;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import adn.ceiba.consignataria.aplicacion.comando.ComandoPublicacion;
import adn.ceiba.consignataria.infraestructura.persistencia.controlador.ControladorAutomovil;
import adn.ceiba.consignataria.testDataBuilder.ComandoTestDataBuilder;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@EnableJpaRepositories
@WebMvcTest(ControladorAutomovil.class)
public class ControladorPublicacionTest {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void agregar() throws Exception {
		ComandoPublicacion comando = new ComandoTestDataBuilder().build();
		mvc.perform(MockMvcRequestBuilders.post("/publicaciones")
				.content(objectMapper.writeValueAsString(comando))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
				
	}

}
