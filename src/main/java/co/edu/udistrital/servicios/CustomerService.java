package co.edu.udistrital.servicios;

import java.util.List;

import co.edu.udistrital.modelo.Customer;

public interface CustomerService {
	
	public Customer addCustomer(String customerName, String country);
	public Customer updateCustomer(long customerId,String customerName, String country);
	public Customer getCustomer(long customerId);
	public List<Customer> getAllCustomers();
}
