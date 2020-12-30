package adn.ceiba.consignataria.aplicacion.unitaria.manejadores;

import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorEliminarAutomovil;
import adn.ceiba.consignataria.dominio.servicio.ServicioEliminarAutomovil;

public class ManejadorEliminarCreditoTest {
	
	private static final String PLACA = "121";

	@Mock
	ServicioEliminarAutomovil servicioEliminarAutomovil;

	@InjectMocks
	ManejadorEliminarAutomovil manejadorEliminarAutomovil;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		Mockito.doNothing().when(servicioEliminarAutomovil).ejecutar(PLACA);

	}

	@Test
	public void ejecutarTest() {
		manejadorEliminarAutomovil.ejecutar(PLACA);
		Mockito.verify(servicioEliminarAutomovil, times(1)).ejecutar(PLACA);
	}

}
