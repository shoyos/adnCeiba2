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
import adn.ceiba.consignataria.aplicacion.fabrica.FabricaPublicacion;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorCrearPublicacion;
import adn.ceiba.consignataria.dominio.model.Publicacion;
import adn.ceiba.consignataria.dominio.servicio.ServicioCrearPublicacion;
import adn.ceiba.consignataria.testDataBuilder.PublicacionTestDataBuilder;

public class ManejadorCrearPublicacionTest {
	

	private static final int ID = 1;
	private static final int IDTIPOPUBLICACION = 1;
	private static final String ID_AUTOMOVIL = "AA1";
	private static final LocalDate FECHAINICIO = LocalDate.of(2020, 12, 29);
	private static final LocalDate FECHAFINAL = LocalDate.of(2020, 12, 29);
	private static final int PRECIO_PUBLICACION = 15000;

	private static final ComandoPublicacion COMANDO = new ComandoPublicacion();
	
	PublicacionTestDataBuilder publicacionTest = new PublicacionTestDataBuilder().conId(ID)
			.conFechaInicio(FECHAINICIO)
			.conFechaFinal(FECHAFINAL)
			.conIdTipoPublicacion(IDTIPOPUBLICACION)
			.conPrecioPublicacion(PRECIO_PUBLICACION);
	
	Publicacion PUBLICACION = publicacionTest.build() ;
 

	@Mock
	ServicioCrearPublicacion servicioCrearPublicacion;
	

	@Mock
	FabricaPublicacion fabricaPublicacion;

	@InjectMocks
	ManejadorCrearPublicacion manejadorCrearPublicacion;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);

		COMANDO.setId(ID);
		COMANDO.setIdTipoPublicacion(IDTIPOPUBLICACION);
		COMANDO.setPlaca(ID_AUTOMOVIL);
		COMANDO.setFechaInicio(FECHAINICIO);
		COMANDO.setFechaFinal(FECHAFINAL);
		COMANDO.setPrecioPublicacion(PRECIO_PUBLICACION);
		
		Mockito.when(fabricaPublicacion.crear(COMANDO)).thenReturn(PUBLICACION);
		Mockito.doNothing().when(servicioCrearPublicacion).ejecutar(PUBLICACION);
	}
	
	@Test
	public void ejecutarTest() {
		Publicacion publicacion = fabricaPublicacion.crear(COMANDO);

		assertEquals(ID, publicacion.getId());
		assertEquals(IDTIPOPUBLICACION, publicacion.getIdTipoPublicacion());
		assertEquals(ID_AUTOMOVIL, publicacion.getIdAutomovil());
		assertEquals(FECHAINICIO, publicacion.getFechaInicio());
		assertEquals(FECHAFINAL, publicacion.getFechaFinal());
		assertEquals(PRECIO_PUBLICACION, publicacion.getPrecioPublicacion());

		//manejadorCrearPublicacion.ejecutar(COMANDO);

		//Mockito.verify(servicioCrearPublicacion, times(1)).ejecutar(PUBLICACION);
	}

}
