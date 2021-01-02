package adn.ceiba.consignataria.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.aplicacion.comando.ComandoPublicacion;
import adn.ceiba.consignataria.dominio.model.Automovil;


@Component
public class FabricaAutomovil {
	
	public Automovil crear(ComandoPublicacion comandoAutomovil) {
		return new Automovil(comandoAutomovil.getPlaca(), comandoAutomovil.getNumeroMotor(),
				comandoAutomovil.getKilometraje(),comandoAutomovil.getCilindraje(), comandoAutomovil.getFechaVencimientoSoat(),
				comandoAutomovil.getModelo(), comandoAutomovil.getValorVenta(), 
				comandoAutomovil.getValorVentaCalculado() );
	}

}
