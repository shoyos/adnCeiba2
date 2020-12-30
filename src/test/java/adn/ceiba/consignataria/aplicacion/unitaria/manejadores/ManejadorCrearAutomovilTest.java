package adn.ceiba.consignataria.aplicacion.unitaria.manejadores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import adn.ceiba.consignataria.aplicacion.comando.ComandoAutomovil;
import adn.ceiba.consignataria.aplicacion.fabrica.FabricaAutomovil;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorCrearAutomovil;
import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.servicio.ServicioCrearAutomovil;

public class ManejadorCrearAutomovilTest {
	
	
	private static final String PLACA = "ABC123";
	private static final String NUMMOTOR = "1111";
	private static final int KILOMETRAJE = 20000;
	private static final int CILINDRAJE = 1200;
	private static final int IDTIPOPUBLICACION = 1;
	private static final int MODELO = 2015;
	private static final LocalDate FECHAVENCIMIENTOSOAT = LocalDate.of(2021, 02, 05);
	private static final LocalDate FECHAINICIO = LocalDate.of(2020, 12, 05);
	private static final LocalDate FECHAFINAL = LocalDate.of(2020, 12, 05);
	private static final int VALORVENTA = 20000;
	private static final int VALORVENTACALCULADO = 0;

	public static final ComandoAutomovil COMANDO_AUTOMOVIL = new ComandoAutomovil();
	public static final FabricaAutomovil FABRICA_AUTOMOVIL = new FabricaAutomovil();
	public static final Automovil AUTOMOVIL = new Automovil() ;

	@Mock
	ServicioCrearAutomovil servicioCrearAutomovil;

	@Mock
	FabricaAutomovil fabricaAutomovil;

	@InjectMocks
	ManejadorCrearAutomovil manejadorCrearAutomovil;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		AUTOMOVIL.setPlaca(PLACA);
		AUTOMOVIL.setNumeroMotor(NUMMOTOR);
		AUTOMOVIL.setKilometraje(KILOMETRAJE);
		AUTOMOVIL.setCilindraje(CILINDRAJE);
		AUTOMOVIL.setIdTipoPublicacion(IDTIPOPUBLICACION);
		AUTOMOVIL.setModelo(MODELO);
		AUTOMOVIL.setFechaVencimientoSoat(FECHAVENCIMIENTOSOAT);
		AUTOMOVIL.setFechaInicio(FECHAINICIO);
		AUTOMOVIL.setFechaFinal(FECHAFINAL);
		AUTOMOVIL.setValorVenta(VALORVENTA);
		AUTOMOVIL.setValorVentaCalculado(VALORVENTACALCULADO);
		
		Mockito.when(fabricaAutomovil.crear(COMANDO_AUTOMOVIL)).thenReturn(AUTOMOVIL);
		Mockito.doNothing().when(servicioCrearAutomovil).ejecutar(AUTOMOVIL);
	}
	
	@Test
	public void ejecutarTest() {
		Automovil automovil = fabricaAutomovil.crear(COMANDO_AUTOMOVIL);

		assertEquals(PLACA, automovil.getPlaca());
		assertEquals(NUMMOTOR, automovil.getNumeroMotor());
		assertEquals(KILOMETRAJE, automovil.getKilometraje());
		assertEquals(CILINDRAJE, automovil.getCilindraje());
		assertEquals(IDTIPOPUBLICACION, automovil.getIdTipoPublicacion());
		assertEquals(MODELO, automovil.getModelo());
		assertEquals(FECHAVENCIMIENTOSOAT, automovil.getFechaVencimientoSoat());
		assertEquals(FECHAINICIO, automovil.getFechaInicio());
		assertEquals(FECHAFINAL, automovil.getFechaFinal());
		assertEquals(VALORVENTA, automovil.getValorVentaCalculado());
		assertEquals(VALORVENTACALCULADO, automovil.getValorVentaCalculado());

		manejadorCrearAutomovil.ejecutar(COMANDO_AUTOMOVIL);

		Mockito.verify(servicioCrearAutomovil, times(1)).ejecutar(AUTOMOVIL);
	}

}
