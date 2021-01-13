package adn.ceiba.consignataria.integracion;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import adn.ceiba.consignataria.aplicacion.comando.ComandoPublicacion;
import adn.ceiba.consignataria.aplicacion.fabrica.FabricaAutomovil;
import adn.ceiba.consignataria.aplicacion.fabrica.FabricaPublicacion;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorCrearAutomovil;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorCrearPublicacion;
import adn.ceiba.consignataria.dominio.servicio.ServicioCrearAutomovil;
import adn.ceiba.consignataria.dominio.servicio.ServicioCrearPublicacion;
import adn.ceiba.consignataria.infraestructura.persistencia.controlador.ControladorAutomovil;
import adn.ceiba.consignataria.infraestructura.persistencia.repositorio.RepositorioAutomovilPersistente;
import adn.ceiba.consignataria.infraestructura.persistencia.repositorio.RepositorioPublicacionPersistente;
import adn.ceiba.consignataria.testDataBuilder.ComandoTestDataBuilder;


@AutoConfigureMockMvc
@ContextConfiguration(classes = {ControladorAutomovil.class, ManejadorCrearPublicacion.class,
		ManejadorCrearAutomovil.class, ServicioCrearPublicacion.class, ServicioCrearAutomovil.class,
		FabricaPublicacion.class, FabricaAutomovil.class,
		RepositorioAutomovilPersistente.class, RepositorioPublicacionPersistente.class,
		})
@WebMvcTest
public class ControladorPublicacionTest {
	/*
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	EntityManager manager;

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void agregar() throws Exception {
		ComandoPublicacion comando = new ComandoTestDataBuilder().build();
		mvc.perform(MockMvcRequestBuilders.post("/publicaciones")
				.content(objectMapper.writeValueAsString(comando))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
				
	}*/

}
