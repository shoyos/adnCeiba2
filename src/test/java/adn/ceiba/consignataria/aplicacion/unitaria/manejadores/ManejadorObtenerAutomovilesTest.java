package adn.ceiba.consignataria.aplicacion.unitaria.manejadores;

import static org.mockito.Mockito.times;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorObtenerAutomoviles;
import adn.ceiba.consignataria.dominio.servicio.ServicioObtenerAutomoviles;

public class ManejadorObtenerAutomovilesTest {
	
	@Mock
	ServicioObtenerAutomoviles servicioObtenerAutomoviles;

	@InjectMocks
	ManejadorObtenerAutomoviles manejadorObtenerAutomoviles;

	@BeforeAll
	public void init() {
		MockitoAnnotations.openMocks(this);

	}

	@Test
	public void ejecutarTest() {
		/*
		manejadorObtenerAutomoviles.ejecutar();
		Mockito.verify(servicioObtenerAutomoviles, times(1)).ejecutar();
		*/
	}

}
