package adn.ceiba.consignataria.integracion;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import adn.ceiba.consignataria.Consignataria2ApplicationTests;
import adn.ceiba.consignataria.aplicacion.comando.ComandoPublicacion;
import adn.ceiba.consignataria.infraestructura.persistencia.controlador.ControladorAutomovil;
import adn.ceiba.consignataria.testDataBuilder.ComandoTestDataBuilder;



//@SpringBootTest()
@WebMvcTest (ControladorAutomovil.class)
@ContextConfiguration(classes= Consignataria2ApplicationTests.class)
@AutoConfigureMockMvc

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
				.andExpect(status().isOk());
				
	}

}
