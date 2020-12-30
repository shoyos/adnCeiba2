package adn.ceiba.consignataria.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.aplicacion.comando.ComandoAutomovil;
import adn.ceiba.consignataria.dominio.model.Automovil;


@Component
public class FabricaAutomovil {
	
	public Automovil crear(ComandoAutomovil comandoAutomovil) {
		return new Automovil(comandoAutomovil.getPlaca(), comandoAutomovil.getNumeroMotor(),comandoAutomovil.getKilometraje(),
				comandoAutomovil.getCilindraje(), comandoAutomovil.getFechaVencimientoSoat(),
				comandoAutomovil.getIdTipoPublicacion(), comandoAutomovil.getModelo(), 
				comandoAutomovil.getValorVenta(), comandoAutomovil.getValorVentaCalculado(),
				comandoAutomovil.getFechaInicio(), comandoAutomovil.getFechaFinal(), comandoAutomovil.getPrecioPublicacion());
						
	}

}
