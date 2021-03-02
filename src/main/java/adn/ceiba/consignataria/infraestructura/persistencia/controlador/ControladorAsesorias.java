package adn.ceiba.consignataria.infraestructura.persistencia.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import adn.ceiba.consignataria.aplicacion.comando.ComandoAsesoria;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorCrearAsesoriaVenta;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/asesorias")
public class ControladorAsesorias {
	
	private final ManejadorCrearAsesoriaVenta manejadorCrearAsesoriaVenta;
	

	public ControladorAsesorias(ManejadorCrearAsesoriaVenta manejadorCrearAsesoriaVenta) {
		super();
		this.manejadorCrearAsesoriaVenta = manejadorCrearAsesoriaVenta;
	}


	//agregar
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void agregarASesorias(@RequestBody ComandoAsesoria comando) {
		this.manejadorCrearAsesoriaVenta.ejecutar(comando);
	}
}
