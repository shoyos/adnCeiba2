package adn.ceiba.dominio.unitaria.servicio;

import static org.mockito.Mockito.times;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.infraestructura.persistencia.repositorio.RepositorioAutomovilPersistente;
import adn.ceiba.testDataBuilder.AutomovilTestDataBuilder;

public class ServicioObtenerAutomovilTest {
	/*
	AutomovilTestDataBuilder automovilTestDataBuilder = new AutomovilTestDataBuilder();
	Automovil automovil =  automovilTestDataBuilder.build();
	
	@Mock
	RepositorioAutomovilPersistente repositorioAutomovil;
	
	@InjectMocks
	ServicioObtenerPublicaciones servicioObtenerAutomoviles;
	
	@BeforeAll
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void crearAutomovilTest() {
		/*
		servicioObtenerAutomoviles.ejecutar();

		Mockito.verify(repositorioAutomovil, times(1)).obtenerAutomoviles();
		
	}*/

}
