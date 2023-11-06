package com.example.dit;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.example.dit.model.Employee;


@Path("/sampleserviceDBCRUD")
public class SampleServiceDBCRUD {
	
	private static Map<String, Customer> customers = new HashMap<String, Customer>();
	
	static {
		
		Customer customer1 = new Customer();
        cusomer1.setCustomerId("1");
        customer1.setCustomerName("Fabrizio");
        customer1.setJob("Software Engineer");
        customers.put(customer1.getCustomerId(), customer1);
        
        Customer customer2 = new Customer();
        customer2.setCustomerId("2");
        customer2.setCustomerName("Justin");
        customer2.setJob("Business Analyst");
        customers.put(customer2.getCustomerId(), customer2);
        
    }

	@GET
    @Path("/hello")
    @Produces("text/plain")
    public String hello(){
        return "Hello World";    
    }
	
	@GET
    @Path("/helloworld")
    @Produces("text/plain")
    public String helloWorld(){
        return "Hello World New";    
    }
	
	@GET
    @Path("/echo/{message}")
    @Produces("text/plain")
    public String echo(@PathParam("message")String message){
        return message;  
    }
	
	@GET
    @Path("/newEcho/{message}")
    @Produces("text/plain")
    public String newEcho(@PathParam("message")String message){
        return message;  
    }

	
	@GET
    @Path("/customers")
    @Produces("application/xml")
    public List<Employee> listEmployees(){
        return new ArrayList<Employee>(employees.values());
    }
	
	@GET
    @Path("/customer/{customerid}")
    @Produces("application/xml")
    public Employee getCustomer(@PathParam("customerid")String customerId){
		return customers.get(customerId);		
    }
	
	@POST
	@Path("/createxml")
    @Consumes("application/xml")
    public String addCustomer(Customer customer){
		
		return "Customer added " +customer.getCustomerName();		
    }
	
	@POST
	@Path("/createjson")
    @Consumes("application/json")
    public String addJSONCustomer(Customer customer){
		return "Customer added " +customer.getCustomerName();		
    }
	
	@GET
    @Path("/json/customers/")
    @Produces("application/json")
    public List<Customer> listCustomerJSON(){
		return new ArrayList<Customer>(s.values());
    }

	@GET
    @Path("/json/customer/{customerid}")
    @Produces("application/json")
    public Customer getCustomerJSON(@PathParam("customerid")String customerId){
		return customers.get(customerId);		
    }
	
	@GET
    @Path("/customersxmlfromdb")
    @Produces("application/xml")
    public List<Customer> getCustomersFromDB(){
        CustomerDAO dao = new CustomerDAO();
        return dao.getAllCustomers();
    }
	
	@GET
    @Path("/customersjsonfromdb")
    @Produces("application/json")
    public List<Employee> getJSONEmployeesFromDB(){
        EmployeeDAO dao = new EmployeeDAO();
        return dao.getAllEmployees();
    }
	
	@GET
    @Path("/jsonDB/customer/{customerName}")
    @Produces("application/json")
    public Customer getCustomerByNameFromDBJSON(@PathParam("customerName")String customerName){
		CustomerDAO dao = new CustomerDAO();
		return dao.getCustomerByName(customerName);		
    }
	
	@GET
    @Path("/customerfromDBXML/{customerName}")
    @Produces("application/xml")
    public Customer getCustomerByNameFromDBXML(@PathParam("customerName")String customerName){
		CustomerDAO dao = new CustomerDAO();
		return dao.getCustomerByName(customerName);	
    }
	
	@POST
	@Path("/newCustomer")
    @Consumes("application/json")
    public String addEmployeeToDBJSON(Customer customer){
		CustomerDAO dao = new CustomerDAO();
		dao.persist(customer);
		return "Customer added to DB from JSON Param "+customer.getCustomerName();	
    }
	
	@PUT
    @Path("/updateCustomer/")
    @Produces("application/json")
    public Customer updateCustomer(Customer customer){
		CustomerDAO dao = new CustomerDAO();
		return dao.merge(customer);	
    }
	
	@DELETE
    @Path("/deleteCustomer/{customerName}")
    @Produces("text/plain")
    public String deleteCustomer(@PathParam("customerName")String customerName){
		CustomerDAO dao = new CustomerDAO();
		Customer cus = dao.getCustomerByName(customerName);
		dao.removeCustomer(cus);	
		return "Customer "+cus+" deleted";
    }
	
	
}

