package MVPControllerImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import MVPController.DepartmentController;
import MVPModels.Department;
import MVPServiceImpl.DepartmentServicesImpl;
import MVPServices.DepartmentServices;

public class DepartmentControllerImpl implements DepartmentController {
	
	public DepartmentServices ds = new DepartmentServicesImpl();
	public Gson gson = new Gson();

	
	public void getDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String input = request.getParameter("departmentId");
		
		int id;
		
		try {
			id = Integer.parseInt(input);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter improperly formatted.");
			return;
		}
		
		Department d = ds.getDepartment(id);
		
		response.getWriter().append((d != null) ? gson.toJson(d) : "{}");
		
	}

	
	public void getDepartmentByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("departmentName");
		
		String name;
		
		try {
			name = input.toString();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "Department Name parameter improperly formatted.");
			return;
		}
		
		Department d = ds.getDepartment(name);
		
		response.getWriter().append((d != null) ? gson.toJson(d) : "{}");

	}


	public void getAllDepartments(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<Department> deptList = ds.getAllDepartments();
		System.out.println(deptList);
		
		response.getWriter().append(gson.toJson(deptList));

	}

	
	public void addDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Department d = gson.fromJson(request.getReader(), Department.class);
		
		ds.addDepartment(d);
		
		response.getWriter().append(gson.toJson(d));

	}

	
	
	public void updateDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Department d = gson.fromJson(request.getReader(), Department.class);
		
		ds.updateDepartment(d);
		
		response.getWriter().append(gson.toJson(d));
	}

	
	public void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Department d = gson.fromJson(request.getReader(), Department.class);
		
		ds.deleteDepartment(d);
		
		response.getWriter().append("Department " + d.getDepartmentName() + " deleted.");

	}
}
