package MVPDAOS;

import java.util.List;

import MVPModels.Employee;

public interface EmployeeDAO {
	
public Employee getEmployee(int employeeId);
	
	public Employee getEmployee(String email);

	public boolean addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public boolean updateEmployee(Employee eChange);

	public boolean deleteEmployee(Employee employee);

}
