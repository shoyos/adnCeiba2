package adn.ceiba.consignataria.aplicacion.unitaria.manejadores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import adn.ceiba.consignataria.aplicacion.comando.ComandoPublicacion;
import adn.ceiba.consignataria.aplicacion.fabrica.FabricaAutomovil;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorCrearAutomovil;
import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.servicio.ServicioCrearAutomovil;
import adn.ceiba.consignataria.testDataBuilder.AutomovilTestDataBuilder;

public class ManejadorCrearAutomovilTest {
	
	private static final String PLACA = "ABC123";
	private static final String NUMMOTOR = "1111";
	private static final int KILOMETRAJE = 20000;
	private static final int CILINDRAJE = 1200;
	private static final int MODELO = 2015;
	private static final LocalDate FECHAVENCIMIENTOSOAT = LocalDate.of(2021, 02, 05);
	private static final int VALORVENTA = 20000;
	private static final int VALORVENTACALCULADO = 0;

	public static final ComandoPublicacion COMANDO = new ComandoPublicacion();
	public static final FabricaAutomovil FABRICA_AUTOMOVIL = new FabricaAutomovil();
	
	AutomovilTestDataBuilder automovilTestBuilder = new AutomovilTestDataBuilder().conPlaca(PLACA)
			.conNumeroMotor(NUMMOTOR)
			.conCilindraje(CILINDRAJE)
			.conKilometraje(KILOMETRAJE)
			.conModelo(MODELO)
			.conFechaVenciminetoSoar(FECHAVENCIMIENTOSOAT)
			.conValorVenta(VALORVENTA);
	
	Automovil AUTOMOVIL = automovilTestBuilder.build();
 

	@Mock
	ServicioCrearAutomovil servicioCrearAutomovil;

	@Mock
	FabricaAutomovil fabricaAutomovil;

	@InjectMocks
	ManejadorCrearAutomovil manejadorCrearAutomovil;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);

		COMANDO.setPlaca(PLACA);
		COMANDO.setNumeroMotor(NUMMOTOR);
		COMANDO.setKilometraje(KILOMETRAJE);
		COMANDO.setCilindraje(CILINDRAJE);
		COMANDO.setModelo(MODELO);
		COMANDO.setFechaVencimientoSoat(FECHAVENCIMIENTOSOAT);
		COMANDO.setValorVenta(VALORVENTA);
		COMANDO.setValorVentaCalculado(VALORVENTACALCULADO);
		
		Mockito.when(fabricaAutomovil.crear(COMANDO)).thenReturn(AUTOMOVIL);
		Mockito.doNothing().when(servicioCrearAutomovil).ejecutar(AUTOMOVIL);
	}
	
	@Test
	public void ejecutarTest() {
		
		Automovil automovil = fabricaAutomovil.crear(COMANDO);

		assertEquals(PLACA, automovil.getPlaca());
		assertEquals(NUMMOTOR, automovil.getNumeroMotor());
		assertEquals(KILOMETRAJE, automovil.getKilometraje());
		assertEquals(CILINDRAJE, automovil.getCilindraje());
		assertEquals(MODELO, automovil.getModelo());
		assertEquals(FECHAVENCIMIENTOSOAT, automovil.getFechaVencimientoSoat());
		assertEquals(VALORVENTA, automovil.getValorVenta());
		assertEquals(VALORVENTACALCULADO, automovil.getValorVentaCalculado());

		manejadorCrearAutomovil.ejecutar(COMANDO);

		Mockito.verify(servicioCrearAutomovil, times(1)).ejecutar(AUTOMOVIL);
	}
	

}
