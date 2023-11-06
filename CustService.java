import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;



@Path("/sampleservicecust")
public class CustService {
	
	private static Map<String, Customer> customer = new HashMap<String, Customer>();
	
	static {
		
        Customer customer1 = new Customer();
        customer1.setId("1");
        customer1.setName("Josh");
        customer1.setJob("Software Engineer");
        customer.put(customer1.getId(), customer1);
        
        Customer customer2 = new Customer();
        customer2.setId("2");
        customer2.setName("Jimmy");
        customer2.setJob("Business Analyst");
        customer.put(customer2.getId(), customer2);
        
    }

	@GET
    @Path("/hello")
    @Produces("text/plain")
    public String hello(){
        return "Hello World";    
    }
	
	@GET
    @Path("/echo/{message}")
    @Produces("text/plain")
    public String echo(@PathParam("message")String message){
        return message;  
    }

	
	@GET
    @Path("/customer")
    @Produces("application/xml")
    public List<Customer> listCustomers(){
        return new ArrayList<Customer>(customer.values());
    }
	
	@GET
    @Path("/customer/{id}")
    @Produces("application/xml")
    public Customer getCustomer(@PathParam("customerid")String customerId){
		return customer.get(customerId);		
    }
	
	@GET
    @Path("/json/custome/")
    @Produces("application/json")
    public List<Customer> listCustomersJSON(){
		return new ArrayList<Customer>(customer.values());
    }

	@GET
    @Path("/json/customer/{customerid}")
    @Produces("application/json")
    public Customer getCustomerJSON(@PathParam("customerid")String customerId){
		return customer.get(customerId);		
    }
	
}


