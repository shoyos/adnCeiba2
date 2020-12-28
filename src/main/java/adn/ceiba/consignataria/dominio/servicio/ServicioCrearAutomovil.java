package adn.ceiba.consignataria.dominio.servicio;

import java.time.LocalDate;
import java.util.Calendar;

import adn.ceiba.consignataria.dominio.Repositorio.IRepositorioAutomovil;
import adn.ceiba.consignataria.dominio.model.Automovil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ServicioCrearAutomovil {
	
	private final IRepositorioAutomovil repositorioAutomovil;
    private final static int MAXKILOMETRAJEXANIO = 20000;
    private final static int PRECIOPUBLICACION = 15000;
    private final static int COSTOEXTRA = 15000; 


    private boolean esPublicacionEstandar = false;
    
	public void crear(Automovil automovil) {
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

		repositorioAutomovil.crear(automovil);
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
