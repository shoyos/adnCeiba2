package adn.ceiba.consignataria.dominio.servicio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.repositorio.RepositorioAutomovil;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.AutomovilEntity;


@Component
public class ServicioCrearAutomovil {
	
	private final RepositorioAutomovil repositorioAutomovil;
    private final static int MAXKILOMETRAJEXANIO = 20000;
    private final static int PRECIOPUBLICACION = 15000;
    private final static int COSTOEXTRA = 15000; 
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    
    public ServicioCrearAutomovil(RepositorioAutomovil repositorioAutomovil ) {
    	this.repositorioAutomovil = repositorioAutomovil;
		// TODO Auto-generated constructor stub
	}


    private boolean esPublicacionEstandar = false;
    
	public void ejecutar(Automovil automovil) {
		
		automovil.setFechaFinal(calcularFechaFinPublicacion(automovil.getFechaInicio(), automovil.getIdTipoPublicacion() ));
		automovil.setValorVentaCalculado(automovil.getValorVenta());
		if (tieneSoatVencido(automovil.getFechaInicio())) {
			automovil.setValorVentaCalculado(automovil.getValorVentaCalculado() - ( (automovil.getValorVenta() * 5) / 100 ) );
		} else if (tieneExcesoKilometraje(automovil.getKilometraje(), automovil.getModelo())) {
			automovil.setValorVentaCalculado(automovil.getValorVentaCalculado() - ( (automovil.getValorVenta() * 7) / 100 ));
		}
		
		if(this.esPublicacionEstandar) {
			automovil.setPrecioPublicacion(PRECIOPUBLICACION );
		} else automovil.setPrecioPublicacion(PRECIOPUBLICACION + COSTOEXTRA );
		System.out.println("Paso ejecutar Servicio");


		AutomovilEntity automovilEntity = repositorioAutomovil.obtenerAutomovilById(automovil.getPlaca());
		if (automovilEntity == null) {
			repositorioAutomovil.crear(automovil);
		} else {
			repositorioAutomovil.actualizar(automovil);
		}
	}
	
	public LocalDate calcularFechaFinPublicacion(LocalDate fechaInicio, int idTipoPublicacion) {
		LocalDate fechaFinPublicacion = fechaInicio;
		if (idTipoPublicacion == 1) {
			this.esPublicacionEstandar = true;
			 fechaFinPublicacion = fechaInicio.plusDays(15);
		} else if (idTipoPublicacion == 2) {
			fechaFinPublicacion = fechaInicio.plusDays(30);
		}
		
		return fechaFinPublicacion;
	}
	
	public boolean tieneSoatVencido (LocalDate fechaInicio ) {
		LocalDate fechaHoy = LocalDate.now();
		// Ocurre si fecha vencimiento soat < diaActual
		if (fechaInicio.compareTo(fechaHoy) < 0) return true;
		else return false;
		
	}
	
	public boolean tieneExcesoKilometraje(int kilometraje, int modelo) {
		int anioActual = Calendar.getInstance().get(Calendar.YEAR);
		int aniosDiferencia = modelo - anioActual;
		int cantidadMaximaPosibleKilometraje;
		if (aniosDiferencia > 0 ) {
			cantidadMaximaPosibleKilometraje = MAXKILOMETRAJEXANIO * aniosDiferencia;			
		} else {
			return false;
		}
		if (kilometraje < cantidadMaximaPosibleKilometraje) return true; 
		else return false;
			
	}
	
	
}
