package MVPControllerImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import MVPController.EmployeeController;
import MVPModels.Employee;
import MVPServices.EmployeeSevices;

public class EmployeeControllerImpl implements EmployeeController, EmployeeSevices {
	
	private EmployeeSevices es = new EmployeeControllerImpl();
	private static Gson gson = new Gson();

	public Employee getEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {// Why does this not work?

		String input = request.getParameter("employeeId");

		System.out.println(input);
		int id;

		try {
			id = Integer.parseInt(input);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return null;
		}

		Employee e = es.getEmployee(id);
		System.out.println(e);
		
		if (e != null) {
			return e;
		} else {
			return null;
		}

	}
	
	public Employee getEmployeeByEmail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {//Why does this not work?

		
		Employee emp = gson.fromJson(request.getReader(), Employee.class);
		
		String email = emp.getEmail();
		String password = emp.getPassword();
		
		System.out.println(email);
		System.out.println(password);
		
		Employee e = es.getEmployee(email);
		
		if (e.getPassword().equals(password)) {
			return e;
		}else {
			return null;
		}


	}

	public void addEmployee(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {
		// Retrieve info being sent in body (employee object(
		Employee e = gson.fromJson(request.getReader(), Employee.class);

		es.addEmployee(e);

		response.getWriter().append(gson.toJson(e));

	}

	public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {//Why does this not work?
		
		Employee e = gson.fromJson(request.getReader(), Employee.class);
		
		es.updateEmployee(e);
		
		response.getWriter().append(gson.toJson(e));

	}

	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {//Why does this not work?
		Employee e = gson.fromJson(request.getReader(), Employee.class);
		
		es.deleteEmployee(e);
		
		response.getWriter().append("Employee Deleted");

	}

	public Employee getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee getEmployee(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateEmployee(Employee eChange) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}


	


}
