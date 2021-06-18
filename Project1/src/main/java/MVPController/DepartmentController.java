package MVPController;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DepartmentController {
	
public void getDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void getDepartmentByName(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void getAllDepartments(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void addDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void updateDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException;


}
