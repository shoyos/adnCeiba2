package adn.ceiba.dominio.unitaria.servicio;

import static org.mockito.Mockito.times;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.servicio.ServicioCrearAutomovil;
import adn.ceiba.consignataria.infraestructura.persistencia.repositorio.RepositorioAutomovilPersistente;
import adn.ceiba.testDataBuilder.AutomovilTestDataBuilder;

public class ServicioCrearAutomovilTest {
	
	AutomovilTestDataBuilder automovilTestDataBuilder = new AutomovilTestDataBuilder();
	Automovil automovil =  automovilTestDataBuilder.build();
	
	@Mock
	RepositorioAutomovilPersistente repositorioAutomovil;
	
	@InjectMocks
	ServicioCrearAutomovil servicioCrearAutomovil;
	
	@Test
	public void crearAutomovilTest() {

		servicioCrearAutomovil.ejecutar(automovil);

		Mockito.verify(repositorioAutomovil, times(1)).crear(automovil);
	}
	

}
