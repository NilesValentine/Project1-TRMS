package MVPServiceImpl;

import java.util.List;

import MVPDAOImpl.EmployeeDAOImpl;
import MVPModels.Employee;

public class EmployeesServiceImpl {
	
	private EmployeeDAOImpl er = new EmployeeDAOImpl();

	public Employee getEmployee(int employeeId) {
		return er.getEmployee(employeeId);
	}
	
	public Employee getEmployee(String email) {
		return er.getEmployee(email);
	}


	public boolean addEmployee(Employee employee) {
		return er.addEmployee(employee);
		
	}

	public List<Employee> getAllEmployees() {
		return er.getAllEmployees();
		
	}

	public boolean updateEmployee(Employee eChange) {
		return er.updateEmployee(eChange);
	}

	public boolean deleteEmployee(Employee employee) {
		return er.deleteEmployee(employee);
	}


}
