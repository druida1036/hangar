package co.edu.udistrital.controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udistrital.controladores.servicios.RegistroMantenimientoService;
import co.edu.udistrital.modelo.entidades.RegistroMantenimiento;

@RestController
public class MntoRestController {

	@Autowired
	private RegistroMantenimientoService service;

	@RequestMapping("/mnto/consulta")
	public RegistroMantenimiento consulta(@RequestParam(value = "id", defaultValue = "1") String id) {
		return (RegistroMantenimiento) service.consultar(Integer.parseInt(id));
	}

	@RequestMapping("/mnto/listado")
	public List<RegistroMantenimiento> consulta() {
		return service.consultar();
	}

}