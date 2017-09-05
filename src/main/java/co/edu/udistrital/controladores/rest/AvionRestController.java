package co.edu.udistrital.controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import co.edu.udistrital.controladores.servicios.NaveService;
import co.edu.udistrital.modelo.entidades.Avion;
import co.edu.udistrital.modelo.entidades.Nave;

@RestController
public class AvionRestController {

	@Autowired
	private NaveService service;

	@RequestMapping("/naves/consulta")
	public Avion consulta(@RequestParam(value = "id", defaultValue = "1") String id) {
		return (Avion) service.consultar(Integer.parseInt(id));
	}

	@RequestMapping("/naves/listado")
	public List<Nave> consulta() {
		return service.consultar();
	}

	@RequestMapping(value = "/naves/crear", method = RequestMethod.POST)
	public ResponseEntity<Void> crear(@RequestBody Avion avion, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + avion.getReferencia());

		if (service.consultar(avion.getId()) != null) {
			System.out.println("Avion de referencia " + avion.getReferencia() + " ya existe");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		avion.setId(0);
		service.crear(avion, avion.getComponentes());
		return new ResponseEntity<Void>(createHeaders(avion, ucBuilder), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/naves/actualizar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Avion> actualizar(@PathVariable("id") int id, @RequestBody Avion avion,
			UriComponentsBuilder ucBuilder) {
		System.out.println("Actualizando Nave " + avion.getId());

		if (service.consultar(id) == null) {
			System.out.println("Nave de referencia " + avion.getReferencia() + " no existe existe");
			return new ResponseEntity<Avion>(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Avion>(avion, createHeaders(avion, ucBuilder), HttpStatus.OK);
	}

	@RequestMapping(value = "/naves/borrar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Avion> borrar(@PathVariable("id") int id) {
		System.out.println("Borrando Avion " + id);

		if (service.consultar(id) == null) {
			System.out.println("Nave de referencia " + id + " no existe existe");
			return new ResponseEntity<Avion>(HttpStatus.CONFLICT);
		}

		service.borrar(service.consultar(id));
		return new ResponseEntity<Avion>(HttpStatus.NO_CONTENT);
	}

	private HttpHeaders createHeaders(Avion avion, UriComponentsBuilder ucBuilder) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Resultado", "Operacion exitosa Avion " + avion.getId());
		return headers;
	}
}