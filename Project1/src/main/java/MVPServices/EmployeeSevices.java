package MVPServices;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import MVPModels.Employee;

public interface EmployeeSevices {
	
public Employee getEmployee(int employeeId);
	
	public Employee getEmployee(String email);

	public boolean addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public boolean updateEmployee(Employee eChange);

	public boolean deleteEmployee(Employee employee);

	Employee getEmployeeByEmail(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException;

	void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException;

	void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException;

}
