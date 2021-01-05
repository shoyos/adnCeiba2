package adn.ceiba.dominio.unitaria.servicio;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import adn.ceiba.consignataria.dominio.excepcion.AsesoriaVentasExcepion;
import adn.ceiba.consignataria.dominio.model.AsesoriaVenta;
import adn.ceiba.consignataria.dominio.repositorio.RepositorioAsesoriaVenta;
import adn.ceiba.consignataria.dominio.servicio.ServicioCrearAsesoriaVenta;
import adn.ceiba.testDataBuilder.AsesoriaTestDataBuilder;

public class ServicioCrearAsesoriaTest {
	
	private static final LocalDate FECHA_DOMINGO = LocalDate.of(2021, 1, 10);

	
	AsesoriaTestDataBuilder asesoriaTestBuilder = new AsesoriaTestDataBuilder();
	AsesoriaVenta asesoriaVenta = asesoriaTestBuilder.build();
	
	@Mock
	RepositorioAsesoriaVenta repositorioAsesoriaVenta;
	
	@InjectMocks
	ServicioCrearAsesoriaVenta servicioCrearAsesoriaVenta;
	
	@BeforeEach
	public void init() {
		//MockitoAnnotations.initMocks(this);
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void crearAsesoriaTest() {
		servicioCrearAsesoriaVenta.ejecutar(asesoriaVenta);

		Mockito.verify(repositorioAsesoriaVenta, times(1)).crear(asesoriaVenta);
	}
	
	@Test
	public void crearAsesoriaConFechaDomingoTest() {

	    assertThrows(AsesoriaVentasExcepion.class,
	            ()->{
	            	AsesoriaVenta asesoriaVenta = asesoriaTestBuilder.conFecha(FECHA_DOMINGO).build();
	            	servicioCrearAsesoriaVenta.ejecutar(asesoriaVenta);
	            });
	}
	

}
