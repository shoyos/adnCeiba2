package adn.ceiba.consignataria.dominio.servicio;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.dominio.excepcion.AsesoriaVentasExcepion;
import adn.ceiba.consignataria.dominio.model.AsesoriaVenta;
import adn.ceiba.consignataria.dominio.repositorio.RepositorioAsesoriaVenta;

@Component
public class ServicioCrearAsesoriaVenta {
	
	private RepositorioAsesoriaVenta repositorioAsesoriaVenta;
	private String FECHA_INVALIDA = "La fecha de asesoria no puede ser un domingo";
	
	
	
	public ServicioCrearAsesoriaVenta(RepositorioAsesoriaVenta repositorioAsesoriaVenta) {
		this.repositorioAsesoriaVenta = repositorioAsesoriaVenta;
	}



	public void ejecutar(AsesoriaVenta asesoria) {
		if (asesoria.getFecha().getDayOfWeek() == DayOfWeek.SUNDAY) { 
			throw new AsesoriaVentasExcepion(FECHA_INVALIDA);
		} else {
			repositorioAsesoriaVenta.crear(asesoria);
		}
		
		
	}


}
