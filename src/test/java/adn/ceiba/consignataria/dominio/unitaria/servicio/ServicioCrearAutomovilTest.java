package adn.ceiba.consignataria.dominio.unitaria.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;

import java.time.LocalDate;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import adn.ceiba.consignataria.dominio.excepcion.AutomovilExcepcionBadRequest;
import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.servicio.ServicioCrearAutomovil;
import adn.ceiba.consignataria.infraestructura.persistencia.repositorio.RepositorioAutomovilPersistente;
import adn.ceiba.consignataria.testDataBuilder.AutomovilTestDataBuilder;

public class ServicioCrearAutomovilTest {
	
	private static final LocalDate FECHA_SOAT_VENCIDO = LocalDate.of(2020, 8, 15);
	private static final int VALOR_VENTA_CALCULADO_SOATVENCIDO = 19000;
	private static final int VALOR_VENTA_CALCULADO_MAXKILOMETRAJE = 19000;
	private static final int KILOMETRAJE = 21000;


	AutomovilTestDataBuilder automovilTestDataBuilder = new AutomovilTestDataBuilder();
	Automovil automovil =  automovilTestDataBuilder.build();
	
	@Mock
	RepositorioAutomovilPersistente repositorioAutomovil;
	
	@InjectMocks
	ServicioCrearAutomovil servicioCrearAutomovil;
	
	@BeforeEach
	public void init() {
		//MockitoAnnotations.initMocks(this);
		MockitoAnnotations.openMocks(this);
	}

	
	@Test
	public void crearAutomovilTest() {

		servicioCrearAutomovil.ejecutar(automovil);

		Mockito.verify(repositorioAutomovil, times(1)).crear(automovil);
	}
	
	@Test
	public void crearAutomovilConSoatVencidoTest() {
		this.automovil.setFechaVencimientoSoat(FECHA_SOAT_VENCIDO);
		servicioCrearAutomovil.ejecutar(automovil);
		assertEquals(VALOR_VENTA_CALCULADO_SOATVENCIDO, automovil.getValorVentaCalculado());
	}
	
	@Test
	public void crearAutomovilConMayorKilometrajeTest() {
		this.automovil.setKilometraje(KILOMETRAJE);
		servicioCrearAutomovil.ejecutar(automovil);
		assertEquals(VALOR_VENTA_CALCULADO_MAXKILOMETRAJE, automovil.getValorVentaCalculado());
	}
	
	
	@Test
	public void crearAutomovilSinPlaca() {
		
	    assertThrows(AutomovilExcepcionBadRequest.class,
	            ()->{
	        		Automovil autosinPlaca = automovilTestDataBuilder.conPlaca("ASDASDASASD2222").build();
	            	servicioCrearAutomovil.ejecutar(autosinPlaca);
	            //do whatever you want to do here
	            //ex : objectName.thisMethodShoulThrowNullPointerExceptionForNullParameter(null);
	            });
	}
	
	
	

}
