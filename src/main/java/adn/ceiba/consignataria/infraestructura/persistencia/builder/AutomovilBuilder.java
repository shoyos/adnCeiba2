package adn.ceiba.consignataria.infraestructura.persistencia.builder;


import adn.ceiba.consignataria.dominio.model.Automovil;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.AutomovilEntity;

public final class AutomovilBuilder {
	
	public static Automovil convertirADominio(AutomovilEntity automovilEntity) {

		Automovil automovil = null;

		if (automovilEntity != null) {
			automovil = new Automovil(automovilEntity.getPlaca(), automovilEntity.getNumeroMotor(), automovilEntity.getKilometraje(),
					automovilEntity.getCilindraje(), automovilEntity.getFechaVencimientoSoat(),
					automovilEntity.getIdTipoPublicacion(), automovilEntity.getModelo(), automovilEntity.getValorVenta(),
					automovilEntity.getValorVentaCalculado(),automovilEntity.getFechaInicio(), automovilEntity.getFechafinal(),
					automovilEntity.getPrecioPublicacion());
		}

		return automovil;
	}

	
	public static AutomovilEntity convertirAEntity(Automovil automovil) {

		AutomovilEntity automovilEntity = new AutomovilEntity();
		automovilEntity.setPlaca(automovil.getPlaca());
		automovilEntity.setNumeroMotor(automovil.getNumeroMotor());
		automovilEntity.setKilometraje(automovil.getKilometraje());
		automovilEntity.setCilindraje(automovil.getCilindraje());
		automovilEntity.setFechaVencimientoSoat(automovil.getFechaVencimientoSoat());
		automovilEntity.setIdTipoPublicacion(automovil.getIdTipoPublicacion());
		automovilEntity.setModelo(automovil.getModelo());
		automovilEntity.setValorVenta(automovil.getValorVenta());
		automovilEntity.setValorVentaCalculado(automovil.getValorVentaCalculado());
		automovilEntity.setFechaInicio(automovil.getFechaInicio());
		automovilEntity.setFechafinal(automovil.getFechaFinal());
		automovilEntity.setPrecioPublicacion(automovil.getPrecioPublicacion());

		return automovilEntity;
	}

}
