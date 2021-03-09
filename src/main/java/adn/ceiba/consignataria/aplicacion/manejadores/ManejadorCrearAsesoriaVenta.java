package adn.ceiba.consignataria.aplicacion.manejadores;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import adn.ceiba.consignataria.aplicacion.comando.ComandoAsesoria;
import adn.ceiba.consignataria.aplicacion.fabrica.FabricaCrearAsesoriaVenta;
import adn.ceiba.consignataria.dominio.model.AsesoriaVenta;
import adn.ceiba.consignataria.dominio.servicio.ServicioCrearAsesoriaVenta;
import adn.ceiba.consignataria.dominio.servicio.ServicioCrearCliente;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.ClienteEntityMongo;

@Component
public class ManejadorCrearAsesoriaVenta {
	private FabricaCrearAsesoriaVenta fabricaCrearAsesoriaVenta;
	private ServicioCrearAsesoriaVenta servicioCrearAsesoriaVenta;
	private ServicioCrearCliente servicioCrearCliente;

	
	public ManejadorCrearAsesoriaVenta(FabricaCrearAsesoriaVenta fabricaCrearAsesoriaVenta, 
			ServicioCrearAsesoriaVenta servicioCrearAsesoriaVenta) {
		
		this.fabricaCrearAsesoriaVenta = fabricaCrearAsesoriaVenta;
		this.servicioCrearAsesoriaVenta = servicioCrearAsesoriaVenta;
	}

	@Transactional
	public void ejecutar(ComandoAsesoria comando) {
		System.out.println("Paso ejecutar comandoAutomovil");
		//Automovil automovil = this.fabricaAutomovil.crear(comandoAutomovil);
		AsesoriaVenta asesoria = this.fabricaCrearAsesoriaVenta.crear(comando);		
	    this.servicioCrearAsesoriaVenta.ejecutar(asesoria);
	}
	
	@Transactional
	public void guardarCliente(ClienteEntityMongo comando) {
		System.out.println("Paso ejecutar comandoAutomovil");
	    this.servicioCrearCliente.ejecutar(comando);
	}


}
