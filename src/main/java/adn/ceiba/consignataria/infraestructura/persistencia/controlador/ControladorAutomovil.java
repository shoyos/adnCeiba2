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


import adn.ceiba.consignataria.aplicacion.comando.ComandoPublicacion;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorCrearAutomovil;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorCrearPublicacion;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorEliminarPublicacion;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorObtenerPublicaciones;
import adn.ceiba.consignataria.dominio.model.Automovil;

//@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/automoviles")
public class ControladorAutomovil {
	
	private final ManejadorCrearAutomovil manejadorCrearAutomovil;
	private final ManejadorCrearPublicacion manejadorCrearPublicacion;
	private final ManejadorEliminarPublicacion manejadorEliminarPublicacion;
	private final ManejadorObtenerPublicaciones manejadorObtenerPublicacion;

	
	public ControladorAutomovil(ManejadorCrearAutomovil manejadorCrearAutomovil, 
			ManejadorCrearPublicacion manejadorCrearPublicacion,
			ManejadorEliminarPublicacion manejadorEliminarPublicacion,
			ManejadorObtenerPublicaciones manejadorObtenerPublicacion) {
		this.manejadorCrearAutomovil = manejadorCrearAutomovil;
		this.manejadorCrearPublicacion = manejadorCrearPublicacion;
		this.manejadorEliminarPublicacion = manejadorEliminarPublicacion;
		this.manejadorObtenerPublicacion = manejadorObtenerPublicacion;
	}
	
	//Crear
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void agregar(@RequestBody ComandoPublicacion comandoPublicacion) {
		this.manejadorCrearAutomovil.ejecutar(comandoPublicacion);
		this.manejadorCrearPublicacion.ejecutar(comandoPublicacion);

	}
	
	//Update
	@PostMapping("/actualizar")
	@ResponseStatus(HttpStatus.CREATED)
	public void actualizar(@RequestBody ComandoPublicacion comandoPublicacion) {
		this.manejadorCrearAutomovil.ejecutar(comandoPublicacion);
		this.manejadorCrearPublicacion.ejecutar(comandoPublicacion);
	}
	
	
	@DeleteMapping(value = "/{idPublicacion}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable(name = "idPublicacion") int idPublicacion) {
		
		this.manejadorEliminarPublicacion.ejecutar(idPublicacion);
	}
	
	
	@GetMapping("/obtenertodos")
	public List<ComandoPublicacion> obtenerAutomoviles() {
		return this.manejadorObtenerPublicacion.ejecutar();
	}



}
