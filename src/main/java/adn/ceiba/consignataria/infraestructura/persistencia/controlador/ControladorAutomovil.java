package adn.ceiba.consignataria.infraestructura.persistencia.controlador;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import adn.ceiba.consignataria.aplicacion.comando.ComandoAsesoria;
import adn.ceiba.consignataria.aplicacion.comando.ComandoPublicacion;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorCrearAsesoriaVenta;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorCrearAutomovil;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorCrearPublicacion;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorEliminarPublicacion;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorObtenerPublicaciones;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/publicaciones")
public class ControladorAutomovil {
	
	private final ManejadorCrearPublicacion manejadorCrearPublicacion;
	private final ManejadorEliminarPublicacion manejadorEliminarPublicacion;
	private final ManejadorObtenerPublicaciones manejadorObtenerPublicacion;

	
	public ControladorAutomovil(ManejadorCrearPublicacion manejadorCrearPublicacion,
			ManejadorEliminarPublicacion manejadorEliminarPublicacion,
			ManejadorObtenerPublicaciones manejadorObtenerPublicacion,
			ManejadorCrearAsesoriaVenta manejadorCrearAsesoriaVenta) {
		
		this.manejadorCrearPublicacion = manejadorCrearPublicacion;
		this.manejadorEliminarPublicacion = manejadorEliminarPublicacion;
		this.manejadorObtenerPublicacion = manejadorObtenerPublicacion;
	}
	
	//Crear
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void agregar(@RequestBody ComandoPublicacion comandoPublicacion) {
		this.manejadorCrearPublicacion.ejecutar(comandoPublicacion);

	}
	
	@DeleteMapping(value = "/{idPublicacion}")
	@ResponseStatus(HttpStatus.OK)
	public void eliminar(@PathVariable(name = "idPublicacion") int idPublicacion) {
		this.manejadorEliminarPublicacion.ejecutar(idPublicacion);
	}
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ComandoPublicacion> obtenerPublicaciones() {
		return this.manejadorObtenerPublicacion.ejecutar();
	}
	




}
