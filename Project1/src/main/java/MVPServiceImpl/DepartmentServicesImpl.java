package MVPServiceImpl;

import java.util.List;

import MVPDAOImpl.DepartmentDAOImpl;
import MVPDAOS.DepartmentDAO;
import MVPModels.Department;
import MVPServices.DepartmentServices;

public class DepartmentServicesImpl implements DepartmentServices {
	
	public DepartmentDAO dr = new DepartmentDAOImpl();

	public Department getDepartment(int deptId) {
		return dr.getDepartment(deptId);
	}

	public Department getDepartment(String deptName) {
		return dr.getDepartmentByName(deptName);
	}
	
	public List<Department> getAllDepartments() {
		return dr.getAllDepartments();
	}

	public boolean addDepartment(Department dept) {
		return dr.addDepartment(dept);
	}

	public boolean updateDepartment(Department deptChange) {
		return dr.updateDepartment(deptChange);
	}

	public boolean deleteDepartment(Department dept) {
		return dr.deleteDepartment(dept);
	}

}
