package adn.ceiba.consignataria.infraestructura.persistencia.controlador;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import adn.ceiba.consignataria.aplicacion.comando.ComandoAutomovil;
import adn.ceiba.consignataria.aplicacion.manejadores.ManejadorCrearAutomovil;

//@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/automoviles")
public class ControladorAutomovil {
	
	private final ManejadorCrearAutomovil manejadorCrearAutomovil;
	
	public ControladorAutomovil(ManejadorCrearAutomovil manejadorCrearAutomovil ) {
		// TODO Auto-generated constructor stub
		this.manejadorCrearAutomovil = manejadorCrearAutomovil;
	}
	
	/*
	public void ejecutar(ComandoAutomovil comandoAutomovil) {
		this.manejadorCrearAutomovil.ejecutar(comandoAutomovil);
	}*/
	
	//Crear
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void agregar(@RequestBody ComandoAutomovil comandoAutomovil) {
		this.manejadorCrearAutomovil.ejecutar(comandoAutomovil);
	}
	
	@GetMapping
	public String obtenerCreditoPorDocumentoCliente() {
		return "holamundo";
	}


}
