package co.edu.udistrital.controladores;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
import co.edu.udistrital.servicios.CustomerService;

@Controller
public class CustomerController {

	Logger LOG = Logger.getLogger(CustomerController.class.getName());

	@Autowired(required = true)
	@Qualifier("customerService")
	private CustomerService customerService;
	
	@Autowired
	private NaveDAO dao;

	private List<Customer> list;
	
	@PostConstruct
	public void init(){
		customerService.addCustomer("TEST-" + new Date().getTime(), "pais " + new Date().getTime());
		
		queryCustomers();
	}

	public String getHome() {
		LOG.info("Home page invoked");
		customerService.addCustomer("TEST-" + new Date().getTime(), "pais " + new Date().getTime());
		return "redirect:customers.action";
	}

	public String queryCustomers() {
		LOG.info("Quering Customers");
		Avion nave = new Avion();
		nave.setEstado("Activo");
		nave.setFabricante("fabricante");
		nave.setAerolinea("aerolinea");
		Componente componente = new Componente();
		componente.setCostoRefraccon(new BigDecimal(2));
		componente.setNombre("parte");
		componente.setDescripcion("Descripcion");
		componente.setEstado("Activo");
		nave.addComponente(componente);
		componente.setNave(nave);
		dao.crear(nave);
		Helicoptero helicoptero = new Helicoptero();
		helicoptero.setEstado("Activos");
		helicoptero.setFabricante("helicop");
		helicoptero.setNumeroRotores(3);
		componente = new Componente();
		componente.setCostoRefraccon(new BigDecimal(2));
		componente.setNombre("parte");
		componente.setDescripcion("Descripcion");
		componente.setEstado("Activo");
		helicoptero.addComponente(componente);
		componente.setNave(helicoptero);
		dao.crear(helicoptero);
		list = customerService.getAllCustomers();
		return "pages/nave/hangar.xhtml";
		
	}



	/**
	 * @return the list
	 */
	public List<Customer> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Customer> list) {
		this.list = list;
	}

}
