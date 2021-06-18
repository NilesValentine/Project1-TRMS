package MVPDAOS;

import java.util.List;

import MVPModels.Department;

public interface DepartmentDAO {
	

	public Department getDepartment(int deptId);
	
	public Department getDepartmentByName(String deptName);
	
	public List<Department> getAllDepartments();
	
	public boolean addDepartment(Department dept);
	
	public boolean updateDepartment(Department deptChange);
	
	public boolean deleteDepartment(Department dept);

}
