package adn.ceiba.consignataria.dominio.servicio;

import java.time.LocalDate;
import java.util.Calendar;

import org.springframework.stereotype.Component;
import adn.ceiba.consignataria.dominio.excepcion.AutomovilExcepcionBadRequest;
import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.dominio.repositorio.RepositorioAutomovil;


@Component
public class ServicioCrearAutomovil {
	
	private final RepositorioAutomovil repositorioAutomovil;
    private final static int MAXKILOMETRAJEXANIO = 20000;
    private final static String PLACA = "LA PLACA DEBE TENER MAXIMO 6 DIGITOS";
    private final static String KILOMETRAJE_NEGATIVO = "EL KILOMETRAJE DEBE SER > 0";
    private final static String FALTA_SOAT = "LA FECHA DEL SOAT ES REQUERIDA";

    
    public ServicioCrearAutomovil(RepositorioAutomovil repositorioAutomovil ) {
    	this.repositorioAutomovil = repositorioAutomovil;
	}
    
	public void ejecutar(Automovil automovil) {
		System.out.println("Paso ejecutar Servicio automovil");
		this.validarDatos(automovil);
		automovil.setValorVentaCalculado(automovil.getValorVenta());
		if (tieneSoatVencido(automovil.getFechaVencimientoSoat())) {
			automovil.setValorVentaCalculado(automovil.getValorVentaCalculado() - ( (automovil.getValorVenta() * 5) / 100 ) );
		} 
		
		if (tieneExcesoKilometraje(automovil.getKilometraje(), automovil.getModelo())) {
			automovil.setValorVentaCalculado(automovil.getValorVentaCalculado() - ( (automovil.getValorVenta() * 7) / 100 ));
		}
	
		Automovil automovilExiste = repositorioAutomovil.obtenerAutomovilById(automovil.getPlaca());
		if (automovilExiste == null) {
			repositorioAutomovil.crear(automovil);
		} else {
			repositorioAutomovil.actualizar(automovil);
		}
	}
	

	/*
	 * Verifica si el soat esta vencido con respecto al dia actual
	 * */
	public boolean tieneSoatVencido (LocalDate fechaVenciminetoSoat ) {
		LocalDate fechaHoy = LocalDate.now();
		// Ocurre si fecha vencimiento soat < diaActual
		if (fechaVenciminetoSoat.compareTo(fechaHoy) < 0) return true;
		else return false;
		
	}
	
	/*
	 * Calcula si tiene exceso de kiloemtraje el automovil con respecto al modelo
	 * */
	public boolean tieneExcesoKilometraje(int kilometraje, int modelo) {
		boolean tieneExcesoKilometraje = false;
		int anioActual = Calendar.getInstance().get(Calendar.YEAR);
		int aniosDiferencia = anioActual - modelo;
		int cantidadMaximaPosibleKilometraje;
		if (aniosDiferencia > 0 ) {
			cantidadMaximaPosibleKilometraje = MAXKILOMETRAJEXANIO * aniosDiferencia;
			if (kilometraje > cantidadMaximaPosibleKilometraje) {
				tieneExcesoKilometraje = true;
			}
		}
		
		return tieneExcesoKilometraje;
	}
	
	public void validarDatos(Automovil automovil) {
		if (automovil.getPlaca().length() > 6 || automovil.getPlaca().isEmpty()) {
			throw new AutomovilExcepcionBadRequest(PLACA);
		} if (automovil.getKilometraje() < 0) {
			throw new AutomovilExcepcionBadRequest(KILOMETRAJE_NEGATIVO);

		} if (automovil.getFechaVencimientoSoat() == null ) {
			throw new AutomovilExcepcionBadRequest(FALTA_SOAT);
		}
	}
	
	
}
