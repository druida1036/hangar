package co.edu.udistrital.controladores;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import co.edu.udistrital.dao.NaveDAO;
import co.edu.udistrital.modelo.Avion;
import co.edu.udistrital.modelo.Componente;
import co.edu.udistrital.modelo.Customer;
import co.edu.udistrital.modelo.Helicoptero;
import co.edu.udistrital.modelo.Nave;
import co.edu.udistrital.modelo.PlanMantenimiento;
import co.edu.udistrital.modelo.Tarea;
import co.edu.udistrital.servicios.CustomerService;
import co.edu.udistrital.servicios.PlanMantenimientoService;

@Controller
public class CustomerController {

	Logger LOG = Logger.getLogger(CustomerController.class.getName());

	@Autowired(required = true)
	@Qualifier("customerService")
	private CustomerService customerService;

	@Autowired
	private NaveDAO dao;

	@Autowired
	private PlanMantenimientoService planMantenimientoService;

	private List<Customer> list;

	@PostConstruct
	public void init() {
		customerService.addCustomer("TEST-" + new Date().getTime(), "pais " + new Date().getTime());
		crearDatos();
		queryCustomers();
	}

	public String getHome() {
		LOG.info("Home page invoked");
		customerService.addCustomer("TEST-" + new Date().getTime(), "pais " + new Date().getTime());
		return "redirect:customers.action";
	}

	public String queryCustomers() {
		LOG.info("Quering Customers");

		list = customerService.getAllCustomers();
		return "pages/nave/hangar.xhtml";

	}

	private void crearDatos() {
		crearNaves();
		crearPlanes();
	}

	private void crearPlanes() {
		Map<String, String[]> planes = new HashMap<String, String[]>();
		planes.put("plan_01", new String[] { "Mantenimiento Aviones,Mantenimiento Aviones",
				"Manteniento Ala,Manteniento Ala;Manteniento Cabina,Manteniento Cabina" });
		planes.put("plan_02", new String[] { "Mantenimiento Hicop,Mantenimiento Helicop",
				"Manteniento Rotor,Manteniento Rotor;Manteniento Patin,Manteniento Patin" });

		for (Map.Entry<String, String[]> row : planes.entrySet()) {
			String[] datos = row.getValue()[0].split(",");
			crearPlan(datos[0], datos[1], row.getValue()[1]);

		}

	}

	private void crearPlan(String nombre, String descripcion, String datos) {
		String[] tareas = datos.split(";");
		PlanMantenimiento planMantenimiento = new PlanMantenimiento();
		planMantenimiento.setNombre(nombre);
		planMantenimiento.setDescripcion(descripcion);
		for (String registro : tareas) {
			String[] info = registro.split(",");
			crearTarea(planMantenimiento, info[0], info[1]);

		}
		planMantenimientoService.crear(planMantenimiento);

	}

	private void crearTarea(PlanMantenimiento planMantenimiento, String nombre, String descripcion) {
		Tarea tarea = new Tarea();
		tarea.setNombre(nombre);
		tarea.setDescripcion(descripcion);
		planMantenimiento.addTarea(tarea);
		tarea.setPlanMantenimiento(planMantenimiento);

	}

	private void crearNaves() {
		Map<String, String[]> naves = new HashMap<String, String[]>();
		naves.put("avion_01", new String[] { "Boing,747,Avianca", "Ala Izq,Ala Izq;Ala Der,Ala Der" });
		naves.put("helico_01", new String[] { "Agusta Wetsland,AW101 VVIP,2", "Rotor,Rotor;Patin,Patin;Tren,Tren" });
		naves.put("helico_02", new String[] { "Sikorky,S-92VVIP,1", "Rotor,Rotor;Patin,Patin;Tren,Tren" });
		for (Map.Entry<String, String[]> row : naves.entrySet()) {
			String[] datos = row.getValue()[0].split(",");
			if (row.getKey().contains("avion")) {
				crearAvion(datos[0], datos[1], datos[2], row.getValue()[1]);
			} else {
				crearHelicoptero(datos[0], datos[1], datos[2], row.getValue()[1]);
			}
		}
	}

	private void crearHelicoptero(String fabricante, String referencia, String rotores, String datos) {
		String[] dtCpnte = datos.split(";");
		Helicoptero helicoptero = new Helicoptero();
		helicoptero.setEstado("Activos");
		helicoptero.setFabricante(fabricante);
		helicoptero.setReferencia(referencia);
		helicoptero.setNumeroRotores(new Integer(rotores));
		for (String registro : dtCpnte) {
			String[] info = registro.split(",");
			crearComponente(helicoptero, info[0], info[1]);

		}
		dao.crear(helicoptero);
	}

	private void crearAvion(String fabricante, String referencia, String aerolinea, String datos) {
		String[] dtCpnte = datos.split(";");
		Avion nave = new Avion();
		nave.setEstado("Activo");
		nave.setFabricante(fabricante);
		nave.setReferencia(referencia);
		nave.setAerolinea(aerolinea);
		for (String registro : dtCpnte) {
			String[] info = registro.split(",");
			crearComponente(nave, info[0], info[1]);

		}

		dao.crear(nave);
	}

	private void crearComponente(Nave nave, String nombre, String descripcion) {
		Componente componente = new Componente();
		componente.setCostoRefraccon(new BigDecimal(2));
		componente.setNombre(nombre);
		componente.setDescripcion(descripcion);
		componente.setEstado("Activo");
		nave.addComponente(componente);
		componente.setNave(nave);
	}

	/**
	 * @return the list
	 */
	public List<Customer> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<Customer> list) {
		this.list = list;
	}

}
