package adn.ceiba.consignataria.aplicacion.fabrica;

import adn.ceiba.consignataria.aplicacion.comando.ComandoAutomovil;
import adn.ceiba.consignataria.dominio.model.Automovil;

public class FabricaAutomovil {
	
	public Automovil crear(ComandoAutomovil comandoAutomovil) {
		return new Automovil(comandoAutomovil.getPlaca(), comandoAutomovil.getNumeroMotor(),comandoAutomovil.getKilometraje(),
				comandoAutomovil.getCilindraje(), comandoAutomovil.getFechaVencimientoSoat(),
				comandoAutomovil.getIdTipoPublicacion(), comandoAutomovil.getModelo(), comandoAutomovil.getValorVenta(),
				comandoAutomovil.getFechaInicio());
	}

}
