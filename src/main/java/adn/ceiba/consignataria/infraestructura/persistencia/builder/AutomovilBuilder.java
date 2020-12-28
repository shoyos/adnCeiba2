package adn.ceiba.consignataria.infraestructura.persistencia.builder;


import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.AutomovilEntity;

public class AutomovilBuilder {
	
	public static Automovil convertirADominio(AutomovilEntity automovilEntity) {

		Automovil automovil = null;

		if (automovilEntity != null) {
			automovil = new Automovil(automovilEntity.getPlaca(), automovilEntity.getNumeroMotor(), automovilEntity.getKilometraje(),
					automovilEntity.getCilindraje(), automovilEntity.getFechaVencimientoSoat(),
					automovilEntity.getIdTipoPublicacion(), automovilEntity.getModelo(), automovilEntity.getValorVenta(),
					automovilEntity.getFechaInicio());
		}

		return automovil;
	}

	
	public static AutomovilEntity convertirAEntity(Automovil automovil) {

		AutomovilEntity automovilEntity = new AutomovilEntity();
		automovil.setPlaca(automovil.getPlaca());
		automovil.setNumeroMotor(automovil.getNumeroMotor());
		automovil.setKilometraje(automovil.getKilometraje());
		automovil.setCilindraje(automovil.getCilindraje());
		automovil.setFechaVencimientoSoat(automovil.getFechaVencimientoSoat());
		automovil.setIdTipoPublicacion(automovil.getIdTipoPublicacion());
		automovil.setModelo(automovil.getModelo());
		automovil.setValorVenta(automovil.getValorVenta());
		automovil.setValorVentaCalculado(automovil.getValorVentaCalculado());

		return automovilEntity;
	}

}
