package MVPServices;

import java.util.List;

import MVPModels.Department;

public interface DepartmentServices {
	
public Department getDepartment(int deptId);
	
	public Department getDepartment(String deptName);
	
	public List<Department> getAllDepartments();
	
	public boolean addDepartment(Department dept);
	
	public boolean updateDepartment(Department dept);

	public boolean deleteDepartment(Department dept);

}
