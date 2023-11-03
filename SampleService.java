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



@Path("/sampleservice")
public class SampleService {
	
	private static Map<String, Customer> employees = new HashMap<String, Customer>();
	
	static {
		
        Customer employee1 = new Customer();
        employee1.setEmployeeId("1");
        employee1.setEmployeeName("Fabrizio");
        employee1.setJob("Software Engineer");
        employees.put(employee1.getEmployeeId(), employee1);
        
        Customer employee2 = new Customer();
        employee2.setEmployeeId("2");
        employee2.setEmployeeName("Justin");
        employee2.setJob("Business Analyst");
        employees.put(employee2.getEmployeeId(), employee2);
        
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
    @Path("/employees")
    @Produces("application/xml")
    public List<Customer> listEmployees(){
        return new ArrayList<Customer>(employees.values());
    }
	
	@GET
    @Path("/employee/{employeeid}")
    @Produces("application/xml")
    public Customer getEmployee(@PathParam("employeeid")String employeeId){
		return employees.get(employeeId);		
    }
	
	@GET
    @Path("/json/employees/")
    @Produces("application/json")
    public List<Customer> listEmployeesJSON(){
		return new ArrayList<Customer>(employees.values());
    }

	@GET
    @Path("/json/employee/{employeeid}")
    @Produces("application/json")
    public Customer getEmployeeJSON(@PathParam("employeeid")String employeeId){
		return employees.get(employeeId);		
    }
	
}


