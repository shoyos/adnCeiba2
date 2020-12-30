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


import adn.ceiba.consignataria.aplicacion.comando.ComandoAutomovil;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorCrearAutomovil;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorEliminarAutomovil;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorObtenerAutomoviles;
import adn.ceiba.consignataria.dominio.model.Automovil;

//@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/automoviles")
public class ControladorAutomovil {
	
	private final ManejadorCrearAutomovil manejadorCrearAutomovil;
	private final ManejadorEliminarAutomovil manejadorEliminarAutomovil;
	private final ManejadorObtenerAutomoviles manejadorObtenerAutomoviles;
	
	public ControladorAutomovil(ManejadorCrearAutomovil manejadorCrearAutomovil, 
			ManejadorEliminarAutomovil manejadorEliminarAutomovil, ManejadorObtenerAutomoviles manejadorObtenerAutomoviles ) {
		this.manejadorCrearAutomovil = manejadorCrearAutomovil;
		this.manejadorEliminarAutomovil = manejadorEliminarAutomovil;
		this.manejadorObtenerAutomoviles = manejadorObtenerAutomoviles;
	}
	
	//Crear
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void agregar(@RequestBody ComandoAutomovil comandoAutomovil) {
		this.manejadorCrearAutomovil.ejecutar(comandoAutomovil);
	}
	
	//Update
	@PostMapping("/actualizar")
	@ResponseStatus(HttpStatus.CREATED)
	public void actualizar(@RequestBody ComandoAutomovil comandoAutomovil) {
		this.manejadorCrearAutomovil.ejecutar(comandoAutomovil);
	}
	
	
	@DeleteMapping(value = "/{idPlaca}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable(name = "idPlaca") String idPlaca) {
		this.manejadorEliminarAutomovil.ejecutar(idPlaca);
	}
	
	@GetMapping("/obtenertodos")
	public List<Automovil> obtenerAutomoviles() {
		return this.manejadorObtenerAutomoviles.ejecutar();
	}



}
