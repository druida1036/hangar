package co.edu.udistrital.controladores;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import co.edu.udistrital.dao.NaveDAO;
import co.edu.udistrital.modelo.Avion;
import co.edu.udistrital.modelo.Componente;
import co.edu.udistrital.modelo.ComponentePK;
import co.edu.udistrital.modelo.Customer;
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
		Avion nave = new Avion();
		nave.setEstado("sss");
		nave.setFabricante("fabricante");
		nave.setAerolinea("aerolinea");
		Componente componente = new Componente();
		componente.setCostoRefraccon(new BigDecimal(2));
		nave.addComponente(componente);
		ComponentePK pk = new ComponentePK();
		pk.setId(9);
		pk.setNaveId(nave.getId());
//		componente.setId(pk);
//		componente.setNave(nave);
//		dao.crear(nave);
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
		return "pages/hangar.xhtml";
		
	}

	public ModelAndView getEditCustomerForm(@PathVariable("customerId") String customerId) {

		ModelAndView model = new ModelAndView("editCustomer");
		Customer cus = customerService.getCustomer(Long.parseLong(customerId));
		model.addObject("customer", cus);
		return model;

	}

	public ModelAndView editCustomer(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView();
		model.setViewName("customers");
		String customerId = request.getParameter("customerId");
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		LOG.info("Adding customer with name:" + name);
		Customer customer = customerService.updateCustomer(Long.parseLong(customerId), name, country);
		if (customer != null) {
			model.addObject("saveSuccess", "Customer Added SuccessFully:" + customer.getCustomerName());
		} else {
			model.addObject("saveError", "Customer creation failed");
		}
		List<Customer> list = customerService.getAllCustomers();
		model.addObject("customers", list);

		return model;

	}

	public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView();
		model.setViewName("customers");
		String name = request.getParameter("name");
		String country = request.getParameter("country");

		Customer customer = customerService.addCustomer(name, country);
		if (customer != null) {
			model.addObject("saveSuccess", "Customer Added SuccessFully:" + customer.getCustomerName());
		} else {
			model.addObject("saveError", "Customer creation failed");
		}
		List<Customer> list = customerService.getAllCustomers();
		model.addObject("customers", list);

		return model;

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
